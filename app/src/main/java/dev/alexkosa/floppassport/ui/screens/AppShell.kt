package dev.alexkosa.floppassport.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alexkosa.floppassport.i18n.Lang
import dev.alexkosa.floppassport.i18n.LanguageStore
import dev.alexkosa.floppassport.i18n.LocalTranslator
import dev.alexkosa.floppassport.i18n.Translator
import androidx.compose.runtime.CompositionLocalProvider
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopBottomNav
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopSupportInvite
import dev.alexkosa.floppassport.ui.designsystem.Tab

/**
 * Where a tip goes.
 *
 * The name is what the button shows, because `kosa.skr` reads as a person and a base58
 * address reads as noise. The address is baked rather than resolved at runtime: `.skr`
 * names live in AllDomains, resolving one costs a public RPC round trip, and a donation
 * button that can fail to load its own recipient is worse than one that cannot follow a
 * moved name. Verified 2026-08-24 and again 2026-08-31.
 */
const val SUPPORT_NAME = "kosa.skr"
const val SUPPORT_WALLET = "BmJaEmaEURBDpj91GUTvJcpKy2MAu8ZtRFRPaMpEuuax"

/**
 * SKR, preselected in the wallet's send screen. Verified on mainnet as an SPL mint owned
 * by the token program with six decimals, rather than copied out of a chat: a wrong mint
 * here would point somebody's money at nothing.
 */
const val SKR_MINT = "SKRbvo6Gf7GondiT3BbTfuRDPqLWei4j2Qy2NPGZhW3"
const val SKR_NAME = "SKR"

/**
 * The app around the screens: three tabs, one shared ViewModel, one language.
 *
 * The ViewModel is created here and handed down rather than fetched per screen, so all
 * three tabs see the same Passport and the same activity without re-reading the server
 * each time somebody switches tab.
 */
@Composable
fun AppShell(vm: PassportViewModel = viewModel()) {
    val context = LocalContext.current
    val store = remember { LanguageStore(context) }
    var chosen by remember { mutableStateOf(store.chosen) }
    val effective = chosen ?: Lang.fromSystem()

    var tab by remember { mutableStateOf(Tab.Passport) }

    CompositionLocalProvider(LocalTranslator provides Translator(effective)) {
        Box(Modifier.fillMaxSize().background(FlopColors.Base)) {
            Column(Modifier.fillMaxSize().safeDrawingPadding()) {
                Box(Modifier.weight(1f)) {
                    when (tab) {
                        Tab.Passport -> PassportScreen(vm)
                        Tab.Activity -> ActivityScreen(vm)
                        Tab.Settings -> SettingsScreen(
                            vm = vm,
                            chosenLang = chosen,
                            effectiveLang = effective,
                            onLanguage = {
                                store.chosen = it
                                chosen = it
                            },
                            supportName = SUPPORT_NAME,
                            supportWallet = SUPPORT_WALLET,
                            splToken = SKR_MINT,
                            tokenName = SKR_NAME,
                        )
                    }
                }
                FlopBottomNav(
                    selected = tab,
                    onSelect = { tab = it },
                    badge = if (vm.activity.liveRecords > 0) {
                        mapOf(Tab.Activity to vm.activity.liveRecords.toString())
                    } else {
                        emptyMap()
                    },
                )
            }

            // The finish line. Shown after the user has been told they are done, never
            // before, and never gating anything.
            if (vm.showSupportInvite) {
                FlopSupportInvite(
                    recipient = SUPPORT_WALLET,
                    displayName = SUPPORT_NAME,
                    splToken = SKR_MINT,
                    tokenName = SKR_NAME,
                    onDismiss = { vm.dismissSupportInvite() },
                )
            }
        }
    }
}
