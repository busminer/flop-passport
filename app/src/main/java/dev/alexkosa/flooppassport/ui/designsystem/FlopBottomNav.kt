package dev.alexkosa.flooppassport.ui.designsystem

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
                            tab.label.uppercase(),
                            style = FlopType.label,
                            color = if (active) FlopColors.IceWhite else FlopColors.Grey,
                        )
                        badge[tab]?.let {
                            Spacer(Modifier.width(FlopSpacing.xs))
                            Text(it, style = FlopType.label, color = FlopColors.Green)
                        }
                    }
                }
            }
        }
    }
}
