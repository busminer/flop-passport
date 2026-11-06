package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.ui.ActivityState
import java.util.TimeZone
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * The streak, which had no tests at all until it started losing people's days.
 *
 * Reported on 23 September 2026 by two users who were certain they had turned up every
 * day. They had. The count was grouping their records by UTC calendar day while they
 * lived three hours east of it, so an evening check-in landed on the day before and the
 * day it belonged to came back empty.
 *
 * Every test here fixes the timezone first. A streak test that runs in whatever zone the
 * build machine happens to be in is exactly the test that would have passed in London and
 * failed nowhere anybody looked.
 */
class StreakTest {

    private val original: TimeZone = TimeZone.getDefault()

    @Before
    fun moscow() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"))
    }

    @After
    fun restore() {
        TimeZone.setDefault(original)
    }

    private fun record(timestamp: String, seq: Int = 1) = ActivityState.Record(
        seq = seq,
        nonce = "n$seq",
        text = "FLOP Passport for Seeker. Signed record.",
        timestamp = timestamp,
        room = "flop-passport",
    )

    /** Alex's own days, as the public room held them on 4 November 2026. */
    private val alexsDays = listOf(
        "09-05", "09-06", "09-07", "09-10", "09-11", "09-12", "09-13", "09-14", "09-15", "09-17",
        "09-18", "09-19", "09-23", "09-24", "09-25", "09-28", "09-30", "11-03", "11-04",
    )

    private fun alex() = ActivityState(
        records = alexsDays.mapIndexed { i, d -> record("2026-${d}T07:00:00.000000Z", i + 1) },
    )

    @Test
    fun `the real room gives the numbers a person would count by hand`() {
        val a = alex()
        assertEquals(2, a.streak("2026-11-04"))
        assertEquals("2026-09-05", a.firstDay)
        assertEquals(60L, a.daysWithFlop("2026-11-04"))
        assertEquals(19, a.activeDays)
        // 10 to 15 September, the 16th forgiven, then 17 to 19: nine signed days.
        assertEquals(9, a.bestStreak("2026-11-04"))
    }

    @Test
    fun `the week and the community are counted the way a stranger would`() {
        val week = alex().lastWeek("2026-11-04")
        assertEquals(7, week.size)
        assertEquals("2026-10-29" to false, week.first())
        assertEquals("2026-11-04" to true, week.last())
        assertTrue(alex().skipLeft("2026-11-04"))
        val c = ActivityState.community(
            listOf(
                "a" to "2026-11-03T07:00:00.000000Z",
                "a" to "2026-11-03T08:00:00.000000Z",
                "a" to "2026-11-04T07:00:00.000000Z",
                "b" to "2026-11-04T07:00:00.000000Z",
                "" to "2026-11-04T07:00:00.000000Z",
            ),
            "2026-11-04",
        )
        assertEquals(2, c.passports)
        assertEquals(3, c.signedDays)
        assertEquals(2, c.signedToday)
    }

    @Test
    fun `the best streak is never below the one running now and is zero with no days`() {
        assertEquals(0, ActivityState().bestStreak("2026-11-04"))
        assertEquals(null, ActivityState().firstDay)
        val a = alex()
        assertTrue(a.bestStreak("2026-11-04") >= a.streak("2026-11-04"))
    }

    @Test
    fun `a second hole inside seven days is not forgiven in the best streak either`() {
        val a = ActivityState(
            records = listOf("10-01", "10-02", "10-04", "10-05", "10-07").mapIndexed { i, d ->
                record("2026-${d}T07:00:00.000000Z", i + 1)
            },
        )
        assertEquals(4, a.bestStreak("2026-11-04"))
    }

    @Test
    fun `a record belongs to the day the person was living in`() {
        // 22:00 UTC on the 21st is one in the morning on the 22nd in Moscow.
        assertEquals("2026-09-22", record("2026-09-21T22:00:00.000000Z").day)
        assertEquals("2026-09-21", record("2026-09-21T07:00:00.000000Z").day)
    }

    @Test
    fun `three days running stay three days when one of them is signed at night`() {
        // The exact shape that broke: Monday morning, Tuesday just after midnight, then
        // Wednesday morning. Sliced as UTC the middle one falls back onto Monday, Tuesday
        // reads as missed, and a person who turned up three days running is told one.
        val state = ActivityState(
            records = listOf(
                record("2026-09-23T07:00:00.000000Z", seq = 3),
                record("2026-09-21T22:00:00.000000Z", seq = 2),
                record("2026-09-21T07:00:00.000000Z", seq = 1),
            ),
        )
        assertEquals(3, state.streak("2026-09-23"))
        assertEquals(3, state.activeDays)
    }

    @Test
    fun `one missed day is forgiven and not counted`() {
        // Alex's rule of 19 October: a single hole no longer ends a streak. The missed
        // day is bridged, not invented - the count is still days with a signed record.
        val state = ActivityState(
            records = listOf(
                record("2026-09-23T07:00:00.000000Z", seq = 2),
                record("2026-09-21T07:00:00.000000Z", seq = 1),
            ),
        )
        val streak = state.streakInfo("2026-09-23")
        assertEquals(2, streak.days)
        assertEquals(listOf("2026-09-22"), streak.forgiven)
    }

    @Test
    fun `two missed days in a row still break it`() {
        val state = ActivityState(
            records = listOf(
                record("2026-09-23T07:00:00.000000Z", seq = 2),
                record("2026-09-20T07:00:00.000000Z", seq = 1),
            ),
        )
        assertEquals(1, state.streak("2026-09-23"))
    }

    @Test
    fun `only one day is forgiven in any seven`() {
        // 10, 12, 14: the hole on 13 is bridged, the hole on 11 is too close to it.
        val state = ActivityState(
            records = listOf(
                record("2026-09-14T07:00:00.000000Z", seq = 3),
                record("2026-09-12T07:00:00.000000Z", seq = 2),
                record("2026-09-10T07:00:00.000000Z", seq = 1),
            ),
        )
        val streak = state.streakInfo("2026-09-14")
        assertEquals(2, streak.days)
        assertEquals(listOf("2026-09-13"), streak.forgiven)
    }

    @Test
    fun `a second hole a week later is forgiven again`() {
        val days = listOf("01", "02", "04", "05", "06", "07", "08", "09", "10", "12")
        val state = ActivityState(
            records = days.mapIndexed { i, d -> record("2026-09-${d}T07:00:00.000000Z", seq = i + 1) },
        )
        val streak = state.streakInfo("2026-09-12")
        assertEquals(10, streak.days)
        assertEquals(listOf("2026-09-11", "2026-09-03"), streak.forgiven)
    }

    @Test
    fun `a streak that used yesterday's forgiveness is at risk until today is signed`() {
        val state = ActivityState(
            records = listOf(
                record("2026-09-21T07:00:00.000000Z", seq = 2),
                record("2026-09-20T07:00:00.000000Z", seq = 1),
            ),
        )
        val streak = state.streakInfo("2026-09-23")
        assertEquals(2, streak.days)
        assertTrue(streak.atRisk)
    }

    @Test
    fun `a clean streak not yet signed today is not at risk`() {
        val state = ActivityState(records = listOf(record("2026-09-22T07:00:00.000000Z")))
        assertFalse(state.streakInfo("2026-09-23").atRisk)
    }

    @Test
    fun `yesterday still counts, so the streak does not vanish before today is signed`() {
        val state = ActivityState(records = listOf(record("2026-09-22T07:00:00.000000Z")))
        assertEquals(1, state.streak("2026-09-23"))
    }

    @Test
    fun `three days ago does not count`() {
        val state = ActivityState(records = listOf(record("2026-09-20T07:00:00.000000Z")))
        assertEquals(0, state.streak("2026-09-23"))
    }

    @Test
    fun `no records is no streak`() {
        assertEquals(0, ActivityState().streak("2026-09-23"))
    }

    @Test
    fun `signing twice in one local day is still one day`() {
        val state = ActivityState(
            records = listOf(
                record("2026-09-23T18:00:00.000000Z", seq = 2),
                record("2026-09-23T07:00:00.000000Z", seq = 1),
            ),
        )
        assertEquals(1, state.streak("2026-09-23"))
        assertEquals(1, state.activeDays)
        assertEquals(2, state.liveRecords)
    }

    @Test
    fun `checked in today reads the phone's day, not the server's`() {
        // 23:30 UTC is already tomorrow morning in Moscow, and the person who signed it
        // has signed today.
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"))
        val night = record("2026-09-22T23:30:00.000000Z")
        assertEquals("2026-09-23", night.day)
        assertFalse(ActivityState().checkedInToday)
    }

    @Test
    fun `previous day walks back over a month and a year`() {
        assertEquals("2026-09-22", ActivityState.previousDay("2026-09-23"))
        assertEquals("2026-08-31", ActivityState.previousDay("2026-09-01"))
        assertEquals("2025-12-31", ActivityState.previousDay("2026-01-01"))
        // A leap year, because February is where date arithmetic goes to die.
        assertEquals("2024-02-29", ActivityState.previousDay("2024-03-01"))
    }

    @Test
    fun `previous day refuses nonsense rather than guessing`() {
        assertEquals("", ActivityState.previousDay("not a date"))
        assertEquals("", ActivityState.previousDay(""))
    }

    @Test
    fun `an unparsable stamp falls back to its first ten characters`() {
        // The server has never sent one, and if it ever does the day is still readable
        // rather than the screen being empty.
        assertEquals("2026-09-21", record("2026-09-21 broken").day)
    }

    @Test
    fun `the day the app signs is the day it groups by`() {
        // The text carries a date and the streak reads the stamp. If these two ever
        // disagree the record is filed under a day its own words deny.
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"))
        val today = ActivityState.today()
        assertTrue(today.matches(Regex("\\d{4}-\\d{2}-\\d{2}")))
        assertEquals(today, ActivityState.localDay(java.time.Instant.now().toString()))
    }
}
