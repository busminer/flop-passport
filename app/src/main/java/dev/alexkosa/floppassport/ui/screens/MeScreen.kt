package dev.alexkosa.floppassport.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import dev.alexkosa.floppassport.R
import dev.alexkosa.floppassport.crypto.DidKey
import dev.alexkosa.floppassport.crypto.Ss58
import dev.alexkosa.floppassport.flop.FlopAmount
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.i18n.tu
import dev.alexkosa.floppassport.ui.ActivityState
import dev.alexkosa.floppassport.ui.FlopViewModel
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopBackupSheet
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButton
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopStepLadder
import dev.alexkosa.floppassport.ui.designsystem.FlopType
import dev.alexkosa.floppassport.ui.designsystem.raisedCard
import dev.alexkosa.floppassport.ui.designsystem.well
import dev.alexkosa.floppassport.util.Biometrics
import dev.alexkosa.floppassport.vault.PassportVault

/**
 * The Passport: one key, two networks.
 *
 * The first level is for a person: which wallet, which FLOP account, how they are doing. The
 * machinery (the key string, the proof, the private key, another address) is real and stays
 * one tap away under Details and key, which is where somebody who wants it looks for it.
 */
@Composable
fun MeScreen(
    vm: PassportViewModel,
    flop: FlopViewModel,
    onOpenDetails: () -> Unit,
    onOpenHistory: () -> Unit,
) {
    val identity = vm.did ?: return
    val today = ActivityState.today()
    val activity = vm.activity
    val known = activity.lastChecked != null
    val cached = flop.cachedStats
    val streak = if (known) activity.streak(today) else cached?.streak
    val best = if (known) activity.bestStreak(today) else cached?.best
    val signedDays = if (known) activity.activeDays else cached?.signedDays
    val firstDay = if (known) activity.firstDay else cached?.firstDay

    LaunchedEffect(Unit) { flop.refreshAccount() }

    FlopScreen {
        FlopHeader("passport", trailing = t("devnet · practice network"))

        Column(
            Modifier.fillMaxWidth().raisedCard(glow = FlopColors.Cyan).padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.seeker_wordmark), "Seeker", Modifier.height(16.dp))
                Text(
                    t("one key · two networks"),
                    style = FlopType.label.copy(letterSpacing = 0.sp, fontSize = 10.sp),
                    color = FlopColors.TextMuted,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f).padding(horizontal = FlopSpacing.xs),
                )
                Image(painterResource(R.drawable.flop_lockup_reverse), "FLOP", Modifier.height(22.dp))
            }
            Lane(
                "Seeker wallet",
                vm.walletAddress?.let { Ss58.abbreviate(it) } ?: "—",
                "Made the Passport with one signature. Brings it back on any phone.",
            )
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.weight(1f).height(1.dp).background(FlopColors.Cyan.copy(alpha = 0.35f)))
                Text(
                    tu("same key"),
                    style = FlopType.label,
                    color = FlopColors.Cyan,
                    modifier = Modifier.padding(horizontal = FlopSpacing.sm),
                )
                Box(Modifier.weight(1f).height(1.dp).background(FlopColors.Cyan.copy(alpha = 0.35f)))
            }
            Lane(
                "FLOP account",
                flop.passportAddress?.let { Ss58.abbreviate(it) } ?: "—",
                "The same key as a FLOP address. The faucet pays here; the model is paid from here.",
            )
        }

        TileRow { m ->
            Stat(firstDay?.let { longDate(it, withYear = true) } ?: "—", "Registered", m)
            Stat(streak?.toString() ?: "—", "Days in a row", m, FlopColors.Green)
        }
        TileRow { m ->
            Stat(best?.toString() ?: "—", "Best streak", m)
            Stat(signedDays?.toString() ?: "—", "Signed days", m)
        }
        TileRow { m ->
            Stat(flop.balance.value?.let { FlopAmount.format(it) } ?: "—", "Balance, FLOP", m, FlopColors.Cyan)
            Stat(flop.spend?.let { FlopAmount.format(it.spent) } ?: "0", "Spent on the model, FLOP", m)
        }
        if (known) {
            FlopBadge(
                if (activity.skipLeft(today)) "1 skip left this week" else "this week's skip is used",
                if (activity.skipLeft(today)) FlopState.Verified else FlopState.Neutral,
            )
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
            FlopButtonSecondary("all my records", onOpenHistory, Modifier.weight(1f))
            FlopButtonSecondary("details and key", onOpenDetails, Modifier.weight(1f))
        }

        Text(
            t("On Seeker · in FLOP Network · an app by Alex Kosa, not FLOP Labs, not Solana Mobile"),
            style = FlopType.bodySm,
            color = FlopColors.TextMuted,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(FlopSpacing.xs))
    }
}

@Composable
private fun Lane(title: String, value: String, about: String) {
    Column(Modifier.fillMaxWidth().well().padding(12.dp), verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(t(title), style = FlopType.cardTitle.copy(fontSize = 14.5.sp), color = FlopColors.IceWhite, modifier = Modifier.weight(1f))
            Text(value, style = FlopType.code, color = FlopColors.Cyan)
        }
        Text(t(about), style = FlopType.bodySm, color = FlopColors.TextMuted)
    }
}

@Composable
private fun Stat(value: String, label: String, modifier: Modifier, color: Color = FlopColors.IceWhite) {
    Column(modifier.well().padding(horizontal = 12.dp, vertical = 10.dp)) {
        Text(value, style = FlopType.number.copy(fontSize = 17.sp), color = color, maxLines = 1)
        Text(t(label), style = FlopType.bodySm, color = FlopColors.TextMuted)
    }
}

/** Everything a person does not need every day, in one place, without being hidden. */
@Composable
fun DetailsScreen(vm: PassportViewModel, flop: FlopViewModel, onOpenSettings: () -> Unit) {
    val identity = vm.did ?: return
    val pulse by vm.pulse.collectAsState()

    FlopScreen {
        FlopHeader("details and key")

        Section("your identity", accent = FlopColors.Cyan) {
            CopyLine(identity)
            Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                FlopBadge(
                    when (vm.securityLevel) {
                        PassportVault.SecurityLevel.STRONGBOX -> "vault: security chip"
                        PassportVault.SecurityLevel.TEE -> "vault: secure area"
                        PassportVault.SecurityLevel.SOFTWARE -> "vault: software"
                        else -> "vault: not sealed yet"
                    },
                    FlopState.Active,
                )
                if (vm.walletAddress != null) FlopBadge("wallet linked", FlopState.Verified)
            }
            KeyValue("fingerprint", DidKey.fingerprint(identity))
            vm.walletAddress?.let { KeyValue("made by wallet", Ss58.abbreviate(it)) }
            Prose("Your wallet made this key and rebuilds it on any phone. There are no words to write down.")
        }

        BalanceCard(flop)

        FlopAddressCard(flop)

        Section("the proof") {
            Prose("Every step below was read back from the server, not just sent.")
            FlopStepLadder(vm.flow, pulse = pulse)
        }

        KeySection(vm)

        FlopButtonSecondary("settings, language, about", onOpenSettings)
        Spacer(Modifier.height(FlopSpacing.md))
    }
}

/**
 * The FLOP address, and the choice of another one the person already had.
 *
 * The Passport's own address is the default because it needs nothing: the key is already on
 * the phone, and it is the only address the gateway can be entered with, since entering is a
 * signature by that key. Somebody who keeps FLOP in SubWallet or Talisman can point the
 * faucet there instead, and is told what they give up.
 */
@Composable
private fun FlopAddressCard(flop: FlopViewModel) {
    val own = flop.passportAddress ?: return
    var editing by rememberSaveable { mutableStateOf(false) }
    var input by rememberSaveable { mutableStateOf(flop.customAddress ?: "") }
    var problem by remember { mutableStateOf<String?>(null) }

    Section("your flop address") {
        Prose("Your Passport key is also an account on FLOP Network. Same key, written the way FLOP writes addresses.")
        CopyLine(own)
        flop.customAddress?.let { custom ->
            Prose("The faucet sends to an address you chose instead:", FlopColors.IceWhite)
            CopyLine(custom)
        }
        if (!editing) {
            FlopButtonSecondary(
                if (flop.customAddress == null) "use an address I already have" else "change the address",
                { editing = true },
            )
        } else {
            Prose(
                "Paste a FLOP address from SubWallet, Talisman or Polkadot.js. The faucet will send " +
                    "there. The model still uses your Passport's own address, because only your " +
                    "Passport can sign for it.",
            )
            BasicTextField(
                value = input,
                onValueChange = { input = it.trim().take(64) },
                singleLine = true,
                textStyle = FlopType.code.copy(color = FlopColors.IceWhite),
                cursorBrush = SolidColor(FlopColors.Cyan),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FlopColors.Base, FlopShapes.md)
                    .border(1.dp, FlopColors.Border, FlopShapes.md)
                    .padding(FlopSpacing.md),
                decorationBox = { inner ->
                    if (input.isEmpty()) Text("5…", style = FlopType.code, color = FlopColors.TextMuted)
                    inner()
                },
            )
            problem?.let { Prose(it, FlopColors.ErrorRed) }
            Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                FlopButton("save", {
                    problem = flop.setCustomAddress(input)
                    if (problem == null) editing = false
                }, Modifier.weight(1f), enabled = input.isNotBlank())
                FlopButtonSecondary("cancel", { editing = false; problem = null }, Modifier.weight(1f))
            }
            if (flop.customAddress != null) {
                FlopButtonSecondary("go back to my passport address", {
                    flop.setCustomAddress(null)
                    input = ""
                    editing = false
                })
            }
        }
    }
}

@Composable
private fun BalanceCard(flop: FlopViewModel) {
    val address = flop.receiveAddress ?: return
    val b = flop.balance
    Section(
        "balance",
        trailing = {
            if (b.loading) FlopBadge("reading", FlopState.Active)
            else ago(b.checkedAt)?.let { FlopBadge(it, FlopState.Neutral) }
        },
    ) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                b.value?.let { dev.alexkosa.floppassport.flop.FlopAmount.format(it) } ?: "\u2014",
                style = FlopType.h1,
                color = FlopColors.IceWhite,
            )
            Spacer(Modifier.width(FlopSpacing.sm))
            Text(
                dev.alexkosa.floppassport.i18n.tu("devnet flop"),
                style = FlopType.label,
                color = FlopColors.TextMuted,
                modifier = Modifier.padding(bottom = 6.dp),
            )
        }
        b.error?.let { Prose(it, FlopColors.ErrorRed) }
        flop.spend?.let {
            KeyValue("spent on the model, as FLOP's explorer sees it", dev.alexkosa.floppassport.flop.FlopAmount.format(it.spent) + " FLOP")
        }
        Prose("Devnet FLOP is practice money: it has no value and can be wiped in a reset.")
        FlopButtonSecondary("refresh", { flop.refreshAccount() }, enabled = !b.loading)
        LinkRow("open in FLOP's explorer", dev.alexkosa.floppassport.flop.FlopEndpoints.explorerAccount(address))
    }
}

@Composable
private fun KeySection(vm: PassportViewModel) {
    val context = LocalContext.current
    val identity = vm.did ?: return
    var gateMessage by remember { mutableStateOf<String?>(null) }

    val saveLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument("text/plain"),
    ) { uri ->
        if (uri != null) {
            val document = vm.backupDocument()
            if (document.isEmpty()) {
                gateMessage = "Nothing was saved. Open your private key again and save it from there."
            } else {
                val written = runCatching {
                    context.contentResolver.openOutputStream(uri)?.use { out ->
                        out.write(document.toByteArray(Charsets.UTF_8))
                    } ?: error("no stream")
                }.isSuccess
                if (!written) gateMessage = "The file could not be written. Try another location."
            }
        }
    }

    vm.revealedSeedHex?.let { seedHex ->
        FlopBackupSheet(
            did = identity,
            seedHex = seedHex,
            onSaveFile = { saveLauncher.launch("flop-passport-${identity.removePrefix("did:key:").take(10)}.txt") },
            onDismiss = { vm.hideSeed() },
        )
    }

    Section("private key") {
        Prose(
            "You never need this to recover: your wallet rebuilds the Passport. It is here for " +
                "people who want to use their identity away from this phone. Nobody, including " +
                "this app's author, will ever ask you for it.",
        )
        FlopButtonSecondary("show my private key", {
            val activity = context as? FragmentActivity
            if (activity == null) {
                gateMessage = "Could not open the security prompt on this screen."
            } else {
                Biometrics.authenticate(
                    activity = activity,
                    title = "Show your private key",
                    subtitle = "Anyone holding it can sign as you",
                    onSuccess = {
                        vm.revealSeed()
                        if (vm.revealedSeedHex == null) {
                            gateMessage = "Could not read the key from secure storage. Restart the phone and try again."
                        }
                    },
                    onFailure = { gateMessage = it },
                )
            }
        })
        gateMessage?.let { Prose(it, FlopColors.ErrorRed) }
    }
}
