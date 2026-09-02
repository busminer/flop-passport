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

    const val CREDIT = "FLOP Passport for Seeker by @AlexKosa1"

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
    fun compose(did: String, contribution: String? = null, includeLink: Boolean = true): Draft =
        drafts(did, contribution, includeLink).firstOrNull { it.fits }
            ?: drafts(did, contribution, includeLink).last()

    /**
     * [contribution] is the user's own sentence about what they actually did.
     *
     * It matters more than everything else in the post. FLOP asked agents to "do
     * something useful"; measured on X, bare identity posts drew zero engagement while
     * the one post that landed was somebody shipping a tool. So when the user writes a
     * line, it goes first and the DID becomes the receipt underneath it. Left blank, the
     * post still works, it just says less.
     */
    fun drafts(
        did: String,
        contribution: String? = null,
        includeLink: Boolean = true,
    ): List<Draft> {
        val link = if (includeLink) noteUrl(did) else null
        val mine = contribution?.trim()?.takeIf { it.isNotEmpty() }

        fun build(vararg lines: String?) =
            lines.filterNotNull().joinToString("\n\n").trimEnd()

        val full = build(
            mine ?: "Created my FLOP Passport on a Solana Seeker.",
            "The identity is born inside Seed Vault and sealed by StrongBox on the phone.",
            did,
            "Identity note published, first check in signed and verified on Technocore.",
            link,
            CREDIT,
        )

        val medium = build(
            mine ?: "Created my FLOP Passport on a Solana Seeker.",
            "Key born in Seed Vault, sealed by StrongBox on device.",
            did,
            "Identity note published, first check in verified.",
            link,
            CREDIT,
        )

        val short = build(
            mine ?: "My FLOP Passport, created on a Solana Seeker.",
            did,
            "Identity note published, first check in verified on Technocore.",
            link,
            CREDIT,
        )

        val minimal = build(
            mine ?: "My FLOP Passport, created on a Solana Seeker.",
            did,
            link,
            CREDIT,
        )

        // Last resort: the DID and the credit are the two things that cannot be dropped,
        // because without the key the post proves nothing and without the credit it does
        // not point anyone at the app.
        val bare = build(mine, did, CREDIT)

        return listOf(
            Draft(full, "full", weightedLength(full)),
            Draft(medium, "medium", weightedLength(medium)),
            Draft(short, "short", weightedLength(short)),
            Draft(minimal, "minimal", weightedLength(minimal)),
            Draft(bare, "bare", weightedLength(bare)),
        )
    }

    /**
     * How many characters the user's own line may still use.
     *
     * The UI needs this to show a live counter and to say "trim 14 characters" instead of
     * letting someone write three sentences and then discover the post is unpostable. The
     * budget is measured against the smallest variant, which carries only their line, the
     * DID, the link and the credit - the four things that cannot be dropped.
     */
    fun contributionBudget(did: String, includeLink: Boolean = true): Int {
        // Measured rather than calculated: compose the smallest variant around a
        // one-character line and subtract that character. A hand-derived figure would
        // drift silently the first time any variant's wording changes.
        // The last variant, not compose(): compose returns the *largest* draft that fits,
        // so probing it would measure whichever variant happened to win and report a
        // budget far smaller than the one the fallback actually allows.
        val floor = drafts(did, contribution = "x", includeLink = includeLink).last()
        return LIMIT - (floor.weightedLength - 1)
    }

    /** True when this line still leaves a postable draft. */
    fun contributionFits(did: String, contribution: String?, includeLink: Boolean = true): Boolean =
        compose(did, contribution, includeLink).fits

    /**
     * The value written into the durable identity note.
     *
     * Two things decide the shape. Technocore's own convention for a DID note is
     * `key: value` fields - its mailbox convention is literally "a line like
     * `mailbox: <room>`" - so a machine reading someone's note, such as a credential-card
     * site, already knows how to pick fields out of it. And the note passes through the
     * same single-line sweep as a message, which turns every newline into a space, so the
     * fields live on one line whether we want them to or not. Writing this with line
     * breaks and assuming they survive is the kind of mistake that only shows up when
     * another tool fails to parse your note.
     *
     * This is also the part the community route leaves out. Both public FLOP tools end by
     * signing a record into a room, and every room is compacted, so within a day the link
     * between the DID and the X account is gone. Here it lives at a permanent address
     * derived from the key.
     */
    fun identityNoteValue(
        xPostUrl: String? = null,
        room: String? = null,
        contributionUrl: String? = null,
    ): String = buildString {
        append("agent: FLOP Passport for Seeker")
        if (!xPostUrl.isNullOrBlank()) append(" x: ").append(xPostUrl.trim())
        if (!room.isNullOrBlank()) append(" room: ").append(room.trim())
        if (!contributionUrl.isNullOrBlank()) append(" contribution: ").append(contributionUrl.trim())
    }
}
