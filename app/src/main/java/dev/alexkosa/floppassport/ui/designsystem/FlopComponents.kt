package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.Dp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.i18n.tu
import androidx.compose.ui.unit.dp

/**
 * The FLOP component set. Every surface in the app is built from these, so a colour or a
 * radius is changed in one place and the design system's rules are enforced by
 * construction rather than by review.
 */

@Composable
fun FlopLabel(text: String, color: Color = FlopColors.TextMuted, modifier: Modifier = Modifier) {
    Text(tu(text), style = FlopType.label, color = color, modifier = modifier)
}

@Composable
fun FlopMonoData(text: String, color: Color = FlopColors.Cyan, modifier: Modifier = Modifier) {
    Text(t(text), style = FlopType.code, color = color, modifier = modifier)
}

@Composable
fun FlopCard(
    modifier: Modifier = Modifier,
    accent: Color? = null,
    content: @Composable ColumnScope.() -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(FlopColors.Surface, FlopShapes.md)
            .border(1.dp, accent ?: FlopColors.Border, FlopShapes.md)
            .padding(FlopSpacing.md),
        content = { content() },
    )
}

/**
 * A button you can feel: a lit face standing on a plinth, which drops onto it when pressed.
 *
 * Two boxes rather than one shadow, because the plinth is what makes it read as raised on a
 * dark ground, where a shadow alone disappears. Long translations wrap, so the height is a
 * floor and not a size.
 */
@Composable
private fun RaisedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    face: List<Color>,
    plinth: Color,
    ink: Color,
    glow: Color,
    minHeight: Dp,
    rimAlpha: Float,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val drop by animateDpAsState(if (pressed) 3.dp else 0.dp, tween(90), label = "drop")
    val haptics = LocalHapticFeedback.current
    LaunchedEffect(pressed) {
        if (pressed) haptics.performHapticFeedback(HapticFeedbackType.LongPress)
    }
    val shape = FlopShapes.button
    Box(modifier.fillMaxWidth().padding(bottom = 3.dp)) {
        if (enabled) Box(Modifier.matchParentSize().offset(y = 3.dp).background(plinth, shape))
        Box(
            Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = minHeight)
                .offset(y = drop)
                .then(
                    if (enabled) {
                        Modifier
                            .shadow(if (pressed) 2.dp else 10.dp, shape, clip = false, ambientColor = glow, spotColor = FlopColors.Ink.copy(alpha = 0.6f))
                            .background(Brush.verticalGradient(0f to face[0], 0.55f to face[1], 1f to face[2]), shape)
                            .border(1.dp, Brush.verticalGradient(0f to Color.White.copy(alpha = rimAlpha), 0.5f to Color.Transparent), shape)
                    } else {
                        Modifier
                            .background(FlopColors.Surface, shape)
                            .border(1.dp, FlopColors.SurfaceLight, shape)
                    },
                )
                .clickable(interaction, indication = null, enabled = enabled, onClick = onClick)
                .padding(horizontal = FlopSpacing.md, vertical = 10.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                tu(text),
                style = FlopType.button,
                color = if (enabled) ink else FlopColors.TextMuted,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun FlopButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true) =
    RaisedButton(
        text, onClick, modifier, enabled,
        listOf(FlopColors.CyanHover, FlopColors.Cyan, FlopColors.CyanDeep),
        FlopColors.CyanPlinth, FlopColors.Base, FlopColors.Cyan.copy(alpha = 0.32f), 56.dp, 0.55f,
    )

/** What says it worked: the end of a process. */
@Composable
fun FlopButtonGreen(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true) =
    RaisedButton(
        text, onClick, modifier, enabled,
        listOf(FlopColors.GreenTop, FlopColors.Green, FlopColors.GreenDeep),
        FlopColors.GreenPlinth, FlopColors.Base, FlopColors.Green.copy(alpha = 0.28f), 56.dp, 0.55f,
    )

@Composable
fun FlopButtonSecondary(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true) =
    RaisedButton(
        text, onClick, modifier, enabled,
        listOf(FlopColors.SecondaryTop, FlopColors.SurfaceLight, FlopColors.SecondaryBottom),
        FlopColors.SecondaryPlinth, FlopColors.IceWhite, FlopColors.Ink.copy(alpha = 0.4f), 46.dp, 0.14f,
    )

/** Raised means you can press it or it matters; every card is lit from above. */
fun Modifier.raisedCard(glow: Color? = null, rim: Color? = null): Modifier =
    this
        .shadow(8.dp, FlopShapes.lg, clip = false, ambientColor = FlopColors.Ink.copy(alpha = 0.45f), spotColor = FlopColors.Ink.copy(alpha = 0.55f))
        .clip(FlopShapes.lg)
        .background(Brush.verticalGradient(listOf(FlopColors.SurfaceRaised, FlopColors.Surface)))
        .then(
            if (glow == null) {
                Modifier
            } else {
                Modifier.drawBehind {
                    drawRect(
                        Brush.radialGradient(
                            listOf(glow.copy(alpha = 0.16f), Color.Transparent),
                            center = Offset(size.width * 0.12f, 0f),
                            radius = 260.dp.toPx(),
                        ),
                    )
                }
            },
        )
        .border(
            1.dp,
            if (rim != null) SolidColor(rim) else Brush.verticalGradient(0f to FlopColors.IceWhite.copy(alpha = 0.12f), 0.6f to Color.Transparent),
            FlopShapes.lg,
        )

/** The counterpart of a raised card: inset holds a value. */
fun Modifier.well(): Modifier =
    this
        .background(FlopColors.Base, FlopShapes.md)
        .border(1.dp, Brush.verticalGradient(listOf(FlopColors.Ink, FlopColors.IceWhite.copy(alpha = 0.05f))), FlopShapes.md)

enum class FlopState { Verified, Active, Neutral, Failure }

/**
 * Status is never carried by colour alone: every badge pairs its colour with a word, so it
 * survives colour blindness, a screenshot in greyscale, and a glance.
 */
@Composable
fun FlopBadge(text: String, state: FlopState, modifier: Modifier = Modifier) {
    val fg = when (state) {
        FlopState.Verified -> FlopColors.Green
        FlopState.Active -> FlopColors.Cyan
        FlopState.Neutral -> FlopColors.TextMuted
        FlopState.Failure -> FlopColors.ErrorRed
    }
    Box(
        modifier = modifier
            .background(fg.copy(alpha = 0.13f), FlopShapes.pill)
            .padding(horizontal = 10.dp, vertical = 4.dp),
    ) {
        Text(tu(text), style = FlopType.label, color = fg)
    }
}

@Composable
fun FlopStatusRow(label: String, value: String, state: FlopState, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = 9.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FlopLabel(label)
        FlopBadge(value, state)
    }
}

@Composable
fun FlopDot(state: FlopState, modifier: Modifier = Modifier) {
    val c = when (state) {
        FlopState.Verified -> FlopColors.Green
        FlopState.Active -> FlopColors.Cyan
        FlopState.Neutral -> FlopColors.Grey
        FlopState.Failure -> FlopColors.ErrorRed
    }
    Box(modifier = modifier.size(7.dp).background(c, CircleShape))
}
