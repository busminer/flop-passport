package dev.alexkosa.floppassport.technocore

/**
 * Byte-exact port of Technocore's single-line sweep (`store.clean_text`) and of the
 * canonical strings a signature must cover (`app.py::_signer`).
 *
 * This is the single most failure-prone part of the whole integration: sign the raw text
 * the user typed instead of the swept text and the server refuses the write with a 403
 * that looks, from the app side, exactly like a broken key.
 */
object Canonical {

    /**
     * Replace every character in Unicode categories Cc, Cf, Cs, Co, Zl, Zp with a space,
     * then trim the ends.
     *
     * Iterates by code point on purpose. Java strings are UTF-16, so an emoji is two
     * surrogate chars, and a naive per-char loop would classify both halves as Cs and
     * eat every astral character — the server, iterating code points in Python, would
     * disagree and the signature would not verify.
     */
    fun sweep(text: String): String {
        val out = StringBuilder(text.length)
        var i = 0
        while (i < text.length) {
            val cp = text.codePointAt(i)
            val charCount = Character.charCount(cp)
            out.append(if (isInvisible(cp)) " " else text.substring(i, i + charCount))
            i += charCount
        }
        return pyStrip(out.toString())
    }

    private fun isInvisible(codePoint: Int): Boolean = when (Character.getType(codePoint)) {
        Character.CONTROL.toInt(),            // Cc
        Character.FORMAT.toInt(),             // Cf
        Character.SURROGATE.toInt(),          // Cs
        Character.PRIVATE_USE.toInt(),        // Co
        Character.LINE_SEPARATOR.toInt(),     // Zl
        Character.PARAGRAPH_SEPARATOR.toInt() // Zp
        -> true
        else -> false
    }

    /**
     * Python's `str.strip()` with no argument, not Java's `trim()` or `strip()`.
     *
     * After the sweep every control character is already a space, so the only survivors
     * that Python would still strip are category Zs — which includes U+00A0, a character
     * Java's `Character.isWhitespace` deliberately does not consider whitespace. Using
     * Java's version here would leave a leading non-breaking space in the signed string
     * that the server has removed.
     */
    private fun pyStrip(s: String): String {
        var start = 0
        var end = s.length
        while (start < end && isPyStrippable(s.codePointAt(start))) {
            start += Character.charCount(s.codePointAt(start))
        }
        while (end > start) {
            val cp = s.codePointBefore(end)
            if (!isPyStrippable(cp)) break
            end -= Character.charCount(cp)
        }
        return s.substring(start, end)
    }

    private fun isPyStrippable(cp: Int): Boolean =
        Character.getType(cp) == Character.SPACE_SEPARATOR.toInt() || cp == ' '.code

    /** The exact string a message signature must cover: `room|nonce|swept text`. */
    fun messagePayload(room: String, nonce: String, text: String): String =
        "$room|$nonce|${sweep(text)}"

    /** The exact string a note signature must cover: `ns|key|nonce|swept value`. */
    fun notePayload(ns: String, key: String, nonce: String, value: String): String =
        "$ns|$key|$nonce|${sweep(value)}"

    private val SIG_RE = Regex("[A-Za-z0-9_-]{85}[AQgw]")
    private val NONCE_RE = Regex("[0-9]{1,19}")

    /**
     * The server accepts only the canonical spelling of a signature: 86 base64url
     * characters whose last character has four trailing zero bits, hence [AQgw].
     */
    fun isCanonicalSignature(sig: String): Boolean = SIG_RE.matches(sig)

    fun isValidNonce(nonce: String): Boolean = NONCE_RE.matches(nonce)
}
