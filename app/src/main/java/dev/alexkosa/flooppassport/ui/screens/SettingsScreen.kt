package dev.alexkosa.flooppassport.ui.screens

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.alexkosa.flooppassport.notify.ReminderPrefs
import dev.alexkosa.flooppassport.notify.DailyReminder
import dev.alexkosa.flooppassport.i18n.t
import dev.alexkosa.flooppassport.i18n.Lang
import dev.alexkosa.flooppassport.ui.PassportViewModel
import dev.alexkosa.flooppassport.ui.designsystem.FlopLanguageDialog
import dev.alexkosa.flooppassport.ui.designsystem.FlopLanguageRow
import dev.alexkosa.flooppassport.ui.designsystem.FlopBadge
import dev.alexkosa.flooppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.flooppassport.ui.designsystem.FlopCard
import dev.alexkosa.flooppassport.ui.designsystem.FlopColors
import dev.alexkosa.flooppassport.ui.designsystem.FlopLabel
import dev.alexkosa.flooppassport.ui.designsystem.FlopMonoData
import dev.alexkosa.flooppassport.ui.designsystem.FlopShapes
import dev.alexkosa.flooppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.flooppassport.ui.designsystem.FlopState
import dev.alexkosa.flooppassport.ui.designsystem.FlopSupportCard
import dev.alexkosa.flooppassport.ui.designsystem.FlopType
import dev.alexkosa.flooppassport.BuildConfig

/**
 * Settings, and the place the app explains itself.
 *
 * The order is what a person actually goes looking for: their language first, then what
 * this thing is and what it does with their data, then the tip jar, then the destructive
 * button last and on its own.
 */
@Composable
fun SettingsScreen(
    vm: PassportViewModel,
    chosenLang: Lang?,
    effectiveLang: Lang,
    onLanguage: (Lang?) -> Unit,
    supportName: String,
    supportWallet: String,
    splToken: String,
    tokenName: String,
) {
    var confirmingDelete by remember { mutableStateOf(false) }
    var pickingLanguage by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val prefs = remember { ReminderPrefs(context) }
    var reminderOn by remember { mutableStateOf(prefs.enabled) }

    Column(
        Modifier
            .fillMaxSize()
            .background(FlopColors.Base)
            .verticalScroll(rememberScrollState())
            .padding(FlopSpacing.md),
    ) {
        FlopLabel("settings")
        Spacer(Modifier.height(FlopSpacing.lg))

        // --- language ---------------------------------------------------------------
        // One row, not eleven. The list lives behind it, so the rest of this screen is
        // still on screen when somebody opens Settings for a different reason.
        FlopLanguageRow(
            chosen = chosenLang,
            effective = effectiveLang,
            onOpen = { pickingLanguage = true },
        )
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(
            t(
                "Only languages with a real translation are listed. A picker offering " +
                    "languages that all render English would say your language is supported " +
                    "and then prove otherwise on the next screen.",
            ),
            style = FlopType.bodySm,
            color = FlopColors.TextMuted,
        )

        // --- daily reminder ----------------------------------------------------------
        Spacer(Modifier.height(FlopSpacing.xl))
        FlopLabel("Daily reminder")
        Spacer(Modifier.height(FlopSpacing.sm))
        Row(
            Modifier
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.md)
                .border(1.dp, FlopColors.Border, FlopShapes.md)
                .clickable {
                    val next = !reminderOn
                    // The switch actually cancels the alarm rather than only hiding a row:
                    // a setting that leaves the thing running is how an app earns a
                    // uninstall instead of a shrug.
                    reminderOn = next
                    prefs.enabled = next
                    if (next) DailyReminder.schedule(context) else DailyReminder.cancel(context)
                }
                .padding(FlopSpacing.md),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    t("Remind me once a day"),
                    style = FlopType.bodyMd,
                    color = FlopColors.IceWhite,
                )
                Spacer(Modifier.height(FlopSpacing.xs))
                Text(
                    t("A signed record has to be left by hand, and a missed day cannot be filled in later."),
                    style = FlopType.bodySm,
                    color = FlopColors.TextMuted,
                )
            }
            Spacer(Modifier.width(FlopSpacing.md))
            FlopBadge(
                if (reminderOn) "on" else "off",
                if (reminderOn) FlopState.Verified else FlopState.Neutral,
            )
        }
        if (reminderOn && !DailyReminder.canPost(context)) {
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                t("Android is blocking notifications for this app. Turn them on in the system settings."),
                style = FlopType.bodySm,
                color = FlopColors.TextSecondary,
            )
        }

        // --- about ------------------------------------------------------------------
        Spacer(Modifier.height(FlopSpacing.xl))
        FlopLabel("About")
        Spacer(Modifier.height(FlopSpacing.sm))
        FlopCard {
            Text(t(
                "FLOP Passport creates a Technocore identity from your Solana wallet and " +
                    "keeps the receipts."),
                style = FlopType.bodyMd,
                color = FlopColors.IceWhite,
            )
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(
                "Your Passport is born inside Seed Vault, the Seeker's hardware key store, " +
                    "from which a key cannot be extracted. On this phone it is then sealed " +
                    "by Android's secure storage. Signing itself happens in the app, not in " +
                    "hardware, because Android Keystore cannot hold this kind of key - so " +
                    "we say sealed, not signed, in hardware."),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
        }

        Spacer(Modifier.height(FlopSpacing.sm))
        FlopCard {
            FlopLabel("what this app never does")
            Spacer(Modifier.height(FlopSpacing.sm))
            listOf(
                "No account, no server of ours, no analytics.",
                "Your key never leaves this phone.",
                "It never asks for your wallet recovery phrase.",
                "It promises nothing about any airdrop, and never will.",
            ).forEach {
                // The bullet is punctuation, the sentence is the copy: translate the sentence.
                Text("- " + t(it), style = FlopType.bodySm, color = FlopColors.TextMuted)
                Spacer(Modifier.height(FlopSpacing.xs))
            }
        }

        vm.did?.let { identity ->
            Spacer(Modifier.height(FlopSpacing.sm))
            FlopCard {
                FlopLabel("your identity")
                Spacer(Modifier.height(FlopSpacing.xs))
                FlopMonoData(identity)
                Spacer(Modifier.height(FlopSpacing.sm))
                Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                    FlopBadge("vault ${vm.securityLevel}", FlopState.Active)
                    FlopBadge("language ${effectiveLang.code}", FlopState.Neutral)
                }
            }
        }

        Spacer(Modifier.height(FlopSpacing.sm))
        FlopCard {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                FlopLabel("version")
                FlopMonoData(BuildConfig.VERSION_NAME, FlopColors.TextMuted)
            }
        }

        // --- support ----------------------------------------------------------------
        Spacer(Modifier.height(FlopSpacing.xl))
        FlopSupportCard(
            recipient = supportWallet,
            displayName = supportName,
            splToken = splToken,
            tokenName = tokenName,
        )

        // --- danger -----------------------------------------------------------------
        if (vm.did != null) {
            Spacer(Modifier.height(FlopSpacing.xl))
            FlopLabel("danger zone", FlopColors.ErrorRed)
            Spacer(Modifier.height(FlopSpacing.sm))
            FlopCard {
                Text(t(
                    "Deleting removes the Passport from this phone only. Anything already " +
                        "published stays public, and the same wallet rebuilds the same " +
                        "identity - so this is not a way to undo anything."),
                    style = FlopType.bodySm,
                    color = FlopColors.TextMuted,
                )
                Spacer(Modifier.height(FlopSpacing.md))
                if (!confirmingDelete) {
                    FlopButtonSecondary(
                        "delete passport from this phone",
                        { confirmingDelete = true },
                    )
                } else {
                    Text(t(
                        "Delete it?"),
                        style = FlopType.h3,
                        color = FlopColors.ErrorRed,
                    )
                    Spacer(Modifier.height(FlopSpacing.sm))
                    Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                        Box(Modifier.weight(1f)) {
                            FlopButtonSecondary("cancel", { confirmingDelete = false })
                        }
                        Box(Modifier.weight(1f)) {
                            FlopButtonSecondary("yes, delete", {
                                vm.deletePassport()
                                confirmingDelete = false
                            })
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(FlopSpacing.xl))
    }

    if (pickingLanguage) {
        FlopLanguageDialog(
            chosen = chosenLang,
            effective = effectiveLang,
            onApply = {
                onLanguage(it)
                pickingLanguage = false
            },
            onDismiss = { pickingLanguage = false },
        )
    }
}

