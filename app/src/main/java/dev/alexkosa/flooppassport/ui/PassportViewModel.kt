package dev.alexkosa.flooppassport.ui

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dev.alexkosa.flooppassport.crypto.DidKey
import dev.alexkosa.flooppassport.crypto.Ed25519
import dev.alexkosa.flooppassport.proof.PostComposer
import dev.alexkosa.flooppassport.technocore.Technocore
import dev.alexkosa.flooppassport.vault.PassportVault
import dev.alexkosa.flooppassport.wallet.WalletLink
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch

const val CHECK_IN_ROOM = "floop-passport"
const val CHECK_IN_TEXT = "FLOOP Passport for Seeker. First signed check-in."

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

    init {
        // Re-establish what is actually true rather than trusting the phone. A reinstall,
        // a cleared app or a second device all leave a Passport whose public records
        // already exist; showing those steps as pending would invite the user to publish
        // them again, and a room is append-only.
        if (did != null) refreshFromServer()
    }

    /** Ask the server what it already holds for this identity, and reflect only that. */
    fun refreshFromServer() {
        val identity = did ?: return
        viewModelScope.launch {
            runCatching {
                val note = technocore.readIdentityNote(identity)
                if (!note.isNullOrBlank()) {
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
                technocore.findLatestMessage(CHECK_IN_ROOM, identity)?.let { p ->
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
                    }
                }
            }
        }
    }

    fun markLaunchScenePlayed() {
        launchScenePlayed = true
    }

    private fun set(step: Step, state: StepState) {
        flow = flow.with(step, state)
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
        viewModelScope.launch {
            val session = WalletLink.newSession()
            try {
                launchIntent(session.intent)
                val derived = WalletLink.authorizeAndDerive(session)
                vault.store(derived.passportSeed, derived.did, derived.walletAddress)
                derived.passportSeed.fill(0)
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
                            "signed" to if (derived.walletSignedRawBytes) {
                                "our exact bytes, no wallet prefix"
                            } else {
                                "with a wallet prefix, which is fine and pinned"
                            },
                        ),
                    ),
                )
            } catch (t: Throwable) {
                settle(
                    Step.Create,
                    StepState.Failed(
                        summary = "The wallet did not complete the signature",
                        publishedSomething = false,
                        whatToDo = "Press Create again. Nothing was sent anywhere.",
                        detail = t.message ?: t.javaClass.simpleName,
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
        viewModelScope.launch {
            try {
                // A real check, not a claim: sign a throwaway string with the stored key and
                // verify it against the DID. That proves the ciphertext decrypts, the
                // Keystore key survived, and the seed still produces this identity. A vault
                // that quietly stored the wrong bytes would otherwise surface days later as
                // an unexplainable refusal from Technocore.
                val probe = "floop-passport vault self-test".toByteArray(Charsets.UTF_8)
                val ok = Ed25519.verify(DidKey.publicKey(identity), probe, vault.sign(probe))
                if (!ok) {
                    settle(
                        Step.Protect,
                        StepState.Failed(
                            "The stored key does not match your identity",
                            publishedSomething = false,
                            whatToDo = "Delete the Passport and create it again from your wallet.",
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
            } catch (t: Throwable) {
                settle(
                    Step.Protect,
                    StepState.Failed(
                        "Could not read the key back from secure storage",
                        publishedSomething = false,
                        whatToDo = "Delete the Passport and create it again from your wallet.",
                        detail = t.message ?: t.javaClass.simpleName,
                    ),
                )
            }
        }
    }

    // ---------------------------------------------------------------- 03 publish
    fun publish() {
        val identity = did ?: return
        if (flow.busy) return
        set(Step.Publish, StepState.Running("Publishing your identity note to technocore.chat"))
        viewModelScope.launch {
            try {
                val value = PostComposer.identityNoteValue(room = CHECK_IN_ROOM)
                when (val r = technocore.publishIdentityNote(identity, value)) {
                    is Technocore.Result.Verified -> settle(
                        Step.Publish,
                        StepState.Verified(
                            "Published and read back from the server",
                            Evidence(
                                "address" to PostComposer.noteUrl(identity),
                                "content" to value,
                                "checked" to "fetched again and matched exactly",
                            ),
                        ),
                    )

                    is Technocore.Result.Refused -> settle(
                        Step.Publish,
                        StepState.Failed(
                            "technocore.chat refused the note",
                            publishedSomething = false,
                            whatToDo = "Try again. Nothing was published.",
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
                settle(
                    Step.Publish,
                    StepState.Failed(
                        "Could not reach technocore.chat",
                        publishedSomething = false,
                        whatToDo = "Check your connection and try again.",
                        detail = t.message ?: t.javaClass.simpleName,
                    ),
                )
            }
        }
    }

    // ---------------------------------------------------------------- 04 check in
    fun checkIn() {
        val identity = did ?: return
        if (flow.busy) return
        set(Step.CheckIn, StepState.Running("Signing your first check-in and sending it"))
        viewModelScope.launch {
            try {
                // A room is append-only and public. If this identity already has a message
                // there, show that one rather than adding a second identical line - the
                // duplicate cannot be taken back, and it is exactly what the lobby is full
                // of.
                technocore.findLatestMessage(CHECK_IN_ROOM, identity)?.let { existing ->
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
                    return@launch
                }
                val nonce = technocore.nextNonce(CHECK_IN_ROOM, identity)
                when (
                    val r = technocore.saySigned(
                        did = identity,
                        room = CHECK_IN_ROOM,
                        text = CHECK_IN_TEXT,
                        nonce = nonce,
                        sign = { vault.sign(it) },
                    )
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
                    }

                    is Technocore.Result.Refused -> settle(
                        Step.CheckIn,
                        StepState.Failed(
                            "technocore.chat refused the signed write",
                            publishedSomething = false,
                            whatToDo = "Try again. Nothing was posted.",
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
                settle(
                    Step.CheckIn,
                    StepState.Failed(
                        "Could not reach technocore.chat",
                        publishedSomething = false,
                        whatToDo = "Check your connection and try again.",
                        detail = t.message ?: t.javaClass.simpleName,
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
            appendLine("FLOOP Passport for Seeker - private backup")
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
        vault.delete()
        did = null
        walletAddress = null
        flow = FlowState()
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
            val probe = "floop-passport vault self-test".toByteArray(Charsets.UTF_8)
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
