package dev.alexkosa.floppassport.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.window.Dialog
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.ui.designsystem.FlopButton
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopType

/**
 * The first screen a new person sees: what they get, and what their wallet will show.
 *
 * In 1.0 the app opened straight onto "01 CREATE", and a two-star review said it never
 * explained why anyone would want it. Three lines of what it is for, one line of what the
 * wallet will ask, one button.
 */
@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    FlopScreen {
        androidx.compose.foundation.Image(
            androidx.compose.ui.res.painterResource(dev.alexkosa.floppassport.R.drawable.flop_lockup_reverse),
            "FLOP",
            Modifier.width(112.dp),
        )
        dev.alexkosa.floppassport.ui.designsystem.FlopLabel("passport for seeker")
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(t("Your day on FLOP, from your Seeker."), style = FlopType.h2, color = FlopColors.IceWhite)

        Promise("1", "An identity made by your wallet", "Nothing new to write down. The same wallet brings it back on any phone.")
        Promise("2", "A FLOP account with daily FLOP", "Your Passport is also a FLOP address. FLOP's faucet gives it 25 FLOP every 24 hours.")
        Promise("3", "A model you pay in FLOP, and a streak", "Ask a question, see what it cost, and keep a streak of the days you show up.")

        Column(
            Modifier
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.md)
                .border(1.dp, FlopColors.Cyan.copy(alpha = 0.4f), FlopShapes.md)
                .padding(FlopSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FlopSpacing.xs),
        ) {
            FlopLabel("what your wallet will show")
            Text(
                t("One short text to sign. It is not a transaction and moves no money. Your wallet keeps its keys; nothing leaves it but that one signature."),
                style = FlopType.bodySm,
                color = FlopColors.IceWhite,
            )
        }

        FlopButton("start", onStart)
        Prose("Free and open source. Made by Alex Kosa, not by FLOP Labs. It promises nothing about any allocation.")
    }
}

@Composable
private fun Promise(number: String, title: String, text: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        Text(number, style = FlopType.h3, color = FlopColors.Cyan)
        Spacer(Modifier.width(FlopSpacing.md))
        Column(Modifier.weight(1f)) {
            Text(t(title), style = FlopType.bodyMd, color = FlopColors.IceWhite)
            Text(t(text), style = FlopType.bodySm, color = FlopColors.TextMuted)
        }
    }
}

/**
 * Shown once to everyone who already had a Passport: what moved, in four lines.
 *
 * Somebody who has signed every day since September opens 2.0 to four tabs they have never
 * seen. The one thing they need to hear first is that their streak came with them.
 */
@Composable
fun WhatsNewSheet(onClose: () -> Unit, onGuide: () -> Unit) {
    Dialog(onDismissRequest = onClose) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, FlopColors.Cyan.copy(alpha = 0.5f), FlopShapes.lg)
                .padding(FlopSpacing.lg),
            verticalArrangement = Arrangement.spacedBy(FlopSpacing.md),
        ) {
            FlopLabel("new in 2.0")
            Text(t("Your Passport now lives on FLOP"), style = FlopType.h3, color = FlopColors.IceWhite)
            Promise("1", "Your streak came with you", "Same Passport, same days. And now one missed day a week is forgiven.")
            Promise("2", "Your Passport is a FLOP account", "It gets 25 devnet FLOP from FLOP's faucet every 24 hours.")
            Promise("3", "Do my day", "One button signs today, takes today's FLOP and asks the model one question.")
            Promise("4", "Devnet is practice", "Its FLOP has no value. What you practise here is what testnet will count.")
            FlopButton("got it", onClose)
            FlopButtonSecondary("how it all works", onGuide)
        }
    }
}
