package dev.alexkosa.flooppassport.ui.screens

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import dev.alexkosa.flooppassport.R
import dev.alexkosa.flooppassport.crypto.DidKey
import dev.alexkosa.flooppassport.crypto.Ed25519
import dev.alexkosa.flooppassport.proof.PostComposer
import dev.alexkosa.flooppassport.technocore.Technocore
import dev.alexkosa.flooppassport.ui.Evidence
import dev.alexkosa.flooppassport.ui.FlowState
import dev.alexkosa.flooppassport.ui.Step
import dev.alexkosa.flooppassport.ui.StepState
import dev.alexkosa.flooppassport.ui.designsystem.FlopBadge
import dev.alexkosa.flooppassport.ui.designsystem.FlopButton
import dev.alexkosa.flooppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.flooppassport.ui.designsystem.FlopCard
import dev.alexkosa.flooppassport.ui.designsystem.FlopColors
import dev.alexkosa.flooppassport.ui.designsystem.FlopLabel
import dev.alexkosa.flooppassport.ui.designsystem.FlopMonoData
import dev.alexkosa.flooppassport.ui.designsystem.FlopShapes
import dev.alexkosa.flooppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.flooppassport.ui.designsystem.FlopState
import dev.alexkosa.flooppassport.ui.designsystem.FlopStepLadder
import dev.alexkosa.flooppassport.ui.designsystem.FlopType
import dev.alexkosa.flooppassport.vault.PassportVault
import dev.alexkosa.flooppassport.wallet.WalletLink
import kotlinx.coroutines.launch

private const val CHECK_IN_ROOM = "floop-passport"
private const val CHECK_IN_TEXT = "FLOOP Passport for Seeker. First signed check-in."

/**
 * The whole setup, as five steps the user can watch.
 *
 * One button at a time, always the next thing to do. Every step names what it is doing
 * while it runs, and none of them goes green until the record has been read back.
 */
@Composable
fun PassportScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val vault = remember { PassportVault(context) }
    val technocore = remember { Technocore() }

    var flow by remember { mutableStateOf(restoreFlow(vault)) }
    var did by remember { mutableStateOf(vault.did) }
    var wallet by remember { mutableStateOf(vault.walletAddress) }

    val walletLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { }

    fun set(step: Step, state: StepState) {
        flow = flow.with(step, state)
    }

    // ---------------------------------------------------------------- 01 create
    fun createPassport() {
        if (flow.busy) return
        set(Step.Create, StepState.Running("Opening your Solana wallet"))
        scope.launch {
            val session = WalletLink.newSession()
            try {
                walletLauncher.launch(session.intent)
                val derived = WalletLink.authorizeAndDerive(session)
                vault.store(derived.passportSeed, derived.did, derived.walletAddress)
                derived.passportSeed.fill(0)
                did = derived.did
                wallet = derived.walletAddress
                set(
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
                confirmHaptic(context)
            } catch (t: Throwable) {
                set(
                    Step.Create,
                    StepState.Failed(
                        summary = "The wallet did not complete the signature",
                        publishedSomething = false,
                        whatToDo = "Open the app again and press Create. Nothing was sent anywhere.",
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
        scope.launch {
            try {
                // A real check, not a claim: sign a throwaway string with the stored key and
                // verify it against the DID. That proves the ciphertext decrypts, the
                // Keystore key survived, and the seed still produces this identity. A vault
                // that quietly stored the wrong bytes would otherwise surface days later as
                // an unexplainable refusal from Technocore.
                val probe = "floop-passport vault self-test".toByteArray(Charsets.UTF_8)
                val ok = Ed25519.verify(DidKey.publicKey(identity), probe, vault.sign(probe))
                if (!ok) {
                    set(
                        Step.Protect,
                        StepState.Failed(
                            "The stored key does not match your identity",
                            publishedSomething = false,
                            whatToDo = "Delete the Passport and create it again from your wallet.",
                        ),
                    )
                    return@launch
                }
                val level = vault.securityLevel
                set(
                    Step.Protect,
                    StepState.Verified(
                        when (level) {
                            PassportVault.SecurityLevel.STRONGBOX ->
                                "Sealed by StrongBox, this phone's separate security chip"
                            PassportVault.SecurityLevel.TEE ->
                                "Sealed by this phone's trusted execution environment"
                            else -> "Sealed by Android Keystore"
                        },
                        Evidence(
                            "storage" to level.name,
                            "self test" to "signed and verified against your DID",
                            "recovery" to "the same wallet rebuilds this identity anywhere",
                        ),
                    ),
                )
                confirmHaptic(context)
            } catch (t: Throwable) {
                set(
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
        scope.launch {
            try {
                val value = PostComposer.identityNoteValue(room = CHECK_IN_ROOM)
                when (val r = technocore.publishIdentityNote(identity, value)) {
                    is Technocore.Result.Verified -> set(
                        Step.Publish,
                        StepState.Verified(
                            "Published and read back from the server",
                            Evidence(
                                "address" to PostComposer.noteUrl(identity),
                                "content" to value,
                                "checked" to "fetched again and matched exactly",
                            ),
                        ),
                    ).also { confirmHaptic(context) }

                    is Technocore.Result.Refused -> set(
                        Step.Publish,
                        StepState.Failed(
                            "technocore.chat refused the note",
                            publishedSomething = false,
                            whatToDo = "Try again. Nothing was published.",
                            detail = "HTTP ${r.status}: ${r.message}",
                        ),
                    )

                    is Technocore.Result.Unconfirmed -> set(
                        Step.Publish,
                        StepState.Unconfirmed(
                            "Accepted, but we could not read it back yet",
                            whatToDo = "Wait a moment and press Check again. Do not repeat the write.",
                            detail = r.reason,
                        ),
                    )
                }
            } catch (t: Throwable) {
                set(
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
        scope.launch {
            try {
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
                        set(
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
                        confirmHaptic(context)
                    }

                    is Technocore.Result.Refused -> set(
                        Step.CheckIn,
                        StepState.Failed(
                            "technocore.chat refused the signed write",
                            publishedSomething = false,
                            whatToDo = "Try again. Nothing was posted.",
                            detail = "HTTP ${r.status}: ${r.message}",
                        ),
                    )

                    is Technocore.Result.Unconfirmed -> set(
                        Step.CheckIn,
                        StepState.Unconfirmed(
                            "Sent, but not confirmed in the room yet",
                            whatToDo = "Wait a moment and press Check again. Sending it twice " +
                                "would post twice in public.",
                            detail = r.reason,
                        ),
                    )
                }
            } catch (t: Throwable) {
                set(
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

    // ---------------------------------------------------------------- screen
    Column(
        Modifier
            .fillMaxSize()
            .background(FlopColors.Base)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(FlopSpacing.md),
    ) {
        Image(
            painter = painterResource(R.drawable.flop_lockup_reverse),
            contentDescription = "FLOP",
            modifier = Modifier.width(140.dp),
        )
        Spacer(Modifier.height(FlopSpacing.xs))
        FlopLabel("passport for seeker")
        Spacer(Modifier.height(FlopSpacing.lg))

        did?.let { identity ->
            FlopCard(accent = FlopColors.Cyan) {
                FlopLabel("your identity")
                Spacer(Modifier.height(FlopSpacing.sm))
                FlopMonoData(identity)
                Spacer(Modifier.height(FlopSpacing.sm))
                Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                    FlopBadge("vault ${vault.securityLevel}", FlopState.Active)
                    wallet?.let { FlopBadge("wallet linked", FlopState.Verified) }
                }
            }
            Spacer(Modifier.height(FlopSpacing.lg))
        }

        FlopStepLadder(flow)
        Spacer(Modifier.height(FlopSpacing.lg))

        val next = flow.next
        when {
            flow.complete -> {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(FlopColors.Green.copy(alpha = 0.08f), FlopShapes.md)
                        .padding(FlopSpacing.md),
                ) {
                    Column {
                        Text(
                            "Your Passport is live.",
                            style = FlopType.h3,
                            color = FlopColors.Green,
                        )
                        Spacer(Modifier.height(FlopSpacing.xs))
                        Text(
                            "Anyone can check it at the address in step 03. " +
                                "This app promises nothing about any allocation, and never will.",
                            style = FlopType.bodySm,
                            color = FlopColors.TextMuted,
                        )
                    }
                }
            }
            next == Step.Create -> ActionBlock(
                title = "Create your Passport",
                body = "Your wallet signs one statement. It is not a transaction and moves " +
                    "no funds. The same wallet rebuilds the same Passport on any device.",
                button = "create passport",
                enabled = !flow.busy,
                onClick = { createPassport() },
            )
            next == Step.Protect -> ActionBlock(
                title = "Protect it",
                body = "The key is sealed in this phone's secure storage, then read back " +
                    "and checked against your identity.",
                button = "protect passport",
                enabled = !flow.busy,
                onClick = { protect() },
            )
            next == Step.Publish -> ActionBlock(
                title = "Publish your identity",
                body = "A permanent note at an address derived from your key, so anyone can " +
                    "find and verify you later.",
                button = "publish identity",
                enabled = !flow.busy,
                onClick = { publish() },
            )
            else -> ActionBlock(
                title = "Make your first signed check-in",
                body = "A message signed by your Passport, posted to a quiet room and then " +
                    "read back to prove it landed.",
                button = "sign and check in",
                enabled = !flow.busy,
                onClick = { checkIn() },
            )
        }

        if (did != null) {
            Spacer(Modifier.height(FlopSpacing.sm))
            FlopButtonSecondary("delete passport from this phone", {
                vault.delete()
                did = null
                wallet = null
                flow = FlowState()
            })
        }
        Spacer(Modifier.height(FlopSpacing.xl))
    }
}

@Composable
private fun ActionBlock(
    title: String,
    body: String,
    button: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Column {
        Text(title, style = FlopType.h3, color = FlopColors.IceWhite)
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(body, style = FlopType.bodyMd, color = FlopColors.TextMuted)
        Spacer(Modifier.height(FlopSpacing.md))
        FlopButton(button, onClick, enabled = enabled)
    }
}

/**
 * Rebuild the ladder for a Passport that already exists on this phone.
 *
 * Only the steps we can prove locally are restored. Publishing and the check-in stay
 * pending until the app has re-read them from the server, because a tick restored from
 * local state would claim something about the world that we have not checked.
 */
private fun restoreFlow(vault: PassportVault): FlowState {
    if (!vault.hasPassport) return FlowState()
    val did = vault.did ?: return FlowState()
    return FlowState()
        .with(
            Step.Create,
            StepState.Verified(
                "Identity derived from your wallet signature",
                Evidence(
                    "did" to did,
                    "fingerprint" to DidKey.fingerprint(did),
                    "wallet" to (vault.walletAddress ?: "-"),
                ),
            ),
        )
}

private fun confirmHaptic(context: Context) {
    runCatching {
        context.getSystemService(Vibrator::class.java)
            ?.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
    }
}
