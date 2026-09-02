package dev.alexkosa.flooppassport.ui.designsystem

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.alexkosa.flooppassport.i18n.t
import dev.alexkosa.flooppassport.technocore.Technocore

/**
 * The live connection block: what the app is doing right now, to whom, and how long the
 * last answer took.
 *
 * It exists because every claim this app makes rests on having really talked to a service,
 * and a spinner is not evidence of that - a spinner turns exactly as happily in aeroplane
 * mode. A number in milliseconds cannot be animated into existence: it is the time the
 * last request took, written by the code that made it, and it moves when the network
 * moves.
 *
 * The block also has to be honest while things go badly, because that is when a person
 * stares at it. A retry says which attempt it is on, a refusal shows what came back, and
 * the moment before any answer exists says so in words rather than showing a stale figure.
 */
@Composable
fun FlopWire(
    pulse: Technocore.Pulse?,
    active: Boolean,
    what: String? = null,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxWidth()
            .background(FlopColors.Surface, FlopShapes.md)
            .border(1.dp, FlopColors.Border, FlopShapes.md)
            .padding(FlopSpacing.md),
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(t(
                if (active) "LIVE CONNECTION" else "LAST CONNECTION"),
                style = FlopType.label,
                color = FlopColors.TextMuted,
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Dot(active = active, ok = pulse?.ok)
                Spacer(Modifier.width(FlopSpacing.sm))
                Text(
                    when {
                        pulse == null && active -> "opening"
                        pulse == null -> "not asked yet"
                        else -> "${pulse.millis} ms"
                    },
                    style = FlopType.h3,
                    color = when {
                        pulse == null -> FlopColors.TextMuted
                        pulse.ok -> FlopColors.Green
                        else -> FlopColors.ErrorRed
                    },
                )
            }
        }

        Spacer(Modifier.height(FlopSpacing.sm))

        // A segment travelling left to right rather than a rotation: the motion language
        // in this app is signal moving along a line, and a spinner would be the one
        // borrowed gesture in it. The track stays visible when idle so the block does not
        // change height and shunt the page around.
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .height(3.dp)
                .clip(FlopShapes.sm)
                .background(FlopColors.Border),
        ) {
            if (active) {
                val t = rememberInfiniteTransition(label = "wire")
                val p by t.animateFloat(
                    initialValue = 0f,
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(tween(1200, easing = LinearEasing)),
                    label = "travel",
                )
                val segment = maxWidth * 0.32f
                Box(
                    Modifier
                        .offset(x = (maxWidth + segment) * p - segment)
                        .width(segment)
                        .height(3.dp)
                        .background(FlopColors.Cyan, FlopShapes.sm),
                )
            } else if (pulse != null) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                        .background(
                            if (pulse.ok) FlopColors.Green else FlopColors.ErrorRed,
                            FlopShapes.sm,
                        ),
                )
            }
        }

        Spacer(Modifier.height(FlopSpacing.sm))

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(t(
                pulse?.host ?: "technocore.chat"),
                style = FlopType.code,
                color = FlopColors.IceWhite,
            )
            Spacer(Modifier.width(FlopSpacing.sm))
            Text(
                buildString {
                    val action = what ?: pulse?.what
                    if (action != null) append(action)
                    if (pulse != null && pulse.attempt > 1) {
                        if (isNotEmpty()) append("  ·  ")
                        append("attempt ${pulse.attempt}")
                    }
                    if (pulse != null && !pulse.ok) {
                        if (isNotEmpty()) append("  ·  ")
                        append(pulse.detail)
                    }
                },
                style = FlopType.code,
                color = if (pulse?.ok == false) FlopColors.ErrorRed else FlopColors.TextMuted,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End,
            )
        }
    }
}

/** Cyan and breathing while a request is open; the outcome's colour once it lands. */
@Composable
private fun Dot(active: Boolean, ok: Boolean?) {
    val colour = when {
        active -> FlopColors.Cyan
        ok == true -> FlopColors.Green
        ok == false -> FlopColors.ErrorRed
        else -> FlopColors.Grey
    }
    if (active) {
        val t = rememberInfiniteTransition(label = "dot")
        val a by t.animateFloat(
            initialValue = 0.3f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                tween(700, easing = LinearEasing), RepeatMode.Reverse,
            ),
            label = "breathe",
        )
        Box(Modifier.size(7.dp).background(colour.copy(alpha = a), FlopShapes.sm))
    } else {
        Box(Modifier.size(7.dp).background(colour, FlopShapes.sm))
    }
}
