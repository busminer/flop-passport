package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.foundation.layout.heightIn
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.DisposableEffect
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
import dev.alexkosa.floppassport.i18n.t
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
    // The window is marked secure for exactly as long as this sheet is open.
    //
    // Without it the 32 bytes on this screen land in any screenshot, in the recent-apps
    // thumbnail the system takes when the app goes to the background, and in a screen
    // recording. A biometric gate in front of a screen that Android is quietly
    // photographing is theatre. The flag is cleared on the way out so the rest of the app
    // - and Alex's own store screenshots - still work normally.
    val host = LocalContext.current
    val window = (host as? android.app.Activity)?.window
    DisposableEffect(window) {
        window?.addFlags(android.view.WindowManager.LayoutParams.FLAG_SECURE)
        onDispose { window?.clearFlags(android.view.WindowManager.LayoutParams.FLAG_SECURE) }
    }

    val clipboard = LocalClipboardManager.current

    Dialog(onDismissRequest = onDismiss, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        Column(
            Modifier
                .padding(FlopSpacing.md)
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, FlopColors.Cyan.copy(alpha = 0.4f), FlopShapes.lg)
                .padding(FlopSpacing.lg)
                // A dialog is measured with no maximum height, and a scroll inside
                // infinity is a crash rather than a scroll. Nine tenths of the screen
                // is the ceiling: enough that nothing is cramped, bounded enough that
                // the buttons at the bottom stay reachable at any font size.
                .heightIn(max = (LocalConfiguration.current.screenHeightDp * 0.9f).dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(20.dp).background(FlopColors.Cyan, FlopShapes.sm))
                Spacer(Modifier.width(FlopSpacing.sm))
                FlopLabel("your private key", FlopColors.Cyan)
            }

            Spacer(Modifier.height(FlopSpacing.md))
            Text(t("Anyone with this can be you"), style = FlopType.h3, color = FlopColors.IceWhite)
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(
                "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign " +
                    "as you on Technocore. Keep them offline and never send them to anyone, " +
                    "including us."),
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
                    Text(t(did), style = FlopType.code, color = FlopColors.Cyan)
                    Spacer(Modifier.height(FlopSpacing.sm))
                    FlopLabel("private key, 32 bytes, hex")
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(t(seedHex), style = FlopType.code, color = FlopColors.IceWhite)
                }
            }

            Spacer(Modifier.height(FlopSpacing.md))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Cyan.copy(alpha = 0.07f), FlopShapes.md)
                    .padding(FlopSpacing.sm),
            ) {
                Text(t(
                    "This is NOT your Solana wallet key. Your wallet's own key never " +
                        "leaves Seed Vault and this app has never seen it. What you are " +
                        "looking at is a separate key that signs only on Technocore."),
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
                Text(t(
                    "You do not need this to recover. The same Solana wallet rebuilds the " +
                        "same Passport on any phone. This copy is for using the key " +
                        "somewhere else, on your own terms."),
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
                        // Marked sensitive so the system does not show the key in its
                        // clipboard preview toast, and cleared after a minute so it does
                        // not sit in the buffer for the rest of the day waiting to be
                        // pasted into the wrong app.
                        copySensitively(host, seedHex)
                    })
                }
            }
            Spacer(Modifier.height(FlopSpacing.sm))
            FlopButtonSecondary("close", onDismiss)
        }
    }
}


/**
 * Put the key on the clipboard as carefully as Android allows.
 *
 * `EXTRA_IS_SENSITIVE` stops the system from rendering the value in the copy confirmation
 * that pops up on Android 13, which would otherwise put the private key on screen in a
 * toast that survives leaving the app. The delayed clear is best effort - the clipboard
 * belongs to the system and another app may take it in the meantime - but a key that
 * disappears after a minute is a smaller target than one that waits until the next copy.
 */
private fun copySensitively(context: android.content.Context, value: String) {
    val manager = context.getSystemService(android.content.ClipboardManager::class.java) ?: return
    val clip = android.content.ClipData.newPlainText("FLOP Passport key", value)
    if (android.os.Build.VERSION.SDK_INT >= 33) {
        clip.description.extras = android.os.PersistableBundle().apply {
            putBoolean(android.content.ClipDescription.EXTRA_IS_SENSITIVE, true)
        }
    }
    manager.setPrimaryClip(clip)

    android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
        val current = manager.primaryClip?.getItemAt(0)?.text?.toString()
        if (current == value) {
            manager.setPrimaryClip(android.content.ClipData.newPlainText("", ""))
        }
    }, 60_000)
}
