package dev.alexkosa.floppassport.notify

import android.content.Context

/**
 * The seven-day rule, and the only place it is written down.
 *
 * Technocore is explicit about it in its own manual, and it is the single fact most
 * likely to quietly ruin somebody's Passport:
 *
 * > CAPACITY: ... Rooms and notes with no write for 7 days are deleted, and a room still
 * > on its single message goes after 12 hours.
 * > — https://technocore.chat/llms.txt
 *
 * So an identity note is not a thing you publish. It is a thing you keep alive. A person
 * who set their Passport up, saved the address and then had a busy fortnight comes back to
 * an empty address - and the app that told them to save it said nothing.
 *
 * Three consequences, all of them implemented rather than merely documented:
 *
 *  1. every check-in rewrites the note, so an active person never approaches the edge;
 *  2. opening the app rewrites it too, because turning up counts and costs one idempotent
 *     write;
 *  3. when neither has happened, the reminder stops being a nudge and starts counting
 *     down, in the person's own language, with the number of days they actually have.
 *
 * The clock is elapsed time, not calendar days, because that is what the server measures.
 * The moment it is measured from is our own last successful write, which is a fact about
 * this phone rather than a guess about the server: the service publishes no last-write
 * time and no remaining TTL, so a countdown derived from anything else would be invented.
 * Before the first recorded write it is [UNKNOWN], and code that does not know says so.
 */
object NoteLife {

    /** What the service deletes after, in days. Not ours to choose. */
    const val TTL_DAYS = 7

    /** No write has been recorded on this phone yet, so nothing here can be claimed. */
    const val UNKNOWN = -1

    private const val DAY_MILLIS = 24L * 60 * 60 * 1000
    private const val PREFS = "flop_passport_prefs"
    private const val KEY_LAST_WRITE = "note_last_write"

    /**
     * Remember that the note was just written, having read it back.
     *
     * Called only where the write was confirmed. Stamping this on a hopeful write would
     * turn a failed renewal into a silent seven-day countdown nobody is told about, which
     * is the exact failure this object exists to prevent.
     */
    fun recordWrite(context: Context, at: Long = System.currentTimeMillis()) {
        prefs(context).edit().putLong(KEY_LAST_WRITE, at).apply()
    }

    fun lastWrite(context: Context): Long = prefs(context).getLong(KEY_LAST_WRITE, 0L)

    /**
     * Forget when the note was last written.
     *
     * A deleted Passport leaves a timestamp that belongs to a key that no longer exists.
     * The next identity would inherit it, be told its brand-new note was "renewed today",
     * and skip the renewal that would have written it for the first time.
     */
    fun forget(context: Context) {
        prefs(context).edit().remove(KEY_LAST_WRITE).apply()
    }

    /**
     * Whole days elapsed between two instants, or [UNKNOWN] when there is no first one.
     *
     * Pure, and separate from the preference it usually reads, so the seven-day arithmetic
     * can be tested at every boundary without an Android context - the day the countdown
     * starts, the day it says "tomorrow", and the day it stops pretending.
     *
     * A clock that has gone backwards - a phone whose time was corrected, or a timezone
     * change that moved it - reads as zero rather than a negative age. Zero silences the
     * reminder for a day; a negative number would sail past every bucket and warn nobody.
     */
    fun daysSince(last: Long, now: Long): Int {
        if (last <= 0L) return UNKNOWN
        if (now < last) return 0
        return ((now - last) / DAY_MILLIS).toInt()
    }

    /** Whole days elapsed since the last confirmed write, or [UNKNOWN]. */
    fun daysSinceWrite(context: Context, now: Long = System.currentTimeMillis()): Int =
        daysSince(lastWrite(context), now)

    /** Whole days before the note is deleted, floored at zero, or [UNKNOWN]. */
    fun daysLeft(context: Context, now: Long = System.currentTimeMillis()): Int {
        val since = daysSinceWrite(context, now)
        if (since == UNKNOWN) return UNKNOWN
        return (TTL_DAYS - since).coerceAtLeast(0)
    }

    /**
     * How loudly to speak today.
     *
     * Deliberately coarse. A person does not need a percentage; they need to know whether
     * this is a nudge they can ignore until tonight or the last day they have.
     */
    enum class Urgency {
        /** Nothing to say: today's write is already done, or nothing exists to protect. */
        SILENT,

        /** Days in hand. A plain reminder, at the ordinary importance. */
        NUDGE,

        /** Three days or fewer. Said louder, and it names the deadline. */
        WARNING,

        /** Past seven days. The note is gone, and the honest thing is to say so. */
        LOST,
    }

    /**
     * How long to keep saying the note is gone before accepting the answer.
     *
     * A daily notification that never stops is how an app gets uninstalled, and it would
     * be the same sentence every morning to somebody who has already decided. Two weeks is
     * long enough to catch a holiday and short enough not to become furniture. After that
     * the app goes quiet and waits to be opened, which is the only thing that would change
     * the situation anyway.
     */
    private const val GIVE_UP_AFTER_DAYS = TTL_DAYS + 14

    fun urgency(daysSince: Int): Urgency = when {
        daysSince == UNKNOWN -> Urgency.NUDGE
        daysSince <= 0 -> Urgency.SILENT
        daysSince > GIVE_UP_AFTER_DAYS -> Urgency.SILENT
        daysSince >= TTL_DAYS -> Urgency.LOST
        daysSince >= TTL_DAYS - 3 -> Urgency.WARNING
        else -> Urgency.NUDGE
    }

    /**
     * The countdown sentence, one fixed sentence per day rather than a number spliced into
     * a template.
     *
     * Eleven languages with four different plural systems between them; "%d days left"
     * translated once is wrong in Russian on the second day and wrong in Arabic on most of
     * them. Whole sentences are more strings to carry and exactly right in every one.
     */
    fun countdown(daysSince: Int): String = when (TTL_DAYS - daysSince) {
        3 -> "Three days left before it is deleted."
        2 -> "Two days left before it is deleted."
        1 -> "Tomorrow is the last day."
        else -> "It will be deleted after seven days without a record."
    }

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
}
