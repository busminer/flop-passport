package dev.alexkosa.floppassport.flop

import dev.alexkosa.floppassport.crypto.Ss58
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.bouncycastle.crypto.digests.Blake2bDigest
import org.json.JSONArray
import org.json.JSONObject
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

/**
 * FLOP Network's public surfaces, as this app uses them.
 *
 * Every address here is one FLOP lists on its own official-links page (docs.flop.network,
 * "Official links & verification", updated 2026-10-23): the gateway at api.flop.network,
 * the devnet faucet, the devnet RPC, and the explorer that FLOP links from the faucet.
 * Nothing is read from a third party.
 *
 * All of it is devnet today. Devnet FLOP has no value, carries no airdrop weight, and the
 * network may be reset; the screens say so wherever a balance is shown.
 */
object FlopEndpoints {
    const val GATEWAY = "https://api.flop.network/v1"
    const val GATEWAY_HEALTH = "https://api.flop.network/health"
    const val FAUCET = "https://faucet.flop.network"
    const val FAUCET_HEALTH = "https://faucet.flop.network/health"
    const val RPC = "https://rpc.devnet.flop.network"
    const val EXPLORER = "https://explorer.devnet.flop.network"

    fun explorerAccount(address: String) = "$EXPLORER/accounts/$address"
    fun explorerTx(hash: String) = "$EXPLORER/transactions/$hash"
}

/** FLOP has 18 decimals: `system_properties` on devnet, measured 2026-11-03. */
object FlopAmount {
    private val ONE = BigDecimal.TEN.pow(18)

    fun fromRaw(raw: String?): BigDecimal =
        runCatching { BigDecimal(BigInteger(raw!!.trim())).divide(ONE) }.getOrDefault(BigDecimal.ZERO)

    /** Short enough for a tile: whole FLOP above 100, two places below, never scientific. */
    fun format(value: BigDecimal): String {
        val scale = when {
            value.abs() >= BigDecimal(100) -> 0
            value.abs() >= BigDecimal.ONE -> 2
            value.signum() == 0 -> 0
            else -> 4
        }
        return value.setScale(scale, RoundingMode.DOWN).stripTrailingZeros().toPlainString()
    }
}

/**
 * One HTTP exchange with a FLOP service.
 *
 * The user agent names the app. Cloudflare in front of the devnet RPC refuses Python's
 * default agent with a 403 (measured 2026-11-03) and accepts an Android one, so naming
 * ourselves is both the polite thing and the thing that works.
 */
internal object FlopHttp {
    private const val TIMEOUT_MS = 15_000
    private const val PING_TIMEOUT_MS = 6_000

    data class Response(val status: Int, val body: String) {
        val ok: Boolean get() = status in 200..299
        fun json(): JSONObject? = runCatching { JSONObject(body) }.getOrNull()
    }

    suspend fun request(
        url: String,
        method: String = "GET",
        json: JSONObject? = null,
        bearer: String? = null,
        timeoutMs: Int = TIMEOUT_MS,
    ): Response = withContext(Dispatchers.IO) {
        val conn = (URL(url).openConnection() as HttpURLConnection).apply {
            requestMethod = method
            connectTimeout = timeoutMs
            readTimeout = timeoutMs
            setRequestProperty(
                "User-Agent",
                "FLOP-Passport-for-Seeker/" + dev.alexkosa.floppassport.BuildConfig.VERSION_NAME,
            )
            setRequestProperty("Accept", "application/json")
            if (bearer != null) setRequestProperty("Authorization", "Bearer $bearer")
            if (json != null) {
                doOutput = true
                setRequestProperty("Content-Type", "application/json")
            }
        }
        try {
            if (json != null) conn.outputStream.use { it.write(json.toString().toByteArray(Charsets.UTF_8)) }
            val code = conn.responseCode
            val stream = if (code in 200..299) conn.inputStream else conn.errorStream
            Response(code, stream?.bufferedReader()?.use { it.readText() } ?: "")
        } finally {
            conn.disconnect()
        }
    }

    /** How long [url] takes to answer, in milliseconds, or null when it does not. */
    suspend fun ping(url: String): Long? = runCatching {
        val start = System.nanoTime()
        val r = request(url, timeoutMs = PING_TIMEOUT_MS)
        ((System.nanoTime() - start) / 1_000_000).takeIf { r.ok }
    }.getOrNull()

    fun enc(s: String): String = URLEncoder.encode(s, "UTF-8")
}

/** Balances, straight from a devnet node rather than from an indexer that can lag. */
object FlopChain {

    /**
     * `System.Account` storage for one account: the pallet and item prefix, then the
     * Blake2-128 of the account id followed by the account id itself. The prefix is the
     * same constant on every Substrate chain.
     */
    internal fun accountStorageKey(accountId: ByteArray): String {
        val prefix = "26aa394eea5630e07c48ae0c9558cef7b99d880ec681799c0cf30e8886371da9"
        val digest = Blake2bDigest(128)
        digest.update(accountId, 0, accountId.size)
        val hash = ByteArray(16)
        digest.doFinal(hash, 0)
        return "0x" + prefix + (hash + accountId).toHex()
    }

    /**
     * Free balance from an encoded `AccountInfo`: four u32 counters, then the free balance
     * as a little-endian u128. An account that has never received anything has no entry
     * at all, which is a balance of zero rather than an error.
     */
    internal fun freeFromAccountInfo(hex: String?): BigInteger {
        if (hex.isNullOrBlank() || hex == "null") return BigInteger.ZERO
        val bytes = hex.removePrefix("0x").chunked(2).map { it.toInt(16).toByte() }.toByteArray()
        require(bytes.size >= 32) { "AccountInfo too short" }
        val free = bytes.copyOfRange(16, 32).reversedArray()
        return BigInteger(1, free)
    }

    suspend fun freeBalance(address: String): BigDecimal {
        val key = accountStorageKey(Ss58.decode(address))
        val body = JSONObject()
            .put("jsonrpc", "2.0").put("id", 1)
            .put("method", "state_getStorage")
            .put("params", JSONArray().put(key))
        val r = FlopHttp.request(FlopEndpoints.RPC, "POST", body)
        check(r.ok) { "The devnet node answered HTTP ${r.status}" }
        val json = r.json() ?: error("The devnet node sent something that is not JSON")
        json.optJSONObject("error")?.let { error(it.optString("message", "RPC error")) }
        val raw = freeFromAccountInfo(if (json.isNull("result")) null else json.optString("result"))
        return BigDecimal(raw).divide(BigDecimal.TEN.pow(18))
    }
}

/** What the explorer knows: the network as a whole, and one account's spending. */
object FlopExplorer {

    data class Stats(
        val latestBlock: Long,
        val finalizedLag: Int?,
        val activeValidators: Int,
        val activeAgents: Int,
        val totalAccounts: Int,
        val tps: Double,
    )

    data class Spend(val spent: BigDecimal, val channels: Int)

    data class NetworkSpend(val spent: BigDecimal, val agents: Int, val channels: Int)

    suspend fun stats(): Stats {
        val r = FlopHttp.request("${FlopEndpoints.EXPLORER}/api/stats")
        val j = r.json()?.takeIf { r.ok } ?: error("The explorer answered HTTP ${r.status}")
        return Stats(
            latestBlock = j.optLong("latestBlockNumber"),
            finalizedLag = j.optJSONObject("finality")?.optInt("finalizedLag"),
            activeValidators = j.optInt("activeValidators"),
            activeAgents = j.optInt("activeAgents"),
            totalAccounts = j.optInt("totalAccounts"),
            tps = j.optDouble("tps", 0.0),
        )
    }

    /**
     * What this account has spent on inference, as the chain records it.
     *
     * This is the figure that matters once testnet opens: FLOP's agent airdrop is earned by
     * testnet FLOP actually spent on inference. A community operator found on 2026-11-02
     * that spend through the hosted gateway can be booked to the gateway's broker rather
     * than to the agent, so the app shows this number instead of trusting its own tally -
     * if it stays at zero after a paid answer, that is the finding, and it is visible.
     */
    suspend fun inferenceSpend(address: String): Spend {
        val r = FlopHttp.request("${FlopEndpoints.EXPLORER}/api/accounts/${FlopHttp.enc(address)}/inference-spend")
        val j = r.json()?.takeIf { r.ok } ?: error("The explorer answered HTTP ${r.status}")
        return Spend(FlopAmount.fromRaw(j.optString("totalSpentRaw", "0")), j.optInt("channelCount"))
    }

    suspend fun networkSpend(): NetworkSpend {
        val r = FlopHttp.request("${FlopEndpoints.EXPLORER}/api/inference-spend?limit=1")
        val j = r.json()?.takeIf { r.ok } ?: error("The explorer answered HTTP ${r.status}")
        return NetworkSpend(
            FlopAmount.fromRaw(j.optString("totalSpentRaw", "0")),
            j.optInt("uniqueAgents"),
            j.optInt("settledChannels"),
        )
    }
}

/**
 * The devnet faucet: 25 FLOP, once a day per address.
 *
 * Its limits, from its own /health on 2026-11-03: one grant per address per 24 hours, a
 * ten-second cooldown and 300 grants a day per client IP. The request is made from this
 * phone, on this person's connection, for their own address - the same request the
 * faucet's web page makes when they press its button.
 */
object FlopFaucet {

    sealed class Result {
        data class Funded(val amount: String, val txHash: String?) : Result()
        data class Refused(val status: Int, val message: String) : Result()
    }

    suspend fun fund(address: String): Result {
        val r = FlopHttp.request(
            "${FlopEndpoints.FAUCET}/fund",
            "POST",
            JSONObject().put("address", address),
            timeoutMs = 120_000,
        )
        val j = r.json()
        if (r.ok && j?.optBoolean("success") == true) {
            return Result.Funded(j.optString("amount", "25"), j.optString("txHash").ifBlank { null })
        }
        return Result.Refused(r.status, j?.optString("error")?.ifBlank { null } ?: "HTTP ${r.status}")
    }

    /**
     * The faucet's refusal for an address inside its 24 hours, as it said it on 3 November:
     * "Address funded recently; retry in 1337 min". Its per-network limits answer 429 too,
     * so the status alone cannot tell the two apart.
     */
    fun isAddressCooldown(status: Int, message: String): Boolean {
        val m = message.lowercase()
        return (status == 429 || status == 400) &&
            (m.contains("address funded") || m.contains("funded recently") || m.contains("already funded"))
    }

    /** 503 "Grant pending; retry the original request later": accepted, not yet sent. */
    fun isGrantPending(message: String): Boolean = message.contains("grant pending", ignoreCase = true)

    /** No answer yet, or a grant in the queue: worth watching the chain and asking again. */
    fun stillWaiting(r: Result?): Boolean =
        r == null || (r is Result.Refused && isGrantPending(r.message))

    /** 429 "Faucet daily cap reached; try again later": the day's FLOP is gone for everybody. */
    fun isDailyCap(message: String): Boolean = message.contains("daily cap", ignoreCase = true)

    /** The minutes in "retry in N min", or null. */
    fun retryMinutes(message: String): Int? =
        Regex("""retry in (\d{1,4}) ?min""", RegexOption.IGNORE_CASE).find(message)
            ?.groupValues?.get(1)?.toIntOrNull()?.takeIf { it in 0..1440 }
}

/**
 * FLOP's OpenAI-compatible gateway, entered by signing a challenge with the Passport key.
 *
 * The rules, from the gateway's own OpenAPI document on 2026-11-03: the challenge lives
 * five minutes and is single use; the account must hold at least 1 FLOP; a new account gets
 * one allowance for at most 24 hours (25 FLOP by its docs, 20,000 as it answered on 3 November,
 * so the app shows the figure and states none); enrolling again only rotates the key, and
 * an allowance that has expired or run out is never renewed on devnet. Ed25519 signatures
 * are accepted alongside sr25519, which is what lets a Passport key do this unchanged.
 */
object FlopGateway {

    data class Challenge(val message: String, val expiresAt: Long)

    data class Enrollment(val key: String, val model: String, val remaining: Double, val expiresAt: Long)

    sealed class EnrollResult {
        data class Enrolled(val enrollment: Enrollment) : EnrollResult()
        data class Refused(val status: Int, val code: String?, val message: String) : EnrollResult()
    }

    data class Reply(val text: String, val costFlop: Double?, val model: String)

    sealed class ChatResult {
        data class Answered(val reply: Reply) : ChatResult()
        data class Refused(val status: Int, val message: String) : ChatResult()
    }

    data class KeyInfo(val remaining: Double, val expiresAt: Long?)

    suspend fun challenge(address: String): Challenge {
        val r = FlopHttp.request("${FlopEndpoints.GATEWAY}/enroll/wallet/challenge?address=${FlopHttp.enc(address)}")
        val j = r.json()?.takeIf { r.ok } ?: error(errorText(r))
        return Challenge(j.getString("message"), j.optLong("expires_at"))
    }

    /**
     * Whether [message] is FLOP's enrolment statement for [address] and nothing else.
     *
     * The shape the gateway sent on 3 November 2026:
     * "api.flop.network wants you to enroll a FLOP devnet gateway key with your account:\n
     * <address>\n\nAction: flop-devnet-enroll/v1\nGenesis: …\nNonce: …". Technocore records
     * and notes are `room|nonce|text` and `ns|key|nonce|value`, so a statement without `|`
     * can never be either of them, whatever else the gateway puts in it.
     */
    fun isEnrollStatement(message: String, address: String): Boolean =
        message.length <= 2_000 &&
            '|' !in message &&
            message.startsWith("api.flop.network wants you to enroll a FLOP devnet gateway key with your account:\n$address\n") &&
            Regex("""(?m)^Action: flop-devnet-enroll/v\d+$""").containsMatchIn(message)

    suspend fun enroll(address: String, message: String, signatureHex: String): EnrollResult {
        val r = FlopHttp.request(
            "${FlopEndpoints.GATEWAY}/enroll/wallet",
            "POST",
            JSONObject().put("address", address).put("message", message).put("signature", "0x$signatureHex"),
        )
        val j = r.json()
        if (r.ok && j != null && j.has("key")) {
            return EnrollResult.Enrolled(
                Enrollment(
                    key = j.getString("key"),
                    model = j.optString("model"),
                    remaining = j.optDouble("remaining_quota", 0.0),
                    expiresAt = expiryMillis(j.opt("expires_at")),
                ),
            )
        }
        return EnrollResult.Refused(r.status, errorCode(j), errorText(r))
    }

    suspend fun keyInfo(key: String): KeyInfo? {
        val r = FlopHttp.request("${FlopEndpoints.GATEWAY}/keys/me", bearer = key)
        val j = r.json()?.takeIf { r.ok } ?: return null
        return KeyInfo(j.optDouble("remaining_quota", 0.0), expiryMillis(j.opt("expires_at")).takeIf { it > 0 })
    }

    /** One turn. History is sent whole: the gateway keeps no conversation of its own. */
    suspend fun chat(key: String, model: String, messages: List<Pair<String, String>>, maxTokens: Int = 256): ChatResult {
        val array = JSONArray()
        messages.forEach { (role, content) -> array.put(JSONObject().put("role", role).put("content", content)) }
        val r = FlopHttp.request(
            "${FlopEndpoints.GATEWAY}/chat/completions",
            "POST",
            JSONObject().put("model", model).put("messages", array).put("max_tokens", maxTokens),
            bearer = key,
            timeoutMs = 90_000,
        )
        val j = r.json()
        if (!r.ok || j == null) return ChatResult.Refused(r.status, errorText(r))
        val text = j.optJSONArray("choices")?.optJSONObject(0)?.optJSONObject("message")?.optString("content").orEmpty()
        val usage = j.optJSONObject("usage")
        val cost = number(usage?.opt("cost_flop"))
        return ChatResult.Answered(Reply(text.trim(), cost, j.optString("model", model)))
    }

    /**
     * The gateway's `expires_at` in milliseconds, or 0 when it gave none. It sends
     * milliseconds today; a value small enough to be seconds is read as seconds, so a
     * change on their side cannot make a live allowance look long expired.
     */
    fun expiryMillis(v: Any?): Long {
        val n = number(v)?.toLong() ?: return 0L
        return when {
            n <= 0L -> 0L
            n < 100_000_000_000L -> n * 1000
            else -> n
        }
    }

    /** A finite number from a JSON value that may be a number, a numeric string, or null. */
    fun number(v: Any?): Double? = when (v) {
        is Number -> v.toDouble()
        is String -> v.toDoubleOrNull()
        else -> null
    }?.takeIf { it.isFinite() }

    private fun errorCode(j: JSONObject?): String? {
        val e = j?.opt("error") ?: return null
        return when (e) {
            is JSONObject -> e.optString("code").ifBlank { e.optString("type") }.ifBlank { null }
            else -> e.toString()
        }
    }

    private fun errorText(r: FlopHttp.Response): String {
        val j = r.json()
        val e = j?.opt("error")
        val text = when (e) {
            is JSONObject -> e.optString("message").ifBlank { e.optString("code") }
            is String -> e
            else -> j?.optString("message")
        }
        return text?.ifBlank { null } ?: "HTTP ${r.status}"
    }
}

internal fun ByteArray.toHex(): String = joinToString("") { "%02x".format(it) }
