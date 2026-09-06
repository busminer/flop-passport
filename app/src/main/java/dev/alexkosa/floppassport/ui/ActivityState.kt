package dev.alexkosa.floppassport.ui

import dev.alexkosa.floppassport.notify.NoteLife
import dev.alexkosa.floppassport.technocore.DidNote

/**
 * What this Passport has actually done, as the server can still show it.
 *
 * The point of measuring it this way: Technocore compacts a room at 10 MiB down to half,
 * so a record is not permanent by default. A local counter would happily say "12 days
 * active" about twelve things nobody can find any more. Everything here is read back from
 * the service, so the number on screen is the number a stranger would get.
 *
 * There is deliberately no points system and no progress bar toward anything. FLOP asked
 * agents to do something useful; a score invented by this app would be a different,
 * made-up game, and inviting people to farm it would produce exactly the wall of identical
 * check-ins the public rooms are already drowning in.
 */
data class ActivityState(
    val checking: Boolean = false,
    val lastChecked: Long? = null,
    val error: String? = null,

    /** The durable identity note, or null when the service no longer returns one. */
    val noteValue: String? = null,

    /**
     * Whether the key has vouched for the note that is actually there.
     *
     * A note address is world-writable, so finding a note proves only that somebody wrote
     * one. FLOP's own instruction is to publish the note and then sign a line carrying its
     * hash; MATCHES means the two agree, CHANGED means the note was edited after signing
     * and should be ignored, MISSING means nothing has vouched for it either way.
     */
    val noteVerdict: DidNote.Verdict = DidNote.Verdict.MISSING,

    /** Our signed records still readable in the room, newest first. */
    val records: List<Record> = emptyList(),

    /**
     * Days since this phone last wrote the identity note, or [NoteLife.UNKNOWN].
     *
     * Measured from our own write rather than read off the server, because the service
     * publishes neither a last-write time nor a remaining TTL. That makes it a fact about
     * this phone: a note kept alive from a second device would show as unknown here, which
     * is the honest answer rather than a wrong number.
     */
    val daysSinceNoteWrite: Int = NoteLife.UNKNOWN,

    /**
     * Whole days of life the note has left, from the time remaining rather than the days
     * elapsed, or [NoteLife.UNKNOWN]. See [NoteLife.daysLeft] for why the two differ.
     */
    val noteDaysLeft: Int = NoteLife.UNKNOWN,
) {
    data class Record(
        val seq: Int,
        val nonce: String,
        val text: String,
        val timestamp: String,
        val room: String,
    ) {
        /** `2026-08-31` from an ISO timestamp, for grouping by day. */
        val day: String get() = timestamp.take(10)
    }

    val liveRecords: Int get() = records.size

    /** Distinct days on which this identity left something still readable. */
    val activeDays: Int get() = records.map { it.day }.distinct().size

    /**
     * Consecutive days ending today, counted only from records that survived.
     *
     * A streak is the one number worth showing, because it rewards coming back rather than
     * volume - and it goes down honestly when the service forgets something, which a
     * locally stored count never would.
     */
    fun streak(today: String): Int {
        val days = records.map { it.day }.distinct().sortedDescending()
        if (days.isEmpty()) return 0
        if (days.first() != today && days.first() != previousDay(today)) return 0

        var streak = 1
        var cursor = days.first()
        for (day in days.drop(1)) {
            if (day == previousDay(cursor)) {
                streak++
                cursor = day
            } else {
                break
            }
        }
        return streak
    }

    val checkedInToday: Boolean
        get() = records.any { it.day == todayUtc() }

    companion object {
        /**
         * UTC, not the phone's timezone. The server stamps records in UTC, so a phone in
         * UTC+13 would otherwise see its own evening as tomorrow and break its own streak.
         */
        fun todayUtc(): String = isoDay(System.currentTimeMillis())

        fun previousDay(day: String): String {
            val parts = day.split("-")
            if (parts.size != 3) return ""
            val cal = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"))
            cal.clear()
            cal.set(parts[0].toInt(), parts[1].toInt() - 1, parts[2].toInt())
            cal.add(java.util.Calendar.DAY_OF_MONTH, -1)
            return isoDay(cal.timeInMillis)
        }

        private fun isoDay(millis: Long): String {
            val fmt = java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US)
            fmt.timeZone = java.util.TimeZone.getTimeZone("UTC")
            return fmt.format(java.util.Date(millis))
        }
    }
}
