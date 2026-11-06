package dev.alexkosa.floppassport.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.ui.FlopViewModel
import dev.alexkosa.floppassport.ui.FlopViewModel.GatewayState
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButton
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopType
import dev.alexkosa.floppassport.ui.designsystem.well

/**
 * A model on FLOP Network, paid for in FLOP, in the phone.
 *
 * A conversation and nothing else: one card that says in words whether the model is open, the
 * chat, and the box. Sending opens the process window, which is where the wait happens, so
 * this screen never has to explain one.
 */
@Composable
fun AskScreen(flop: FlopViewModel, onOpenGuide: () -> Unit) {
    var draft by rememberSaveable { mutableStateOf("") }
    val list = rememberLazyListState()
    val messages = flop.chat

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) list.animateScrollToItem(messages.size)
    }

    // The ping on the card is measured while this screen is open, and only then.
    LaunchedEffect(Unit) {
        while (true) {
            flop.refreshPing()
            kotlinx.coroutines.delay(20_000)
        }
    }

    Column(Modifier.fillMaxSize().background(FlopColors.Base)) {
        LazyColumn(
            Modifier.weight(1f).fillMaxWidth(),
            state = list,
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 18.dp, vertical = FlopSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FlopSpacing.sm),
        ) {
            item {
                FlopHeader("ask", trailing = t("FLOP model"))
                Spacer(Modifier.height(14.dp))
                GatewayCard(flop, onOpenGuide)
                Spacer(Modifier.height(FlopSpacing.sm))
            }
            if (messages.isEmpty()) {
                item { Prose("The model is small: short, plain questions work best. Everything you pay is practice FLOP.") }
                items(flop.starters) { q ->
                    Text(
                        t(q),
                        style = FlopType.bodyMd,
                        color = FlopColors.IceWhite,
                        modifier = Modifier
                            .fillMaxWidth()
                            .well()
                            .clickable(enabled = !flop.runBusy) { flop.ask(q) }
                            .padding(12.dp),
                    )
                }
            }
            items(messages) { m -> Bubble(m) }
        }

        val canAsk = flop.passportAddress != null && flop.gateway !is GatewayState.Finished
        Row(
            Modifier
                .fillMaxWidth()
                .background(FlopColors.Surface)
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BasicTextField(
                value = draft,
                onValueChange = { draft = it.take(1_000) },
                enabled = canAsk && !flop.runBusy,
                textStyle = FlopType.bodyMd.copy(color = FlopColors.IceWhite),
                cursorBrush = SolidColor(FlopColors.Cyan),
                modifier = Modifier
                    .weight(1f)
                    .well()
                    .padding(14.dp),
                decorationBox = { inner ->
                    if (draft.isEmpty()) {
                        Text(
                            t(if (canAsk) "Type a question" else "The model is closed for this account"),
                            style = FlopType.bodyMd,
                            color = FlopColors.TextMuted,
                        )
                    }
                    inner()
                },
            )
            Spacer(Modifier.width(10.dp))
            FlopButton(
                "send",
                {
                    flop.ask(draft)
                    draft = ""
                },
                modifier = Modifier.widthIn(max = 100.dp),
                enabled = canAsk && !flop.runBusy && draft.isNotBlank(),
            )
        }
    }
}

@Composable
private fun GatewayCard(flop: FlopViewModel, onOpenGuide: () -> Unit) {
    val g = flop.gateway
    Section(
        when (g) {
            is GatewayState.Open -> "model open"
            GatewayState.Entering -> "opening the model"
            GatewayState.Finished -> "trial over for this account"
            is GatewayState.Refused -> if (g.needsFunds) "needs 1 flop" else "model closed for now"
            GatewayState.Closed -> "first question opens it"
        },
        accent = if (g is GatewayState.Open) FlopColors.Green.copy(alpha = 0.5f) else FlopColors.Border,
        trailing = {
            flop.gatewayPing?.let { p ->
                FlopBadge(
                    p.ms?.let { t("ping {n} ms", "n" to it.toString()) } ?: t("no answer"),
                    if (p.ms == null) FlopState.Failure else FlopState.Verified,
                )
            }
        },
    ) {
        when (g) {
            GatewayState.Closed -> Prose("Your Passport signs a short statement from FLOP's gateway. Nothing moves. You need at least 1 FLOP; the faucet on Today gives you 25.")
            GatewayState.Entering -> Unit
            is GatewayState.Open -> {
                KeyValue("allowance left", g.remaining?.let { "%,.2f FLOP".format(it) } ?: "…")
                flop.lastAnswerSeconds?.let { KeyValue("last answer took", "$it s") }
                Fold("more") {
                    KeyValue("model", g.model)
                    if (g.expiresAt > 0) KeyValue("closes in", until(g.expiresAt))
                    Prose(
                        "FLOP gives each account one devnet allowance for 24 hours. The figure above is what is " +
                            "left of it. When it is over it is over until testnet.",
                    )
                    dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary("how the model works here", onOpenGuide)
                }
            }
            GatewayState.Finished -> Prose(
                "This account has used its one devnet allowance. FLOP does not renew it on devnet. " +
                    "The model opens again when testnet starts, and on testnet the FLOP you spend here " +
                    "is what counts.",
            )
            is GatewayState.Refused -> Prose(g.message, FlopColors.ErrorRed)
        }
    }
}

@Composable
private fun Bubble(m: dev.alexkosa.floppassport.flop.FlopPrefs.Message) {
    val mine = m.role == "user"
    Row(Modifier.fillMaxWidth(), horizontalArrangement = if (mine) Arrangement.End else Arrangement.Start) {
        Column(
            Modifier
                .widthIn(max = 300.dp)
                .background(if (mine) FlopColors.SurfaceLight else FlopColors.Surface, FlopShapes.lg)
                .padding(FlopSpacing.md),
        ) {
            if (!mine) {
                FlopLabel("model")
                Spacer(Modifier.height(FlopSpacing.xs))
            }
            Text(m.text, style = FlopType.bodyMd, color = FlopColors.IceWhite)
            m.costFlop?.let {
                Spacer(Modifier.height(FlopSpacing.xs))
                Text(t("cost {n} FLOP", "n" to "%.3f".format(it)), style = FlopType.label, color = FlopColors.Cyan)
            }
        }
    }
}
