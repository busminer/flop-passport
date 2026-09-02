package dev.alexkosa.flooppassport.ui.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

/**
 * The one screen that shows the private key.
 *
 * It exists because a key nobody can take out is a key nobody really owns: the user may
 * want to sign from a laptop, move to another tool, or simply keep a copy they control.
 * The wallet can always rebuild this identity, so this is convenience rather than the
 * recovery path - which is exactly why it can be optional and quiet.
 *
 * Everything here is written to be sobering rather than exciting. The key is shown in
 * full, in a plain block, with what it can do stated before the value itself. A screen
 * that treats a secret casually teaches the person holding it to do the same.
 */
@Composable
fun FlopBackupSheet(
    did: String,
    seedHex: String,
    onSaveFile: () -> Unit,
    onDismiss: () -> Unit,
) {
    val clipboard = LocalClipboardManager.current

    Dialog(onDismissRequest = onDismiss, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        Column(
            Modifier
                .padding(FlopSpacing.md)
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, FlopColors.Cyan.copy(alpha = 0.4f), FlopShapes.lg)
                .padding(FlopSpacing.lg)
                .verticalScroll(rememberScrollState()),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(20.dp).background(FlopColors.Cyan, FlopShapes.sm))
                Spacer(Modifier.width(FlopSpacing.sm))
                FlopLabel("your private key", FlopColors.Cyan)
            }

            Spacer(Modifier.height(FlopSpacing.md))
            Text("Anyone with this can be you", style = FlopType.h3, color = FlopColors.IceWhite)
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign " +
                    "as you on Technocore. Keep them offline and never send them to anyone, " +
                    "including us.",
                style = FlopType.bodyMd,
                color = FlopColors.TextMuted,
            )

            Spacer(Modifier.height(FlopSpacing.md))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Base, FlopShapes.md)
                    .padding(FlopSpacing.sm),
            ) {
                Column {
                    FlopLabel("identity")
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(did, style = FlopType.code, color = FlopColors.Cyan)
                    Spacer(Modifier.height(FlopSpacing.sm))
                    FlopLabel("private key, 32 bytes, hex")
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(seedHex, style = FlopType.code, color = FlopColors.IceWhite)
                }
            }

            Spacer(Modifier.height(FlopSpacing.md))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Cyan.copy(alpha = 0.07f), FlopShapes.md)
                    .padding(FlopSpacing.sm),
            ) {
                Text(
                    "This is NOT your Solana wallet key. Your wallet's own key never " +
                        "leaves Seed Vault and this app has never seen it. What you are " +
                        "looking at is a separate key that signs only on Technocore.",
                    style = FlopType.bodySm,
                    color = FlopColors.Cyan,
                )
            }

            Spacer(Modifier.height(FlopSpacing.sm))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Green.copy(alpha = 0.07f), FlopShapes.md)
                    .padding(FlopSpacing.sm),
            ) {
                Text(
                    "You do not need this to recover. The same Solana wallet rebuilds the " +
                        "same Passport on any phone. This copy is for using the key " +
                        "somewhere else, on your own terms.",
                    style = FlopType.bodySm,
                    color = FlopColors.Green,
                )
            }

            Spacer(Modifier.height(FlopSpacing.md))
            Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                Box(Modifier.weight(1f)) {
                    FlopButton("save to a file", onSaveFile)
                }
                Box(Modifier.weight(1f)) {
                    FlopButtonSecondary("copy key", {
                        clipboard.setText(AnnotatedString(seedHex))
                    })
                }
            }
            Spacer(Modifier.height(FlopSpacing.sm))
            FlopButtonSecondary("close", onDismiss)
        }
    }
}
