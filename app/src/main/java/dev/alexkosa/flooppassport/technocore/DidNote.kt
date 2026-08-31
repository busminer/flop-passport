package dev.alexkosa.flooppassport.technocore

import dev.alexkosa.flooppassport.crypto.DidKey
import java.security.MessageDigest

/**
 * The `did-note` line, exactly as FLOP Labs published it.
 *
 * A DID note lives in a world-writable namespace: the key signs the *message*, not the
 * note, so anyone can overwrite anyone's profile. FLOP named the problem and gave the fix
 * in the same post (@flop_labs, 21 Aug 2026):
 *
 * > Until the note itself is a signed write, do this: treat the profile note as a cache.
 * > Publish it, then post a signed line `did-note <fp> <sha256 of the body>`. Check the
 * > line against the key. If the note's hash no longer matches, ignore it. No registrar.
 *
 * So: the note stays a convenience, and this line is the part that carries the key's word.
 * A reader who finds a note, finds this line, and sees the hashes agree knows the holder
 * of the key vouched for that exact text. If they disagree, the note was changed by
 * somebody else and should be ignored — which is a far more useful answer than "a note
 * exists".
 *
 * The server neither knows nor enforces this. It is a convention, and it works only
 * because both sides compute the same bytes, which is why this is one small object with
 * one test rather than a line built inline somewhere.
 */
object DidNote {

    const val PREFIX = "did-note"

    /**
     * SHA-256 of the note body, lowercase hex.
     *
     * The body means exactly the bytes the server stores and returns — after its
     * single-line sweep, and with the untrusted-content banner already stripped. Hashing
     * what we *sent* rather than what is *stored* would produce a line that never matches
     * for any note whose text the sweep touched.
     */
    fun hashOf(noteBody: String): String =
        MessageDigest.getInstance("SHA-256")
            .digest(noteBody.toByteArray(Charsets.UTF_8))
            .joinToString("") { "%02x".format(it) }

    /** `did-note <fingerprint> <sha256>` — the line to sign and post. */
    fun line(did: String, noteBody: String): String =
        "$PREFIX ${DidKey.fingerprint(did)} ${hashOf(noteBody)}"

    private val LINE = Regex("""^did-note\s+([0-9a-f]{16})\s+([0-9a-f]{64})$""")

    data class Parsed(val fingerprint: String, val hash: String)

    /**
     * Read a `did-note` line, or null.
     *
     * Fails closed on anything that is not exactly the shape: a 16-character fingerprint
     * and a 64-character hash, both lowercase hex. A near-miss is not treated as a
     * near-match, because the whole value of this line is that it either agrees or it
     * does not.
     */
    fun parse(text: String): Parsed? =
        LINE.find(text.trim())?.let { Parsed(it.groupValues[1], it.groupValues[2]) }

    enum class Verdict {
        /** The key vouched for exactly this note text. */
        MATCHES,

        /** A line exists but the note has changed since. Treat the note as untrusted. */
        CHANGED,

        /** No line found. The note is a plain claim, which is what it always was. */
        MISSING,
    }

    /**
     * Compare a note against the most recent `did-note` line this identity signed.
     *
     * [lines] must already be filtered to messages the server attributed to this DID, so
     * "signed by them" is the server's verdict rather than ours. Newest first.
     */
    fun check(did: String, noteBody: String?, lines: List<String>): Verdict {
        if (noteBody.isNullOrBlank()) return Verdict.MISSING
        val fp = DidKey.fingerprint(did)
        val claim = lines.firstNotNullOfOrNull { parse(it) }?.takeIf { it.fingerprint == fp }
            ?: return Verdict.MISSING
        return if (claim.hash == hashOf(noteBody)) Verdict.MATCHES else Verdict.CHANGED
    }
}
