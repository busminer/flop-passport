package dev.alexkosa.floppassport.ui.screens

import androidx.compose.ui.platform.LocalDensity
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.LaunchedEffect
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
import dev.alexkosa.floppassport.ui.FlopViewModel
import dev.alexkosa.floppassport.ui.ActivityState
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
 * The app around the screens.
 *
 * Two shapes. Until a Passport is set up, the five-step setup is the whole app, because
 * nothing else works without it and a tab bar of things that do not work yet is noise.
 * After that, four tabs: Today, Ask, Network, Passport.
 *
 * "Set up" is remembered once it has been seen, so a person who finished in 1.0 is not shown
 * the setup ladder for the second it takes the server to confirm what it already knows.
 * Today still says, in words, when that confirmation fails.
 *
 * Both ViewModels are created here and handed down, so every tab sees the same Passport and
 * the same account without re-reading the network on each switch.
 */
@Composable
fun AppShell(vm: PassportViewModel = viewModel(), flop: FlopViewModel = viewModel()) {
    val context = LocalContext.current
    val store = remember { LanguageStore(context) }
    var chosen by remember { mutableStateOf(store.chosen) }
    val effective = chosen ?: Lang.fromSystem()
    val setup = remember { SetupMemory(context) }
    var setupSeen by remember { mutableStateOf(setup.done) }

    var tab by rememberSaveable { mutableStateOf(Tab.Today) }
    var page by rememberSaveable { mutableStateOf(Page.None) }
    var welcomed by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) { vm.syncFinishNudge(context) }
    LaunchedEffect(vm.did) {
        flop.onIdentity(vm.did)
        if (vm.did == null) {
            setup.done = false
            setupSeen = false
            tab = Tab.Today
            page = Page.None
        }
    }
    LaunchedEffect(vm.flow.complete) {
        if (vm.flow.complete) {
            setup.done = true
            setupSeen = true
        }
    }

    // What the reminder needs to know without asking the network from an alarm.
    val todayStreak = vm.activity.streak(ActivityState.today())
    LaunchedEffect(vm.activity.checkedInToday, todayStreak) {
        val reminder = dev.alexkosa.floppassport.notify.ReminderPrefs(context)
        if (vm.activity.lastChecked != null) {
            val today = ActivityState.today()
            reminder.lastStreak = todayStreak
            // Tomorrow's risk is already decided by today's record, so a person who signs
            // today and then does not open the app tomorrow is still warned tomorrow night.
            val tomorrow = runCatching { java.time.LocalDate.parse(today).plusDays(1).toString() }.getOrNull()
            reminder.atRiskDay = when {
                vm.activity.streakInfo(today).atRisk -> today
                vm.activity.checkedInToday && tomorrow != null && vm.activity.streakInfo(tomorrow).atRisk -> tomorrow
                else -> null
            }
        }
        if (vm.activity.checkedInToday) reminder.lastSignedDay = ActivityState.today()
        // What Today shows on the next launch before the room has answered.
        val identity = vm.did
        if (identity != null && vm.activity.lastChecked != null) {
            val today = ActivityState.today()
            flop.rememberStats(
                identity,
                dev.alexkosa.floppassport.flop.FlopPrefs.Stats(
                    streak = todayStreak,
                    best = vm.activity.bestStreak(today),
                    signedDays = vm.activity.activeDays,
                    firstDay = vm.activity.firstDay,
                ),
            )
        }
    }

    val inSetup = vm.did == null || !(vm.flow.complete || setupSeen)

    // Back closes a page, then goes to Today, then leaves. Somebody who wandered into
    // Settings and pressed Back expects the app, not the launcher.
    BackHandler(!inSetup && (page != Page.None || tab != Tab.Today)) {
        if (page != Page.None) page = Page.None else tab = Tab.Today
    }

    CompositionLocalProvider(LocalTranslator provides Translator(effective)) {
        Box(Modifier.fillMaxSize().background(FlopColors.Base)) {
            Column(Modifier.fillMaxSize().safeDrawingPadding()) {
                Box(Modifier.weight(1f)) {
                    when {
                        // "What's new" is for people coming from 1.0: "your streak came with
                        // you" is untrue for somebody who made their Passport a minute ago, and
                        // the welcome has just told them the same things in its own words.
                        inSetup && vm.did == null && !welcomed -> WelcomeScreen(onStart = {
                            welcomed = true
                            flop.dismissWhatsNew()
                        })
                        inSetup -> PassportScreen(vm, onOpenActivity = {})
                        page == Page.Guide -> Column {
                            BackRow("back", onBack = { page = Page.None })
                            GuideScreen(flop)
                        }
                        page == Page.Details -> Column {
                            BackRow("back", onBack = { page = Page.None })
                            DetailsScreen(vm, flop, onOpenSettings = { page = Page.Settings })
                        }
                        page == Page.History -> Column {
                            BackRow("back", onBack = { page = Page.None })
                            ActivityScreen(vm)
                        }
                        page == Page.Settings -> Column {
                            BackRow("back", onBack = { page = Page.None })
                            SettingsScreen(
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
                        else -> when (tab) {
                            Tab.Today -> TodayScreen(
                                vm,
                                flop,
                                onOpenAsk = { tab = Tab.Ask },
                                onOpenGuide = { page = Page.Guide },
                                onOpenPulse = { tab = Tab.Network },
                            )
                            Tab.Ask -> AskScreen(flop, onOpenGuide = { page = Page.Guide })
                            Tab.Network -> NetworkScreen(flop, onOpenGuide = { page = Page.Guide })
                            Tab.Passport -> MeScreen(
                                vm,
                                flop,
                                onOpenDetails = { page = Page.Details },
                                onOpenHistory = { page = Page.History },
                            )
                        }
                    }
                }
                if (!inSetup) ProcessPill(flop)
                // Hidden while the keyboard is up. The bar sits directly above the keys,
                // so a finger reaching for the top row of letters landed on a tab and
                // threw the person out of the sentence they were writing.
                if (!inSetup && WindowInsets.ime.getBottom(LocalDensity.current) == 0) FlopBottomNav(
                    selected = tab,
                    onSelect = {
                        tab = it
                        page = Page.None
                    },
                    badge = vm.activity.streak(ActivityState.today()).takeIf { it > 0 }
                        ?.let { mapOf(Tab.Today to it.toString()) } ?: emptyMap(),
                )
            }

            if (!inSetup) {
                ProcessWindow(vm, flop, onRetryDay = {
                    flop.doMyDay(alreadySigned = vm.activity.checkedInToday) { vm.signToday() }
                })
            }

            // Once per install, after setup: what 2.0 changed, in four lines, and where the
            // rest is written. A person who has signed every day since September opens the
            // app to four tabs they have never seen, and deserves to be told why.
            if (!inSetup && !flop.whatsNewSeen && !vm.showSupportInvite) {
                WhatsNewSheet(
                    onClose = { flop.dismissWhatsNew() },
                    onGuide = {
                        flop.dismissWhatsNew()
                        page = Page.Guide
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

/** The pages that open over a tab. */
private enum class Page { None, Details, History, Settings, Guide }

/** Whether this phone has seen its Passport finished. Not a secret, so not in the vault. */
private class SetupMemory(context: android.content.Context) {
    private val prefs = context.getSharedPreferences("flop_passport_prefs", android.content.Context.MODE_PRIVATE)
    var done: Boolean
        get() = prefs.getBoolean("setup_done", false)
        set(value) = prefs.edit().putBoolean("setup_done", value).apply()
}
