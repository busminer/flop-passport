package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.i18n.DE_STRINGS
import dev.alexkosa.floppassport.i18n.ES_STRINGS
import dev.alexkosa.floppassport.i18n.ID_STRINGS
import dev.alexkosa.floppassport.i18n.JA_STRINGS
import dev.alexkosa.floppassport.i18n.KO_STRINGS
import dev.alexkosa.floppassport.i18n.PT_STRINGS
import dev.alexkosa.floppassport.i18n.RU_STRINGS
import dev.alexkosa.floppassport.i18n.TR_STRINGS
import dev.alexkosa.floppassport.i18n.VI_STRINGS
import dev.alexkosa.floppassport.i18n.ZH_STRINGS
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The ten tables, checked the way a reader would find their faults.
 *
 * A translation that drops `{host}` shows a sentence with a hole in it; one that adds a
 * `%s` the English lacks crashes String.format. A key written twice is silently the last
 * one in a mapOf, so the earlier translation is dead text nobody notices.
 */
class TranslationTablesTest {

    private val tables = mapOf(
        "ru" to RU_STRINGS, "de" to DE_STRINGS, "es" to ES_STRINGS, "pt" to PT_STRINGS, "tr" to TR_STRINGS,
        "vi" to VI_STRINGS, "id" to ID_STRINGS, "ko" to KO_STRINGS, "ja" to JA_STRINGS, "zh" to ZH_STRINGS,
    )

    private val holes = Regex("""\{[a-zA-Z]+\}|%(\.\d+)?[sdf]""")

    @Test fun placeholdersMatchTheEnglish() {
        val wrong = tables.flatMap { (lang, table) ->
            table.mapNotNull { (en, tr) ->
                val a = holes.findAll(en).map { it.value }.sorted().toList()
                val b = holes.findAll(tr).map { it.value }.sorted().toList()
                if (a != b) "$lang: \"${en.take(60)}\" has $a, translation has $b" else null
            }
        }
        assertTrue(wrong.joinToString("\n"), wrong.isEmpty())
    }

    @Test fun noTranslationIsBlank() {
        val blank = tables.flatMap { (lang, table) -> table.filterValues { it.isBlank() }.keys.map { "$lang: $it" } }
        assertTrue(blank.joinToString("\n"), blank.isEmpty())
    }

    @Test fun noKeyIsWrittenTwice() {
        val dir = sequenceOf("src/main/java/dev/alexkosa/floppassport/i18n", "app/src/main/java/dev/alexkosa/floppassport/i18n")
            .map { java.io.File(it) }.first { it.isDirectory }
        val key = Regex("""^\s{4}"((?:[^"\\]|\\.)*)"\s+to\b""", RegexOption.MULTILINE)
        val twice = dir.listFiles { f -> f.name.length == 5 && f.name.endsWith(".kt") }!!.flatMap { f ->
            key.findAll(f.readText()).map { it.groupValues[1] }.groupingBy { it }.eachCount()
                .filterValues { it > 1 }.keys.map { "${f.name}: ${it.take(60)}" }
        }
        assertTrue(twice.joinToString("\n"), twice.isEmpty())
    }

    @Test fun theNewFaucetSentencesAreInEveryLanguage() {
        val needed = listOf(
            "The faucet works",
            "FLOP's faucet gives each address 25 FLOP once every 24 hours. It can be slow: an answer may take a minute or two. The app waits for it and checks your balance.",
            "Your FLOP comes from FLOP's faucet: 25 FLOP once every 24 hours. Press do my day and wait, the faucet can take a minute or two. If the balance stays 0, the faucet step says why.",
            "The model is busy. Try again in a minute; nothing was spent.",
            "working",
            "The faucet has your request in its queue and has not sent the FLOP yet. This can take a while. Press do my day again later.",
            "The faucet has given out all of today's FLOP. Nothing arrived. It opens again within hours, so try later.",
            "Signing today's line with your Passport and reading it back from technocore.chat…",
            "Asking FLOP's faucet. It serves about 10 people a minute, so this can take up to 2 minutes.",
            "You are in the faucet's queue. The app watches your balance and asks again by itself.",
            "Reading your balance…",
            "Sending your question to the model. It has up to 90 seconds to answer.",
            "FLOP's gateway is full right now: many people are asking at once. Nothing was spent. The app tries again by itself.",
            "Your FLOP is still settling on the network. The app tries again by itself.",
            "Reading what the answer cost…",
            "FLOP's gateway stayed full through every try. Nothing was spent. Try again in a few minutes.",
            "{n} s so far",
            "try {n} of {m}",
            "next try in {n} s",
            "gateway ping {n} ms",
            "faucet ping {n} ms",
            "the gateway does not answer a ping",
            "the faucet does not answer a ping",
            "step {n} of 3",
            "ping",
            "no answer",
            "last answer took",
            "You can leave this screen: it keeps going.",
            "Join FLOP with Alex's link",
            "This is Alex Kosa's personal referral link from FLOP, and it may count for him. It gives you nothing extra from this app. Prefer not to? Go to flop.finance yourself.",
            "open {host}",
            "Pulse",
            "Who is here, and how FLOP's network is doing today.",
            "who is here",
            "Passport holders",
            "{n} Passport holders · {m} signed today",
            "{n} of them signed today",
            "To keep a streak, each holder signs one short public line a day. Counted from that public record, so anyone can repeat it.",
            "same key",
            "knock now",
            "A refused knock costs nothing. Knock as often as you like.",
            "FLOP spent on the model, all time",
            "accounts that paid for the model",
            "Signing today's line",
            "Your Passport signs one short line in the public room and reads it back. That line is your day.",
            "Asking FLOP's faucet",
            "The faucet pays about 10 people a minute. This can take up to two minutes.",
            "Standing in the faucet's queue",
            "The faucet pays about 10 people a minute. Your request is in. We watch your balance and ask again by ourselves.",
            "Your FLOP is on its way",
            "One moment.",
            "Opening the model",
            "Your Passport signs the gateway's statement. Nothing is spent.",
            "Asking the model",
            "Your question is with the model. It has up to 90 seconds.",
            "The model is full right now",
            "Many people are asking at once. Nothing was spent. We try again by ourselves.",
            "Your FLOP is still settling",
            "A fresh grant takes a moment to count. We try again by ourselves.",
            "Reading what it cost",
            "FLOP's gateway stayed full through all 6 tries. Nothing was spent. This is on FLOP's side, not yours.",
            "to next try",
            "elapsed {t}",
            "ask the model",
            "Answered",
            "cost {c} FLOP · {s} s",
            "The model did not answer",
            "your question",
            "waiting",
            "Connect your Passport",
            "Get the answer",
            "minimise · it keeps going",
            "my day · step {n} of 3",
            "my day",
            "Your day is closed",
            "See you tomorrow.",
            "Today is signed",
            "not today",
            "Could not sign today",
            "Your day is signed. Your streak of {n} is safe whatever happens next.",
            "Today is not signed yet. One missed day a week is forgiven; two in a row end the streak.",
            "question of the day: {q}",
            "Part of your day waits",
            "passport · {name}",
            "Days in a row: {n}",
            "Start your streak today",
            "Registered {date} · day {n} with us",
            "reading your days",
            "today signed",
            "sign today or the streak ends",
            "today not signed yet",
            "in a row",
            "{n} of 3",
            "Your Passport signs one public line. That line is your streak.",
            "From FLOP's faucet, once a day. Practice coins, no price.",
            "One question of the day, paid in FLOP.",
            "One press, all three steps in order. What is already done is skipped.",
            "devnet · practice network",
            "one key · two networks",
            "Seeker wallet",
            "Made the Passport with one signature. Brings it back on any phone.",
            "FLOP account",
            "The same key as a FLOP address. The faucet pays here; the model is paid from here.",
            "Registered",
            "Days in a row",
            "Best streak",
            "Signed days",
            "Balance, FLOP",
            "Spent on the model, FLOP",
            "1 skip left this week",
            "this week's skip is used",
            "details and key",
            "On Seeker · in FLOP Network · an app by Alex Kosa, not FLOP Labs, not Solana Mobile",
            "days signed together",
            "flop pulse",
            "Devnet is a practice network, open to everyone since 3 November. Coins have no price, there is no reward.",
            "more about the network",
            "thanks to both sides",
            "for Seeker, the wallet and one-tap signing",
            "for the network, the faucet and a model you can pay",
            "An independent app by Alex Kosa. No promises about tokens or rewards.",
            "check a link, an @name or an address someone sent you",
            "check",
            "FLOP model",
            "The model is small: short, plain questions work best. Everything you pay is practice FLOP.",
            "model open",
            "opening the model",
            "trial over for this account",
            "needs 1 flop",
            "model closed for now",
            "first question opens it",
            "ping {n} ms",
            "Your Passport signs a short statement from FLOP's gateway. Nothing moves. You need at least 1 FLOP; the faucet on Today gives you 25.",
            "more",
            "That was the last step. Your Passport is live, and your day on FLOP starts now.",
        )
        val missing = tables.flatMap { (lang, table) -> needed.filter { it !in table }.map { "$lang: $it" } }
        assertTrue(missing.joinToString("\n"), missing.isEmpty())
    }
}
