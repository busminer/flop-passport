package dev.alexkosa.flooppassport.proof

import dev.alexkosa.flooppassport.crypto.DidKey

/**
 * Builds the X post a user publishes to link their public account to their Passport.
 *
 * Why the app writes this at all: the community route that FLOP contributors already
 * follow ends with a public post carrying the DID, and doing it by hand is where people
 * break their own proof - a DID copied out of a screenshot is usually corrupt, and a post
 * that runs past the limit gets truncated in the middle of the key.
 *
 * Three rules shape the text:
 *
 *  - **The DID is never abbreviated.** A shortened key cannot be verified by anyone, which
 *    defeats the only purpose of the post.
 *  - **It reads like a person wrote it.** Short lines, blank lines between them, no
 *    em-dashes, no marketing punctuation. A post that looks generated gets treated as
 *    farming, and the rooms are already full of that.
 *  - **It never claims an allocation.** It says what happened, which is verifiable, and
 *    stops.
 */
object PostComposer {

    /** X counts every link as this many characters regardless of its real length. */
    private const val URL_WEIGHT = 23
    const val LIMIT = 280

    const val CREDIT = "FLOOP Passport for Seeker by @AlexKosa1"

    data class Draft(
        val text: String,
        val variant: String,
        val weightedLength: Int,
    ) {
        val fits: Boolean get() = weightedLength <= LIMIT
    }

    /**
     * X's counting, not Kotlin's: a URL always costs 23 whatever its true length, so a
     * draft that looks over the limit locally can be comfortably inside it, and a draft
     * built without this rule wastes the space that would have carried the proof link.
     */
    fun weightedLength(text: String): Int {
        val urls = Regex("""https?://\S+""").findAll(text).toList()
        val urlChars = urls.sumOf { it.value.length }
        return text.length - urlChars + urls.size * URL_WEIGHT
    }

    /**
     * The verification link is the identity note, not a room message.
     *
     * Rooms are trimmed - a check-in in a busy room is unreadable within the hour - while
     * notes are durable and live at a path derived from the DID itself. So the one link
     * worth putting in a post that outlives today is the note.
     */
    fun noteUrl(did: String, base: String = "https://technocore.chat"): String =
        base + DidKey.notePath(did)

    /**
     * Longest variant that fits, in descending order of what it says. Callers can also
     * offer the list so the user picks.
     */
    fun compose(did: String, includeLink: Boolean = true): Draft =
        drafts(did, includeLink).firstOrNull { it.fits }
            ?: drafts(did, includeLink).last()

    fun drafts(did: String, includeLink: Boolean = true): List<Draft> {
        val link = if (includeLink) noteUrl(did) else null

        fun build(vararg lines: String?) =
            lines.filterNotNull().joinToString("\n\n").trimEnd()

        val full = build(
            "Created my FLOP Passport on a Solana Seeker.",
            "The identity is born inside Seed Vault and sealed by StrongBox on the phone.",
            did,
            "Identity note published, first check in signed and verified on Technocore.",
            link,
            CREDIT,
        )

        val medium = build(
            "Created my FLOP Passport on a Solana Seeker.",
            "Key born in Seed Vault, sealed by StrongBox on device.",
            did,
            "Identity note published, first check in verified.",
            link,
            CREDIT,
        )

        val short = build(
            "My FLOP Passport, created on a Solana Seeker.",
            did,
            "Identity note published, first check in verified on Technocore.",
            link,
            CREDIT,
        )

        val minimal = build(
            "My FLOP Passport, created on a Solana Seeker.",
            did,
            link,
            CREDIT,
        )

        // Last resort: the DID and the credit are the two things that cannot be dropped,
        // because without the key the post proves nothing and without the credit it does
        // not point anyone at the app.
        val bare = build(did, CREDIT)

        return listOf(
            Draft(full, "full", weightedLength(full)),
            Draft(medium, "medium", weightedLength(medium)),
            Draft(short, "short", weightedLength(short)),
            Draft(minimal, "minimal", weightedLength(minimal)),
            Draft(bare, "bare", weightedLength(bare)),
        )
    }

    /**
     * The value written into the durable identity note once the user has posted.
     *
     * This is the part the community route leaves out. Everyone ends by posting a signed
     * record into a room, and every room is trimmed, so within a day the link between the
     * DID and the X account is gone. Writing it into the note instead puts it at a
     * permanent address derived from the key, where anyone - including a card site that
     * already reads profile notes - can find it later.
     */
    fun identityNoteValue(xPostUrl: String?): String = buildString {
        append("FLOOP Passport for Seeker")
        if (!xPostUrl.isNullOrBlank()) {
            append(" | x: ")
            append(xPostUrl.trim())
        }
    }
}
