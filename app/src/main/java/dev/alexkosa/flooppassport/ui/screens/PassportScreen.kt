package dev.alexkosa.flooppassport.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alexkosa.flooppassport.R
import dev.alexkosa.flooppassport.ui.PassportViewModel
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
import dev.alexkosa.flooppassport.ui.designsystem.FlopBackupSheet
import dev.alexkosa.flooppassport.ui.designsystem.FlopProblemDialog
import dev.alexkosa.flooppassport.ui.designsystem.FlopSupportCard
import dev.alexkosa.flooppassport.ui.designsystem.FlopStepDialog
import dev.alexkosa.flooppassport.ui.designsystem.FlopStepLadder
import dev.alexkosa.flooppassport.ui.designsystem.FlopType
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.fragment.app.FragmentActivity
import dev.alexkosa.flooppassport.util.Biometrics
import dev.alexkosa.flooppassport.util.confirmHaptic

/**
 * The whole setup, as five steps the user can watch.
 *
 * The screen draws; it holds no state of its own. Everything lives in the ViewModel so a
 * rotation - most likely exactly while the wallet is open - redraws the same flow rather
 * than restarting it.
 */
@Composable
fun PassportScreen(vm: PassportViewModel = viewModel()) {
    val context = LocalContext.current
    val flow = vm.flow

    val walletLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { }

    var gateMessage by remember { mutableStateOf<String?>(null) }

    // The Storage Access Framework, so the user picks where the file goes and the app never
    // asks for storage permission or touches anywhere it was not sent.
    val saveLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument("text/plain"),
    ) { uri ->
        if (uri != null) {
            runCatching {
                context.contentResolver.openOutputStream(uri)?.use { out ->
                    out.write(vm.backupDocument().toByteArray(Charsets.UTF_8))
                }
            }
        }
    }

    // One tick each time a step actually settles, not on every recomposition.
    val verifiedCount = remember(flow) { Step.all.count { flow[it] is StepState.Verified } }
    LaunchedEffect(verifiedCount) {
        if (verifiedCount > 0) confirmHaptic(context)
    }

    // The outcome of whatever the user just pressed, shown once and dismissed by them.
    vm.announce?.let { step ->
        when (val state = flow[step]) {
            is StepState.Verified -> FlopStepDialog(
                step = step,
                headline = state.summary,
                body = nextHint(flow.next),
                evidence = state.evidence,
                nextLabel = if (flow.complete) "done" else "continue",
                onDismiss = { vm.dismissAnnouncement() },
            )

            is StepState.Failed -> FlopProblemDialog(
                step = step,
                headline = state.summary,
                whatToDo = state.whatToDo,
                publishedSomething = state.publishedSomething,
                detail = state.detail,
                onDismiss = { vm.dismissAnnouncement() },
            )

            is StepState.Unconfirmed -> FlopProblemDialog(
                step = step,
                headline = state.summary,
                whatToDo = state.whatToDo,
                publishedSomething = true,
                detail = state.detail,
                onDismiss = { vm.dismissAnnouncement() },
            )

            else -> Unit
        }
    }

    vm.revealedSeedHex?.let { seedHex ->
        vm.did?.let { identity ->
            FlopBackupSheet(
                did = identity,
                seedHex = seedHex,
                onSaveFile = {
                    saveLauncher.launch("floop-passport-${'$'}{DidKeyShort(identity)}.txt")
                },
                onDismiss = { vm.hideSeed() },
            )
        }
    }

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

        vm.did?.let { identity ->
            FlopCard(accent = FlopColors.Cyan) {
                FlopLabel("your identity")
                Spacer(Modifier.height(FlopSpacing.sm))
                FlopMonoData(identity)
                Spacer(Modifier.height(FlopSpacing.sm))
                Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                    FlopBadge("vault ${vm.securityLevel}", FlopState.Active)
                    if (vm.walletAddress != null) FlopBadge("wallet linked", FlopState.Verified)
                }
            }
            Spacer(Modifier.height(FlopSpacing.lg))
        }

        FlopStepLadder(flow)
        Spacer(Modifier.height(FlopSpacing.lg))

        when {
            flow.complete -> Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Green.copy(alpha = 0.08f), FlopShapes.md)
                    .padding(FlopSpacing.md),
            ) {
                Column {
                    Text("Your Passport is live.", style = FlopType.h3, color = FlopColors.Green)
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(
                        "Anyone can check it at the address in step 03. This app promises " +
                            "nothing about any allocation, and never will.",
                        style = FlopType.bodySm,
                        color = FlopColors.TextMuted,
                    )
                }
            }

            flow.next == Step.Create -> ActionBlock(
                title = "Create your Passport",
                body = "Your wallet signs one statement. It is not a transaction and moves " +
                    "no funds. The same wallet rebuilds the same Passport on any device.",
                button = "create passport",
                enabled = !flow.busy,
                onClick = { vm.createPassport { walletLauncher.launch(it) } },
            )

            flow.next == Step.Protect -> ActionBlock(
                title = "Protect it",
                body = "The key is sealed in this phone's secure storage, then read back " +
                    "and checked against your identity.",
                button = "protect passport",
                enabled = !flow.busy,
                onClick = { vm.protect() },
            )

            flow.next == Step.Publish -> ActionBlock(
                title = "Publish your identity",
                body = "A permanent note at an address derived from your key, so anyone can " +
                    "find and verify you later.",
                button = "publish identity",
                enabled = !flow.busy,
                onClick = { vm.publish() },
            )

            else -> ActionBlock(
                title = "Make your first signed check-in",
                body = "A message signed by your Passport, posted to a quiet room and then " +
                    "read back to prove it landed.",
                button = "sign and check in",
                enabled = !flow.busy,
                onClick = { vm.checkIn() },
            )
        }

        if (vm.did != null) {
            Spacer(Modifier.height(FlopSpacing.lg))
            FlopButtonSecondary("save my key", {
                val activity = context as? FragmentActivity
                if (activity == null) {
                    gateMessage = "Could not open the security prompt on this screen."
                } else {
                    Biometrics.authenticate(
                        activity = activity,
                        title = "Show your private key",
                        subtitle = "Anyone holding it can sign as you",
                        onSuccess = { vm.revealSeed() },
                        onFailure = { gateMessage = it },
                    )
                }
            })
            gateMessage?.let {
                Spacer(Modifier.height(FlopSpacing.sm))
                Text(it, style = FlopType.bodySm, color = FlopColors.ErrorRed)
            }

            Spacer(Modifier.height(FlopSpacing.lg))
            FlopSupportCard(
                recipient = SUPPORT_WALLET,
                displayName = SUPPORT_NAME,
                splToken = SKR_MINT,
                tokenName = SKR_NAME,
            )

            Spacer(Modifier.height(FlopSpacing.lg))
            FlopButtonSecondary("delete passport from this phone", { vm.deletePassport() })
        }
        Spacer(Modifier.height(FlopSpacing.xl))
    }
}

/**
 * Where a tip goes.
 *
 * The name is what the button shows, because `kosa.skr` reads as a person and a base58
 * address reads as noise. The address is baked rather than resolved at runtime: `.skr`
 * names live in AllDomains, resolving one costs a public RPC round trip, and a donation
 * button that can fail to load its own recipient is worse than one that cannot follow a
 * moved name. This pairing was verified on 2026-08-24 and again today; re-check it if the
 * name is ever pointed somewhere else.
 */
private const val SUPPORT_NAME = "kosa.skr"
private const val SUPPORT_WALLET = "BmJaEmaEURBDpj91GUTvJcpKy2MAu8ZtRFRPaMpEuuax"

/**
 * SKR, the Solana Mobile token, preselected in the wallet's send screen. Verified on
 * mainnet: an SPL mint owned by the token program, six decimals. A wrong mint here would
 * point somebody's money at nothing, so it is checked rather than copied out of a chat.
 */
private const val SKR_MINT = "SKRbvo6Gf7GondiT3BbTfuRDPqLWei4j2Qy2NPGZhW3"
private const val SKR_NAME = "SKR"

/** Short, filename-safe form of a DID, for the saved backup's name. */
private fun DidKeyShort(did: String): String =
    did.removePrefix("did:key:").take(10)

/** What the dialog tells the user is coming, so "continue" is never a leap in the dark. */
private fun nextHint(next: Step?): String = when (next) {
    Step.Create -> "Next: create your Passport from your wallet."
    Step.Protect -> "Next: seal the key in this phone's secure storage."
    Step.Publish -> "Next: publish your identity so anyone can verify you."
    Step.CheckIn -> "Next: make your first signed check-in."
    Step.Ready, null -> "That was the last step. Your Passport is live."
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
