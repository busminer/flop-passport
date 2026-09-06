package dev.alexkosa.floppassport.proof

import android.content.Context

/**
 * What the person said they did, and where they said it.
 *
 * FLOP named two actions when it said agents would be rewarded at the airdrop: create a
 * unique `did:key`, and do something useful to spread the word about Technocore
 * (@flop_labs, 24 Aug 2026). The app has always done the first. This is the second half,
 * and the reason it is stored rather than typed once: the identity note is rewritten on
 * every launch to keep it from being deleted, so anything the note carries has to survive
 * in a form the app can rewrite without asking again.
 *
 * Kept beside the language and the reminder rather than in the vault. None of it is
 * secret - the whole point is that it ends up at a public address - and putting it in the
 * vault would mean unlocking key material to render a screen.
 *
 * Blank rather than absent is the normal state. A person who never writes a line still has
 * a working Passport; the note simply says less.
 */
class SharePrefs(context: Context) {
    private val prefs =
        context.getSharedPreferences("flop_passport_prefs", Context.MODE_PRIVATE)

    /** The person's own sentence about what they did. Goes first in the post. */
    var contributionLine: String
        get() = prefs.getString(KEY_LINE, "").orEmpty()
        set(value) = prefs.edit().putString(KEY_LINE, value.trim()).apply()

    /** A link to the thing they made, if there is one. */
    var contributionUrl: String
        get() = prefs.getString(KEY_CONTRIBUTION, "").orEmpty()
        set(value) = prefs.edit().putString(KEY_CONTRIBUTION, value.trim()).apply()

    /**
     * The post itself, once it exists.
     *
     * This is the field that turns a claim into a pair a stranger can check: the note
     * points at the post, the post carries the DID, and the same key is on both ends.
     * Rooms are trimmed within the hour, so a record saying "I posted this" disappears;
     * the note is at an address derived from the key and this app keeps it alive.
     */
    var xPostUrl: String
        get() = prefs.getString(KEY_X, "").orEmpty()
        set(value) = prefs.edit().putString(KEY_X, value.trim()).apply()

    /**
     * Forget everything about the person who used to hold this phone's Passport.
     *
     * Deleting a Passport used to leave the link to their post behind, so the next
     * identity - a different key, possibly a different wallet - published a note pointing
     * at a post that carries somebody else's DID, and the app read that note back and
     * called the sixth step finished. A new key with a stranger's receipt.
     */
    fun clear() {
        prefs.edit().remove(KEY_LINE).remove(KEY_CONTRIBUTION).remove(KEY_X).apply()
    }

    private companion object {
        const val KEY_LINE = "share_line"
        const val KEY_CONTRIBUTION = "share_contribution"
        const val KEY_X = "share_x_post"
    }
}

/**
 * Whether a string is a plausible link to a post on X, without pretending to validate it.
 *
 * Deliberately shallow. The app cannot check that a URL is really this person's post -
 * only a reader can, by opening it and finding the DID - so the check exists to catch a
 * paste that went wrong, not to grant anything. Anything host-shaped from x.com or
 * twitter.com with a path passes; everything else is refused with a sentence rather than
 * quietly written into a public note.
 */
fun looksLikeXPost(url: String): Boolean {
    val u = url.trim()
    if (u.isEmpty()) return false
    val m = Regex("""^https://(?:www\.)?(?:x|twitter)\.com/[^/\s]+/status/\d+""")
    return m.containsMatchIn(u)
}

/** The same shallow shape check for any link the person offers as their contribution. */
fun looksLikeUrl(url: String): Boolean {
    val u = url.trim()
    return u.isNotEmpty() && Regex("""^https://[^\s/]+\.[^\s/]+(/\S*)?$""").matches(u)
}
