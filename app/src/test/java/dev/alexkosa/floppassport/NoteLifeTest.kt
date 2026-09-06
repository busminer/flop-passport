package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.notify.NoteLife
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * The seven-day rule, pinned at every boundary.
 *
 * This is the arithmetic behind the one notification the app would be negligent not to
 * send, and its failure mode is silence: a bucket off by one day means somebody is told
 * their identity note is safe on the morning it is deleted. Nobody would report that as a
 * bug, because from the outside it looks exactly like an app that never nagged them.
 *
 * technocore.chat states the rule itself: "Rooms and notes with no write for 7 days are
 * deleted" — https://technocore.chat/llms.txt
 */
class NoteLifeTest {

    private val day = 24L * 60 * 60 * 1000
    private val now = 1_780_000_000_000L

    private fun since(days: Long) = NoteLife.daysSince(now - days * day, now)

    @Test
    fun `a day is a day, and part of one is not`() {
        assertEquals(0, since(0))
        assertEquals(NoteLife.UNKNOWN, NoteLife.daysSince(0L, now))
        // Just short of a full day still reads as the same day: the server measures
        // elapsed time, so rounding up here would warn people a day early, every day.
        assertEquals(0, NoteLife.daysSince(now - day + 1, now))
        assertEquals(1, NoteLife.daysSince(now - day, now))
    }

    @Test
    fun `a clock that went backwards does not silence the warning forever`() {
        // A phone whose time was corrected forward and then back must not produce a
        // negative age, which would fall through every bucket and warn nobody ever again.
        assertEquals(0, NoteLife.daysSince(now + 5 * day, now))
    }

    @Test
    fun `today's writer is left in peace`() {
        assertEquals(NoteLife.Urgency.SILENT, NoteLife.urgency(0))
    }

    @Test
    fun `the first three quiet days are a nudge, the last three are a warning`() {
        assertEquals(NoteLife.Urgency.NUDGE, NoteLife.urgency(1))
        assertEquals(NoteLife.Urgency.NUDGE, NoteLife.urgency(3))
        assertEquals(NoteLife.Urgency.WARNING, NoteLife.urgency(4))
        assertEquals(NoteLife.Urgency.WARNING, NoteLife.urgency(6))
    }

    @Test
    fun `the seventh day is the day it is gone, not the day before`() {
        assertEquals(NoteLife.Urgency.WARNING, NoteLife.urgency(NoteLife.TTL_DAYS - 1))
        assertEquals(NoteLife.Urgency.LOST, NoteLife.urgency(NoteLife.TTL_DAYS))
    }

    @Test
    fun `it stops saying it eventually, rather than notifying forever`() {
        // Somebody who walked away has heard the answer. Repeating it every morning until
        // they uninstall is not diligence, and the app cannot fix anything they are no
        // longer opening.
        assertEquals(NoteLife.Urgency.LOST, NoteLife.urgency(NoteLife.TTL_DAYS + 14))
        assertEquals(NoteLife.Urgency.SILENT, NoteLife.urgency(NoteLife.TTL_DAYS + 15))
        assertEquals(NoteLife.Urgency.SILENT, NoteLife.urgency(400))
    }

    @Test
    fun `an unknown last write is nudged rather than declared safe or lost`() {
        // Somebody who reinstalled, or restored onto a second phone, has a note this app
        // has never written. Claiming it is fresh would be a guess; claiming it is gone
        // would be a lie. The nudge brings them into the app, which renews it for real.
        assertEquals(NoteLife.Urgency.NUDGE, NoteLife.urgency(NoteLife.UNKNOWN))
    }

    @Test
    fun `the countdown names the right number of days`() {
        assertEquals("Three days left before it is deleted.", NoteLife.countdown(3))
        assertEquals("Two days left before it is deleted.", NoteLife.countdown(2))
        assertEquals("Tomorrow is the last day.", NoteLife.countdown(1))
        assertEquals(
            "Today is the last day. It is deleted within 24 hours unless you open the app.",
            NoteLife.countdown(0),
        )
    }

    @Test
    fun `every countdown sentence is distinct, so a translator cannot collapse them`() {
        val sentences = (0..3).map { NoteLife.countdown(it) }
        assertEquals(sentences.size, sentences.distinct().size)
        assertNotEquals(NoteLife.countdown(1), NoteLife.countdown(6))
    }

    @Test
    fun `days left counts the time remaining, not the days elapsed`() {
        val hour = 60L * 60 * 1000
        // Six days and twenty-three hours in: one hour of life left, which is "today",
        // never "tomorrow".
        assertEquals(0, NoteLife.daysLeft(now - 6 * day - 23 * hour, now))
        // Exactly six days in: a full day left, so tomorrow really is the last day.
        assertEquals(1, NoteLife.daysLeft(now - 6 * day, now))
        assertEquals(3, NoteLife.daysLeft(now - 4 * day, now))
        assertEquals(7, NoteLife.daysLeft(now, now))
        // Past the deadline the note is gone; the floor is zero, never negative.
        assertEquals(0, NoteLife.daysLeft(now - 9 * day, now))
        assertEquals(NoteLife.UNKNOWN, NoteLife.daysLeft(0L, now))
    }

    @Test
    fun `the morning-of-deletion case is told the truth`() {
        // Written at noon on day 0; the reminder fires at 11:00 on day 7.
        val written = now
        val reminder = now + 7 * day - 60L * 60 * 1000
        assertEquals(6, NoteLife.daysSince(written, reminder))
        assertEquals(NoteLife.Urgency.WARNING, NoteLife.urgency(NoteLife.daysSince(written, reminder)))
        assertEquals(
            "Today is the last day. It is deleted within 24 hours unless you open the app.",
            NoteLife.countdown(NoteLife.daysLeft(written, reminder)),
        )
    }
}
