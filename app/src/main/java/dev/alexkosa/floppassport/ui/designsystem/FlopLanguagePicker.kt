package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import dev.alexkosa.floppassport.i18n.Lang
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.i18n.tu

/**
 * The language setting: one row that opens a list, rather than the list itself.
 *
 * Eleven languages laid out as cards pushed everything else on the settings screen below
 * the fold, and the one thing a person came here to change was buried in the thing they
 * were scrolling past. A row that names the current language, and a sheet that appears when
 * they ask for it, costs one tap and gives the screen back.
 *
 * The choice is not applied until Apply is pressed. Switching the whole interface under
 * somebody's finger while they are still reading the options is disorienting, and it makes
 * "what was it before?" unanswerable in a language they may not read.
 */
@Composable
fun FlopLanguageRow(
    chosen: Lang?,
    effective: Lang,
    onOpen: () -> Unit,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(FlopColors.Surface, FlopShapes.md)
            .border(1.dp, FlopColors.Border, FlopShapes.md)
            .clickable { onOpen() }
            .padding(FlopSpacing.md),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text(t("Language"), style = FlopType.bodyMd, color = FlopColors.IceWhite)
            Spacer(Modifier.height(FlopSpacing.xs))
            Text(
                if (chosen == null) {
                    t("Use the phone's language") + "  ·  " + effective.label
                } else {
                    chosen.label
                },
                style = FlopType.code,
                color = FlopColors.TextMuted,
            )
        }
        Text(tu("change"), style = FlopType.label, color = FlopColors.Cyan)
    }
}

@Composable
fun FlopLanguageDialog(
    chosen: Lang?,
    effective: Lang,
    onApply: (Lang?) -> Unit,
    onDismiss: () -> Unit,
) {
    // Local until Apply: the screen behind stays in the language it was in.
    var picked by remember { mutableStateOf(chosen) }

    Dialog(onDismissRequest = onDismiss, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        Column(
            Modifier
                .padding(FlopSpacing.md)
                .fillMaxWidth()
                .background(FlopColors.Base, FlopShapes.lg)
                .border(1.dp, FlopColors.Border, FlopShapes.lg)
                .padding(FlopSpacing.md),
        ) {
            FlopLabel("Language")
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                t("Every language listed here has a full translation."),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
            Spacer(Modifier.height(FlopSpacing.md))

            Column(
                Modifier
                    .heightIn(max = 380.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                Option(
                    title = t("Use the phone's language"),
                    note = effective.label,
                    selected = picked == null,
                    onClick = { picked = null },
                )
                Lang.entries.forEach { lang ->
                    Option(
                        title = lang.label,
                        note = lang.code,
                        selected = picked == lang,
                        onClick = { picked = lang },
                    )
                }
            }

            Spacer(Modifier.height(FlopSpacing.md))
            Row(Modifier.fillMaxWidth()) {
                FlopButtonSecondary(
                    text = t("Cancel"),
                    onClick = onDismiss,
                    modifier = Modifier.weight(1f),
                )
                Spacer(Modifier.width(FlopSpacing.sm))
                FlopButton(
                    text = t("Apply"),
                    onClick = { onApply(picked) },
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun Option(title: String, note: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = FlopSpacing.xs)
            .background(
                if (selected) FlopColors.Surface else FlopColors.Base,
                FlopShapes.md,
            )
            .border(1.dp, if (selected) FlopColors.Cyan else FlopColors.Border, FlopShapes.md)
            .clickable { onClick() }
            .padding(FlopSpacing.md),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
            // A square, not a tick: the selected state has to survive a greyscale screenshot
            // and colour blindness, so it is a shape that is either filled or not.
            Box(
                Modifier
                    .size(10.dp)
                    .background(
                        if (selected) FlopColors.Cyan else FlopColors.Border,
                        FlopShapes.sm,
                    ),
            )
            Spacer(Modifier.width(FlopSpacing.sm))
            Text(
                title,
                style = FlopType.bodyMd,
                color = if (selected) FlopColors.IceWhite else FlopColors.TextSecondary,
            )
        }
        Text(note, style = FlopType.label, color = FlopColors.TextMuted)
    }
}
