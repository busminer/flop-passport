package dev.alexkosa.floppassport.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import dev.alexkosa.floppassport.R
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.i18n.tu
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopType
import dev.alexkosa.floppassport.ui.designsystem.raisedCard
import dev.alexkosa.floppassport.ui.designsystem.well
import kotlinx.coroutines.delay

/**
 * The pieces every tab of 2.0 is built from, so the four read as one app.
 *
 * Same tokens as 1.0 - Base, Surface, Cyan, Green, Space Mono for anything a machine said,
 * Inter for anything a person reads. Nothing new in the palette: the redesign is in what
 * the screens say and in what order, not in how they are coloured.
 */
@Composable
fun FlopScreen(content: @Composable ColumnScope.() -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(FlopColors.Base)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp, vertical = FlopSpacing.md),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        content = content,
    )
}

/** A row that opens in place, for what is here for those who want it. */
@Composable
fun Fold(title: String, content: @Composable ColumnScope.() -> Unit) {
    var open by androidx.compose.runtime.saveable.rememberSaveable(title) { mutableStateOf(false) }
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { open = !open }
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(t(title), style = FlopType.bodyMd, color = FlopColors.IceWhite, modifier = Modifier.weight(1f))
        Text(if (open) "⌃" else "⌄", style = FlopType.h3, color = FlopColors.Cyan)
    }
    if (open) {
        Column(verticalArrangement = Arrangement.spacedBy(FlopSpacing.sm), content = content)
    }
}

/** The screen's name, and on the right what it is about. */
@Composable
fun FlopHeader(title: String, network: String? = null, trailing: String? = null) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            t(title).replaceFirstChar { it.uppercase() },
            style = FlopType.title,
            color = FlopColors.IceWhite,
            modifier = Modifier.weight(1f),
        )
        trailing?.let { Text(it, style = FlopType.label, color = FlopColors.TextMuted) }
        network?.let { FlopBadge(it, FlopState.Active) }
    }
}

/** A surface with a heading, for one subject per card. */
@Composable
fun Section(
    title: String,
    modifier: Modifier = Modifier,
    accent: Color = FlopColors.Border,
    trailing: (@Composable () -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier
            .fillMaxWidth()
            .raisedCard(rim = accent.takeIf { it != FlopColors.Border })
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(FlopSpacing.sm),
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            FlopLabel(title, modifier = Modifier.weight(1f))
            trailing?.invoke()
        }
        content()
    }
}

/** A sentence that needs attention, in the colour of how much. */
@Composable
fun Notice(text: String, color: Color = FlopColors.Cyan, action: (@Composable () -> Unit)? = null) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color.copy(alpha = 0.08f), FlopShapes.md)
            .border(1.dp, color.copy(alpha = 0.45f), FlopShapes.md)
            .padding(FlopSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FlopSpacing.sm),
    ) {
        Text(t(text), style = FlopType.bodySm, color = color)
        action?.invoke()
    }
}

@Composable
fun Prose(text: String, color: Color = FlopColors.TextMuted) {
    Text(t(text), style = FlopType.bodySm, color = color)
}

/** A label and a value on one line; the value in mono, because a machine said it. */
@Composable
fun KeyValue(label: String, value: String, valueColor: Color = FlopColors.IceWhite) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(t(label), style = FlopType.bodySm, color = FlopColors.TextMuted, modifier = Modifier.weight(1f))
        Spacer(Modifier.width(FlopSpacing.sm))
        Text(value, style = FlopType.code, color = valueColor)
    }
}

/**
 * Something the person may want to paste elsewhere, with a copy button that says it worked.
 *
 * "Copied" for two seconds rather than a toast: a toast covers the bottom bar on a Seeker
 * and disappears before somebody who looked away can read it.
 */
@Composable
fun CopyLine(value: String, display: String = value) {
    val clipboard = LocalClipboardManager.current
    var copied by remember { mutableStateOf(false) }
    LaunchedEffect(copied) {
        if (copied) {
            delay(2_000)
            copied = false
        }
    }
    Row(
        Modifier
            .fillMaxWidth()
            .background(FlopColors.Base, FlopShapes.md)
            .clickable {
                clipboard.setText(AnnotatedString(value))
                copied = true
            }
            .padding(horizontal = FlopSpacing.md, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(display, style = FlopType.code, color = FlopColors.Cyan, modifier = Modifier.weight(1f))
        Spacer(Modifier.width(FlopSpacing.sm))
        Text(
            tu(if (copied) "copied" else "copy"),
            style = FlopType.label,
            color = if (copied) FlopColors.Green else FlopColors.TextMuted,
        )
    }
}

/** A link out, drawn as a row so it is obviously pressable. */
@Composable
fun LinkRow(label: String, url: String, detail: String? = null) {
    val context = LocalContext.current
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { runCatching { context.startActivity(Intent(Intent.ACTION_VIEW, url.toUri())) } }
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text(t(label), style = FlopType.bodyMd, color = FlopColors.IceWhite)
            detail?.let { Text(it, style = FlopType.bodySm, color = FlopColors.TextMuted) }
        }
        Text("↗", style = FlopType.h3, color = FlopColors.Cyan)
    }
}

/** A number with its name under it, for the tiles on Today and Network. */
@Composable
fun Tile(value: String, label: String, modifier: Modifier = Modifier, color: Color = FlopColors.IceWhite) {
    Column(
        modifier
            .well()
            .padding(horizontal = 12.dp, vertical = 10.dp),
    ) {
        Text(value, style = FlopType.number.copy(fontSize = 17.sp), color = color, maxLines = 1)
        Spacer(Modifier.height(FlopSpacing.xs))
        Text(t(label), style = FlopType.bodySm, color = FlopColors.TextMuted)
    }
}

@Composable
fun TileRow(content: @Composable (Modifier) -> Unit) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
        content(Modifier.weight(1f))
    }
}

/** A back row for the pages under a tab. */
@Composable
fun BackRow(title: String, onBack: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onBack)
            .padding(vertical = FlopSpacing.sm),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("←", style = FlopType.h3, color = FlopColors.Cyan)
        Spacer(Modifier.width(FlopSpacing.sm))
        Text(tu(title), style = FlopType.label, color = FlopColors.IceWhite)
    }
}

/** How long ago, in the largest unit that is not zero, in the reader's language. */
@Composable
fun ago(millis: Long?, now: Long = System.currentTimeMillis()): String? {
    millis ?: return null
    val s = ((now - millis) / 1000).coerceAtLeast(0)
    return when {
        s < 60 -> t("just now")
        s < 3600 -> t("{n} min ago", "n" to (s / 60).toString())
        s < 86_400 -> t("{n} h ago", "n" to (s / 3600).toString())
        else -> t("{n} d ago", "n" to (s / 86_400).toString())
    }
}

/** Hours and minutes until a moment, for "next faucet in". */
@Composable
fun until(millis: Long, now: Long = System.currentTimeMillis()): String {
    val m = ((millis - now) / 60_000).coerceAtLeast(0)
    return if (m >= 60) {
        t("{h} h {m} min", "h" to (m / 60).toString(), "m" to (m % 60).toString())
    } else {
        t("{m} min", "m" to m.toString())
    }
}

@Composable
fun Gap() = Box(Modifier.height(FlopSpacing.xs))
