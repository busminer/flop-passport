package dev.alexkosa.floppassport.proof

import dev.alexkosa.floppassport.crypto.DidKey

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

    /** The same credit at a size that survives when the rest of the post is long. */
    private const val CREDIT_SHORT = "FLOP Passport by @AlexKosa1"

    /**
     * Who this is about, and where it belongs.
     *
     * The handle was checked against the live account rather than typed from memory:
     * @flop_labs, "Flop Labs", a verified organisation. A post that tags the wrong account
     * is worse than one that tags nobody.
     *
     * The tags are what make a post findable by somebody who is not already following the
     * person who wrote it, which is the entire reason the post exists.
     */
    const val TAGS = "@flop_labs #FLOP #SolanaMobile"

    /** A shorter tail for drafts that have run out of room. */
    private const val TAGS_SHORT = "@flop_labs #FLOP"

    data class Draft(
        val text: String,
        val variant: String,
        val weightedLength: Int,
    ) {
        val fits: Boolean get() = weightedLength <= LIMIT
    }

    /**
     * One person's way of saying it.
     *
     * [opener] leads the post when the user wrote nothing of their own; their own line
     * always wins over it. [mechanism] is the sentence that makes somebody stop, and
     * [brief] is the same claim at a size that still fits when the rest is long.
     * [closer] is the specific technical reason the whole thing works, and it is the first
     * line dropped when space runs out.
     */
    data class Voice(
        val opener: String,
        val mechanism: String,
        val brief: String,
        val closer: String,
    )

    /**
     * Six of them, all saying something true and checkable, none saying anything about
     * what it earns.
     *
     * Written to open on the surprising part rather than on the announcement. "I created
     * my Passport" is news to nobody; "wipe this phone and the same identity comes back"
     * is a claim a reader can test, and the DID underneath is how they test it.
     */
    val VOICES: List<Voice> = listOf(
        Voice(
            opener = "My identity on Technocore. Stored nowhere, written down nowhere.",
            mechanism = "No seed phrase. My wallet signed one line in Seed Vault and the key came from it.",
            brief = "Derived from one Seed Vault signature. No seed phrase to lose.",
            closer = "It works only because Seed Vault signs the exact bytes it is handed.",
        ),
        Voice(
            opener = "Wipe this phone and the same identity comes back.",
            mechanism = "It is not stored. It is computed from one signature my wallet makes in Seed Vault.",
            brief = "Computed from one Seed Vault signature, not stored anywhere.",
            closer = "Same wallet, same sentence, same key. Every time, on any device.",
        ),
        Voice(
            opener = "Nothing here to back up, and nothing anyone can take away.",
            mechanism = "This key was not generated. It was derived from a single Seed Vault signature.",
            brief = "Not generated. Derived from a single Seed Vault signature.",
            closer = "Only possible because Seed Vault signs the exact bytes it is handed.",
        ),
        Voice(
            opener = "Anyone can check this key against what it signed. You included.",
            mechanism = "It came from one line my wallet signed inside Seed Vault. No seed phrase.",
            brief = "One line signed in Seed Vault, and that is the whole key.",
            closer = "Most wallets wrap a message first. Seed Vault signs it exactly as given.",
        ),
        Voice(
            opener = "A key that still proves I am the same person tomorrow.",
            mechanism = "Derived from one Seed Vault signature on my Seeker. Nothing written down.",
            brief = "One Seed Vault signature on a Seeker. Nothing written down.",
            closer = "Change one byte of that sentence and the key changes. That is the point.",
        ),
        Voice(
            opener = "Made my Technocore identity on a Solana Seeker.",
            mechanism = "One wallet signature inside Seed Vault, and the key falls out of it.",
            brief = "One wallet signature inside Seed Vault. That is the key.",
            closer = "Reproducible because Seed Vault signs exactly the bytes it is handed.",
        ),
    )

    /**
     * Which voice this identity speaks in.
     *
     * Taken from the key's own fingerprint rather than from a random number, so the draft
     * a person reads is the draft they send: a wording that reshuffles itself between
     * opening the screen and pressing the button is a wording nobody trusts. Two different
     * keys almost always land on different voices, which is the whole point.
     */
    fun voiceFor(did: String): Voice =
        VOICES[(DidKey.fingerprint(did).take(6).toLong(16) % VOICES.size).toInt()]


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
    fun compose(
        did: String,
        contribution: String? = null,
        includeLink: Boolean = true,
        voice: Voice = voiceFor(did),
    ): Draft =
        drafts(did, contribution, includeLink, voice).firstOrNull { it.fits }
            ?: drafts(did, contribution, includeLink, voice).last()

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
        /** Overridden only by the "say it another way" control, which walks the list. */
        voice: Voice = voiceFor(did),
    ): List<Draft> {
        val link = if (includeLink) noteUrl(did) else null
        val mine = contribution?.trim()?.takeIf { it.isNotEmpty() }

        fun build(vararg lines: String?) =
            lines.filterNotNull().joinToString("\n\n").trimEnd()

        // Two tails, because the tags cost real space and the post has a hard limit. The
        // long one names the app in full and carries both tags; the short one keeps the
        // account, the project and the credit, which are the three things that make the
        // post findable and attributable at all.
        val tail = CREDIT + "\n" + TAGS
        val tailShort = CREDIT_SHORT + " " + TAGS_SHORT

        // Descending by what it costs. The user's own line leads every one of them: it is
        // required before the post can be sent, so the openers below it exist to show
        // somebody what a good line looks like, not to stand in for one.
        val full = build(
            mine ?: voice.opener,
            voice.mechanism,
            did,
            link,
            tail,
        )

        val medium = build(
            mine ?: voice.opener,
            voice.brief,
            did,
            link,
            tail,
        )

        val short = build(
            mine ?: voice.opener,
            voice.brief,
            did,
            link,
            tailShort,
        )

        val minimal = build(
            mine ?: voice.opener,
            did,
            link,
            tailShort,
        )

        // Last resort: the DID and the credit are the two things that cannot be dropped,
        // because without the key the post proves nothing and without the credit it does
        // not point anyone at the app.
        val bare = build(mine, did, tailShort)

        return listOf(
            Draft(full, "full", weightedLength(full)),
            Draft(medium, "medium", weightedLength(medium)),
            Draft(short, "short", weightedLength(short)),
            Draft(minimal, "minimal", weightedLength(minimal)),
            Draft(bare, "bare", weightedLength(bare)),
        )
    }

    /**
     * Whether this line is something a person actually wrote.
     *
     * The app will not post without one. Not to be strict for its own sake: five thousand
     * posts whose only difference is a key read as one machine talking to itself, and the
     * people who would be hurt by that are the ones who did the work. One real sentence
     * about what they did is what separates a contributor from a bot, and it is the half
     * FLOP actually asked for.
     *
     * The rule is deliberately low, and it is script-aware. Most of the people this is
     * written for do not write in a language that puts spaces between words: a
     * word-counting rule would have accepted two lazy English words and rejected a
     * thoughtful Chinese sentence. So Han, kana and Hangul are counted by character, and
     * everything else by words as well as length.
     */
    fun isRealSentence(line: String?): Boolean {
        val text = line?.trim().orEmpty()
        if (text.isEmpty()) return false
        // Anything a machine would type to get past a check. Kept short on purpose: this
        // is a doormat, not a filter, and a long list would start rejecting real people.
        val filler = setOf("gm", "gn", "hi", "hello", "test", "hey", "ok", "flop", "done", "签到", "打卡")
        if (text.lowercase() in filler) return false
        val dense = text.any {
            it in '\u4e00'..'\u9fff' || it in '\u3040'..'\u30ff' || it in '\uac00'..'\ud7af'
        }
        if (dense) return text.count { !it.isWhitespace() } >= 8
        return text.length >= 20 && text.split(Regex("\\s+")).count { it.isNotBlank() } >= 4
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
    fun contributionFits(
        did: String,
        contribution: String?,
        includeLink: Boolean = true,
        voice: Voice = voiceFor(did),
    ): Boolean = compose(did, contribution, includeLink, voice).fits

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
