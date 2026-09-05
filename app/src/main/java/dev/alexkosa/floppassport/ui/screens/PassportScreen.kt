package dev.alexkosa.floppassport.ui.screens

import android.content.Intent
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.R
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.Step
import dev.alexkosa.floppassport.ui.StepState
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButton
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopCard
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopMonoData
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopBackupSheet
import dev.alexkosa.floppassport.ui.designsystem.FlopProblemDialog
import dev.alexkosa.floppassport.ui.designsystem.FlopStepDialog
import dev.alexkosa.floppassport.ui.designsystem.FlopStepLadder
import dev.alexkosa.floppassport.ui.designsystem.FlopType
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.fragment.app.FragmentActivity
import dev.alexkosa.floppassport.util.Biometrics
import dev.alexkosa.floppassport.util.confirmHaptic

/**
 * The whole setup, as five steps the user can watch.
 *
 * The screen draws; it holds no state of its own. Everything lives in the ViewModel so a
 * rotation - most likely exactly while the wallet is open - redraws the same flow rather
 * than restarting it.
 */
@Composable
fun PassportScreen(vm: PassportViewModel = viewModel()) {
    // Collected here rather than deeper: one subscription for the screen, and the
    // ladder stays a pure function of what it is given.
    val pulse by vm.pulse.collectAsState()
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

    // The reminders about the unfinished last step follow the same two facts the screen
    // shows. Recomputed when either moves, so a person who finishes is never nagged and a
    // person who stops is reminded three times and then left alone.
    LaunchedEffect(flow.complete, vm.nameLinked) {
        vm.syncFinishNudge(context)
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
                onRetry = {
                    vm.dismissAnnouncement()
                    retry(vm, step) { walletLauncher.launch(it) }
                },
            )

            is StepState.Unconfirmed -> FlopProblemDialog(
                step = step,
                headline = state.summary,
                whatToDo = state.whatToDo,
                publishedSomething = true,
                detail = state.detail,
                onDismiss = { vm.dismissAnnouncement() },
                // Not "send again". The write may already be in the room, and the step
                // looks for it before it would ever post a second copy.
                retryLabel = "check again",
                onRetry = {
                    vm.dismissAnnouncement()
                    retry(vm, step) { walletLauncher.launch(it) }
                },
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
                    saveLauncher.launch("flop-passport-${didKeyShort(identity)}.txt")
                },
                onDismiss = { vm.hideSeed() },
            )
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(FlopColors.Base)
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
                    FlopBadge(t("vault {level}", "level" to vm.securityLevel.toString()), FlopState.Active)
                    if (vm.walletAddress != null) FlopBadge("wallet linked", FlopState.Verified)
                }
            }
            Spacer(Modifier.height(FlopSpacing.lg))
        }

        // Said before the ladder rather than after it. Four ticks and a shrug looks very
        // like five ticks unless something on the screen counts them out loud.
        if (!flow.complete && verifiedCount > 0) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Surface, FlopShapes.md)
                    .border(1.dp, FlopColors.Cyan.copy(alpha = 0.35f), FlopShapes.md)
                    .padding(FlopSpacing.md),
            ) {
                Column {
                    Text(
                        "$verifiedCount / 5",
                        style = FlopType.h3,
                        color = FlopColors.Cyan,
                    )
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(
                        t(
                            "Not finished yet. Until all five are green your identity is not " +
                                "published and there is nothing anyone can verify. Keep going.",
                        ),
                        style = FlopType.bodySm,
                        color = FlopColors.TextMuted,
                    )
                }
            }
            Spacer(Modifier.height(FlopSpacing.md))
        }

        FlopStepLadder(flow, pulse = pulse)
        // Drawn under the ladder rather than inside it: the five are the Passport and the
        // app can prove every one of them, this one is what the Passport is for and only
        // half of it can be proved. Same sequence, different promise, so it is shown as a
        // continuation and never counted into the five.
        if (flow.complete) {
            Spacer(Modifier.height(FlopSpacing.sm))
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Surface, FlopShapes.md)
                    .border(
                        1.dp,
                        if (vm.nameLinked) FlopColors.Green.copy(alpha = 0.5f)
                        else FlopColors.Cyan.copy(alpha = 0.35f),
                        FlopShapes.md,
                    )
                    .padding(FlopSpacing.md),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(Modifier.weight(1f)) {
                    FlopLabel("06  tell them")
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(
                        t(
                            if (vm.nameLinked) {
                                "Your post is in your identity note, at your key's own address."
                            } else {
                                "Not done. Your Passport is not attached to any public name " +
                                    "yet, and this is the one step nobody can do for you."
                            },
                        ),
                        style = FlopType.bodySm,
                        color = FlopColors.TextMuted,
                    )
                }
                Spacer(Modifier.width(FlopSpacing.sm))
                FlopBadge(
                    if (vm.nameLinked) "linked" else "open",
                    if (vm.nameLinked) FlopState.Verified else FlopState.Neutral,
                )
            }
        }
        Spacer(Modifier.height(FlopSpacing.lg))

        when {
            flow.complete && vm.nameLinked -> Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Green.copy(alpha = 0.12f), FlopShapes.md)
                    .border(2.dp, FlopColors.Green, FlopShapes.md)
                    .padding(FlopSpacing.lg),
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        Modifier.size(44.dp).background(FlopColors.Green, FlopShapes.md),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text("\u2713", style = FlopType.h2, color = FlopColors.Base)
                    }
                    Spacer(Modifier.height(FlopSpacing.sm))
                    Text(
                        t("All six done"),
                        style = FlopType.h2,
                        color = FlopColors.Green,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(
                        t("Your Passport is live, it is yours, and your name is on it."),
                        style = FlopType.bodyMd,
                        color = FlopColors.IceWhite,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(Modifier.height(FlopSpacing.sm))
                    Text(
                        t(
                            "Anyone can check it at the address in step 03. This app promises " +
                                "nothing about any allocation, and never will.",
                        ),
                        style = FlopType.bodySm,
                        color = FlopColors.TextMuted,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            flow.complete -> Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Surface, FlopShapes.md)
                    .border(2.dp, FlopColors.Cyan, FlopShapes.md)
                    .padding(FlopSpacing.lg),
            ) {
                Column {
                    FlopLabel(t("5 of 6"))
                    Spacer(Modifier.height(FlopSpacing.sm))
                    Text(
                        t("Your Passport is live. One step left."),
                        style = FlopType.h3,
                        color = FlopColors.IceWhite,
                    )
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(
                        t(
                            "The five steps built your identity. Nobody outside this phone " +
                                "knows it is yours yet. Step 06 below: write one line, post " +
                                "it, then come back and paste the link. That last part is " +
                                "what puts your name beside your key for good, and it is " +
                                "where people stop.",
                        ),
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
                body = "A public note at an address derived from your key, so anyone can " +
                    "find and verify you later. This one goes to technocore.chat, which is " +
                    "someone else's public service: when it is busy it refuses, and pressing " +
                    "again is the answer. Two or three attempts is normal and means nothing " +
                    "is wrong with your phone.",
                button = "publish identity",
                enabled = !flow.busy,
                onClick = { vm.publish() },
            )

            else -> ActionBlock(
                title = "Make your first signed check-in",
                body = "A message signed by your Passport, posted to a quiet room and then " +
                    "read back to prove it landed. Same service as step 03, same rule: if it " +
                    "refuses, press again. It is their load, not your key.",
                button = "sign and check in",
                enabled = !flow.busy,
                onClick = { vm.checkIn() },
            )
        }

        // Only after the ladder is finished, and this condition is the whole point.
        //
        // Gated on `did != null` it appeared the moment a key existed, which is one tap
        // in: a person who had not published anything, checked in anywhere or posted a
        // word was shown a field asking for the link to their post. Caught on a clean
        // install on a second phone. The five steps are a guided sequence that explains
        // itself, and a box from step six sitting under step one undoes that guidance for
        // everybody who is not already sure what the app is.
        if (flow[Step.Ready] is StepState.Verified) {
            Spacer(Modifier.height(FlopSpacing.lg))
            TellThemCard(vm)
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
                Text(t(it), style = FlopType.bodySm, color = FlopColors.ErrorRed)
            }


        }
        Spacer(Modifier.height(FlopSpacing.xl))
    }
}

/** Short, filename-safe form of a DID, for the saved backup's name. */
private fun didKeyShort(did: String): String =
    did.removePrefix("did:key:").take(10)

/** What the dialog tells the user is coming, so "continue" is never a leap in the dark. */
private fun nextHint(next: Step?): String = when (next) {
    Step.Create -> "Next: create your Passport from your wallet."
    Step.Protect -> "Next: seal the key in this phone's secure storage."
    Step.Publish -> "Next: publish your identity so anyone can verify you."
    Step.CheckIn -> "Next: make your first signed check-in."
    // The ladder ends, the app does not. Saying so here is what stops the last dialog
    // from feeling like a door closing on somebody who still has the useful half to do.
    Step.Ready, null ->
        "That was the last step. Your Passport is live. One thing left, and it is the " +
            "part FLOP actually asked for: tell people what you did. The app writes the " +
            "post for you at the bottom of this screen."
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
        Text(t(title), style = FlopType.h3, color = FlopColors.IceWhite)
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(t(body), style = FlopType.bodyMd, color = FlopColors.TextMuted)
        Spacer(Modifier.height(FlopSpacing.md))
        FlopButton(button, onClick, enabled = enabled)
    }
}

/**
 * Run a step again.
 *
 * Written once, here, because the retry button and the step's own button have to do the
 * same thing - and a second copy of this mapping is a bug waiting for the day a step is
 * added. `Ready` is not an action; it settles when step 04 does.
 */
private fun retry(vm: PassportViewModel, step: Step, launchIntent: (Intent) -> Unit) {
    when (step) {
        Step.Create -> vm.createPassport(launchIntent)
        Step.Protect -> vm.protect()
        Step.Publish -> vm.publish()
        Step.CheckIn -> vm.checkIn()
        Step.Ready -> Unit
    }
}
