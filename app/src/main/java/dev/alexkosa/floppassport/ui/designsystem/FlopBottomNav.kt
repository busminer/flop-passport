package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.sp

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.alexkosa.floppassport.i18n.t
import androidx.compose.ui.unit.dp

/**
 * The four places this app has. Named as nouns, because a tab is a place, not an action -
 * "Ask" is the exception, because the place is the asking.
 */
enum class Tab(val label: String) {
    Today("Today"),
    Ask("Ask"),
    // Network, then Bridge, which nobody could read. The enum keeps its first name: it is
    // only a tab's identity.
    Network("Pulse"),
    Passport("Passport"),
}

/**
 * Four tabs; the one you are on stands up as a raised capsule with its icon lit.
 * Never colour alone: the capsule is the mark, and the label is always there.
 */
@Composable
fun FlopBottomNav(
    selected: Tab,
    onSelect: (Tab) -> Unit,
    modifier: Modifier = Modifier,
    badge: Map<Tab, String> = emptyMap(),
) {
    Row(
        modifier
            .fillMaxWidth()
            .background(FlopColors.Base)
            .padding(horizontal = FlopSpacing.sm, vertical = FlopSpacing.sm),
        horizontalArrangement = Arrangement.spacedBy(FlopSpacing.xs),
    ) {
        Tab.entries.forEach { tab ->
            val active = tab == selected
            val shape = FlopShapes.button
            Box(Modifier.weight(1f).padding(bottom = 2.dp)) {
                if (active) Box(Modifier.matchParentSize().offset(y = 2.dp).background(FlopColors.SecondaryPlinth, shape))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .then(
                            if (active) {
                                Modifier.background(Brush.verticalGradient(listOf(Color(0xFF243052), FlopColors.SurfaceLight)), shape)
                            } else {
                                Modifier
                            },
                        )
                        .clickable { onSelect(tab) }
                        .defaultMinSize(minHeight = 54.dp)
                        .padding(vertical = 6.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TabIcon(tab, if (active) FlopColors.Cyan else FlopColors.Grey)
                    Spacer(Modifier.height(3.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            t(tab.label),
                            style = FlopType.label.copy(fontSize = navLabelSize(), letterSpacing = 0.sp),
                            color = if (active) FlopColors.IceWhite else FlopColors.TextMuted,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Visible,
                        )
                        badge[tab]?.let {
                            Spacer(Modifier.width(FlopSpacing.xs))
                            Text(
                                it,
                                style = FlopType.label.copy(fontSize = navLabelSize()),
                                color = FlopColors.Green,
                                maxLines = 1,
                            )
                        }
                    }
                }
            }
        }
    }
}

/** Line icons drawn here: four small shapes are not worth a library. */
@Composable
private fun TabIcon(tab: Tab, color: Color) {
    Canvas(Modifier.size(22.dp)) {
        val w = size.width
        val stroke = Stroke(width = 1.8.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
        when (tab) {
            Tab.Today -> {
                drawCircle(color, radius = w * 0.2f, style = stroke)
                repeat(8) { i ->
                    val angle = i * Math.PI / 4
                    val c = kotlin.math.cos(angle).toFloat()
                    val s = kotlin.math.sin(angle).toFloat()
                    drawLine(
                        color,
                        Offset(w / 2 + c * w * 0.33f, w / 2 + s * w * 0.33f),
                        Offset(w / 2 + c * w * 0.44f, w / 2 + s * w * 0.44f),
                        strokeWidth = stroke.width,
                        cap = StrokeCap.Round,
                    )
                }
            }
            Tab.Ask -> {
                val p = Path().apply {
                    addRoundRect(RoundRect(w * 0.1f, w * 0.14f, w * 0.9f, w * 0.72f, CornerRadius(w * 0.16f)))
                    moveTo(w * 0.34f, w * 0.72f)
                    lineTo(w * 0.28f, w * 0.92f)
                    lineTo(w * 0.52f, w * 0.72f)
                }
                drawPath(p, color, style = stroke)
            }
            Tab.Network -> {
                val p = Path().apply {
                    moveTo(w * 0.04f, w * 0.52f)
                    lineTo(w * 0.28f, w * 0.52f)
                    lineTo(w * 0.40f, w * 0.14f)
                    lineTo(w * 0.58f, w * 0.88f)
                    lineTo(w * 0.70f, w * 0.52f)
                    lineTo(w * 0.96f, w * 0.52f)
                }
                drawPath(p, color, style = stroke)
            }
            Tab.Passport -> {
                drawRoundRect(color, Offset(w * 0.16f, w * 0.08f), Size(w * 0.68f, w * 0.84f), CornerRadius(w * 0.1f), style = stroke)
                drawCircle(color, radius = w * 0.12f, center = Offset(w * 0.5f, w * 0.38f), style = stroke)
                drawLine(color, Offset(w * 0.32f, w * 0.7f), Offset(w * 0.68f, w * 0.7f), stroke.width, StrokeCap.Round)
            }
        }
    }
}

/**
 * A tab label that stops growing before it breaks.
 *
 * Four tabs share one row, so past a certain size a word simply cannot fit the column and
 * Compose falls back to breaking it mid-word - "НАСТРОЙ / КИ" on a phone with large type. Android's
 * own bottom bar caps label scaling for exactly this reason. Body text still follows the
 * system size in full; this cap applies to navigation labels alone, where a broken word
 * costs more legibility than the extra millimetre buys.
 */
@Composable
private fun navLabelSize(): TextUnit {
    val scale = LocalConfiguration.current.fontScale
    val capped = scale.coerceAtMost(1.15f)
    return FlopType.label.fontSize * (capped / scale)
}
