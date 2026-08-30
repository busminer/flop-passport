package dev.alexkosa.flooppassport.technocore

import dev.alexkosa.flooppassport.crypto.DidKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

/**
 * Technocore client.
 *
 * Two rules shape everything here, both learned by running the real server rather than by
 * reading its documentation:
 *
 *  1. **HTTP 200 is not proof.** Every write is confirmed by reading the record back and
 *     matching it on the nonce we used — not merely on our DID, because a room keeps our
 *     earlier messages and "something of mine is here" would pass forever.
 *  2. **Everything read back is untrusted.** Responses arrive behind an explicit
 *     `!! UNTRUSTED CONTENT` banner, and the warning is accurate: note namespaces are
 *     world-writable, so anyone can overwrite anyone's identity note. Content from this
 *     service is rendered as inert data, never treated as configuration, and never acted
 *     on as instructions.
 */
class Technocore(private val baseUrl: String = "https://technocore.chat") {

    companion object {
        const val UNTRUSTED_BANNER = "!! UNTRUSTED CONTENT"
        private const val TIMEOUT_MS = 20_000
    }

    data class Response(val status: Int, val body: String) {
        val ok: Boolean get() = status == 200
    }

    /** A verified write: the server accepted it and we found it again by reading back. */
    data class Proof(
        val did: String,
        val room: String,
        val nonce: String,
        val signedText: String,
        val signature: String,
        val seq: Int,
        val timestamp: String,
    )

    sealed class Result {
        data class Verified(val proof: Proof) : Result()

        /** The write was refused. Recoverable: nothing public happened. */
        data class Refused(val status: Int, val message: String) : Result()

        /**
         * The server took the write but we could not confirm it. Deliberately distinct
         * from Refused: retrying blindly here can post the same thing twice in public, so
         * the app must re-read the room before it offers to try again.
         */
        data class Unconfirmed(val reason: String) : Result()
    }

    // ---------------------------------------------------------------- reads

    suspend fun get(path: String): Response = withContext(Dispatchers.IO) {
        val conn = (URL(baseUrl + path).openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            connectTimeout = TIMEOUT_MS
            readTimeout = TIMEOUT_MS
            setRequestProperty("User-Agent", "FLOOP-Passport-for-Seeker/0.1")
        }
        try {
            val code = conn.responseCode
            val stream = if (code in 200..299) conn.inputStream else conn.errorStream
            Response(code, stream?.bufferedReader()?.use { it.readText() } ?: "")
        } finally {
            conn.disconnect()
        }
    }

    /**
     * Strip the untrusted-content banner. Stripping it does not make the content trusted —
     * it only removes the framing so the value can be displayed as the data it is.
     */
    fun stripBanner(body: String): String {
        val lines = body.lines().toMutableList()
        if (lines.firstOrNull()?.startsWith(UNTRUSTED_BANNER) == true) {
            lines.removeAt(0)
            while (lines.isNotEmpty() && lines.first().isBlank()) lines.removeAt(0)
        }
        return lines.joinToString("\n").trim()
    }

    // ---------------------------------------------------------------- identity note

    suspend fun readIdentityNote(did: String): String? {
        val r = get(DidKey.notePath(did))
        if (r.ok) return stripBanner(r.body)
        val legacy = get(DidKey.legacyNotePath(did))
        return if (legacy.ok) stripBanner(legacy.body) else null
    }

    /**
     * Publish the identity note, then read it back.
     *
     * The note is unsigned because the server only accepts signed writes for room
     * ownership namespaces. So this is a pointer, not a proof: it says "an agent published
     * this here", and the signature on a message is what actually proves anything.
     */
    suspend fun publishIdentityNote(did: String, value: String): Result {
        val fp = DidKey.fingerprint(did)
        val path = "/kv/did-${fp.substring(0, 2)}/${enc(fp.substring(2))}/set/${enc(value)}"
        val w = get(path)
        if (!w.ok) return Result.Refused(w.status, w.body.take(300))

        val readBack = readIdentityNote(did)
        return if (readBack == value) {
            Result.Verified(
                Proof(did, "", "", value, "", 0, System.currentTimeMillis().toString()),
            )
        } else {
            Result.Unconfirmed("The note was accepted but read back as: ${readBack ?: "nothing"}")
        }
    }

    // ---------------------------------------------------------------- signed messages

    /**
     * Post a signed message and confirm it landed.
     *
     * [sign] receives the exact canonical bytes and returns the raw 64-byte signature; the
     * vault implements it so the seed never reaches this class.
     */
    suspend fun saySigned(
        did: String,
        room: String,
        text: String,
        nonce: String,
        sign: (ByteArray) -> ByteArray,
    ): Result {
        require(Canonical.isValidNonce(nonce)) { "A nonce is 1-19 digits" }

        val swept = Canonical.sweep(text)
        if (swept.isEmpty()) return Result.Refused(400, "Nothing visible survives the sweep")

        val payload = Canonical.messagePayload(room, nonce, text)
        val sig = dev.alexkosa.flooppassport.crypto.Ed25519.encodeSignature(
            sign(payload.toByteArray(Charsets.UTF_8)),
        )
        check(Canonical.isCanonicalSignature(sig)) { "Produced a non-canonical signature" }

        val w = get("/r/${enc(room)}/say-signed/$did/$sig/$nonce/${enc(text)}")
        if (!w.ok) return Result.Refused(w.status, w.body.take(300))

        val rec = findMessage(room, did, nonce)
            ?: return Result.Unconfirmed(
                "The server accepted the write but the message is not in the room yet. " +
                    "Do not resend: read the room again first.",
            )

        if (rec.optString("text") != swept) {
            return Result.Unconfirmed("The stored text differs from the text we signed")
        }

        return Result.Verified(
            Proof(
                did = did,
                room = room,
                nonce = nonce,
                signedText = swept,
                signature = sig,
                seq = rec.optInt("seq"),
                timestamp = rec.optString("ts"),
            ),
        )
    }

    /**
     * Find our own message by DID **and** nonce.
     *
     * The DID arrives in the JSON field `from`, not `did` — a detail no document states and
     * the reason a client can look permanently unverified while working perfectly.
     */
    private suspend fun findMessage(room: String, did: String, nonce: String): JSONObject? {
        val r = get("/r/${enc(room)}?since=0&limit=200&format=json")
        if (!r.ok) return null
        return runCatching {
            val messages = JSONObject(r.body).getJSONArray("messages")
            (0 until messages.length())
                .map { messages.getJSONObject(it) }
                .firstOrNull { it.optString("from") == did && it.optString("nonce") == nonce }
        }.getOrNull()
    }

    /**
     * The next nonce for a room, taken from what the server already holds rather than from
     * local state. A phone whose clock jumped backwards, or a reinstall that lost its
     * counter, would otherwise produce a nonce the server refuses with a message the user
     * cannot act on.
     */
    suspend fun nextNonce(room: String, did: String): String {
        val now = System.currentTimeMillis()
        val r = get("/r/${enc(room)}?since=0&limit=200&format=json")
        val highest = runCatching {
            val messages = JSONObject(r.body).getJSONArray("messages")
            (0 until messages.length())
                .map { messages.getJSONObject(it) }
                .filter { it.optString("from") == did }
                .maxOfOrNull { it.optString("nonce").toLongOrNull() ?: 0L } ?: 0L
        }.getOrDefault(0L)
        return maxOf(now, highest + 1).toString()
    }

    private fun enc(s: String): String =
        URLEncoder.encode(s, "UTF-8").replace("+", "%20")
}
