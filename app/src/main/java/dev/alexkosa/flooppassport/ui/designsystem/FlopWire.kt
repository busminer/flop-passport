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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.alexkosa.flooppassport.i18n.t
import dev.alexkosa.flooppassport.technocore.Technocore

/**
 * The connection block: one sentence about what is happening, and the measured round trip.
 *
 * Two rules, both learned from watching it on a real phone.
 *
 * **It must not move.** Every line is capped at one line and ellipsised rather than
 * wrapped, so the block is the same height whatever the status says. The first version grew
 * and shrank as the text changed and the page jumped under the reader - much worse at a
 * large system font size, where one status could take three lines and shove the screen down.
 *
 * **It must not frighten.** A retry in progress is not an error: this service refuses about
 * one request in three and the next attempt usually succeeds, so a red "HTTP 503 · attempt 2"
 * mid-retry described a normal Tuesday as a catastrophe. Red is kept for a request that has
 * finished failing. Everything else is said in words, and no status codes, attempt counts or
 * exception class names reach the screen. The milliseconds stay, because they are the one
 * thing here a person can check against their own sense of whether the network is alive.
 */
@Composable
fun FlopWire(
    pulse: Technocore.Pulse?,
    active: Boolean,
    modifier: Modifier = Modifier,
) {
    val busy = active && pulse != null && !pulse.ok
    val failed = !active && pulse != null && !pulse.ok

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
            Text(
                t(if (active) "connection" else "last connection").uppercase(),
                style = FlopType.label,
                color = FlopColors.TextMuted,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f, fill = false),
            )
            Spacer(Modifier.width(FlopSpacing.sm))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Dot(active = active, ok = pulse?.ok)
                Spacer(Modifier.width(FlopSpacing.sm))
                Text(
                    if (pulse == null) "—" else "${pulse.millis} ms",
                    style = FlopType.bodyMd,
                    color = when {
                        pulse == null -> FlopColors.TextMuted
                        failed -> FlopColors.ErrorRed
                        pulse.ok -> FlopColors.Green
                        else -> FlopColors.TextSecondary
                    },
                    maxLines = 1,
                )
            }
        }

        Spacer(Modifier.height(FlopSpacing.sm))

        // A segment travelling left to right rather than a rotation: the motion language
        // here is signal moving along a line. The track is always drawn, so the block keeps
        // its height whether or not anything is in flight.
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .height(3.dp)
                .clip(FlopShapes.sm)
                .background(FlopColors.Border),
        ) {
            if (active) {
                val transition = rememberInfiniteTransition(label = "wire")
                val travel by transition.animateFloat(
                    initialValue = 0f,
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(tween(1200, easing = LinearEasing)),
                    label = "travel",
                )
                val segment = maxWidth * 0.32f
                Box(
                    Modifier
                        .offset(x = (maxWidth + segment) * travel - segment)
                        .width(segment)
                        .height(3.dp)
                        .background(FlopColors.Cyan),
                )
            } else if (pulse != null) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                        .background(if (pulse.ok) FlopColors.Green else FlopColors.ErrorRed),
                )
            }
        }

        Spacer(Modifier.height(FlopSpacing.sm))

        // Exactly one line, always. The ellipsis is what keeps the height fixed.
        Text(
            when {
                failed -> t("Could not reach the server.")
                busy -> t("The server is busy. Trying again.")
                active -> t(pulse?.what ?: "Opening a connection")
                pulse != null -> t("technocore.chat answered")
                else -> t("Nothing asked yet")
            },
            style = FlopType.bodySm,
            color = when {
                failed -> FlopColors.ErrorRed
                busy -> FlopColors.TextSecondary
                else -> FlopColors.TextMuted
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

/** Cyan and breathing while a request is open; the outcome's colour once it has landed. */
@Composable
private fun Dot(active: Boolean, ok: Boolean?) {
    val colour = when {
        active -> FlopColors.Cyan
        ok == true -> FlopColors.Green
        ok == false -> FlopColors.ErrorRed
        else -> FlopColors.Grey
    }
    if (active) {
        val transition = rememberInfiniteTransition(label = "dot")
        val alpha by transition.animateFloat(
            initialValue = 0.3f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                tween(700, easing = LinearEasing), RepeatMode.Reverse,
            ),
            label = "breathe",
        )
        Box(Modifier.size(7.dp).background(colour.copy(alpha = alpha), FlopShapes.sm))
    } else {
        Box(Modifier.size(7.dp).background(colour, FlopShapes.sm))
    }
}
