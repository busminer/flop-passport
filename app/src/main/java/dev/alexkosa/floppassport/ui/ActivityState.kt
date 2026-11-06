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
        /**
         * The calendar day this record belongs to, in the phone's own timezone.
         *
         * This used to slice the first ten characters off the server's stamp, which is
         * UTC. A record signed at one in the morning in Moscow therefore landed on the
         * previous day: the person had turned up two days running, the app showed one,
         * and the streak broke while they watched. Grouping by the day the person is
         * actually living in is the only version that matches what they remember doing.
         */
        val day: String get() = localDay(timestamp)
    }

    val liveRecords: Int get() = records.size

    /** Distinct days on which this identity left something still readable. */
    val activeDays: Int get() = records.map { it.day }.distinct().size

    /** Whether the forgiven day of this week is still there to be used. */
    fun skipLeft(today: String): Boolean =
        streakInfo(today).forgiven.none { daysBetween(today, it) < FORGIVE_WINDOW_DAYS }

    /** The last seven days, oldest first, with whether each was signed. */
    fun lastWeek(today: String): List<Pair<String, Boolean>> {
        val signed = records.map { it.day }.toSet()
        val days = generateSequence(today) { previousDay(it) }.take(7).toList().reversed()
        return days.map { it to (it in signed) }
    }

    /** The first day this identity left anything still readable: when the Passport began. */
    val firstDay: String? get() = records.minOfOrNull { it.day }

    /** Whole days from the first record to [today]; 0 before there is one. */
    fun daysWithFlop(today: String): Long = firstDay?.let { daysBetween(it, today) } ?: 0L

    /**
     * The longest streak this identity ever had, by the same rule as [streakInfo]: a one-day
     * hole is bridged at most once in any seven days. Never less than the streak running now.
     */
    fun bestStreak(today: String): Int {
        val days = records.map { it.day }.distinct().sorted()
        var best = 0
        var run = 0
        var previous: String? = null
        var forgiven: String? = null
        for (day in days) {
            val last = previous
            val gap = last?.let { daysBetween(it, day) }
            when {
                gap == 1L -> run++
                gap == 2L && forgiven.let { it == null || daysBetween(it, previousDay(day)) >= FORGIVE_WINDOW_DAYS } -> {
                    forgiven = previousDay(day)
                    run++
                }
                else -> {
                    run = 1
                    forgiven = null
                }
            }
            best = maxOf(best, run)
            previous = day
        }
        return maxOf(best, streak(today))
    }

    /**
     * Consecutive days ending today, counted only from records that survived.
     *
     * A streak is the one number worth showing, because it rewards coming back rather than
     * volume - and it goes down honestly when the service forgets something, which a
     * locally stored count never would.
     */
    fun streak(today: String): Int = streakInfo(today).days

    /**
     * The streak, with one missed day forgiven.
     *
     * Alex's decision of 19 October 2026, made against the live room: 163 people had lost a
     * streak to a single missed day, and forgiving one would have given 58 people a streak
     * of thirty or more instead of 21. So a one-day hole is bridged, at most once in any
     * seven days; two days missed in a row still end it. The missed day is not counted -
     * the number is still days a stranger can see a signed record for, it just no longer
     * falls to zero because somebody's phone was off on a Tuesday.
     */
    fun streakInfo(today: String): Streak {
        val days = records.map { it.day }.distinct().sortedDescending()
        if (days.isEmpty()) return Streak(0, emptyList(), atRisk = false)
        val yesterday = previousDay(today)
        val dayBefore = previousDay(yesterday)

        val forgiven = mutableListOf<String>()
        when (days.first()) {
            today, yesterday -> Unit
            // Yesterday was missed and today is still open: the streak is alive on the
            // strength of the forgiveness, and lives only if today is signed.
            dayBefore -> forgiven += yesterday
            else -> return Streak(0, emptyList(), atRisk = false)
        }

        var count = 1
        var cursor = days.first()
        for (day in days.drop(1)) {
            val expected = previousDay(cursor)
            if (day == expected) {
                count++
                cursor = day
                continue
            }
            val bridgeable = day == previousDay(expected) &&
                forgiven.none { daysBetween(expected, it) < FORGIVE_WINDOW_DAYS }
            if (!bridgeable) break
            forgiven += expected
            count++
            cursor = day
        }
        // Not signed today, and today cannot be forgiven: if yesterday was the forgiven
        // day, or the one before that was forgiven too recently, missing today ends it.
        val signedToday = days.first() == today
        val atRisk = !signedToday && forgiven.any { daysBetween(today, it) < FORGIVE_WINDOW_DAYS }
        return Streak(count, forgiven.sortedDescending(), atRisk)
    }

    /** [forgiven] are the missed days that were bridged, newest first. */
    data class Streak(val days: Int, val forgiven: List<String>, val atRisk: Boolean)

    val checkedInToday: Boolean
        get() = records.any { it.day == today() }

    /** The public room counted. Anyone can repeat this count. */
    data class Community(val passports: Int, val signedDays: Int, val signedToday: Int, val checkedAt: Long = 0)

    companion object {
        /** [lines] are (signer, server timestamp). One signer on one day counts once. */
        fun community(lines: List<Pair<String, String>>, today: String): Community {
            val pairs = lines.filter { it.first.isNotBlank() }.map { (who, ts) -> who to localDay(ts) }.toSet()
            return Community(
                passports = pairs.map { it.first }.distinct().size,
                signedDays = pairs.size,
                signedToday = pairs.count { it.second == today },
            )
        }

        /** One forgiven day per this many days. */
        const val FORGIVE_WINDOW_DAYS = 7

        /** Whole days from [earlier] to [later], both calendar dates. */
        fun daysBetween(earlier: String, later: String): Long = runCatching {
            kotlin.math.abs(
                java.time.temporal.ChronoUnit.DAYS.between(
                    java.time.LocalDate.parse(earlier),
                    java.time.LocalDate.parse(later),
                ),
            )
        }.getOrElse { Long.MAX_VALUE }

        /**
         * The phone's own calendar day, which is the one the person is living in.
         *
         * This was UTC, reasoning that the server stamps in UTC so the two would agree.
         * They agree only for somebody sitting on the meridian. Measured against the live
         * room on 23 September 2026: 14% of all check-ins land between 21:00 and 03:00
         * UTC, the window where a UTC day and a local day disagree, and 118 of 254 people
         * had at least one hole in their record. Both sides of every comparison are local
         * now - this and [Record.day] - so a day is a day wherever the person is, and the
         * two must be changed together or the streak compares one calendar against another.
         */
        fun today(): String = isoDay(System.currentTimeMillis())

        /** An instant from the server rendered as a calendar day where the phone is. */
        fun localDay(timestamp: String): String = runCatching {
            java.time.Instant.parse(timestamp)
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate()
                .toString()
        }.getOrElse { timestamp.take(10) }

        /**
         * Yesterday, as plain arithmetic on a calendar date.
         *
         * Deliberately not routed through [isoDay]: this is a date with no instant behind
         * it, and turning it into milliseconds to turn it back would re-apply a timezone
         * that was never in it.
         */
        fun previousDay(day: String): String = runCatching {
            java.time.LocalDate.parse(day).minusDays(1).toString()
        }.getOrElse { "" }

        private fun isoDay(millis: Long): String =
            java.time.Instant.ofEpochMilli(millis)
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate()
                .toString()
    }
}
