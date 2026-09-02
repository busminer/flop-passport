package dev.alexkosa.flooppassport.ui.designsystem

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.alexkosa.flooppassport.i18n.t
import dev.alexkosa.flooppassport.ui.Evidence
import dev.alexkosa.flooppassport.ui.FlowState
import dev.alexkosa.flooppassport.technocore.Technocore
import dev.alexkosa.flooppassport.ui.Step
import dev.alexkosa.flooppassport.ui.StepState

/**
 * The step ladder: five rows that always say where the user is.
 *
 * Every row carries a word as well as a colour, so the state survives a greyscale
 * screenshot and colour blindness. A running row names the service it is talking to. A
 * finished row can be tapped open to show the raw evidence, because a user who wants to
 * check our arithmetic should be able to, and one who does not should never have to look
 * at a nonce.
 */
@Composable
fun FlopStepLadder(
    flow: FlowState,
    modifier: Modifier = Modifier,
    pulse: Technocore.Pulse? = null,
) {
    Column(modifier.fillMaxWidth()) {
        Step.all.forEachIndexed { index, step ->
            StepRow(step, flow[step], isLast = index == Step.all.lastIndex, pulse = pulse)
        }
    }
}

@Composable
private fun StepRow(
    step: Step,
    state: StepState,
    isLast: Boolean,
    pulse: Technocore.Pulse?,
) {
    var open by remember { mutableStateOf(false) }
    val evidence = (state as? StepState.Verified)?.evidence
    val canOpen = evidence != null || state is StepState.Failed || state is StepState.Unconfirmed

    Column(
        Modifier
            .fillMaxWidth()
            .then(if (canOpen) Modifier.clickable { open = !open } else Modifier)
            .padding(vertical = FlopSpacing.sm),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            StepMarker(state)
            Spacer(Modifier.width(FlopSpacing.md))
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(t(
                        step.ordinal1),
                        style = FlopType.label,
                        color = if (state is StepState.Pending) FlopColors.Grey else FlopColors.TextMuted,
                    )
                    Spacer(Modifier.width(FlopSpacing.sm))
                    Text(
                        t(step.title).uppercase(),
                        style = FlopType.label,
                        color = when (state) {
                            is StepState.Pending -> FlopColors.Grey
                            is StepState.Verified -> FlopColors.IceWhite
                            else -> FlopColors.IceWhite
                        },
                    )
                }
                val line = statusLine(state)
                if (line != null) {
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(t(line), style = FlopType.bodySm, color = statusColour(state))
                }
                // While a step is talking to the service, show what the wire is actually
                // doing. Naming the host is a claim; the milliseconds are the evidence.
                if (state is StepState.Running) {
                    Spacer(Modifier.height(FlopSpacing.sm))
                    FlopWire(pulse = pulse, active = true)
                }
            }
            StatusWord(state)
        }

        AnimatedVisibility(visible = open) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, top = FlopSpacing.sm)
                    .background(FlopColors.Base, FlopShapes.md)
                    .padding(FlopSpacing.sm),
            ) {
                when (state) {
                    is StepState.Verified -> evidence?.lines?.forEach { (k, v) ->
                        EvidenceLine(k, v)
                    }
                    is StepState.Failed -> {
                        EvidenceLine("what to do", state.whatToDo)
                        if (state.publishedSomething) {
                            EvidenceLine("published", "yes, something is already public")
                        } else {
                            EvidenceLine("published", "no, nothing was made public")
                        }
                        state.detail?.let { EvidenceLine("detail", it) }
                    }
                    is StepState.Unconfirmed -> {
                        EvidenceLine("what to do", state.whatToDo)
                        state.detail?.let { EvidenceLine("detail", it) }
                    }
                    else -> Unit
                }
            }
        }

        if (!isLast) {
            Spacer(Modifier.height(FlopSpacing.xs))
            Box(
                Modifier
                    .padding(start = 5.dp)
                    .width(1.dp)
                    .height(FlopSpacing.sm)
                    .background(FlopColors.Border),
            )
        }
    }
}

@Composable
private fun EvidenceLine(key: String, value: String) {
    Row(Modifier.fillMaxWidth().padding(vertical = 3.dp)) {
        Text(t(key).uppercase(),
            style = FlopType.label,
            color = FlopColors.TextMuted,
            modifier = Modifier.width(96.dp),
        )
        Text(t(value), style = FlopType.code, color = FlopColors.IceWhite, modifier = Modifier.weight(1f))
    }
}

@Composable
private fun StepMarker(state: StepState) {
    when (state) {
        is StepState.Running -> {
            // A slow pulse, not a spinner: this is a machine waiting on another machine,
            // and the rest of the motion language is signal rather than rotation.
            val t = rememberInfiniteTransition(label = "pulse")
            val a by t.animateFloat(
                initialValue = 0.35f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    tween(700, easing = LinearEasing), RepeatMode.Reverse,
                ),
                label = "alpha",
            )
            Box(Modifier.size(11.dp), contentAlignment = Alignment.Center) {
                Box(
                    Modifier
                        .size(9.dp)
                        .alpha(a)
                        .background(FlopColors.Cyan, FlopShapes.sm),
                )
            }
        }
        else -> {
            val c = when (state) {
                is StepState.Pending -> FlopColors.Grey
                is StepState.Verified -> FlopColors.Green
                is StepState.Failed -> FlopColors.ErrorRed
                is StepState.Unconfirmed -> FlopColors.Cyan
                is StepState.Running -> FlopColors.Cyan
            }
            Box(Modifier.size(11.dp), contentAlignment = Alignment.Center) {
                Box(Modifier.size(if (state is StepState.Pending) 5.dp else 9.dp).background(c, FlopShapes.sm))
            }
        }
    }
}

@Composable
private fun StatusWord(state: StepState) {
    when (state) {
        is StepState.Pending -> Unit
        is StepState.Running -> FlopBadge("working", FlopState.Active)
        is StepState.Verified -> FlopBadge("verified", FlopState.Verified)
        is StepState.Failed -> FlopBadge("failed", FlopState.Failure)
        is StepState.Unconfirmed -> FlopBadge("unconfirmed", FlopState.Active)
    }
}

private fun statusLine(state: StepState): String? = when (state) {
    is StepState.Pending -> null
    is StepState.Running -> state.what
    is StepState.Verified -> state.summary
    is StepState.Failed -> state.summary
    is StepState.Unconfirmed -> state.summary
}

private fun statusColour(state: StepState): Color = when (state) {
    is StepState.Failed -> FlopColors.ErrorRed
    is StepState.Verified -> FlopColors.TextMuted
    else -> FlopColors.TextMuted
}
