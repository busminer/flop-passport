package dev.alexkosa.floppassport.ui.designsystem

import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.net.toUri
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.util.Qr

/**
 * The one time the app asks for anything, shown after the setup is finished.
 *
 * Order matters and is deliberate: the user is told they are done, then asked. Nothing is
 * gated behind it, "no thanks" is a real button of equal weight, and it appears once per
 * completion rather than following the user around.
 *
 * It also states, in the dialog itself, that a tip changes nothing about the Passport or
 * any airdrop. An app whose whole credibility rests on promising nothing cannot afford a
 * money prompt that even looks like a toll gate.
 */
@Composable
fun FlopSupportInvite(
    recipient: String,
    displayName: String,
    splToken: String?,
    tokenName: String?,
    onDismiss: () -> Unit,
) {
    val context = LocalContext.current
    var shown by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { shown = true }
    val mark by animateFloatAsState(if (shown) 1f else 0.75f, tween(420), label = "mark")
    val uri = remember(recipient, splToken) {
        Qr.solanaPay(recipient, "FLOP Passport for Seeker", "Thanks for building this", splToken)
    }

    Dialog(onDismissRequest = onDismiss, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        Column(
            Modifier
                .padding(FlopSpacing.lg)
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, FlopColors.Cyan.copy(alpha = 0.45f), FlopShapes.lg)
                .padding(FlopSpacing.lg),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                Modifier.size(26.dp).scale(mark).background(FlopColors.Green, FlopShapes.sm),
                contentAlignment = Alignment.Center,
            ) {
                Text(t("✓"), style = FlopType.h3, color = FlopColors.Base)
            }

            Spacer(Modifier.height(FlopSpacing.md))
            Text(t(
                "You're all set"),
                style = FlopType.h2,
                color = FlopColors.IceWhite,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(
                "Your Passport is live and your first signed record is on Technocore. " +
                    "Anyone can verify it, and it stays yours."),
                style = FlopType.bodyMd,
                color = FlopColors.TextMuted,
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.height(FlopSpacing.lg))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Base, FlopShapes.md)
                    .padding(FlopSpacing.md),
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    FlopLabel("built by a community builder")
                    Spacer(Modifier.height(FlopSpacing.sm))
                    Text(t("Alex Kosa"), style = FlopType.h3, color = FlopColors.IceWhite)
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(t(displayName), style = FlopType.code, color = FlopColors.Cyan)
                    Spacer(Modifier.height(FlopSpacing.sm))
                    Text(t(
                        "This app is free and open source, and nobody paid for it. " +
                            "If it saved you an afternoon, a tip is welcome."),
                        style = FlopType.bodySm,
                        color = FlopColors.TextMuted,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            Spacer(Modifier.height(FlopSpacing.md))
            FlopButton(
                if (tokenName != null) "send a tip in $tokenName" else "send a tip",
                {
                    runCatching { context.startActivity(Intent(Intent.ACTION_VIEW, uri.toUri())) }
                    onDismiss()
                },
            )
            Spacer(Modifier.height(FlopSpacing.sm))
            // Equal weight on purpose. A greyed-out or tiny decline turns a request into
            // pressure, and this app does not get to pressure anybody.
            FlopButtonSecondary("no thanks, continue", onDismiss)

            Spacer(Modifier.height(FlopSpacing.md))
            Text(t(
                "A tip changes nothing about your Passport and nothing about any airdrop."),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
                textAlign = TextAlign.Center,
            )
        }
    }
}
