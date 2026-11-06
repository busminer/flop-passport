package dev.alexkosa.floppassport.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.alexkosa.floppassport.flop.FlopStatus
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.ui.FlopViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopDot
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopType

/**
 * How it all works, in our words, in one place.
 *
 * Alex's ask for 2.0: people should never have to guess what is happening. Every rule the
 * app lives by - what devnet is, how often the faucet gives, why the model closes after a
 * day, what testnet will count - is written here plainly, with the date it was true and a
 * link to where FLOP itself says it.
 */
@Composable
fun GuideScreen(flop: FlopViewModel) {
    FlopScreen {
        FlopHeader("how it works")

        StatusCard(flop, compact = false)

        Chapter("Questions people ask") { FaqList() }

        Chapter("What this app is") {
            Para(
                "FLOP Passport gives your Seeker an identity and an account on FLOP Network, and one " +
                    "place to do your day there. It is free, open source, and made by one developer, " +
                    "Alex Kosa. It is not made by FLOP Labs.",
            )
        }

        Chapter("What FLOP is") {
            Para(
                "FLOP Network is a blockchain where AI agents pay for AI work with FLOP. Miners run " +
                    "models on graphics cards, validators check that the work was really done, and " +
                    "agents buy the answers. Asking the model a question here is exactly that: your " +
                    "Passport acts as an agent and pays for one answer.",
            )
        }

        Chapter("Where FLOP is now") {
            Stage("Devnet", "now", FlopState.Active,
                "A practice network, open to everyone since 3 November 2026. FLOP here has no value, " +
                    "earns nothing and can be wiped in a reset. Use it to learn the day before it counts.")
            Stage("Testnet", "no date yet", FlopState.Neutral,
                "About 90 days. This is where FLOP's agent airdrop is earned: the testnet FLOP you " +
                    "spend on the model is recorded as your claim on mainnet FLOP.")
            Stage("Mainnet", "FLOP says Q1 2027", FlopState.Neutral,
                "The real token. There is no FLOP token before this, so anything sold or “claimed” " +
                    "as FLOP today is a scam.")
        }

        Chapter("Your day, step by step") {
            Step("1", "Sign today's record",
                "Your Passport signs one short line in a public room on technocore.chat, and the app " +
                    "reads it back to prove it landed. Each signed day adds to your streak. Miss one day " +
                    "and it is forgiven, once a week. Miss two in a row and the streak starts again.")
            Step("2", "Take today's FLOP",
                "FLOP's faucet sends 25 devnet FLOP to your address, once every 24 hours per address. " +
                    "The request goes from your phone, for your own address, the same as pressing the " +
                    "button on faucet.flop.network. When the faucet is down, the app says so and the rest " +
                    "of your day still counts.")
            Step("3", "Ask the model one question",
                "To use the model, your Passport signs a short statement from api.flop.network. That " +
                    "signature moves nothing. FLOP then opens an allowance for your account: on devnet one, " +
                    "for 24 hours, and your account needs at least 1 FLOP to start it. The Ask tab shows how " +
                    "much of it is left. An answer costs about 0.006 FLOP per word-piece, usually one or two " +
                    "FLOP. When the allowance ends, the model stays closed for that account until testnet.")
        }

        Chapter("Your FLOP address") {
            Para(
                "Your Passport key is also your FLOP account. It is the same key, written the way FLOP " +
                    "writes addresses, so there is nothing new to back up: your Solana wallet rebuilds " +
                    "both on any phone. If you already have a FLOP address in SubWallet, Talisman or " +
                    "Polkadot.js, you can send the faucet there instead, on the Passport tab. The model " +
                    "works only with the Passport's own address, because only the Passport can sign for it.",
            )
        }

        Chapter("Testnet and the airdrop") {
            Para(
                "What FLOP says: on testnet, testnet FLOP that an agent actually spends on inference " +
                    "becomes its claim on mainnet FLOP. That claim is locked, and unlocks as it is spent " +
                    "on inference on mainnet: three spent unlock one. Holding FLOP earns nothing. Making " +
                    "more accounts earns nothing. Posting your identity earns nothing.",
            )
            Para(
                "What we say: this app promises nothing about any allocation, and never will. It helps " +
                    "you do, every day, the thing FLOP says it counts. One person, one Passport.",
                FlopColors.IceWhite,
            )
        }

        Chapter("Staying safe") {
            Para(
                "There is no FLOP token yet. Nobody, including this app's author, will ever ask for your " +
                    "private key or your wallet's words. Your wallet only ever signs text here, never a " +
                    "transaction. If somebody sends you a FLOP link, check it on the Network tab first.",
            )
        }

        Chapter("Where these facts come from") {
            LinkRow("FLOP: the airdrop and testnet conversion", "https://docs.flop.network/docs/airdrop-and-testnet-conversion")
            LinkRow("FLOP: official links and verification", "https://docs.flop.network/docs/official-links")
            LinkRow("FLOP's gateway rules (OpenAPI)", "https://api.flop.network/openapi.json")
            LinkRow("The faucet", "https://faucet.flop.network")
            LinkRow("This app's source code", "https://github.com/busminer/flop-passport")
        }
        Spacer(Modifier.height(FlopSpacing.md))
    }
}

/**
 * "What is happening now", ours, dated. Shown on Today in short and at the top of the guide
 * in full. Live facts the phone has seen itself correct the written status: a faucet that
 * just paid this person is not described to them as down.
 */
@Composable
fun StatusCard(flop: FlopViewModel, compact: Boolean, onMore: (() -> Unit)? = null) {
    val status = flop.statusNow
    Section(
        "what is happening now",
        trailing = { Text(status.updated, style = FlopType.label, color = FlopColors.TextMuted) },
    ) {
        status.lines.forEach { line ->
            Row(verticalAlignment = Alignment.Top) {
                FlopDot(
                    when (line.level) {
                        FlopStatus.Level.Good -> FlopState.Verified
                        FlopStatus.Level.Info -> FlopState.Active
                        FlopStatus.Level.Warning -> FlopState.Neutral
                        FlopStatus.Level.Problem -> FlopState.Failure
                    },
                    Modifier.padding(top = 6.dp),
                )
                Spacer(Modifier.width(FlopSpacing.sm))
                Column(Modifier.weight(1f)) {
                    Text(t(line.title), style = FlopType.bodyMd, color = FlopColors.IceWhite)
                    if (!compact) Text(t(line.text), style = FlopType.bodySm, color = FlopColors.TextMuted)
                }
            }
        }
        Text(
            t(if (status.fromSite) "From the FLOP Passport team." else "From the FLOP Passport team, written into this version."),
            style = FlopType.bodySm,
            color = FlopColors.TextMuted,
        )
        onMore?.let { LinkButton("how it works, questions and answers", it) }
    }
}

@Composable
private fun LinkButton(text: String, onClick: () -> Unit) {
    dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary(text, onClick)
}

@Composable
private fun Chapter(title: String, content: @Composable () -> Unit) {
    Column(
        Modifier.fillMaxWidth().background(FlopColors.Surface, FlopShapes.md).padding(FlopSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FlopSpacing.sm),
    ) {
        Text(t(title), style = FlopType.h3, color = FlopColors.IceWhite)
        content()
    }
}

@Composable
private fun Para(text: String, color: androidx.compose.ui.graphics.Color = FlopColors.TextMuted) {
    Text(t(text), style = FlopType.bodyMd, color = color)
}

@Composable
private fun Stage(name: String, whenText: String, state: FlopState, text: String) {
    Column(Modifier.fillMaxWidth().background(FlopColors.Base, FlopShapes.md).padding(FlopSpacing.md)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(t(name), style = FlopType.h3, color = FlopColors.IceWhite, modifier = Modifier.weight(1f))
            dev.alexkosa.floppassport.ui.designsystem.FlopBadge(whenText, state)
        }
        Spacer(Modifier.height(FlopSpacing.xs))
        Text(t(text), style = FlopType.bodySm, color = FlopColors.TextMuted)
    }
}

@Composable
private fun Step(number: String, title: String, text: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        FlopLabel(number, color = FlopColors.Cyan, modifier = Modifier.padding(top = 3.dp))
        Spacer(Modifier.width(FlopSpacing.md))
        Column(Modifier.weight(1f)) {
            Text(t(title), style = FlopType.bodyMd, color = FlopColors.IceWhite)
            Text(t(text), style = FlopType.bodySm, color = FlopColors.TextMuted)
        }
    }
}
