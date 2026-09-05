package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.ui.Evidence
import dev.alexkosa.floppassport.ui.Step

/**
 * The moment a step lands.
 *
 * A step going quietly green in a list is easy to miss, and someone using this for the
 * first time needs to be told plainly that the thing worked, what it was, and what happens
 * next. So each completed step stops and says so, with the evidence underneath for anyone
 * who wants it, and one button that carries on.
 *
 * Deliberately restrained: Electric Green, one mark, one short line. It is a confirmation,
 * not a celebration - the app has nothing to celebrate on the user's behalf and promises
 * them nothing.
 */
@Composable
fun FlopStepDialog(
    step: Step,
    headline: String,
    body: String,
    evidence: Evidence?,
    nextLabel: String,
    onDismiss: () -> Unit,
) {
    var shown by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { shown = true }
    val mark by animateFloatAsState(
        if (shown) 1f else 0.7f, tween(420), label = "mark",
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Column(
            Modifier
                .padding(FlopSpacing.lg)
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, FlopColors.Green.copy(alpha = 0.45f), FlopShapes.lg)
                .padding(FlopSpacing.lg),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier
                        .size(22.dp)
                        .scale(mark)
                        .background(FlopColors.Green, FlopShapes.sm),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(t("✓"), style = FlopType.label, color = FlopColors.Base)
                }
                Spacer(Modifier.width(FlopSpacing.sm))
                FlopLabel("step ${step.ordinal1} ${step.title} complete", FlopColors.Green)
            }

            Spacer(Modifier.height(FlopSpacing.md))
            Text(t(headline), style = FlopType.h3, color = FlopColors.IceWhite)
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(body), style = FlopType.bodyMd, color = FlopColors.TextMuted)

            if (evidence != null && evidence.lines.isNotEmpty()) {
                Spacer(Modifier.height(FlopSpacing.md))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .heightIn()
                        .background(FlopColors.Base, FlopShapes.md)
                        .padding(FlopSpacing.sm)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(FlopSpacing.xs),
                ) {
                    evidence.lines.forEach { (k, v) ->
                        FlopLabel(k)
                        Text(t(v), style = FlopType.code, color = FlopColors.IceWhite)
                    }
                }
            }

            Spacer(Modifier.height(FlopSpacing.lg))
            FlopButton(nextLabel, onDismiss)
        }
    }
}

/** No max height constraint yet; kept as a seam so the evidence block can gain one. */
private fun Modifier.heightIn(): Modifier = this

/**
 * Shown when a step does not land. Same shape as the success dialog on purpose: the user
 * learns one pattern, and a failure is not hidden in a different, smaller place.
 */
@Composable
fun FlopProblemDialog(
    step: Step,
    headline: String,
    whatToDo: String,
    publishedSomething: Boolean,
    detail: String?,
    onDismiss: () -> Unit,
    /** Runs the step again. The way out of a failure belongs in the window that reports it. */
    onRetry: (() -> Unit)? = null,
    /** "try again" when nothing was sent, "check again" when something might already be there. */
    retryLabel: String = "try again",
) {
    Dialog(onDismissRequest = onDismiss, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        // Scrolls for the same reason as the success dialog, and it matters more here: this
        // is the dialog that appears when something has already gone wrong, it carries the
        // longest text in the app, and its way out is at the bottom.
        Column(
            Modifier
                .padding(FlopSpacing.lg)
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, FlopColors.ErrorRed.copy(alpha = 0.45f), FlopShapes.lg)
                .verticalScroll(rememberScrollState())
                .padding(FlopSpacing.lg),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(22.dp).background(FlopColors.ErrorRed, FlopShapes.sm))
                Spacer(Modifier.width(FlopSpacing.sm))
                FlopLabel("step ${step.ordinal1} ${step.title} did not finish", FlopColors.ErrorRed)
            }
            Spacer(Modifier.height(FlopSpacing.md))
            Text(t(headline), style = FlopType.h3, color = FlopColors.IceWhite)
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(whatToDo), style = FlopType.bodyMd, color = FlopColors.TextMuted)

            Spacer(Modifier.height(FlopSpacing.md))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Base, FlopShapes.md)
                    .padding(FlopSpacing.sm),
            ) {
                Column {
                    FlopLabel("did anything go public?")
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(t(
                        if (publishedSomething) {
                            "Yes. Something is already visible to others."
                        } else {
                            "No. Nothing was published."
                        }),
                        style = FlopType.code,
                        color = if (publishedSomething) FlopColors.Cyan else FlopColors.Green,
                    )
                    if (detail != null) {
                        Spacer(Modifier.height(FlopSpacing.sm))
                        FlopLabel("detail")
                        Spacer(Modifier.height(FlopSpacing.xs))
                        Text(t(detail), style = FlopType.code, color = FlopColors.TextMuted)
                    }
                }
            }

            Spacer(Modifier.height(FlopSpacing.lg))
            // The action first, and as the primary button. A failed step is not finished,
            // and a dialog whose only way out is "ok" says that it is.
            if (onRetry != null) {
                FlopButton(retryLabel, onRetry)
                Spacer(Modifier.height(FlopSpacing.sm))
                FlopButtonSecondary("close", onDismiss)
            } else {
                FlopButton("ok", onDismiss)
            }
        }
    }
}

/** Centred variant used by the final screen, where the message is the whole point. */
@Composable
fun FlopCentredText(text: String, modifier: Modifier = Modifier) {
    Text(t(
        text),
        style = FlopType.bodyMd,
        color = FlopColors.TextMuted,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth(),
    )
}
