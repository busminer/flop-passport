package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.foundation.layout.heightIn
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
        // Scrolls, like the problem dialog already does. A dialog is clipped by the edge
        // of the screen rather than moved, and this one carries a URL, a note body, a nonce
        // and a timestamp: at the largest system font its "continue" button sat below the
        // glass - on the windows whose whole job is to say a step succeeded.
        Column(
            Modifier
                .padding(FlopSpacing.lg)
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, FlopColors.Green.copy(alpha = 0.45f), FlopShapes.lg)
                .padding(FlopSpacing.lg)
                // A dialog is measured with no maximum height, and a scroll inside
                // infinity is a crash rather than a scroll. Nine tenths of the screen
                // is the ceiling: enough that nothing is cramped, bounded enough that
                // the buttons at the bottom stay reachable at any font size.
                .heightIn(max = (LocalConfiguration.current.screenHeightDp * 0.9f).dp)
                .verticalScroll(rememberScrollState()),
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
                // The step's own name is translated separately and then put in: it is a
                // word the tables already carry, and pasting it in first is exactly what
                // stopped this whole line from ever matching one.
                FlopLabel(
                    t("step {n} {title} complete", "n" to step.ordinal1, "title" to t(step.title)),
                    FlopColors.Green,
                )
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
                        .background(FlopColors.Base, FlopShapes.md)
                        .padding(FlopSpacing.sm),
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
    /**
     * True when the write may well have landed and only our confirmation of it failed.
     *
     * It gets the cyan frame and its own words. Dressing it as a failure told people to
     * treat "we could not check" as "it did not happen", and the safe action for the two is
     * not the same one.
     */
    unconfirmed: Boolean = false,
    onDismiss: () -> Unit,
    /** Runs the step again. The way out of a failure belongs in the window that reports it. */
    onRetry: (() -> Unit)? = null,
    /** "try again" when nothing was sent, "check again" when something might already be there. */
    retryLabel: String = "try again",
) {
    val accent = if (unconfirmed) FlopColors.Cyan else FlopColors.ErrorRed
    Dialog(onDismissRequest = onDismiss, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        // Scrolls for the same reason as the success dialog, and it matters more here: this
        // is the dialog that appears when something has already gone wrong, it carries the
        // longest text in the app, and its way out is at the bottom.
        Column(
            Modifier
                .padding(FlopSpacing.lg)
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, accent.copy(alpha = 0.45f), FlopShapes.lg)
                // A dialog is measured with no maximum height, and a scroll inside
                // infinity is a crash rather than a scroll. Nine tenths of the screen
                // is the ceiling: enough that nothing is cramped, bounded enough that
                // the buttons at the bottom stay reachable at any font size.
                .heightIn(max = (LocalConfiguration.current.screenHeightDp * 0.9f).dp)
                .verticalScroll(rememberScrollState())
                .padding(FlopSpacing.lg),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(22.dp).background(accent, FlopShapes.sm))
                Spacer(Modifier.width(FlopSpacing.sm))
                FlopLabel(
                    t(
                        if (unconfirmed) "step {n} {title} not confirmed yet"
                        else "step {n} {title} did not finish",
                        "n" to step.ordinal1,
                        "title" to t(step.title),
                    ),
                    accent,
                )
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
                        when {
                            unconfirmed ->
                                "Maybe. The service accepted it, and this app could not " +
                                    "read it back to be sure."
                            publishedSomething -> "Yes. Something is already visible to others."
                            else -> "No. Nothing was published."
                        }),
                        style = FlopType.code,
                        color = if (publishedSomething || unconfirmed) FlopColors.Cyan
                        else FlopColors.Green,
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
