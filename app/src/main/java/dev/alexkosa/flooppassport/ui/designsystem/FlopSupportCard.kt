package dev.alexkosa.flooppassport.ui.designsystem

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import dev.alexkosa.flooppassport.i18n.t
import dev.alexkosa.flooppassport.util.Qr

/**
 * Support the builder: one button, straight into the wallet.
 *
 * No QR. The person holding this phone already has the wallet on it, so a code to scan
 * would mean pointing the phone at itself - the gesture only makes sense between two
 * devices. Tapping hands a Solana Pay URI to whichever wallet the user has registered, it
 * opens on its own send screen with the recipient filled in and SKR preselected, and they
 * choose the amount and confirm there.
 *
 * This app builds no transaction, asks for no signature, and sets no amount.
 *
 * Placed as a permanent row rather than a banner at the success moment: the app's
 * credibility rests on promising nothing, and asking for money a second after telling
 * someone they are set up reads as selling hope no matter how it is worded.
 */
@Composable
fun FlopSupportCard(
    recipient: String,
    modifier: Modifier = Modifier,
    /** The human name shown on the button. A Seeker ID reads as a person. */
    displayName: String = recipient,
    /** Preselected token. The wallet still lets the sender pick another one. */
    splToken: String? = null,
    tokenName: String? = null,
    label: String = "FLOP Passport for Seeker",
    note: String = "Thanks for building this",
) {
    val context = LocalContext.current
    var problem by remember { mutableStateOf<String?>(null) }
    val uri = remember(recipient, splToken) { Qr.solanaPay(recipient, label, note, splToken) }

    Column(
        modifier
            .fillMaxWidth()
            .background(FlopColors.Surface, FlopShapes.md)
            .border(1.dp, FlopColors.Border, FlopShapes.md)
            .padding(FlopSpacing.md),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            FlopLabel("support the builder")
            Spacer(Modifier.width(FlopSpacing.sm))
            if (tokenName != null) FlopBadge(tokenName, FlopState.Active)
        }
        Spacer(Modifier.height(FlopSpacing.xs))
        Text(t(
            "This app is free and open source. If it was useful, you can send a tip to " +
                "$displayName. Your wallet opens and you choose the amount there."),
            style = FlopType.bodySm,
            color = FlopColors.TextMuted,
        )

        Spacer(Modifier.height(FlopSpacing.md))
        FlopButton("send a tip to $displayName", {
            problem = null
            // A plain view intent, so whichever app registered the solana: scheme takes it.
            // Nothing here assumes a particular wallet.
            runCatching {
                context.startActivity(Intent(Intent.ACTION_VIEW, uri.toUri()))
            }.onFailure {
                problem = "No wallet on this phone opened the payment link."
            }
        })

        problem?.let {
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(it), style = FlopType.bodySm, color = FlopColors.ErrorRed)
        }

        Spacer(Modifier.height(FlopSpacing.sm))
        Text(t(
            (if (tokenName != null) "$tokenName is preselected and you can switch it. " else "") +
                "A tip changes nothing about your Passport, and nothing about any airdrop. " +
                "It is a thank you, not a fee."),
            style = FlopType.bodySm,
            color = FlopColors.TextMuted,
        )
    }
}
