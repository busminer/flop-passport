package dev.alexkosa.flooppassport.ui.designsystem

import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import dev.alexkosa.flooppassport.util.Qr

/**
 * Support the builder.
 *
 * Placed as a permanent row rather than a banner that ambushes the success moment: the
 * app's whole credibility rests on promising nothing, and asking for money a second after
 * telling someone they are set up reads as selling hope no matter how it is worded.
 * Somewhere the user can find it, never somewhere it finds them.
 *
 * Tapping expands a QR and a button. Both point at a Solana Pay URI, so the user's own
 * wallet opens on its own send screen and they choose the amount there. This app builds no
 * transaction and asks for no signature.
 */
@Composable
fun FlopSupportCard(
    recipient: String,
    modifier: Modifier = Modifier,
    label: String = "FLOOP Passport for Seeker",
    note: String = "Thanks for building this",
) {
    var open by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val clipboard = LocalClipboardManager.current
    val uri = remember(recipient) { Qr.solanaPay(recipient, label, note) }
    val qr = remember(uri) { runCatching { Qr.encode(uri, sizePx = 420) }.getOrNull() }

    Column(
        modifier
            .fillMaxWidth()
            .background(FlopColors.Surface, FlopShapes.md)
            .border(1.dp, FlopColors.Border, FlopShapes.md)
            .clickable { open = !open }
            .padding(FlopSpacing.md),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                FlopLabel("support the builder")
                Spacer(Modifier.height(FlopSpacing.xs))
                Text(
                    "This app is free and open source. If it was useful, you can send " +
                        "the developer a tip.",
                    style = FlopType.bodySm,
                    color = FlopColors.TextMuted,
                )
            }
            Spacer(Modifier.width(FlopSpacing.sm))
            FlopLabel(if (open) "hide" else "open", FlopColors.Cyan)
        }

        if (open) {
            Spacer(Modifier.height(FlopSpacing.md))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Base, FlopShapes.md)
                    .padding(FlopSpacing.md),
                contentAlignment = Alignment.Center,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (qr != null) {
                        Image(
                            bitmap = qr,
                            contentDescription = "Solana Pay code for the developer's wallet",
                            modifier = Modifier.size(190.dp),
                        )
                        Spacer(Modifier.height(FlopSpacing.sm))
                    }
                    FlopLabel("scan with any solana wallet")
                    Spacer(Modifier.height(FlopSpacing.sm))
                    Text(
                        recipient,
                        style = FlopType.code,
                        color = FlopColors.TextMuted,
                    )
                }
            }

            Spacer(Modifier.height(FlopSpacing.sm))
            Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                Box(Modifier.weight(1f)) {
                    FlopButton("open my wallet", {
                        // A view intent, so whichever wallet the user has registered for
                        // solana: takes it. Nothing here assumes a particular app.
                        runCatching {
                            context.startActivity(Intent(Intent.ACTION_VIEW, uri.toUri()))
                        }
                    })
                }
                Box(Modifier.weight(1f)) {
                    FlopButtonSecondary("copy address", {
                        clipboard.setText(AnnotatedString(recipient))
                    })
                }
            }
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                "A tip changes nothing about your Passport, and nothing about any airdrop. " +
                    "It is a thank you, not a fee.",
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
        }
    }
}
