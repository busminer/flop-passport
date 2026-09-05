package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.platform.LocalConfiguration
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.alexkosa.floppassport.i18n.t
import androidx.compose.ui.unit.dp

/** The three places this app has. Named as nouns, because a tab is a place, not an action. */
enum class Tab(val label: String) {
    Passport("Passport"),
    Activity("Activity"),
    Settings("Settings"),
}

/**
 * Bottom navigation in the brand's own shape.
 *
 * A 2dp Cyan bar above the selected tab rather than a filled pill: the design system's
 * depth comes from tonal layers and precise marks, not from soft containers, and a filled
 * selector at the bottom of a dark screen is the loudest thing on it for no reason.
 *
 * The selected tab is Ice White with a mark; the others are Grey. Never colour alone.
 */
@Composable
fun FlopBottomNav(
    selected: Tab,
    onSelect: (Tab) -> Unit,
    modifier: Modifier = Modifier,
    badge: Map<Tab, String> = emptyMap(),
) {
    Column(
        modifier
            .fillMaxWidth()
            .background(FlopColors.Base),
    ) {
        Box(Modifier.fillMaxWidth().height(1.dp).background(FlopColors.Border))
        Row(
            Modifier.fillMaxWidth().padding(vertical = FlopSpacing.sm),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Tab.entries.forEach { tab ->
                val active = tab == selected
                Column(
                    Modifier
                        .clickable { onSelect(tab) }
                        .padding(horizontal = FlopSpacing.md, vertical = FlopSpacing.xs),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        Modifier
                            .width(22.dp)
                            .height(2.dp)
                            .background(if (active) FlopColors.Cyan else FlopColors.Base),
                    )
                    Spacer(Modifier.height(FlopSpacing.sm))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            t(tab.label).uppercase(),
                            style = FlopType.label.copy(fontSize = navLabelSize()),
                            color = if (active) FlopColors.IceWhite else FlopColors.Grey,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Visible,
                        )
                        badge[tab]?.let {
                            Spacer(Modifier.width(FlopSpacing.xs))
                            Text(
                                t(it),
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

/**
 * A tab label that stops growing before it breaks.
 *
 * Three tabs share one row, so past a certain size a word simply cannot fit the column and
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
