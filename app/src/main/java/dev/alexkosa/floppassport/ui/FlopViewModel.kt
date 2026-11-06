package dev.alexkosa.floppassport.ui

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dev.alexkosa.floppassport.crypto.Ss58
import dev.alexkosa.floppassport.flop.FlopChain
import dev.alexkosa.floppassport.flop.FlopEndpoints
import dev.alexkosa.floppassport.flop.FlopExplorer
import dev.alexkosa.floppassport.flop.FlopFaucet
import dev.alexkosa.floppassport.flop.FlopGateway
import dev.alexkosa.floppassport.flop.FlopHttp
import dev.alexkosa.floppassport.flop.FlopOfficial
import dev.alexkosa.floppassport.flop.FlopPrefs
import dev.alexkosa.floppassport.flop.FlopStatus
import dev.alexkosa.floppassport.flop.toHex
import dev.alexkosa.floppassport.vault.PassportVault
import java.math.BigDecimal
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

/**
 * The Passport's life on FLOP Network: its account, the faucet, the model, the network.
 *
 * Kept apart from [PassportViewModel] on purpose. That one holds the identity and its
 * public record on Technocore, and every line of it was paid for with a bug found on a real
 * phone. Nothing here can break it: this class only reads the Passport's public key and asks
 * the vault for one kind of signature, the gateway's enrollment statement.
 *
 * Everything shown is read back from FLOP's own services. A balance is what the devnet node
 * says, a spend is what the explorer has indexed, a grant is what the faucet answered.
 */
class FlopViewModel(app: Application) : AndroidViewModel(app) {

    private val vault = PassportVault(app)
    private val prefs = FlopPrefs(app)
    private var work = SupervisorJob()

    /** The Passport's own FLOP account, or null before there is a Passport. */
    var passportAddress by mutableStateOf(vault.did?.let { Ss58.fromDid(it) })
        private set

    /** An address the person already had, chosen in place of the Passport's for the faucet. */
    var customAddress by mutableStateOf(prefs.receiveAddress)
        private set

    val receiveAddress: String? get() = customAddress ?: passportAddress

    /**
     * Follow the Passport. Called whenever the identity changes - created, restored,
     * deleted - so a new key never inherits the last one's key, history or allowance.
     */
    fun onIdentity(did: String?) {
        val address = did?.let { Ss58.fromDid(it) }
        if (address == passportAddress) return
        work.cancel()
        work = SupervisorJob()
        if (address == null) {
            prefs.clear()
            customAddress = null
            chat = emptyList()
        }
        passportAddress = address
        balance = Balance()
        spend = null
        faucet = FaucetState.Idle
        gateway = gatewayFromPrefs()
        day = DayRun()
        run = null
        askResult = null
        live = null
        cachedStats = did?.let { prefs.stats(it) }
        refreshAccount()
    }

    // ------------------------------------------------------------------ what the hero shows first

    /** Last known numbers, so a returning person sees their Passport before the room answers. */
    var cachedStats by mutableStateOf<FlopPrefs.Stats?>(null)
        private set

    fun rememberStats(did: String, stats: FlopPrefs.Stats) {
        prefs.saveStats(did, stats)
        cachedStats = stats
    }

    private val technocore = dev.alexkosa.floppassport.technocore.Technocore()

    /** The public room counted: everybody here, as a stranger could count them. */
    var community by mutableStateOf(prefs.community)
        private set

    fun refreshCommunity() {
        if (System.currentTimeMillis() - (community?.checkedAt ?: 0L) < COMMUNITY_EVERY_MS) return
        viewModelScope.launch {
            val lines = runCatching {
                technocore.roomLines(CHECK_IN_ROOM) { dev.alexkosa.floppassport.technocore.DidNote.parse(it) != null }
            }.getOrNull() ?: return@launch
            val counted = ActivityState.community(lines, ActivityState.today()).copy(checkedAt = System.currentTimeMillis())
            prefs.community = counted
            community = counted
        }
    }

    // ------------------------------------------------------------------ account

    data class Balance(
        val loading: Boolean = false,
        val value: BigDecimal? = null,
        val error: String? = null,
        val checkedAt: Long? = null,
    )

    var balance by mutableStateOf(Balance())
        private set

    /** What the explorer has seen this account spend on inference. */
    var spend by mutableStateOf<FlopExplorer.Spend?>(null)
        private set

    fun refreshAccount() {
        val address = receiveAddress ?: return
        if (balance.loading) return
        balance = balance.copy(loading = true, error = null)
        viewModelScope.launch(work) {
            val b = runCatching { FlopChain.freeBalance(address) }
            if (address != receiveAddress) return@launch
            balance = Balance(
                loading = false,
                value = b.getOrNull() ?: balance.value,
                error = b.exceptionOrNull()?.takeIf { it !is CancellationException }?.let {
                    "Could not reach the FLOP devnet node. This says nothing about your balance, only about the connection."
                },
                checkedAt = if (b.isSuccess) System.currentTimeMillis() else balance.checkedAt,
            )
            passportAddress?.let { own ->
                runCatching { FlopExplorer.inferenceSpend(own) }.getOrNull()?.let { spend = it }
                // What is left of the allowance, so the Ask tab has its figure after a restart
                // and not only after the next answer.
                val open = gateway as? GatewayState.Open
                val key = prefs.gatewayKey?.takeIf { it.address == own }
                if (open != null && key != null) {
                    runCatching { FlopGateway.keyInfo(key.key) }.getOrNull()?.let { info ->
                        (gateway as? GatewayState.Open)?.let { gateway = it.copy(remaining = info.remaining) }
                    }
                }
            }
        }
    }

    fun setCustomAddress(value: String?): String? {
        val cleaned = value?.trim()?.ifBlank { null }
        if (cleaned != null && !Ss58.isValid(cleaned)) {
            return "That is not a FLOP address. It should start with 5 and be 47 or 48 characters; copy it again from your wallet."
        }
        val canonical = cleaned?.let { Ss58.canonical(it) }
        val final = if (canonical == passportAddress) null else canonical
        prefs.receiveAddress = final
        customAddress = final
        balance = Balance()
        faucet = FaucetState.Idle
        refreshAccount()
        return null
    }

    // ------------------------------------------------------------------ faucet

    sealed interface FaucetState {
        data object Idle : FaucetState
        data object Running : FaucetState
        data class Funded(val amount: String, val txHash: String?) : FaucetState

        /** [outage] means the faucet is failing for everybody, which is theirs to fix. */
        data class Refused(val message: String, val outage: Boolean, val alreadyToday: Boolean) : FaucetState
    }

    var faucet by mutableStateOf<FaucetState>(FaucetState.Idle)
        private set

    /** When this address can be funded again, or null if it can be funded now. */
    val nextFaucetAt: Long?
        get() {
            val address = receiveAddress ?: return null
            val last = prefs.lastFunded(address)
            val next = last + FAUCET_COOLDOWN_MS
            return if (last > 0 && next > System.currentTimeMillis()) next else null
        }

    val fundedToday: Boolean get() = nextFaucetAt != null

    fun claimFaucet() {
        viewModelScope.launch(work) {
            try {
                claim()
            } finally {
                live = null
            }
        }
    }

    private suspend fun claim(): FaucetState {
        val address = receiveAddress ?: return faucet
        if (faucet == FaucetState.Running) return faucet
        faucet = FaucetState.Running
        val started = System.currentTimeMillis()
        live = Live(Stage.Faucet, started, target = PingTarget.Faucet)
        refreshFaucetPing()
        val before = runCatching { FlopChain.freeBalance(address) }.getOrNull()
        val result = runCatching { FlopFaucet.fund(address) }
        if (address != receiveAddress) return faucet
        currentCoroutineContext().ensureActive()
        var r = result.getOrNull()
        // The faucet can hold a request for minutes, and while it does it answers "Grant
        // pending; retry the original request later". A lost answer means the same thing, so
        // both are waited out: watch the chain, then send the same request again, as it asks.
        var arrived = false
        var tries = 0
        while (!arrived && tries < GRANT_TRIES && FlopFaucet.stillWaiting(r)) {
            live = Live(Stage.Queue, started, attempt = tries + 1, attempts = GRANT_TRIES, target = PingTarget.Faucet)
            refreshFaucetPing()
            arrived = landed(address, before)
            if (!arrived) {
                r = runCatching { FlopFaucet.fund(address) }.getOrNull()
                currentCoroutineContext().ensureActive()
                if (address != receiveAddress) return faucet
            }
            tries++
        }
        // A 5xx is not a refusal until the chain agrees either.
        val unclear = r == null || (r is FlopFaucet.Result.Refused && r.status >= 500)
        val final = r
        faucet = when {
            final is FlopFaucet.Result.Funded -> {
                prefs.recordFunded(address, System.currentTimeMillis(), final.txHash)
                FaucetState.Funded(final.amount, final.txHash)
            }
            arrived || (unclear && landed(address, before)) -> {
                prefs.recordFunded(address, System.currentTimeMillis(), null)
                FaucetState.Funded("25", null)
            }
            final is FlopFaucet.Result.Refused -> refusal(address, final)
            else -> FaucetState.Refused(
                "Could not reach the FLOP faucet. Check your connection and try again.",
                outage = false,
                alreadyToday = false,
            )
        }
        if ((faucet as? FaucetState.Refused)?.alreadyToday == true) refreshAccount()
        if (faucet is FaucetState.Funded) {
            // The grant is a transfer that still has to land in a block. One second blocks;
            // a few seconds is enough for the balance to show it.
            live = Live(Stage.Landing, started)
            kotlinx.coroutines.delay(6_000)
            refreshAccount()
        }
        return faucet
    }

    /** Whether the balance rose above [before] within half a minute. */
    private suspend fun landed(address: String, before: BigDecimal?): Boolean {
        // Without a balance from before the request there is nothing to compare with, and
        // an old balance must not be mistaken for today's grant.
        if (before == null) {
            kotlinx.coroutines.delay(30_000)
            return false
        }
        repeat(5) {
            val now = runCatching { FlopChain.freeBalance(address) }.getOrNull()
            if (now != null && now > before) return true
            kotlinx.coroutines.delay(6_000)
        }
        return false
    }

    /**
     * The faucet's refusals in words.
     *
     * "IP classification unavailable" is the faucet failing for every caller - FLOP's issue
     * network#22, open since 2 November 2026 - and is said to be theirs, so nobody thinks
     * their phone or their address is at fault.
     */
    private fun refusal(address: String, r: FlopFaucet.Result.Refused): FaucetState.Refused {
        val m = r.message
        val pending = FlopFaucet.isGrantPending(m)
        val dailyCap = FlopFaucet.isDailyCap(m)
        val outage = !pending && (
            r.status >= 500 || m.contains("classification", ignoreCase = true) ||
                m.contains("indexer", ignoreCase = true)
            )
        // Only the address's own cooldown means "already funded". A 429 for the network's
        // ten-second or daily cap means nothing arrived, and saying otherwise would tick
        // the step for somebody with an empty account.
        val already = !outage && FlopFaucet.isAddressCooldown(r.status, m)
        if (already && !fundedToday) {
            // Funded by an earlier try whose answer was lost, or on the faucet's page: date
            // it from the faucet's own countdown, so the app knows when to try again.
            FlopFaucet.retryMinutes(m)?.let { left ->
                val at = System.currentTimeMillis() - FAUCET_COOLDOWN_MS + left * 60_000L
                prefs.recordFunded(address, at, null)
            }
        }
        return FaucetState.Refused(
            when {
                pending -> "The faucet has your request in its queue and has not sent the FLOP yet. This can take a while. Press do my day again later."
                dailyCap -> "The faucet has given out all of today's FLOP. Nothing arrived. It opens again within hours, so try later."
                outage -> "FLOP's faucet is down for everyone right now. It is not your phone. Try again later."
                already -> "This address already got its FLOP in the last 24 hours."
                r.status == 429 -> "The faucet is limiting requests from your network right now. Nothing arrived; try again later."
                else -> "The faucet said no: $m"
            },
            outage = outage,
            alreadyToday = already,
        )
    }

    // ------------------------------------------------------------------ gateway

    sealed interface GatewayState {
        /** Not entered yet. Entering needs a signature and at least 1 FLOP. */
        data object Closed : GatewayState
        data object Entering : GatewayState
        data class Open(val model: String, val remaining: Double?, val expiresAt: Long) : GatewayState

        /** The one devnet allowance for this account is over. */
        data object Finished : GatewayState

        data class Refused(val message: String, val needsFunds: Boolean) : GatewayState
    }

    var gateway by mutableStateOf(gatewayFromPrefs())
        private set

    private fun gatewayFromPrefs(): GatewayState {
        val own = passportAddress ?: return GatewayState.Closed
        if (prefs.gatewayClosed(own)) return GatewayState.Finished
        val k = prefs.gatewayKey?.takeIf { it.address == own } ?: return GatewayState.Closed
        // 0 is an allowance the gateway gave no end for: the gateway itself enforces the
        // end, so only a known, past date closes it here.
        if (k.expiresAt in 1..System.currentTimeMillis()) {
            prefs.markGatewayClosed(own)
            return GatewayState.Finished
        }
        return GatewayState.Open(k.model, null, k.expiresAt)
    }

    var chat by mutableStateOf(prefs.chat)
        private set

    /** A request is out, or the app is waiting to try the model again. */
    val asking: Boolean get() = requesting || patient

    private var requesting by mutableStateOf(false)
    private var patient by mutableStateOf(false)

    /** What is happening this second. A screen with something running shows this, not "working". */
    var live by mutableStateOf<Live?>(null)
        private set

    var gatewayPing by mutableStateOf<Ping?>(null)
        private set
    var faucetPing by mutableStateOf<Ping?>(null)
        private set

    /** The job in the process window, running or finished and not yet closed. */
    var run by mutableStateOf<Run?>(null)
        private set

    var askResult by mutableStateOf<AskResult?>(null)
        private set

    /** Whether the job in the window is still working. */
    val runBusy: Boolean get() = asking || day.running

    fun minimizeRun() {
        run = run?.copy(minimized = true)
    }

    fun openRun() {
        run = run?.copy(minimized = false)
    }

    /** A finished job goes away; a running one only leaves the screen. */
    fun closeRun() {
        if (runBusy) minimizeRun() else run = null
    }

    /** How long the last answer took, from the question to the reply, tries included. */
    var lastAnswerSeconds by mutableStateOf<Long?>(null)
        private set

    fun refreshPing() {
        viewModelScope.launch(work) { gatewayPing = Ping(FlopHttp.ping(FlopEndpoints.GATEWAY_HEALTH)) }
    }

    private fun refreshFaucetPing() {
        viewModelScope.launch(work) { faucetPing = Ping(FlopHttp.ping(FlopEndpoints.FAUCET_HEALTH)) }
    }

    var askError by mutableStateOf<String?>(null)
        private set

    /** The last refusal was FLOP's gateway being full, which passes in a minute or so. */
    private var lastAskBusy = false
    private val knock = Channel<Unit>(Channel.CONFLATED)

    /** Enter the gateway with a signature from the Passport key. Nothing else is signed. */
    private suspend fun enter(): GatewayState {
        val own = passportAddress ?: return gateway
        gateway = GatewayState.Entering
        val outcome = runCatching {
            val challenge = FlopGateway.challenge(own)
            // The Passport key also signs the daily records and the identity note, which are
            // plain text too. Only a statement that is visibly FLOP's sign-in for this
            // account is signed, so the gateway cannot get a record signed in its place.
            if (!FlopGateway.isEnrollStatement(challenge.message, own)) {
                return@runCatching FlopGateway.EnrollResult.Refused(0, UNRECOGNISED, "")
            }
            val signature = vault.sign(challenge.message.toByteArray(Charsets.UTF_8))
            FlopGateway.enroll(own, challenge.message, signature.toHex())
        }
        currentCoroutineContext().ensureActive()
        if (own != passportAddress) return gateway
        gateway = when (val r = outcome.getOrNull()) {
            is FlopGateway.EnrollResult.Enrolled -> {
                prefs.gatewayKey = FlopPrefs.GatewayKey(own, r.enrollment.key, r.enrollment.model, r.enrollment.expiresAt)
                GatewayState.Open(r.enrollment.model, r.enrollment.remaining, r.enrollment.expiresAt)
            }
            is FlopGateway.EnrollResult.Refused -> when {
                r.code == UNRECOGNISED -> GatewayState.Refused(
                    "FLOP's gateway sent a sign-in text this app does not recognise, so it was not signed. Nothing happened.",
                    false,
                )
                r.status == 403 && r.code?.contains("unfunded") == true -> GatewayState.Refused(
                    "The model needs at least 1 FLOP on your Passport address first. Get it from the faucet.",
                    needsFunds = true,
                )
                r.status == 402 || r.status == 403 -> {
                    prefs.markGatewayClosed(own)
                    GatewayState.Finished
                }
                r.status == 429 -> GatewayState.Refused("Too many tries from this network. Wait a minute and try again.", false)
                r.status == 503 -> GatewayState.Refused(
                    "FLOP's gateway has handed out all of today's devnet allowances, or is unavailable. Try again later.",
                    false,
                )
                else -> GatewayState.Refused("The gateway said no: ${r.message}", false)
            }
            null -> GatewayState.Refused("Could not reach FLOP's gateway. Check your connection and try again.", false)
        }
        return gateway
    }

    /** Send one message. Enters the gateway first if this is the first one. */
    fun ask(text: String) {
        val question = text.trim()
        if (question.isEmpty() || runBusy) return
        askResult = null
        run = Run(RunKind.Ask, question)
        viewModelScope.launch(work) { askPatiently(question) }
    }

    /** Stop waiting for the timer and ask again now. A refusal costs nothing. */
    fun knockNow() {
        knock.trySend(Unit)
    }

    /**
     * Ask, and when the gateway is full wait and ask again, saying so all the way.
     *
     * A refusal for being full costs nothing and passes by itself, so it is not worth
     * handing back to the person the first time. The input stays locked through the waits,
     * so a second question cannot interleave and lose messages from the chat.
     */
    private suspend fun askPatiently(question: String, maxTokens: Int = 256): Boolean {
        val started = System.currentTimeMillis()
        patient = true
        try {
            var tries = 1
            var ok = askNow(question, maxTokens, started, tries)
            // The gateway wants a finalized balance, which trails a fresh grant a little.
            fun settling() = (gateway as? GatewayState.Refused)?.needsFunds == true && faucet is FaucetState.Funded
            while (!ok && tries < BUSY_TRIES && (lastAskBusy || settling())) {
                live = Live(
                    if (lastAskBusy) Stage.Full else Stage.Settling,
                    started,
                    attempt = tries,
                    attempts = BUSY_TRIES,
                    nextAt = System.currentTimeMillis() + BUSY_WAIT_MS,
                    waitMs = BUSY_WAIT_MS,
                    target = PingTarget.Gateway,
                )
                refreshPing()
                knock.tryReceive()
                val knocked = withTimeoutOrNull(BUSY_WAIT_MS) { knock.receive() } != null
                val last = chat.lastOrNull()
                if (last?.role == "user" && last.text == question) {
                    chat = chat.dropLast(1)
                    prefs.chat = chat
                }
                // Their own knock starts the count over: they asked to keep trying.
                tries = if (knocked) 1 else tries + 1
                ok = askNow(question, maxTokens, started, tries)
            }
            val seconds = (System.currentTimeMillis() - started) / 1000
            if (ok) {
                lastAnswerSeconds = seconds
                val reply = chat.lastOrNull()
                askResult = AskResult(question, reply?.text, reply?.costFlop, seconds, null)
            } else {
                if (lastAskBusy) askError = STAYED_FULL
                // The window keeps the question and offers it again. An unanswered question
                // left in the chat would only be asked twice.
                val last = chat.lastOrNull()
                if (last?.role == "user" && last.text == question) {
                    chat = chat.dropLast(1)
                    prefs.chat = chat
                }
                val why = askError ?: (gateway as? GatewayState.Refused)?.message
                    ?: if (gateway is GatewayState.Finished) TRIAL_OVER else "The model did not answer."
                askResult = AskResult(question, null, null, seconds, why)
            }
            return ok
        } finally {
            patient = false
            live = null
        }
    }

    private suspend fun askNow(question: String, maxTokens: Int, started: Long, attempt: Int): Boolean {
        val own = passportAddress ?: return false
        requesting = true
        askError = null
        lastAskBusy = false
        try {
            if (gateway !is GatewayState.Open) {
                live = Live(Stage.Enter, started, target = PingTarget.Gateway)
                enter()
            }
            if (gateway !is GatewayState.Open) return false
            live = Live(Stage.Model, started, attempt = attempt, attempts = BUSY_TRIES, target = PingTarget.Gateway)
            refreshPing()
            val history = chat + FlopPrefs.Message("user", question, null, System.currentTimeMillis())
            chat = history
            prefs.chat = history
            val turns = listOf("system" to SYSTEM_PROMPT) +
                history.takeLast(CONTEXT_TURNS).map { it.role to it.text }
            var r = send(own, turns, maxTokens)
            // 401 is a bearer that is no longer this account's: enrolling on another phone
            // rotates it, and the allowance lives on. Enter again once and retry, rather
            // than calling the trial over.
            var reentered = false
            if (r is FlopGateway.ChatResult.Refused && r.status == 401) {
                prefs.gatewayKey = null
                gateway = GatewayState.Closed
                enter()
                reentered = true
                r = if (gateway is GatewayState.Open) send(own, turns, maxTokens) else NOT_ENTERED
            }
            val open = gateway as? GatewayState.Open
            when (r) {
                is FlopGateway.ChatResult.Answered -> {
                    live = Live(Stage.Cost, started)
                    val reply = FlopPrefs.Message("assistant", r.reply.text.ifBlank { "…" }, r.reply.costFlop, System.currentTimeMillis())
                    chat = history + reply
                    prefs.chat = chat
                    val key = prefs.gatewayKey?.takeIf { it.address == own }
                    val info = key?.let { k -> runCatching { FlopGateway.keyInfo(k.key) }.getOrNull() }
                    if (open != null) gateway = open.copy(remaining = info?.remaining ?: open.remaining)
                    refreshAccount()
                    return true
                }
                NOT_ENTERED -> {
                    // Entering again failed and the gateway card says why. The question was
                    // never sent, so it does not stay in the chat waiting for an answer.
                    chat = history.dropLast(1)
                    prefs.chat = chat
                }
                is FlopGateway.ChatResult.Refused -> {
                    // 402 is the allowance spent. 403, or a 401 straight after a fresh
                    // entry, means the gateway will not take this account's questions.
                    if (r.status == 402 || r.status == 403 || (r.status == 401 && reentered)) {
                        prefs.markGatewayClosed(own)
                        gateway = GatewayState.Finished
                    }
                    lastAskBusy = r.status == 429 || r.status == 503
                    askError = when (r.status) {
                        402 -> "This account's devnet allowance is used up."
                        429, 503 -> "The model is busy. Try again in a minute; nothing was spent."
                        else -> "The model did not answer: ${r.message}"
                    }
                }
                null -> askError = "Could not reach FLOP's gateway. Check your connection and try again."
            }
            return false
        } finally {
            requesting = false
        }
    }

    /** One request with the key stored now; [NOT_ENTERED] without one, null when unreachable. */
    private suspend fun send(own: String, turns: List<Pair<String, String>>, maxTokens: Int): FlopGateway.ChatResult? {
        val open = gateway as? GatewayState.Open ?: return NOT_ENTERED
        val key = prefs.gatewayKey?.takeIf { it.address == own } ?: return NOT_ENTERED
        val r = runCatching { FlopGateway.chat(key.key, open.model, turns, maxTokens) }.getOrNull()
        currentCoroutineContext().ensureActive()
        return r
    }

    fun clearChat() {
        chat = emptyList()
        prefs.chat = emptyList()
    }

    // ------------------------------------------------------------------ network

    data class Network(
        val loading: Boolean = false,
        val stats: FlopExplorer.Stats? = null,
        val spend: FlopExplorer.NetworkSpend? = null,
        val error: String? = null,
        val checkedAt: Long? = null,
    )

    var network by mutableStateOf(Network())
        private set

    /** The dated "what is happening" from the app's makers: built in, refreshed from the site. */
    var status by mutableStateOf(FlopStatus.BUILT_IN)
        private set

    /**
     * The status as this person should read it, corrected by what this phone has seen.
     *
     * The written status can be a day old. If the faucet has just paid this address, telling
     * the person it is down for everyone would be the app contradicting itself on one screen.
     */
    val statusNow: FlopStatus.Status
        get() {
            val faucetWorks = faucet is FaucetState.Funded || fundedToday
            val faucetDown = (faucet as? FaucetState.Refused)?.outage == true
            val lines = status.lines.map { line ->
                val aboutFaucet = line.topic == "faucet" || line.title.contains("faucet", ignoreCase = true)
                when {
                    aboutFaucet && faucetWorks -> FlopStatus.Line(
                        "The faucet works for you",
                        "Your address got its FLOP from the faucet in the last 24 hours. It can ask again 24 hours after the last grant.",
                        FlopStatus.Level.Good,
                        "faucet",
                    )
                    aboutFaucet && faucetDown && line.level != FlopStatus.Level.Problem -> line.copy(level = FlopStatus.Level.Problem)
                    else -> line
                }
            }
            return status.copy(lines = lines)
        }

    /** Lines from the app's news feed, each linking to an official FLOP source. */
    var news by mutableStateOf<List<FlopOfficial.News>>(emptyList())
        private set

    fun refreshNetwork() {
        if (network.loading) return
        network = network.copy(loading = true, error = null)
        viewModelScope.launch {
            val stats = async { runCatching { FlopExplorer.stats() } }
            val spent = async { runCatching { FlopExplorer.networkSpend() } }
            val lang = dev.alexkosa.floppassport.i18n.LanguageStore(getApplication()).effective.code
            val feed = async { runCatching { FlopOfficial.news(lang) } }
            val written = async { runCatching { FlopStatus.fetch(lang) } }
            val s = stats.await()
            val p = spent.await()
            network = Network(
                loading = false,
                stats = s.getOrNull() ?: network.stats,
                spend = p.getOrNull() ?: network.spend,
                error = if (s.isFailure && p.isFailure) "Could not reach the FLOP explorer." else null,
                checkedAt = if (s.isSuccess) System.currentTimeMillis() else network.checkedAt,
            )
            feed.await().getOrNull()?.let { news = it }
            written.await().getOrNull()?.let { status = it }
        }
    }

    // ------------------------------------------------------------------ my day

    enum class DayStep { Sign, Fund, Ask }

    sealed interface DayResult {
        data object Waiting : DayResult
        data object Running : DayResult
        data class Done(val note: String) : DayResult
        data class Skipped(val why: String) : DayResult
        data class Failed(val why: String) : DayResult
    }

    data class DayRun(
        val running: Boolean = false,
        val steps: Map<DayStep, DayResult> = emptyMap(),
        val answer: String? = null,
        val date: String = "",
        val seconds: Long = 0,
    ) {
        operator fun get(step: DayStep): DayResult? = steps[step]

        /** 1 to 3 while a step runs, 0 otherwise. */
        val stepNumber: Int get() = DayStep.entries.indexOfFirst { steps[it] == DayResult.Running } + 1

        /** Whether this run says anything about [today]. */
        fun isFor(today: String): Boolean = running || date == today
    }

    /** Where a run is, in words a person reads: what is happening, then why it is fine. */
    enum class Stage(val title: String, val text: String) {
        Sign("Signing today's line", "Your Passport signs one short line in the public room and reads it back. That line is your day."),
        Faucet("Asking FLOP's faucet", "The faucet pays about 10 people a minute. This can take up to two minutes."),
        Queue("Standing in the faucet's queue", "The faucet pays about 10 people a minute. Your request is in. We watch your balance and ask again by ourselves."),
        Landing("Your FLOP is on its way", "One moment."),
        Enter("Opening the model", "Your Passport signs the gateway's statement. Nothing is spent."),
        Model("Asking the model", "Your question is with the model. It has up to 90 seconds."),
        Full("The model is full right now", "Many people are asking at once. Nothing was spent. We try again by ourselves."),
        Settling("Your FLOP is still settling", "A fresh grant takes a moment to count. We try again by ourselves."),
        Cost("Reading what it cost", "One moment."),
    }

    /** What a screen shows of a running step. Everything here is a fact, none of it a promise. */
    data class Live(
        val stage: Stage,
        val since: Long = System.currentTimeMillis(),
        val attempt: Int = 0,
        val attempts: Int = 0,
        val nextAt: Long = 0,
        val waitMs: Long = 0,
        val target: PingTarget? = null,
    ) {
        fun secondsSoFar(now: Long): Long = ((now - since) / 1000).coerceAtLeast(0)

        /** Seconds to the next try, or null when none is planned. */
        fun secondsToNext(now: Long): Long? =
            if (nextAt == 0L) null else ((nextAt - now + 999) / 1000).coerceAtLeast(0)

        /** How much of the wait is left, 1 to 0, or null when nothing is being counted down. */
        fun waitLeft(now: Long): Float? =
            if (nextAt == 0L || waitMs <= 0L) null else ((nextAt - now).toFloat() / waitMs).coerceIn(0f, 1f)
    }

    enum class RunKind { Ask, Day }

    /** A job the person started and may be watching in the process window. */
    data class Run(val kind: RunKind, val question: String? = null, val minimized: Boolean = false)

    /** How a question ended. */
    data class AskResult(val question: String, val answer: String?, val cost: Double?, val seconds: Long, val failure: String?)

    enum class PingTarget { Gateway, Faucet }

    /** One measurement. Null [ms] is a server that did not answer it. */
    data class Ping(val ms: Long?)

    private var day by mutableStateOf(DayRun())

    /** Today's run. The app can stay open overnight, and yesterday's ticks are not today's. */
    val dayToday: DayRun get() = day.takeIf { it.isFor(ActivityState.today()) } ?: DayRun()

    /** Today's question, the same for everyone on the same day. */
    fun questionOfTheDay(today: String = ActivityState.today()): String {
        val n = runCatching { java.time.LocalDate.parse(today).dayOfYear }.getOrDefault(1)
        return QUESTIONS[n % QUESTIONS.size]
    }

    val askedToday: Boolean get() = prefs.lastAskedDay == ActivityState.today()

    /** Three questions to start from, so an empty chat is never a blank page. */
    val starters: List<String>
        get() = List(3) { QUESTIONS[(java.time.LocalDate.now().dayOfYear + it * 5) % QUESTIONS.size] }

    /** Whether this install has been shown what changed in 2.0. */
    var whatsNewSeen by mutableStateOf(prefs.whatsNewSeen)
        private set

    fun dismissWhatsNew() {
        prefs.whatsNewSeen = true
        whatsNewSeen = true
    }

    /**
     * The whole day in one press: sign today's record, take today's FLOP, ask today's
     * question. Each part is skipped if it is already done, and a part that cannot run says
     * why instead of stopping the rest - the faucet being down must not cost anybody their
     * streak.
     *
     * [signToday] is the Passport's own daily record, so the streak keeps being counted
     * exactly the way it always has been.
     */
    fun doMyDay(alreadySigned: Boolean, signToday: suspend () -> String?) {
        if (runBusy) return
        askResult = null
        val started = System.currentTimeMillis()
        run = Run(RunKind.Day)
        val job = viewModelScope.launch(work) {
            fun put(step: DayStep, r: DayResult) {
                day = day.copy(steps = day.steps + (step to r))
            }
            day = DayRun(
                running = true,
                steps = DayStep.entries.associateWith { DayResult.Waiting },
                date = ActivityState.today(),
            )

            if (alreadySigned) {
                put(DayStep.Sign, DayResult.Done("already signed today"))
            } else {
                put(DayStep.Sign, DayResult.Running)
                live = Live(Stage.Sign)
                val problem = runCatching { signToday() }.getOrElse { "Could not reach technocore.chat." }
                live = null
                // runCatching swallows cancellation: a Passport deleted mid-run must stop here,
                // not carry on and ask the faucet and the model for whoever comes next.
                currentCoroutineContext().ensureActive()
                put(DayStep.Sign, if (problem == null) DayResult.Done("signed and read back") else DayResult.Failed(problem))
            }

            currentCoroutineContext().ensureActive()
            if (fundedToday) {
                put(DayStep.Fund, DayResult.Done("already taken today"))
            } else {
                put(DayStep.Fund, DayResult.Running)
                val funded = claim()
                live = null
                put(
                    DayStep.Fund,
                    when (funded) {
                        is FaucetState.Funded -> DayResult.Done("+${funded.amount} FLOP")
                        is FaucetState.Refused ->
                            if (funded.alreadyToday) DayResult.Done("already taken today") else DayResult.Skipped(funded.message)
                        else -> DayResult.Skipped("The faucet did not answer.")
                    },
                )
            }

            when {
                askedToday -> put(DayStep.Ask, DayResult.Done("already asked today"))
                gateway is GatewayState.Finished -> put(
                    DayStep.Ask,
                    DayResult.Skipped("Your one devnet trial of the model is over. It opens again on testnet."),
                )
                else -> {
                    put(DayStep.Ask, DayResult.Running)
                    val before = chat.size
                    val question = questionOfTheDay()
                    // A question sent from the Ask tab just before this step finishes first.
                    while (asking) kotlinx.coroutines.delay(250)
                    val ok = askPatiently(question, maxTokens = 160)
                    if (ok) {
                        prefs.lastAskedDay = ActivityState.today()
                        val cost = chat.lastOrNull()?.costFlop
                        day = day.copy(answer = chat.drop(before).lastOrNull { it.role == "assistant" }?.text)
                        put(DayStep.Ask, DayResult.Done(cost?.let { "spent ${"%.3f".format(it)} FLOP" } ?: "answered"))
                    } else {
                        put(DayStep.Ask, DayResult.Skipped(askResult?.failure ?: "The model did not answer."))
                    }
                }
            }
            day = day.copy(running = false, seconds = (System.currentTimeMillis() - started) / 1000)
        }
        // A Passport deleted mid-run cancels this; the status must not outlive it.
        job.invokeOnCompletion { live = null }
    }

    init {
        refreshAccount()
        refreshNetwork()
    }

    companion object {
        const val FAUCET_COOLDOWN_MS = 24L * 60 * 60 * 1000
        private const val CONTEXT_TURNS = 8
        private const val BUSY_TRIES = 6
        private const val GRANT_TRIES = 4
        private const val UNRECOGNISED = "unrecognised_challenge"

        /** A stand-in result: there was no open allowance to ask with. */
        private val NOT_ENTERED = FlopGateway.ChatResult.Refused(0, "")
        private const val BUSY_WAIT_MS = 30_000L

        private const val COMMUNITY_EVERY_MS = 6 * 60 * 60 * 1000L
        private const val TRIAL_OVER = "Your one devnet trial of the model is over. It opens again on testnet."
        private const val STAYED_FULL = "FLOP's gateway stayed full through all 6 tries. Nothing was spent. This is on FLOP's side, not yours."

        private const val SYSTEM_PROMPT =
            "You are a small model running on FLOP Network's devnet, answering inside a phone app. " +
                "Answer briefly and plainly. Answer in the language the user writes in."

        /** Short questions a half-billion-parameter model can answer without embarrassment. */
        val QUESTIONS = listOf(
            "In two sentences, what does a GPU do that a CPU does badly?",
            "Explain what a blockchain block is to a ten-year-old, in three sentences.",
            "Give me one practical tip for writing clearer emails.",
            "What is a hash function? Two sentences.",
            "Name three uses of AI that run well on small models.",
            "In plain words, what does 'inference' mean for an AI model?",
            "Suggest a five-minute stretch for someone who sits all day.",
            "What is the difference between a private key and a public key?",
            "Give one good question to ask before buying any crypto token.",
            "Explain what an API is using a restaurant as the example.",
            "What makes a password strong? Three short points.",
            "Summarise what 'proof of work' means in two sentences.",
            "Give me a simple recipe idea with rice and eggs.",
            "What is latency, and why do people care about it?",
            "Explain what open-source software is in two sentences.",
            "Tell me one interesting fact about the history of computers.",
            "What is a token in the context of language models?",
            "Give three tips for keeping a phone's battery healthy.",
            "What is a validator in a blockchain network? Keep it short.",
            "Explain what 'decentralised' means without using jargon.",
            "Write a haiku about a phone that never sleeps.",
            "What is phishing, and how do you spot it? Three signs.",
            "Why do computers use binary? Two sentences.",
            "Give one way to remember a new word in a foreign language.",
            "What does a miner do in a compute network?",
            "Explain the idea of a 'seed phrase' and why it must stay secret.",
            "What is the cloud, really? Two sentences.",
            "Give me a short motivational sentence for a Monday.",
            "What is an AI agent, in one paragraph?",
            "Name three things to check before signing anything in a crypto wallet.",
        )
    }
}
