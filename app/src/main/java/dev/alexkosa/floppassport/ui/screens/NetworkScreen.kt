package dev.alexkosa.floppassport.ui.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import dev.alexkosa.floppassport.flop.FlopAmount
import dev.alexkosa.floppassport.flop.FlopEndpoints
import dev.alexkosa.floppassport.flop.FlopOfficial
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.ui.FlopViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopType
import dev.alexkosa.floppassport.ui.designsystem.raisedCard

/**
 * Pulse: who is here, how the network is doing, and who makes it possible.
 *
 * This app joins two ecosystems, and each should be able to see that here. The numbers come
 * from the public room and FLOP's own explorer, so anyone can repeat them. Thanks are warm and
 * specific, and always sit beside the line saying that neither side made or endorses this app.
 * The scam check is here because the token does not exist yet and people are being sold it.
 */
@Composable
fun NetworkScreen(flop: FlopViewModel, onOpenGuide: () -> Unit) {
    LaunchedEffect(Unit) {
        flop.refreshNetwork()
        flop.refreshCommunity()
    }
    val n = flop.network
    val us = flop.community

    FlopScreen {
        FlopHeader("Pulse", trailing = "Seeker ↔ FLOP")
        Text(t("Who is here, and how FLOP's network is doing today."), style = FlopType.bodyMd, color = FlopColors.TextMuted)

        Column(
            Modifier.fillMaxWidth().raisedCard(glow = FlopColors.Cyan).padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            FlopLabel("who is here")
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                UsNumber(us?.let { "%,d".format(it.passports) } ?: "—", "Passport holders", Modifier.weight(1f))
                Box(Modifier.width(1.dp).height(56.dp).background(FlopColors.Cyan.copy(alpha = 0.4f)))
                Spacer(Modifier.width(14.dp))
                UsNumber(us?.let { "%,d".format(it.signedDays) } ?: "—", "days signed together", Modifier.weight(1f))
            }
            us?.let { c ->
                FlopBadge(t("{n} of them signed today", "n" to c.signedToday.toString()), FlopState.Verified)
                Text(
                    t("To keep a streak, each holder signs one short public line a day. Counted from that public record, so anyone can repeat it."),
                    style = FlopType.bodySm,
                    color = FlopColors.TextMuted,
                )
            }
        }

        Section(
            "flop pulse",
            trailing = {
                if (n.loading) FlopBadge("reading", FlopState.Active)
                else ago(n.checkedAt)?.let { FlopBadge(it, FlopState.Neutral) }
            },
        ) {
            val s = n.stats
            TileRow { m ->
                Tile(s?.latestBlock?.let { "%,d".format(it) } ?: "—", "latest block", m, FlopColors.Cyan)
                Tile(s?.activeAgents?.toString() ?: "—", "active agents", m)
            }
            n.spend?.let { sp ->
                TileRow { m ->
                    Tile(FlopAmount.format(sp.spent), "FLOP spent on the model, all time", m, FlopColors.Green)
                    Tile(sp.agents.toString(), "accounts that paid for the model", m)
                }
            }
            n.error?.let { Prose(it, FlopColors.ErrorRed) }
            Prose("Devnet is a practice network, open to everyone since 3 November. Coins have no price, there is no reward.")
            Fold("more about the network") {
                val st = n.stats
                KeyValue("validators", st?.activeValidators?.toString() ?: "—")
                KeyValue("accounts", st?.totalAccounts?.toString() ?: "—")
                st?.finalizedLag?.let {
                    Prose(
                        if (it <= 30) "Blocks are being finalised normally." else "Finality is lagging behind. The network may be slow.",
                        if (it <= 30) FlopColors.TextMuted else FlopColors.ErrorRed,
                    )
                }
                FlopButtonSecondary("refresh", { flop.refreshNetwork() }, enabled = !n.loading)
                LinkRow("compute market and FRCR index", "${FlopEndpoints.EXPLORER}/markets")
                Prose(
                    "Devnet is open to everyone since 3 November 2026. It has no rewards and may be reset. " +
                        "Testnet has no date yet; FLOP will announce it on x.com/flop_labs. On testnet, the " +
                        "testnet FLOP an agent spends on inference becomes its claim on mainnet FLOP. Creating " +
                        "accounts earns nothing.",
                    FlopColors.IceWhite,
                )
                LinkRow("read it in FLOP's own words", "https://docs.flop.network/docs/airdrop-and-testnet-conversion")
            }
            if (flop.news.isNotEmpty()) {
                Fold("news") {
                    flop.news.forEach { item -> LinkRow(item.title, item.url, item.date) }
                }
            }
        }

        Section("thanks to both sides") {
            LinkRow("Solana Mobile", "https://solanamobile.com", t("for Seeker, the wallet and one-tap signing"))
            LinkRow("FLOP Labs", "https://flop.finance", t("for the network, the faucet and a model you can pay"))
            Prose("An independent app by Alex Kosa. No promises about tokens or rewards.")
        }

        Section("is this really flop?") {
            Prose("check a link, an @name or an address someone sent you")
            Fold("check") { OfficialCheck() }
            Fold("official channels") {
                FlopOfficial.SOURCES.forEach { LinkRow(it.name, it.url, t(it.what)) }
                Prose("FLOP has no Discord, Telegram, Reddit or Medium. There is no FLOP token yet.")
            }
        }

        FlopButtonSecondary("how it all works", onOpenGuide)
        Spacer(Modifier.height(FlopSpacing.md))
    }
}

@Composable
private fun UsNumber(value: String, label: String, modifier: Modifier) {
    Column(modifier) {
        Text(value, style = FlopType.h1, color = FlopColors.IceWhite, maxLines = 1)
        Text(t(label), style = FlopType.bodySm, color = FlopColors.TextMuted)
    }
}

@Composable
private fun OfficialCheck() {
    var input by rememberSaveable { mutableStateOf("") }
    val result = FlopOfficial.check(input)
    run {
        BasicTextField(
            value = input,
            onValueChange = { input = it.take(300) },
            singleLine = true,
            textStyle = FlopType.code.copy(color = FlopColors.IceWhite),
            cursorBrush = SolidColor(FlopColors.Cyan),
            modifier = Modifier
                .fillMaxWidth()
                .background(FlopColors.Base, FlopShapes.md)
                .border(1.dp, FlopColors.Border, FlopShapes.md)
                .padding(FlopSpacing.md),
            decorationBox = { inner ->
                if (input.isEmpty()) Text("x.com/…", style = FlopType.code, color = FlopColors.TextMuted)
                inner()
            },
        )
        if (input.isNotBlank()) {
            val (label, state, color) = when (result.verdict) {
                FlopOfficial.Verdict.Official -> Triple("official", FlopState.Verified, FlopColors.Green)
                FlopOfficial.Verdict.NotOfficial -> Triple("not flop", FlopState.Failure, FlopColors.ErrorRed)
                FlopOfficial.Verdict.NoTokenYet -> Triple("scam warning", FlopState.Failure, FlopColors.ErrorRed)
                FlopOfficial.Verdict.Unknown -> Triple("not flop's", FlopState.Neutral, FlopColors.TextMuted)
            }
            FlopBadge(label, state)
            Text(t(result.reason, "host" to result.host, "account" to result.account), style = FlopType.bodySm, color = color)
        }
    }
}
