package dev.alexkosa.floppassport.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopType

/**
 * The questions people kept sending Alex, answered where they are asked.
 *
 * Every answer here is one he had typed by hand into a DM at least once. Kept short, kept
 * honest, and closed until tapped, so the page reads as a list of questions a person can
 * find theirs in.
 */
val FAQ: List<Pair<String, String>> = listOf(
    "Will I get FLOP tokens for this?" to
        "Nobody can promise that, and this app never will. What FLOP says: on testnet, the testnet FLOP an agent spends on the model becomes its claim on mainnet FLOP. The app helps you do exactly that every day. Devnet, which is now, earns nothing.",
    "What do I need to do every day?" to
        "Open the app and press do my day. It signs today, takes today's FLOP from the faucet and asks the model one question. That is all. Whatever is already done is skipped.",
    "Why did my streak go back to zero?" to
        "A streak counts days in a row with a signed record. One missed day a week is now forgiven; two missed days in a row end it. The count is read from the public room, so a day you did not sign cannot be added later.",
    "Why is my balance 0?" to
        "Your FLOP comes from FLOP's faucet: 25 FLOP once every 24 hours. Press do my day and wait, the faucet can take a minute or two. If the balance stays 0, the faucet step says why.",
    "Why does the model not answer me?" to
        "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial, for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is.",
    "Is this FLOP money real?" to
        "No. Devnet FLOP is practice money with no value, and FLOP may wipe the devnet at any time. There is no FLOP token yet at all. Anybody selling FLOP today is a scammer.",
    "What exactly does my wallet sign?" to
        "Only text, never a transaction. Once, to create your Passport. After that the Passport signs on its own: your daily record and the model's entry statement. None of it can move money from your wallet.",
    "Do I need more than one account?" to
        "No, and it would not help. FLOP counts spending, not accounts, and says extra accounts earn nothing. One person, one Passport.",
    "I changed phones. How do I get my Passport back?" to
        "Install the app and connect the same Solana wallet. The same wallet makes the same Passport, with the same FLOP address and the same streak. There are no words to write down.",
    "When does testnet start?" to
        "FLOP has not given a date. It will be announced on x.com/flop_labs, and this app's status will say so the same day.",
    "Who made this app?" to
        "Alex Kosa, one developer, for Seeker owners. It is not made by FLOP Labs. It is free and its code is open.",
)

@Composable
fun FaqList() {
    Column(Modifier.fillMaxWidth()) {
        FAQ.forEachIndexed { i, (q, a) -> FaqItem(i, q, a) }
    }
}

@Composable
private fun FaqItem(index: Int, question: String, answer: String) {
    var open by rememberSaveable(index) { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxWidth()
            .clickable { open = !open }
            .padding(vertical = FlopSpacing.sm),
    ) {
        Row(verticalAlignment = Alignment.Top) {
            Text(t(question), style = FlopType.bodyMd, color = FlopColors.IceWhite, modifier = Modifier.weight(1f))
            Spacer(Modifier.width(FlopSpacing.sm))
            Text(if (open) "−" else "+", style = FlopType.h3, color = FlopColors.Cyan)
        }
        if (open) {
            Spacer(Modifier.height(FlopSpacing.xs))
            Text(
                t(answer),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
                modifier = Modifier.background(FlopColors.Base, FlopShapes.md).padding(FlopSpacing.md).fillMaxWidth(),
            )
        }
    }
}
