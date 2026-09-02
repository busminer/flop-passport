package dev.alexkosa.flooppassport.ui.designsystem

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import dev.alexkosa.flooppassport.i18n.t
import androidx.compose.ui.unit.dp

/**
 * The FLOP component set. Every surface in the app is built from these, so a colour or a
 * radius is changed in one place and the design system's rules are enforced by
 * construction rather than by review.
 */

@Composable
fun FlopLabel(text: String, color: Color = FlopColors.TextMuted, modifier: Modifier = Modifier) {
    Text(t(text).uppercase(), style = FlopType.label, color = color, modifier = modifier)
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
 * Primary action: Cyan fill with Base text, which the design system measures at 7.6:1.
 * Disabled state drops to a surface fill rather than a faded Cyan, because a washed-out
 * accent on a dark ground stops being readable well before it stops being visible.
 */
@Composable
fun FlopButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(if (enabled) FlopColors.Cyan else FlopColors.Surface, FlopShapes.md)
            .then(if (enabled) Modifier else Modifier.border(1.dp, FlopColors.Border, FlopShapes.md))
            .clickable(enabled = enabled) { onClick() }
            .padding(vertical = 15.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(t(text).uppercase(),
            style = FlopType.label,
            color = if (enabled) FlopColors.Base else FlopColors.TextMuted,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun FlopButtonSecondary(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(FlopColors.Surface, FlopShapes.md)
            .border(1.dp, FlopColors.Border, FlopShapes.md)
            .clickable { onClick() }
            .padding(vertical = 14.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(t(text).uppercase(), style = FlopType.label, color = FlopColors.IceWhite)
    }
}

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
        Text(t(text).uppercase(), style = FlopType.label, color = fg)
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
