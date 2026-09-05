package dev.alexkosa.floppassport.ui.screens

import android.content.Intent
import androidx.core.net.toUri
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
import dev.alexkosa.floppassport.notify.ReminderPrefs
import dev.alexkosa.floppassport.notify.DailyReminder
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.i18n.Lang
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopLanguageDialog
import dev.alexkosa.floppassport.ui.designsystem.FlopLanguageRow
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopCard
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopMonoData
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopSupportCard
import dev.alexkosa.floppassport.ui.designsystem.FlopType
import dev.alexkosa.floppassport.BuildConfig

/**
 * Settings, and the place the app explains itself.
 *
 * The order is what a person actually goes looking for: their language first, then what
 * this thing is and what it does with their data, then the tip jar, then the destructive
 * button last and on its own.
 */
/**
 * The long-form answers live on the site, so they can be fixed the afternoon somebody
 * asks something new instead of waiting for a release and a store review.
 */
const val MANUAL_URL = "https://flop.alexkosa.dev/#faq"

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
                    t(
                        "A signed record has to be left by hand, and a missed day cannot " +
                            "be filled in later. This is also the switch that warns you " +
                            "before your identity note is deleted.",
                    ),
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

        // --- the manual ---------------------------------------------------------------
        //
        // A link out rather than another screen in here. The questions people actually ask
        // are long-form and they change as the project does; a page can be corrected the
        // afternoon somebody asks something new, while a screen has to wait for a release
        // and a store review. What stays in the app is the short version, on the screens
        // where each thing happens.
        Spacer(Modifier.height(FlopSpacing.xl))
        FlopLabel("The manual")
        Spacer(Modifier.height(FlopSpacing.sm))
        Row(
            Modifier
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.md)
                .border(1.dp, FlopColors.Border, FlopShapes.md)
                .clickable {
                    runCatching {
                        context.startActivity(
                            Intent(Intent.ACTION_VIEW, MANUAL_URL.toUri()),
                        )
                    }
                }
                .padding(FlopSpacing.md),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    t("Questions, answered in full"),
                    style = FlopType.bodyMd,
                    color = FlopColors.IceWhite,
                )
                Spacer(Modifier.height(FlopSpacing.xs))
                Text(
                    t(
                        "What to do and how often, why the identity expires, why this " +
                            "works on a Seeker, and what the catch is. Opens in your " +
                            "browser.",
                    ),
                    style = FlopType.bodySm,
                    color = FlopColors.TextMuted,
                )
            }
            Spacer(Modifier.width(FlopSpacing.md))
            FlopBadge("open", FlopState.Active)
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
                // The precise chain, because the shorter version - "born inside Seed
                // Vault" - claims more than is true. What lives in Seed Vault is the
                // WALLET key. It signs one statement there, and this Passport is derived
                // from that signature inside the app. Seed Vault is where the entropy
                // comes from; it is not where this key lives.
                "Your Passport is derived from one signature your wallet makes inside " +
                    "Seed Vault, the Seeker's hardware key store. The wallet key never " +
                    "leaves that hardware. The Passport key is computed from its " +
                    "signature in this app and then sealed by Android's secure storage - " +
                    "sealed, not signed, in hardware, because Android Keystore cannot " +
                    "hold this kind of key."),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
        }

        // The seven-day rule, spelled out where somebody reading about the app will meet
        // it - not buried in a FAQ nobody opens.
        //
        // It is the single fact most likely to quietly ruin a Passport, and it is not
        // ours: technocore.chat states it in its own manual, "Rooms and notes with no
        // write for 7 days are deleted". An app that asks a person to save an address and
        // does not tell them the address empties itself is setting them up.
        //
        // The card says the rule, then says what the app already does about it, then says
        // the one thing left for the person to do. In that order, because a warning with
        // no action attached only produces anxiety.
        Spacer(Modifier.height(FlopSpacing.sm))
        FlopCard {
            Text(
                t("Your note has to be kept alive").uppercase(),
                style = FlopType.label,
                color = FlopColors.TextMuted,
            )
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                t(
                    "technocore.chat deletes anything nobody has written to for seven " +
                        "days. That includes the identity note at the address you save " +
                        "and share.",
                ),
                style = FlopType.bodySm,
                color = FlopColors.TextSecondary,
            )
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                t(
                    "This app rewrites your note every time you open it and every time " +
                        "you sign a record, so the seven days start again. Open it at " +
                        "least once a week and nothing is ever lost.",
                ),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                t(
                    "If it does get deleted, your Passport is not gone: the same wallet " +
                        "still gives the same identity, and signing a record publishes " +
                        "the note back to the same address.",
                ),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
        }

        // The one thing about this design that a careful person deserves to be told, and
        // that no marketing page would volunteer: recovery without a seed phrase and
        // "anything that can get this signature owns the Passport" are the same property
        // seen from two sides. An outside review raised it, and the honest response is to
        // say it here rather than to hope nobody notices.
        Spacer(Modifier.height(FlopSpacing.sm))
        FlopCard {
            Text(
                t("What recovery without a seed phrase costs").uppercase(),
                style = FlopType.label,
                color = FlopColors.TextMuted,
            )
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                t(
                    "Your Passport is rebuilt from one wallet signature, which is why no " +
                        "seed phrase exists to lose. The same fact cuts the other way: any " +
                        "app that persuades your wallet to sign that exact sentence can " +
                        "rebuild this Passport. Read what a wallet asks you to sign, here " +
                        "and everywhere else.",
                ),
                style = FlopType.bodySm,
                color = FlopColors.TextSecondary,
            )
        }

        Spacer(Modifier.height(FlopSpacing.sm))
        FlopCard {
            FlopLabel("what this app never does")
            Spacer(Modifier.height(FlopSpacing.sm))
            listOf(
                "No account, no server of ours, no analytics.",
                // It leaves the moment somebody uses Save my key, which is a
                // feature of this app. "Never leaves" was a promise the app itself
                // breaks on request.
                "Your key is never sent anywhere. Only you can export it.",
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
                    FlopBadge(t("vault {level}", "level" to vm.securityLevel.toString()), FlopState.Active)
                    FlopBadge(t("language {code}", "code" to effectiveLang.code), FlopState.Neutral)
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
                        "published may stay public, and the same wallet rebuilds the same " +
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

