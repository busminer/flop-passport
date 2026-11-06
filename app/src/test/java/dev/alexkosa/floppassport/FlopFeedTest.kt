package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.flop.FlopOfficial
import dev.alexkosa.floppassport.flop.FlopOfficial.Verdict
import dev.alexkosa.floppassport.flop.FlopStatus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * What the app reads from its own site, and the check that guards every link it shows.
 *
 * The site can be wrong or, at worst, taken over. These tests pin down that either way it
 * can only change words on a screen: it cannot replace a fresher built-in status with an
 * older one, and it cannot put a link in front of somebody that is not FLOP's.
 */
class FlopFeedTest {

    @Test fun statusReadsTheReadersLanguageAndFallsBackToEnglish() {
        val body = """
            {"updated":"2026-11-04","lines":[
              {"topic":"faucet","level":"good","title":{"en":"The faucet works","ru":"Кран работает"},
               "text":{"en":"Twenty-five a day."}}
            ]}
        """.trimIndent()
        val ru = FlopStatus.parse(body, "ru")!!
        assertTrue(ru.fromSite)
        assertEquals("Кран работает", ru.lines[0].title)
        assertEquals("Twenty-five a day.", ru.lines[0].text)
        assertEquals(FlopStatus.Level.Good, ru.lines[0].level)
        assertEquals("faucet", ru.lines[0].topic)
    }

    @Test fun anOlderSiteFileNeverOverridesTheBuild() {
        val body = """{"updated":"2026-11-01","lines":[{"title":"Old","text":"Old news"}]}"""
        assertNull(FlopStatus.parse(body))
    }

    @Test fun aBrokenSiteFileIsIgnored() {
        assertNull(FlopStatus.parse("<html>502</html>"))
        assertNull(FlopStatus.parse("""{"updated":"tomorrow","lines":[{"title":"a","text":"b"}]}"""))
        assertNull(FlopStatus.parse("""{"updated":"2026-11-05","lines":[]}"""))
        assertNull(FlopStatus.parse("""{"updated":"2026-11-05","lines":[{"title":"","text":"b"}]}"""))
    }

    @Test fun anUnknownLevelIsReadAsInfoAndTheFileIsCapped() {
        val many = (1..12).joinToString(",") { """{"title":"t$it","text":"x","level":"panic"}""" }
        val s = FlopStatus.parse("""{"updated":"2026-11-05","lines":[$many]}""")!!
        assertEquals(8, s.lines.size)
        assertTrue(s.lines.all { it.level == FlopStatus.Level.Info })
    }

    @Test fun theBuiltInStatusSaysTheFaucetWorks() {
        val faucet = FlopStatus.BUILT_IN.lines.single { it.topic == "faucet" }
        assertEquals(FlopStatus.Level.Good, faucet.level)
    }

    @Test fun theShippedSiteStatusIsReadable() {
        val file = java.io.File("../site/status.json").takeIf { it.exists() } ?: java.io.File("site/status.json")
        val s = FlopStatus.parse(file.readText(), "ru")
        assertTrue("site/status.json must parse and not be older than the build", s != null)
        assertTrue(s!!.lines.any { it.topic == "faucet" && it.level == FlopStatus.Level.Good })
    }

    @Test fun newsKeepsOnlyOfficialLinks() {
        val body = """
            {"items":[
              {"date":"2026-11-03","title":{"en":"Devnet is open","ru":"Девнет открыт"},"url":"https://x.com/flop_labs/status/1"},
              {"date":"2026-11-03","title":"Free FLOP here","url":"https://flop-finance.com/drop"},
              {"date":"2026-11-03","title":"Docs","url":"https://docs.flop.network/docs/official-links"},
              {"date":"2026-11-03","title":"Somebody else","url":"https://x.com/not_flop/status/2"},
              {"date":"2026-11-03","title":"Trick","url":"https://docs.flop.network@evil.example/x"}
            ]}
        """.trimIndent()
        val news = FlopOfficial.parseNews(body, "ru")
        assertEquals(listOf("Девнет открыт", "Docs"), news.map { it.title })
    }

    @Test fun newsSurvivesGarbage() {
        assertEquals(emptyList<FlopOfficial.News>(), FlopOfficial.parseNews("not json"))
        assertEquals(emptyList<FlopOfficial.News>(), FlopOfficial.parseNews("""{"items":"nope"}"""))
    }

    @Test fun theShippedNewsLinksAreAllOfficial() {
        val file = java.io.File("../site/news.json").takeIf { it.exists() } ?: java.io.File("site/news.json")
        val raw = org.json.JSONObject(file.readText()).getJSONArray("items").length()
        assertEquals("every item in site/news.json must survive the link check", raw, FlopOfficial.parseNews(file.readText()).size)
    }

    @Test fun theSiteFilesSpeakEveryLanguageTheAppDoes() {
        val langs = dev.alexkosa.floppassport.i18n.Lang.entries.map { it.code }
        fun file(name: String) = (java.io.File("../site/$name").takeIf { it.exists() } ?: java.io.File("site/$name")).readText()
        val status = org.json.JSONObject(file("status.json")).getJSONArray("lines")
        val news = org.json.JSONObject(file("news.json")).getJSONArray("items")
        val fields = (0 until status.length()).flatMap { i ->
            listOf(status.getJSONObject(i).getJSONObject("title"), status.getJSONObject(i).getJSONObject("text"))
        } + (0 until news.length()).map { news.getJSONObject(it).getJSONObject("title") }
        val missing = fields.flatMap { f -> langs.filter { f.optString(it).isBlank() }.map { "$it: ${f.optString("en").take(40)}" } }
        assertTrue(missing.joinToString("\n"), missing.isEmpty())
    }

    @Test fun lookalikesAreCaught() {
        assertEquals(Verdict.Official, FlopOfficial.check("https://flop.finance").verdict)
        assertEquals(Verdict.Official, FlopOfficial.check("docs.flop.network/docs").verdict)
        assertEquals(Verdict.Official, FlopOfficial.check("https://x.com/flop_labs").verdict)
        assertEquals(Verdict.Official, FlopOfficial.check("@flop_labs").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("https://flop.finance.example").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("flop-finance.com").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("https://x.com/flop_labs_airdrop").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("https://t.me/flopofficial").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("@flop_support").verdict)
        assertEquals(Verdict.NoTokenYet, FlopOfficial.check("flop presale today").verdict)
        assertEquals(Verdict.NoTokenYet, FlopOfficial.check("0x1234567890abcdef1234567890abcdef12345678").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("https://docs.flop.network@evil.example").verdict)
        assertEquals(Verdict.Unknown, FlopOfficial.check("").verdict)
    }

    @Test fun everySourceTheAppListsPassesItsOwnCheck() {
        FlopOfficial.SOURCES.forEach {
            assertEquals(it.url, Verdict.Official, FlopOfficial.check(it.url).verdict)
        }
    }

    @Test fun noReferralMeansNoBlock() {
        val body = """{"updated":"2026-11-05","lines":[{"title":"a","text":"b"}]}"""
        assertNull(FlopStatus.parse(body)!!.referral)
        assertNull(FlopStatus.parse(body.replace("{\"updated", "{\"referral\":\"\",\"updated"))!!.referral)
        assertNull(FlopStatus.BUILT_IN.referral)
    }

    @Test fun aReferralOnFlopsOwnDomainsIsKept() {
        val body = """{"updated":"2026-11-05","referral":" https://flop.finance/r/kosa?x=1 ","lines":[{"title":"a","text":"b"}]}"""
        assertEquals("https://flop.finance/r/kosa?x=1", FlopStatus.parse(body)!!.referral)
        assertEquals("https://app.flop.network/join", FlopStatus.safeReferral("https://app.flop.network/join"))
        assertEquals("flop.finance", FlopStatus.hostOf("https://flop.finance/r/kosa"))
    }

    @Test fun aReferralAnywhereElseIsRefused() {
        listOf(
            "http://flop.finance/r/kosa",
            "https://flop.finance.evil.com/r/kosa",
            "https://evilflop.finance/r/kosa",
            "https://flop.finance@evil.com/",
            "https://evil.com/flop.finance",
            "https://evil.com#flop.finance",
            "https://flop.finance:8443/r",
            "https://flop.finance\\@evil.com/",
            "https://FLOP.finance.evil.com/",
            "javascript:alert(1)",
            "intent://flop.finance#Intent;end",
            "flop.finance/r/kosa",
            "https://flop.finance/" + "a".repeat(300),
        ).forEach { assertNull(it, FlopStatus.safeReferral(it)) }
    }

    @Test fun aBadReferralLeavesTheStatusStanding() {
        val body = """{"updated":"2026-11-05","referral":"https://evil.com","lines":[{"title":"a","text":"b"}]}"""
        val s = FlopStatus.parse(body)!!
        assertNull(s.referral)
        assertEquals(1, s.lines.size)
    }
}
