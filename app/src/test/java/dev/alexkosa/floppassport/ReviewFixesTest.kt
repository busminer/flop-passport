package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.flop.FlopFaucet
import dev.alexkosa.floppassport.flop.FlopGateway
import dev.alexkosa.floppassport.flop.FlopOfficial
import dev.alexkosa.floppassport.flop.FlopOfficial.Verdict
import dev.alexkosa.floppassport.i18n.Lang
import dev.alexkosa.floppassport.i18n.Translator
import dev.alexkosa.floppassport.technocore.Canonical
import dev.alexkosa.floppassport.ui.FlopViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/** What the review before the 2.0 release found, held in place. */
class ReviewFixesTest {

    private val me = "5FcqBspY6ioVRoHumDxaLtQHi9qQYPb8FRZRmK6brFM21Vir"

    /** The challenge api.flop.network sent for this address on 3 November 2026. */
    private val realChallenge =
        "api.flop.network wants you to enroll a FLOP devnet gateway key with your account:\n" +
            "$me\n\nAction: flop-devnet-enroll/v1\n" +
            "Genesis: 0x99c172c095340ace980631f9123544c6bebd4839f3437e463533422d8be2d631\n" +
            "Nonce: b8c24f7c376e9d6de3de9590c1df633d900013da3f2b4fc3ed3ff59b08bca988\n" +
            "Issued At: 2026-11-03T14:56:24.504Z\nExpiration Time: 2026-11-03T15:01:24.504Z"

    @Test fun theRealChallengeIsSigned() {
        assertTrue(FlopGateway.isEnrollStatement(realChallenge, me))
    }

    @Test fun aRecordOrNoteDressedAsAChallengeIsNot() {
        val record = Canonical.messagePayload("flop-passport", "123", "did:key:z6Mk… checked in")
        val note = Canonical.notePayload("did-note", "z6Mk", "1", "anything")
        assertFalse(FlopGateway.isEnrollStatement(record, me))
        assertFalse(FlopGateway.isEnrollStatement(note, me))
        // Even with the right opening, a payload carrying a record's separators is refused.
        assertFalse(FlopGateway.isEnrollStatement(realChallenge + "\nflop-passport|1|x", me))
    }

    @Test fun aChallengeForSomebodyElseIsNotSigned() {
        val other = "5DZsAQuavUAM7A6XvoTkDQgtQdRCMcALdUd6Bx4FSoFMF8ux"
        assertFalse(FlopGateway.isEnrollStatement(realChallenge, other))
        assertFalse(FlopGateway.isEnrollStatement(realChallenge.replace("Action: flop-devnet-enroll/v1", "Action: transfer"), me))
        assertFalse(FlopGateway.isEnrollStatement(realChallenge + "x".repeat(3_000), me))
    }

    @Test fun expiryIsReadInMillisecondsWhateverTheGatewaySends() {
        assertEquals(1_793_718_084_504L, FlopGateway.expiryMillis(1_793_718_084_504L))
        assertEquals(1_793_718_084_000L, FlopGateway.expiryMillis(1_793_718_084L))
        assertEquals(0L, FlopGateway.expiryMillis(null))
        assertEquals(0L, FlopGateway.expiryMillis(org.json.JSONObject.NULL))
        assertEquals(0L, FlopGateway.expiryMillis(-5))
        assertEquals(1_793_718_084_504L, FlopGateway.expiryMillis("1793718084504"))
    }

    @Test fun aCostThatIsNotANumberIsNoCost() {
        assertNull(FlopGateway.number(null))
        assertNull(FlopGateway.number(org.json.JSONObject.NULL))
        assertNull(FlopGateway.number(Double.NaN))
        assertNull(FlopGateway.number("n/a"))
        assertEquals(0.012, FlopGateway.number("0.012")!!, 1e-12)
        assertEquals(1.5, FlopGateway.number(1.5)!!, 1e-12)
    }

    @Test fun onlyTheAddressCooldownCountsAsAlreadyFunded() {
        val said = "Address funded recently; retry in 1337 min"
        assertTrue(FlopFaucet.isAddressCooldown(429, said))
        assertEquals(1337, FlopFaucet.retryMinutes(said))
        assertFalse(FlopFaucet.isAddressCooldown(429, "Too many requests from this IP"))
        assertFalse(FlopFaucet.isAddressCooldown(429, "Daily IP limit reached"))
        assertFalse(FlopFaucet.isAddressCooldown(503, said))
        assertNull(FlopFaucet.retryMinutes("Too many requests"))
        assertNull(FlopFaucet.retryMinutes("retry in 99999 min"))
    }

    @Test fun theFaucetsOtherRefusalsAreNotMistakenForAnOutageOrACooldown() {
        val pending = "Grant pending; retry the original request later"
        val cap = "Faucet daily cap reached; try again later"
        assertTrue(FlopFaucet.isGrantPending(pending))
        assertFalse(FlopFaucet.isGrantPending(cap))
        assertTrue(FlopFaucet.isDailyCap(cap))
        assertFalse(FlopFaucet.isDailyCap(pending))
        assertFalse(FlopFaucet.isAddressCooldown(429, cap))
        assertFalse(FlopFaucet.isAddressCooldown(503, pending))
        assertTrue(FlopFaucet.stillWaiting(null))
        assertTrue(FlopFaucet.stillWaiting(FlopFaucet.Result.Refused(503, pending)))
        assertFalse(FlopFaucet.stillWaiting(FlopFaucet.Result.Refused(429, cap)))
        assertFalse(FlopFaucet.stillWaiting(FlopFaucet.Result.Funded("25", null)))
    }

    @Test fun linksAreJudgedAsTheBrowserWouldOpenThem() {
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("https://x.com/flop_labs/../fake_flop").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("https://github.com/flop-labs/../evil").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("http://flop.finance/airdrop-and-testnet").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("intent://flop.finance/x").verdict)
        assertEquals(Verdict.NotOfficial, FlopOfficial.check("https://user@flop.finance/airdrop").verdict)
        assertEquals(Verdict.Official, FlopOfficial.check("https://x.com/flop_labs/status/1").verdict)
        assertEquals(Verdict.Official, FlopOfficial.check("https://docs.flop.network/docs/./official-links").verdict)
    }

    @Test fun yesterdaysRunDoesNotCountAsToday() {
        val run = FlopViewModel.DayRun(date = "2026-11-03")
        assertTrue(run.isFor("2026-11-03"))
        assertFalse(run.isFor("2026-11-04"))
        // A run that crosses midnight is still the one on screen.
        assertTrue(run.copy(running = true).isFor("2026-11-04"))
    }

    @Test fun theRunningStepIsNumberedFromOne() {
        val waiting = FlopViewModel.DayStep.entries.associateWith<FlopViewModel.DayStep, FlopViewModel.DayResult> { FlopViewModel.DayResult.Waiting }
        assertEquals(0, FlopViewModel.DayRun(steps = waiting).stepNumber)
        val second = waiting + (FlopViewModel.DayStep.Fund to FlopViewModel.DayResult.Running)
        assertEquals(2, FlopViewModel.DayRun(steps = second).stepNumber)
    }

    @Test fun theStatusCountsUpAndTheNextTryCountsDown() {
        val live = FlopViewModel.Live(FlopViewModel.Stage.Full, since = 10_000, nextAt = 40_000, waitMs = 30_000)
        assertEquals(5L, live.secondsSoFar(15_400))
        assertEquals(25L, live.secondsToNext(15_000))
        assertEquals(1L, live.secondsToNext(39_500))
        assertEquals(0L, live.secondsToNext(90_000))
        assertNull(FlopViewModel.Live(FlopViewModel.Stage.Model, since = 10_000).secondsToNext(15_000))
        assertEquals(0.5f, live.waitLeft(25_000)!!, 0.001f)
        assertNull(FlopViewModel.Live(FlopViewModel.Stage.Model).waitLeft(25_000))
        assertEquals(0L, live.secondsSoFar(1_000))
    }

    @Test fun aSentenceFinishedWithTheServersWordsIsStillTranslated() {
        val ru = Translator(Lang.RU)
        assertEquals("Кран отказал: Bad address", ru("The faucet said no: Bad address"))
        assertEquals("Модель не ответила: HTTP 500", ru("The model did not answer: HTTP 500"))
        // An exact key still wins over the template, and English stays English.
        assertEquals(dev.alexkosa.floppassport.i18n.RU_STRINGS.getValue("The model did not answer."), ru("The model did not answer."))
        assertEquals("The faucet said no: x", Translator(Lang.EN)("The faucet said no: x"))
    }
}
