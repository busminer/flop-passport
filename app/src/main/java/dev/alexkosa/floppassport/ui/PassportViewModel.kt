package dev.alexkosa.floppassport.ui

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dev.alexkosa.floppassport.crypto.DidKey
import dev.alexkosa.floppassport.crypto.Ed25519
import dev.alexkosa.floppassport.notify.FinishNudge
import dev.alexkosa.floppassport.notify.NudgePrefs
import dev.alexkosa.floppassport.proof.PostComposer
import dev.alexkosa.floppassport.proof.SharePrefs
import dev.alexkosa.floppassport.proof.looksLikeXPost
import dev.alexkosa.floppassport.technocore.Canonical
import dev.alexkosa.floppassport.technocore.DidNote
import dev.alexkosa.floppassport.technocore.Technocore
import dev.alexkosa.floppassport.notify.NoteLife
import dev.alexkosa.floppassport.vault.PassportVault
import dev.alexkosa.floppassport.wallet.WalletLink
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

const val CHECK_IN_ROOM = "flop-passport"
/**
 * The first signed line, ending in the key's own fingerprint.
 *
 * The fingerprint is what makes it this person's sentence and not everybody's. The service
 * documents a duplicate filter - copies of one text, counted across senders, refused with a
 * 422 once five land inside two minutes - and every user of this app writes into one shared
 * room. Measured today the filter is not enforced on this deployment, so this is insurance
 * rather than a repair; but a launch that puts six people through step 04 in the same
 * minute is exactly the traffic the app is built to attract, and the failure would look to
 * each of them like a broken key. It also leaves a readable room instead of a thousand
 * identical lines.
 */
fun checkInText(did: String): String =
    "FLOP Passport for Seeker. First signed check-in. " + DidKey.fingerprint(did)

/**
 * Holds the setup so it survives the screen being rebuilt.
 *
 * Android destroys and recreates an Activity on every rotation, and state kept in the
 * composition goes with it. Left in the screen, turning the phone over mid-signature would
 * throw away the flow and drop the user back at step one with no idea why - and the launch
 * animation would replay each time. A ViewModel outlives the configuration change, so the
 * work carries on and the screen simply redraws whatever is true when it comes back.
 *
 * The wallet handshake is the reason this matters most: it spans another app's activity,
 * which is exactly when a rotation is most likely and least forgivable.
 */
class PassportViewModel(app: Application) : AndroidViewModel(app) {

    private val vault = PassportVault(app)
    private val technocore = Technocore()

    /**
     * Every coroutine this class starts hangs off this job, so deleting the Passport can
     * cancel all of them at once.
     *
     * Without it, a publish still in flight when the person pressed delete finished a few
     * seconds later and wrote its Verified into the empty ladder of whatever identity came
     * next - a brand-new key with step 03 already green, on the strength of another key's
     * note. Every step also re-checks that the identity it worked for is still the one on
     * the phone before it writes anything, because a cancelled coroutine can be one
     * statement away from its write.
     */
    private var work: CompletableJob = SupervisorJob()

    /**
     * The launch-time question to the server has not been answered yet.
     *
     * While it is open the buttons for steps 03 and 04 wait: pressing publish while the
     * server was about to say "already published" posted a second vouch line, and a
     * refusal arriving after the restore had lit the step flipped it back to Failed for a
     * note that was sitting on the server the whole time.
     */
    var restoring by mutableStateOf(false)
        private set

    /** Why the launch-time question could not be answered, in words for the screen. */
    var restoreError by mutableStateOf<String?>(null)
        private set

    /**
     * The last measured round trip to technocore.chat, for the screens that claim to be
     * talking to it. Straight from the client, not a copy: nothing here can drift from
     * what the network actually did.
     */
    val pulse = technocore.pulse

    var flow by mutableStateOf(restoreFlow())
        private set
    var did by mutableStateOf(vault.did)
        private set
    var walletAddress by mutableStateOf(vault.walletAddress)
        private set

    /**
     * The step whose outcome the user has not seen yet.
     *
     * Set only by actions the user took, never by the background refresh on opening: being
     * greeted by a congratulations dialog for something you did yesterday is noise, and it
     * would teach people to dismiss these without reading them.
     */
    var announce by mutableStateOf<Step?>(null)
        private set

    fun dismissAnnouncement() {
        announce = null
    }

    /** True once the launch scene has played, so a rotation does not replay it. */
    var launchScenePlayed by mutableStateOf(false)
        private set

    val securityLevel: PassportVault.SecurityLevel get() = vault.securityLevel

    /** What the server still holds for this identity. Never inferred from local state. */
    var activity by mutableStateOf(ActivityState())
        private set

    /** Shown once, after the last step lands. Alex's ask: invite support at the finish. */
    var showSupportInvite by mutableStateOf(false)
        private set

    fun dismissSupportInvite() {
        showSupportInvite = false
        vault.supportInviteShown = true
    }

    /**
     * Offer the invitation, at most once for this install.
     *
     * Every route to the finish calls this, including the quiet reconcile on opening. A
     * returning user - a reinstall, a second device - arrives at a finished Passport
     * without ever pressing the last button, and used to reach the end having never been
     * asked. Once, on whichever route, is the honest middle.
     */
    /**
     * Ask once, at the end, and only after the person has been told they are finished.
     *
     * It used to fire when the fifth step went green, which is in the middle of somebody's
     * work: they still had the post to write and the link to bring back, and the app
     * interrupted that to ask them for money. Now it waits for the link to land in the note
     * and for the congratulation to have been earned. Ask where something was just
     * finished, never where something is still owed.
     */
    private fun offerSupportInvite() {
        if (!flow.complete || !nameLinked) return
        if (!vault.supportInviteShown) showSupportInvite = true
    }

    /**
     * Re-read everything public about this Passport and show only what came back.
     *
     * This is the honest answer to "is my history still there": rooms are compacted, so a
     * record that existed last week may simply be gone. The screen shows what a stranger
     * would find today, not what this phone remembers doing.
     */
    fun refreshActivity(force: Boolean = false, carryError: String? = null) {
        val identity = did ?: return
        // The guard stops two taps racing each other. It must not stop the refresh that
        // follows a write, which sets `checking` itself: that combination left the flag on
        // forever, so the screen said CHECKING for the rest of its life and the record the
        // user had just signed never appeared.
        if (activity.checking && !force) return
        // `carryError` is the outcome of the write this refresh follows. It used to be set
        // and then wiped by this very line before a frame was drawn, so a refused daily
        // record looked like a button that did nothing.
        activity = activity.copy(checking = true, error = carryError)
        viewModelScope.launch(work) {
            runCatching {
                val note = technocore.readIdentityNote(identity)
                // One read of the room serves both halves: the records a person left, and
                // every line this key signed, which is what vouches for the note. Two
                // reads could disagree if a line landed between them.
                val all = technocore.findAllMessages(CHECK_IN_ROOM, identity)
                val records = all
                    // A did-note line is machinery: it vouches for the profile note and
                    // says nothing about what this person did. Listing it as activity put
                    // a wall of hex in front of the user and inflated their own count.
                    .filterNot { DidNote.parse(it.signedText) != null }
                    .map {
                        ActivityState.Record(
                            seq = it.seq,
                            nonce = it.nonce,
                            text = it.signedText,
                            timestamp = it.timestamp,
                            room = it.room,
                        )
                    }.sortedByDescending { it.seq }
                // Newest first, as the convention expects.
                val signedLines = all.sortedByDescending { it.seq }.map { it.signedText }
                val verdict = DidNote.check(identity, note, signedLines)
                if (did != identity) return@runCatching
                // A note our key vouched for is ours whatever this phone remembers. After a
                // reinstall it remembers nothing, and the post link the person pasted lives
                // only in that note - so it is read back from there before anything here
                // could overwrite it.
                if (verdict == DidNote.Verdict.MATCHES) adoptLinksFrom(note)
                val ours = noteValue()
                activity = ActivityState(
                    checking = false,
                    lastChecked = System.currentTimeMillis(),
                    error = carryError,
                    noteValue = note,
                    noteVerdict = verdict,
                    records = records,
                    daysSinceNoteWrite = NoteLife.daysSinceWrite(getApplication()),
                    noteDaysLeft = NoteLife.daysLeft(getApplication()),
                )
                // Turning up counts. Somebody who opens the app to look at their history
                // has proved they are still here, and one idempotent write buys them
                // another seven days - so the note outlives every user who keeps the app
                // rather than only those who remember to sign something.
                //
                // Skipped when a note is present but is not ours: that is the CHANGED
                // case, where somebody else overwrote the address, and the screen says so
                // and offers to publish. Repairing it quietly behind the user's back would
                // hide the one event they most need to see.
                // Renewable means "this address is ours to write". A note whose hash a
                // valid signed line carries is ours whatever its text says - which is how
                // notes written by an earlier release, with a different wording, are kept
                // alive rather than abandoned. A note that is present, is not our text and
                // nothing vouches for is somebody else's, and is left alone.
                val renewable = note == null || note == ours ||
                    verdict == DidNote.Verdict.MATCHES
                // And only after the person has actually published. Opening this tab at
                // step 02 used to publish the note and post a signed line into the public
                // room - work the user had not asked for and had not been told about,
                // while the ladder still showed 03 as pending and every failure dialog
                // promised "Nothing was published." Decided from what was just read, not
                // only from the ladder: on a cold start the ladder is still being restored
                // and could lose the race, which silently skipped the renewal the
                // notifications promise.
                val published = flow[Step.Publish] is StepState.Verified ||
                    (note != null && (note == ours || verdict == DidNote.Verdict.MATCHES))
                // The server answered, so the ladder can be asked again too: a person who
                // launched offline and pressed re-check on the Activity tab used to see
                // their records come back while the Passport tab kept saying "not live".
                if (restoreError != null ||
                    (published && flow[Step.Publish] !is StepState.Verified)
                ) {
                    if (!restoring) refreshFromServer()
                }
                if (published && renewable && NoteLife.daysSinceWrite(getApplication()) != 0) {
                    keepNoteAlive(identity, note)
                    if (did != identity) return@runCatching
                    activity = activity.copy(
                        daysSinceNoteWrite = NoteLife.daysSinceWrite(getApplication()),
                        noteDaysLeft = NoteLife.daysLeft(getApplication()),
                    )
                }
            }.onFailure {
                if (it is CancellationException || did != identity) return@onFailure
                activity = activity.copy(
                    checking = false,
                    error = carryError ?: ("Could not reach technocore.chat. This says nothing about your " +
                        "records, only about the connection."),
                )
            }
        }
    }

    /**
     * Take the post link out of a note our key vouched for, when this phone has none.
     *
     * The link is the one thing a finished Passport publishes that cannot be rebuilt from
     * the wallet. A reinstall, or a second device, arrives with an empty field and would
     * otherwise write the note again without it - deleting the person's own proof from
     * the public address, and re-signing for the shorter text. Only a vouched note is
     * trusted here: the address is world-writable, and a stranger's `x:` must not become
     * this person's finished sixth step.
     */
    private fun adoptLinksFrom(note: String?) {
        if (note == null || share.xPostUrl.isNotBlank()) return
        val url = PostComposer.xPostFromNote(note) ?: return
        if (!looksLikeXPost(url)) return
        share.xPostUrl = url
        xPostUrl = url
    }

    /**
     * A further signed record on a later day, which is what keeps a streak alive - and,
     * in the same breath, what keeps the identity note from being deleted.
     *
     * The record and the note expire under the same seven-day rule but for different
     * reasons: the room stays alive because everybody writes to it, while a person's note
     * is written by that person alone. So a check-in that only signed a line would leave
     * somebody with a growing streak and, seven days after their last setup, an empty
     * address. Renewing here costs one idempotent write and means an active person can
     * never reach the edge.
     *
     * Order matters. The record is signed first and the note second: if the connection
     * dies halfway, the day the person turned up is the part that survives.
     */
    fun checkInAgain(text: String) {
        val identity = did ?: return
        if (flow.busy || activity.checking) return
        // Only once the ladder is finished. This button used to be live at step 01: it
        // signed a public line and then published the identity note as a side effect,
        // while the Passport tab still showed 03 and 04 as pending and every failure
        // dialog there promised "Nothing was published."
        if (flow[Step.Publish] !is StepState.Verified ||
            flow[Step.CheckIn] !is StepState.Verified
        ) {
            return
        }
        activity = activity.copy(checking = true, error = null)
        viewModelScope.launch(work) {
            var outcome: String? = null
            runCatching {
                // Read before writing, the way the first check-in does. Without it a write
                // the server took but could not confirm left the button live and the
                // screen saying nothing was signed today - and the next tap minted a new
                // nonce and posted the same sentence a second time, in public, for good.
                if (technocore.findAllMessages(CHECK_IN_ROOM, identity)
                        .any { it.signedText == text }
                ) {
                    return@runCatching
                }
                val nonce = technocore.nextNonce(CHECK_IN_ROOM, identity)
                val result = technocore.saySigned(
                    did = identity,
                    room = CHECK_IN_ROOM,
                    text = text,
                    nonce = nonce,
                    sign = { vault.sign(it) },
                )
                if (did != identity) return@runCatching
                // The result used to be thrown away, so a refusal was indistinguishable
                // from a success that had not appeared yet.
                when (result) {
                    is Technocore.Result.Verified -> keepNoteAlive(identity, activity.noteValue)
                    is Technocore.Result.Unconfirmed -> outcome =
                        "The service took your record but has not shown it back " +
                            "yet. Press re-check in a moment; nothing needs signing again."
                    is Technocore.Result.Refused -> outcome =
                        "technocore.chat refused the record. It refuses writes " +
                            "when it is busy - try again in a moment."
                }
            }.onFailure {
                if (it is CancellationException) return@onFailure
                outcome = "Could not reach technocore.chat. Check your connection and " +
                    "try again; nothing was lost."
            }
            if (did != identity) return@launch
            // The refresh carries the outcome across, so the sentence survives long enough
            // to be read. Setting it and then refreshing used to erase it in the same
            // frame.
            refreshActivity(force = true, carryError = outcome)
        }
    }

    /**
     * Rewrite the note, and re-sign for it only when nothing valid vouches for it.
     *
     * Two different jobs with two different costs. The note write is a fixed-value key set
     * that resets the seven-day clock, so it happens every time. The signed line is a
     * public message in a shared room, so posting one daily would fill the room with
     * identical machinery lines and inflate nothing but noise - it is written only when
     * the room no longer holds one that matches, which happens after compaction drops the
     * old line, or after somebody overwrote the note.
     *
     * Failures are swallowed on purpose. This runs beside something the user asked for,
     * and a lost connection here must not turn their successful check-in into an error.
     */
    private suspend fun keepNoteAlive(identity: String, observed: String?) {
        runCatching {
            val ours = noteValue()
            if (!renewNote(identity)) return

            // A signed line vouches for exact bytes, so it survives this write only if the
            // note that was already there was byte-identical to what we just wrote AND
            // something valid vouched for it. Both halves matter: an earlier release
            // composed a different note text, and renewing over it while keeping the old
            // signed line would leave every one of those users permanently reading
            // "changed" about their own note.
            val stillVouched =
                observed == ours && activity.noteVerdict == DidNote.Verdict.MATCHES
            if (!stillVouched) vouchForNote(identity, ours)
        }
    }

    init {
        // Re-establish what is actually true rather than trusting the phone. A reinstall,
        // a cleared app or a second device all leave a Passport whose public records
        // already exist; showing those steps as pending would invite the user to publish
        // them again, and a room is append-only.
        if (did != null) {
            refreshFromServer()
            // And the note itself, on open, not only when somebody happens to visit the
            // Activity tab. `nameLinked` reads `activity.noteValue`, so without this a
            // person who finished everything was shown "5 of 6 - one step left" on every
            // launch, the sixth row said "not done", and half an hour later the phone told
            // them so again in a notification. The app disbelieving a finished user is the
            // same defect as believing an unfinished one, pointed the other way.
            refreshActivity()
        }
    }

    /** Ask the server what it already holds for this identity, and reflect only that. */
    fun refreshFromServer() {
        val identity = did ?: return
        restoring = true
        restoreError = null
        viewModelScope.launch(work) {
            runCatching {
                val note = technocore.readIdentityNote(identity)
                // Ours, not merely present. The address is world-writable: anybody can put
                // a line at it, and this used to tick step 03 green for whatever was
                // found - so a stranger overwriting the note repaired the ladder instead
                // of raising the alarm, while the Activity tab said "changed" about the
                // same bytes. A note is ours when it is the text we compose, or when a
                // signed line of ours vouches for its hash, which is how a note written by
                // an earlier release with different wording still counts.
                val vouched = note != null && DidNote.check(
                    identity,
                    note,
                    technocore.findAllMessages(CHECK_IN_ROOM, identity)
                        .sortedByDescending { it.seq }
                        .map { it.signedText },
                ) == DidNote.Verdict.MATCHES
                if (did != identity) return@runCatching
                // Before comparing texts: a vouched note may carry the post link this
                // phone has forgotten, and the comparison below has to see the same link.
                if (vouched) adoptLinksFrom(note)
                val ourNote = note != null && (note == noteValue() || vouched)
                if (!note.isNullOrBlank() && ourNote) {
                    set(
                        Step.Publish,
                        StepState.Verified(
                            "Already published, read back just now",
                            Evidence(
                                "address" to PostComposer.noteUrl(identity),
                                "content" to note,
                                "checked" to "fetched from the server on opening",
                            ),
                        ),
                    )
                }
                val latest = technocore.findLatestMessage(CHECK_IN_ROOM, identity)
                if (did != identity) return@runCatching
                latest?.let { p ->
                    set(
                        Step.CheckIn,
                        StepState.Verified(
                            "Already checked in, found in the room",
                            Evidence(
                                "room" to p.room,
                                "sequence" to p.seq.toString(),
                                "nonce" to p.nonce,
                                "text" to p.signedText,
                                "when" to p.timestamp,
                            ),
                        ),
                    )
                    if (flow[Step.Publish] is StepState.Verified &&
                        flow[Step.Protect] is StepState.Verified
                    ) {
                        set(
                            Step.Ready,
                            StepState.Verified(
                                "Your Passport is live",
                                Evidence(
                                    "identity" to identity,
                                    "verify it yourself" to PostComposer.noteUrl(identity),
                                ),
                            ),
                        )
                        offerSupportInvite()
                    }
                }
            }.onFailure {
                if (it is CancellationException || did != identity) return@onFailure
                // Said out loud rather than left as a grey ladder. A finished person whose
                // phone was offline at launch used to see "not finished, your Passport is
                // not live" with no explanation and no way to ask again.
                restoreError = "Could not check technocore.chat for your published steps. " +
                    "This says nothing about them, only about the connection. Re-check " +
                    "when you are back online."
            }
            if (did == identity) restoring = false
        }
    }

    fun markLaunchScenePlayed() {
        launchScenePlayed = true
    }

    private fun set(step: Step, state: StepState) {
        flow = flow.with(step, state)
    }

    /**
     * Step 05 is not an action; it settles when 02, 03 and 04 are all Verified, whichever
     * of them landed last. Every path that can light one of the three calls this.
     */
    private fun settleReadyIfDue(identity: String) {
        if (flow[Step.Ready] is StepState.Verified) return
        if (flow[Step.Protect] !is StepState.Verified ||
            flow[Step.Publish] !is StepState.Verified ||
            flow[Step.CheckIn] !is StepState.Verified
        ) {
            return
        }
        set(
            Step.Ready,
            StepState.Verified(
                "Your Passport is live",
                Evidence(
                    "identity" to identity,
                    "verify it yourself" to PostComposer.noteUrl(identity),
                ),
            ),
        )
        offerSupportInvite()
    }

    /** Set a step and tell the user about it, for outcomes they asked for by pressing something. */
    private fun settle(step: Step, state: StepState) {
        flow = flow.with(step, state)
        announce = step
    }

    // ---------------------------------------------------------------- 01 create
    fun createPassport(launchIntent: (Intent) -> Unit) {
        if (flow.busy) return
        set(Step.Create, StepState.Running("Opening your Solana wallet"))
        viewModelScope.launch(work) {
            val session = WalletLink.newSession()
            try {
                launchIntent(session.intent)
                val derived = WalletLink.authorizeAndDerive(session)
                val signedRaw = derived.walletSignedRawBytes
                // Sealing is a different failure from signing, and blaming the wallet for
                // a Keystore fault sent people back to the wallet indefinitely.
                try {
                    vault.store(derived.passportSeed, derived.did, derived.walletAddress)
                } catch (t: Throwable) {
                    if (t is CancellationException) throw t
                    settle(
                        Step.Create,
                        StepState.Failed(
                            summary = "The key could not be sealed in this phone's secure storage",
                            publishedSomething = false,
                            whatToDo = "Try again. If it keeps failing, restart the phone " +
                                "and try once more. Nothing was sent anywhere.",
                            detail = null,
                        ),
                    )
                    return@launch
                } finally {
                    // Both are key material: the seed directly, and the signature it is
                    // derived from, since everything else in the derivation is public.
                    derived.passportSeed.fill(0)
                    derived.walletSignature.fill(0)
                }
                did = derived.did
                walletAddress = derived.walletAddress
                settle(
                    Step.Create,
                    StepState.Verified(
                        "Identity derived from your wallet signature",
                        Evidence(
                            "did" to derived.did,
                            "fingerprint" to DidKey.fingerprint(derived.did),
                            "wallet" to derived.walletAddress,
                            "signed" to if (signedRaw) {
                                "our exact bytes, no wallet prefix"
                            } else {
                                "with a wallet prefix - this Passport rebuilds only through this same wallet app"
                            },
                        ),
                    ),
                )
                // The same wallet gives the same key, so this may be a Passport that already
                // exists in public: a reinstall, a second phone. Ask the server now, so the
                // steps it already holds light up and the person is not invited to publish
                // over their own note.
                refreshFromServer()
                refreshActivity(force = true)
            } catch (t: Throwable) {
                if (t is CancellationException) throw t
                settle(
                    Step.Create,
                    StepState.Failed(
                        summary = "The wallet did not complete the signature",
                        publishedSomething = false,
                        whatToDo = "Try again. Nothing was sent anywhere.",
                        detail = null,
                    ),
                )
            } finally {
                session.close()
            }
        }
    }

    // ---------------------------------------------------------------- 02 protect
    fun protect() {
        val identity = did ?: return
        if (flow.busy) return
        set(Step.Protect, StepState.Running("Sealing the key in this device's secure storage"))
        viewModelScope.launch(work) {
            try {
                // A real check, not a claim: sign a throwaway string with the stored key and
                // verify it against the DID. That proves the ciphertext decrypts, the
                // Keystore key survived, and the seed still produces this identity. A vault
                // that quietly stored the wrong bytes would otherwise surface days later as
                // an unexplainable refusal from Technocore.
                val probe = "flop-passport vault self-test".toByteArray(Charsets.UTF_8)
                val ok = Ed25519.verify(DidKey.publicKey(identity), probe, vault.sign(probe))
                if (!ok) {
                    settle(
                        Step.Protect,
                        StepState.Failed(
                            "The stored key does not match your identity",
                            publishedSomething = false,
                            whatToDo = "In Settings, delete the Passport from this phone, then create it again from your wallet.",
                        ),
                    )
                    return@launch
                }
                settle(
                    Step.Protect,
                    StepState.Verified(
                        when (vault.securityLevel) {
                            PassportVault.SecurityLevel.STRONGBOX ->
                                "Sealed by StrongBox, this phone's separate security chip"
                            PassportVault.SecurityLevel.TEE ->
                                "Sealed by this phone's trusted execution environment"
                            else -> "Sealed by Android Keystore"
                        },
                        Evidence(
                            "storage" to vault.securityLevel.name,
                            "self test" to "signed and verified against your DID",
                            "recovery" to "the same wallet rebuilds this identity anywhere",
                        ),
                    ),
                )
                // A restored Passport can reach this step with 03 and 04 already lit from
                // the server; sealing the key was the last thing missing, so the ladder is
                // done - it must not stop at 4/5 and offer a "first check-in".
                settleReadyIfDue(identity)
            } catch (t: Throwable) {
                if (t is CancellationException) throw t
                if (did != identity) return@launch
                settle(
                    Step.Protect,
                    StepState.Failed(
                        "Could not read the key back from secure storage",
                        publishedSomething = false,
                        whatToDo = "In Settings, delete the Passport from this phone, then create it again from your wallet.",
                        detail = null,
                    ),
                )
            }
        }
    }

    // ------------------------------------------------------------ what the note says

    private val share = SharePrefs(app)

    /**
     * The note this Passport should be publishing right now, in one place.
     *
     * It is read in four spots - publishing, renewing, vouching, and deciding whether a
     * note found on the server is ours - and every one of them has to produce byte-identical
     * text. They do not any more once the note carries the person's own links: composing it
     * separately in each caller would mean a note written with an X link and a comparison
     * made without one, so the app would decide its own note belonged to a stranger and
     * stop renewing it. Exactly the failure this whole path exists to prevent, arrived at
     * from the other side.
     */
    private fun noteValue(): String = Canonical.sweep(
        PostComposer.identityNoteValue(
            xPostUrl = share.xPostUrl.ifBlank { null },
            room = CHECK_IN_ROOM,
            contributionUrl = share.contributionUrl.ifBlank { null },
        ),
    )

    /** What the person wrote about themselves, and where they put it. */
    var contributionLine by mutableStateOf(share.contributionLine)
        private set
    var contributionUrl by mutableStateOf(share.contributionUrl)
        private set
    var xPostUrl by mutableStateOf(share.xPostUrl)
        private set

    fun saveContributionLine(value: String) {
        contributionLine = value
        share.contributionLine = value
    }

    /**
     * Attach a link to the note, and republish it so the change is public rather than
     * merely saved.
     *
     * A field the user filled in that only lives on their phone is worse than no field: it
     * looks done and proves nothing. So each of these writes the note again immediately,
     * and the signed line that vouches for the note is re-posted because the bytes changed.
     */
    fun attachContributionUrl(value: String) {
        attachLinks(post = xPostUrl, contribution = value)
    }

    fun attachPostUrl(value: String) {
        attachLinks(post = value, contribution = contributionUrl)
    }

    /**
     * Save both links and write the note once.
     *
     * They used to be two calls, each republishing. On the main dispatcher the first
     * coroutine composed the note before the second had saved its field, so two different
     * values raced to the same address and two signed lines were posted for one change.
     * One write, composed after both fields are in.
     */
    fun attachLinks(post: String, contribution: String) {
        xPostUrl = post
        share.xPostUrl = post
        contributionUrl = contribution
        share.contributionUrl = contribution
        republishNote()
    }

    /**
     * What happened to the last attempt to write those links into the note.
     *
     * The write used to be silent in both directions: the fields were saved locally first,
     * so the button that would repeat it went grey, and the failure was swallowed by the
     * keep-alive path, which is written to stay quiet beside somebody else's success. A
     * person whose write was refused - and this service refuses roughly one write in three
     * under load - was left looking at "publishing" with no error and nothing to press.
     */
    var linkPublishError by mutableStateOf<String?>(null)
        private set

    var linkPublishing by mutableStateOf(false)
        private set

    /**
     * How far the user has stepped away from the wording their key was given.
     *
     * Kept in the ViewModel, so turning the phone while reading the draft does not hand
     * back a different post than the one that was on screen a second ago.
     */
    var wordingShift by mutableIntStateOf(0)
        private set

    /** Offer the next wording. Wraps, so the original always comes back around. */
    fun nextWording() {
        wordingShift = (wordingShift + 1) % PostComposer.VOICES.size
    }

    /** The wording this identity speaks in, moved along by "say it another way". */
    private val voice: PostComposer.Voice
        get() {
            val identity = did ?: return PostComposer.VOICES.first()
            val base = PostComposer.VOICES.indexOf(PostComposer.voiceFor(identity))
            return PostComposer.VOICES[(base + wordingShift) % PostComposer.VOICES.size]
        }

    /** The example shown in the empty field. Follows the wording, so the card reads as one. */
    val exampleLine: String get() = voice.example

    /**
     * Whether the public name is really attached, rather than merely typed.
     *
     * The test is the same one the five steps use: the note was read back off the server
     * and the link is in it. A URL sitting in a text field on this phone proves nothing to
     * anybody else, and this app does not hand out green ticks for that.
     */
    /**
     * True from the moment the share sheet opened until a link comes back.
     *
     * This is the gap where people are lost: they tap post, land in another app, publish,
     * and never return to the field. Not carelessness - attention simply goes with the
     * screen. Remembering that they left is what lets the app ask the question at the one
     * moment it is easy to answer, which is the second they come back.
     */
    var awaitingLink by mutableStateOf(false)
        private set

    /** Called when the post is handed to whichever app the person chose. */
    fun postHandedOff() {
        awaitingLink = true
    }

    fun stopAwaitingLink() {
        awaitingLink = false
    }

    /**
     * Keep the unfinished-step reminders in step with reality.
     *
     * One place decides, and it decides on the same fact the screen shows: five steps done
     * and no link in the note. Called wherever either of those can change, so a person who
     * finishes never hears from it again, and one who stops halfway hears from it three
     * times and then not at all.
     */
    fun syncFinishNudge(context: android.content.Context) {
        val unfinished = flow.complete && !nameLinked
        NudgePrefs(context).pending = unfinished
        when {
            unfinished -> FinishNudge.start(context)
            // Finished: stop, and forget how many were sent, so a Passport made again later
            // gets the same help.
            nameLinked -> FinishNudge.cancel(context, resetCount = true)
            // Not finished, not linked - the ladder is still being restored from the
            // server. Stop the alarm but keep the count: resetting it here, on every
            // slow launch, gave a person who had heard all three reminders all three
            // again.
            else -> FinishNudge.cancel(context, resetCount = false)
        }
    }

    val nameLinked: Boolean
        get() {
            val url = xPostUrl.trim()
            if (url.isEmpty()) return false
            return activity.noteValue?.contains(url) == true
        }

    /** The post text the app offers, or null before there is a Passport to post about. */
    fun postDraft(): PostComposer.Draft? = did?.let { identity ->
        PostComposer.compose(identity, contributionLine.ifBlank { null }, voice = voice)
    }

    private fun republishNote() {
        val identity = did ?: return
        if (linkPublishing) return
        linkPublishing = true
        linkPublishError = null
        viewModelScope.launch(work) {
            val outcome = runCatching {
                val written = renewNote(identity)
                if (written) keepNoteAlive(identity, activity.noteValue)
                written
            }
            if (outcome.exceptionOrNull() is CancellationException || did != identity) return@launch
            linkPublishing = false
            // Two different failures, two different sentences: the service said no, or the
            // phone could not reach it at all. Telling somebody with Wi-Fi off to wait for
            // a busy server sends them looking in the wrong place.
            when {
                outcome.isFailure -> linkPublishError = "Could not reach technocore.chat. " +
                    "Check your connection and press publish again. Your link is saved on " +
                    "this phone either way."
                outcome.getOrNull() == false -> linkPublishError = "technocore.chat did not " +
                    "take the change. It refuses writes when it is busy - press publish " +
                    "again in a moment. Your link is saved on this phone either way."
            }
            refreshActivity(force = true)
            // The one moment the app has earned the right to ask for anything: the link is
            // in the note, the note has been read back, and the person has just been told
            // they are finished. `offerSupportInvite` checks that for itself, so calling
            // here is safe on every other republish too.
            offerSupportInvite()
        }
    }

    // ------------------------------------------------------------ keeping the note alive

    /**
     * Write the identity note again, and remember that we did.
     *
     * The note is not a thing you publish once. technocore.chat deletes any note with no
     * write for seven days, so the address this app asks a person to save goes empty a week
     * after they stop turning up - silently, at the one address they were told to trust.
     *
     * The repair is that every path which proves the person is still here also renews the
     * note: finishing the setup, signing a later record, and simply opening the app. The
     * write is a key set to a fixed value, so doing it a hundred times leaves exactly what
     * doing it once leaves, and [Technocore.publishIdentityNote] already reads it back
     * before calling it done. Only a confirmed read-back stamps the clock in [NoteLife] -
     * a hopeful write that stamped it would start a seven-day countdown nobody is warned
     * about, which is the failure this whole path exists to prevent.
     */
    private suspend fun renewNote(identity: String): Boolean {
        val value = noteValue()
        val ok = technocore.publishIdentityNote(identity, value) is Technocore.Result.Verified
        if (ok) NoteLife.recordWrite(getApplication())
        return ok
    }

    /**
     * Sign a line carrying the note's hash, which is what makes the note worth anything.
     *
     * FLOP's own instruction, and the reason this is separate from writing the note: the
     * note address is world-writable, so a note proves only that somebody wrote one.
     * https://x.com/flop_labs/status/2090661329837371428
     *
     * It reads the note back one more time and signs only if it is still *our* text. Skip
     * that and a stranger who overwrites the note between the write and this line gets our
     * signature on their words.
     */
    private suspend fun vouchForNote(identity: String, expected: String): Boolean =
        runCatching {
            val body = technocore.readIdentityNote(identity)
            check(body == expected) { "the note changed between reads" }
            val nonce = technocore.nextNonce(CHECK_IN_ROOM, identity)
            technocore.saySigned(
                did = identity,
                room = CHECK_IN_ROOM,
                text = DidNote.line(identity, body),
                nonce = nonce,
                sign = { vault.sign(it) },
            ) is Technocore.Result.Verified
        }.getOrDefault(false)

    // ---------------------------------------------------------------- 03 publish
    fun publish() {
        val identity = did ?: return
        if (flow.busy || restoring) return
        set(Step.Publish, StepState.Running("Publishing your identity note to technocore.chat"))
        viewModelScope.launch(work) {
            try {
                // Look before writing. The address may already hold this person's own note
                // from before a reinstall, carrying the post link this phone has forgotten;
                // writing without looking deleted that link from the public address. And
                // if a valid signed line already vouches for exactly what is about to be
                // written, another one is noise in a shared room.
                val existing = technocore.readIdentityNote(identity)
                val lines = technocore.findAllMessages(CHECK_IN_ROOM, identity)
                    .sortedByDescending { it.seq }
                    .map { it.signedText }
                if (did != identity) return@launch
                if (DidNote.check(identity, existing, lines) == DidNote.Verdict.MATCHES) {
                    adoptLinksFrom(existing)
                }
                val value = noteValue()
                when (val r = technocore.publishIdentityNote(identity, value)) {
                    is Technocore.Result.Verified -> {
                        if (did != identity) return@launch
                        NoteLife.recordWrite(getApplication())
                        val alreadyVouched =
                            DidNote.check(identity, value, lines) == DidNote.Verdict.MATCHES
                        val vouched = alreadyVouched || vouchForNote(identity, value)
                        if (did != identity) return@launch

                        settle(
                            Step.Publish,
                            StepState.Verified(
                                if (vouched) {
                                    "Published, read back, and vouched for by your key"
                                } else {
                                    "Published and read back from the server"
                                },
                                Evidence(
                                    "address" to PostComposer.noteUrl(identity),
                                    "content" to value,
                                    "checked" to "fetched again and matched exactly",
                                    "vouched for" to if (vouched) {
                                        "yes, a signed did-note line carries its hash"
                                    } else {
                                        "not yet - the note alone is a claim, not a proof"
                                    },
                                ),
                            ),
                        )
                        // A person re-publishing an expired note already has a check-in
                        // behind them; without this the ladder asked them for a "first"
                        // check-in they made weeks ago.
                        if (flow[Step.CheckIn] is StepState.Verified &&
                            flow[Step.Protect] is StepState.Verified
                        ) {
                            set(
                                Step.Ready,
                                StepState.Verified(
                                    "Your Passport is live",
                                    Evidence(
                                        "identity" to identity,
                                        "verify it yourself" to PostComposer.noteUrl(identity),
                                    ),
                                ),
                            )
                        }
                    }

                    is Technocore.Result.Refused -> settle(
                        Step.Publish,
                        StepState.Failed(
                            "technocore.chat refused the note",
                            publishedSomething = false,
                            whatToDo = "Try again. technocore.chat is a public " +
                                "service and it refuses writes when it is busy, which has " +
                                "nothing to do with this app, your phone or your key. Two " +
                                "or three attempts is normal. Nothing was published.",
                            detail = "HTTP ${r.status}: ${r.message}",
                        ),
                    )

                    is Technocore.Result.Unconfirmed -> settle(
                        Step.Publish,
                        StepState.Unconfirmed(
                            "Accepted, but we could not read it back yet",
                            whatToDo = "Wait a moment and press it again to re-check. " +
                                "Do not treat this as a failure.",
                            detail = r.reason,
                        ),
                    )
                }
            } catch (t: Throwable) {
                if (t is CancellationException) throw t
                if (did != identity) return@launch
                settle(
                    Step.Publish,
                    StepState.Failed(
                        "Could not reach technocore.chat",
                        publishedSomething = false,
                        whatToDo = "Check your connection and try again.",
                        detail = null,
                    ),
                )
            }
        }
    }

    // ---------------------------------------------------------------- 04 check in
    fun checkIn() {
        val identity = did ?: return
        if (flow.busy || restoring) return
        set(Step.CheckIn, StepState.Running("Signing your first check-in and sending it"))
        viewModelScope.launch(work) {
            try {
                // A room is append-only and public. If this identity already has a message
                // there, show that one rather than adding a second identical line - the
                // duplicate cannot be taken back, and it is exactly what the lobby is full
                // of.
                val existing = technocore.findLatestMessage(CHECK_IN_ROOM, identity)
                if (did != identity) return@launch
                existing?.let { existing ->
                    settle(
                        Step.CheckIn,
                        StepState.Verified(
                            "You have already checked in",
                            Evidence(
                                "room" to existing.room,
                                "sequence" to existing.seq.toString(),
                                "nonce" to existing.nonce,
                                "text" to existing.signedText,
                                "when" to existing.timestamp,
                            ),
                        ),
                    )
                    settle(
                        Step.Ready,
                        StepState.Verified(
                            "Your Passport is live",
                            Evidence(
                                "identity" to identity,
                                "verify it yourself" to PostComposer.noteUrl(identity),
                            ),
                        ),
                    )
                    // Reaching the end by finding an earlier check-in is still reaching the
                    // end. Leaving these two out of this branch meant that anyone who had
                    // ever checked in before - a reinstall, a second device - finished the
                    // flow with no invitation and a stale activity tab.
                    offerSupportInvite()
                    refreshActivity()
                    return@launch
                }
                val nonce = technocore.nextNonce(CHECK_IN_ROOM, identity)
                when (
                    val r = technocore.saySigned(
                        did = identity,
                        room = CHECK_IN_ROOM,
                        text = checkInText(identity),
                        nonce = nonce,
                        sign = { vault.sign(it) },
                    ).also { if (did != identity) return@launch }
                ) {
                    is Technocore.Result.Verified -> {
                        settle(
                            Step.CheckIn,
                            StepState.Verified(
                                "Signed, accepted and found again in the room",
                                Evidence(
                                    "room" to r.proof.room,
                                    "sequence" to r.proof.seq.toString(),
                                    "nonce" to r.proof.nonce,
                                    "text" to r.proof.signedText,
                                    "checked" to "matched on our nonce, not just our key",
                                ),
                            ),
                        )
                        settle(
                            Step.Ready,
                            StepState.Verified(
                                "Your Passport is live",
                                Evidence(
                                    "identity" to identity,
                                    "verify it yourself" to PostComposer.noteUrl(identity),
                                ),
                            ),
                        )
                        // The finish is the one moment the app has earned the right to ask
                        // for anything, and only after telling the user they are done.
                        offerSupportInvite()
                        refreshActivity()
                    }

                    is Technocore.Result.Refused -> settle(
                        Step.CheckIn,
                        StepState.Failed(
                            "technocore.chat refused the signed write",
                            publishedSomething = false,
                            whatToDo = "Try again. technocore.chat is a public " +
                                "service and it refuses writes when it is busy, which has " +
                                "nothing to do with this app, your phone or your key. Two " +
                                "or three attempts is normal. Nothing was posted.",
                            detail = "HTTP ${r.status}: ${r.message}",
                        ),
                    )

                    is Technocore.Result.Unconfirmed -> settle(
                        Step.CheckIn,
                        StepState.Unconfirmed(
                            "Sent, but not confirmed in the room yet",
                            whatToDo = "Wait a moment and press it again to re-check. " +
                                "Sending it as a new message would post twice in public.",
                            detail = r.reason,
                        ),
                    )
                }
            } catch (t: Throwable) {
                if (t is CancellationException) throw t
                if (did != identity) return@launch
                settle(
                    Step.CheckIn,
                    StepState.Failed(
                        "Could not reach technocore.chat",
                        publishedSomething = false,
                        whatToDo = "Check your connection and try again.",
                        detail = null,
                    ),
                )
            }
        }
    }

    /**
     * The private key in the clear, for the export screen only.
     *
     * Held in state just long enough to be shown, then dropped by [hideSeed] when the
     * sheet closes. It never goes near a log, a crash report or the network - the vault
     * exposes signing for everything else precisely so this is the only path that sees it.
     */
    var revealedSeedHex by mutableStateOf<String?>(null)
        private set

    fun revealSeed() {
        runCatching {
            val seed = vault.exportSeed()
            revealedSeedHex = seed.joinToString("") { "%02x".format(it) }
            seed.fill(0)
        }
    }

    fun hideSeed() {
        revealedSeedHex = null
    }

    /** The file the user saves. Plain, self-describing, and honest about what it holds. */
    fun backupDocument(): String {
        val identity = did ?: return ""
        val seedHex = revealedSeedHex ?: return ""
        return buildString {
            appendLine("FLOP Passport for Seeker - private backup")
            appendLine()
            appendLine("did: $identity")
            appendLine("fingerprint: " + DidKey.fingerprint(identity))
            appendLine("wallet: " + (walletAddress ?: "-"))
            appendLine("algorithm: Ed25519, did:key, 32-byte seed")
            appendLine("seed_hex: $seedHex")
            appendLine()
            appendLine("Anyone holding seed_hex can sign as this identity on Technocore.")
            appendLine("Keep this file offline. Never send it to anyone, including the app author.")
            appendLine()
            appendLine("You do not need this file to recover. The same Solana wallet that")
            appendLine("created this Passport rebuilds it on any device.")
        }
    }

    fun deletePassport() {
        // First, before anything else: whatever is in flight for the old identity must not
        // finish into the new one.
        work.cancel()
        work = SupervisorJob()
        restoring = false
        restoreError = null
        announce = null
        vault.delete()
        did = null
        walletAddress = null
        flow = FlowState()
        // Otherwise the next Passport opens the activity screen on the last
        // one's records: lastChecked is not null, so nothing refreshes, and somebody
        // else's history is presented as theirs.
        activity = ActivityState()
        showSupportInvite = false
        // Everything the previous holder of this phone left behind. Without this the next
        // Passport inherits their post link and publishes a note pointing at a post that
        // carries a different DID - and the app reads it back and calls the sixth step
        // finished, for a key that never posted anything.
        share.clear()
        contributionLine = ""
        contributionUrl = ""
        xPostUrl = ""
        wordingShift = 0
        awaitingLink = false
        linkPublishError = null
        NoteLife.forget(getApplication())
        NudgePrefs(getApplication()).pending = false
        FinishNudge.cancel(getApplication(), resetCount = true)
    }

    /**
     * Rebuild the ladder for a Passport that already exists on this phone.
     *
     * Only the steps provable on the device are restored. Publishing and the check-in stay
     * pending until the app has re-read them from the server, because a tick restored from
     * local state would claim something about the world that we have not checked.
     */
    private fun restoreFlow(): FlowState {
        val existing = vault.did ?: return FlowState()
        var state = FlowState().with(
            Step.Create,
            StepState.Verified(
                "Identity derived from your wallet signature",
                Evidence(
                    "did" to existing,
                    "fingerprint" to DidKey.fingerprint(existing),
                    "wallet" to (vault.walletAddress ?: "-"),
                ),
            ),
        )

        // Protect is provable here and now without asking anyone: sign a throwaway string
        // with the stored key and check it against the DID. Leaving it pending after a
        // reinstall would show the user a grey step for something that is demonstrably
        // already true, and invite them to redo it.
        runCatching {
            val probe = "flop-passport vault self-test".toByteArray(Charsets.UTF_8)
            if (Ed25519.verify(DidKey.publicKey(existing), probe, vault.sign(probe))) {
                state = state.with(
                    Step.Protect,
                    StepState.Verified(
                        when (vault.securityLevel) {
                            PassportVault.SecurityLevel.STRONGBOX ->
                                "Sealed by StrongBox, this phone's separate security chip"
                            PassportVault.SecurityLevel.TEE ->
                                "Sealed by this phone's trusted execution environment"
                            else -> "Sealed by Android Keystore"
                        },
                        Evidence(
                            "storage" to vault.securityLevel.name,
                            "self test" to "re-checked when the app opened",
                            "recovery" to "the same wallet rebuilds this identity anywhere",
                        ),
                    ),
                )
            }
        }
        return state
    }
}
