package dev.alexkosa.floppassport.technocore

import dev.alexkosa.floppassport.crypto.DidKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.delay
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
        /**
         * Sized from measurement, not from habit. A healthy call to this service answers
         * in about half a second and a 503 comes back just as fast; the only thing 20
         * seconds bought was a user watching a spinner for a minute while three attempts
         * each waited out a stall. Eight seconds is far past the slow end of normal.
         */
        private const val TIMEOUT_MS = 8_000

        /** Shown beside the live figure, so the user sees who is being asked. */
        private const val HOST = "technocore.chat"
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

    /**
     * The last completed round trip. Null until something has actually been asked.
     *
     * A StateFlow rather than Compose state because it is written from the IO dispatcher
     * on every request; the UI collects it and is the only thing that touches the frame.
     */
    data class Pulse(
        val host: String,
        val millis: Long,
        val attempt: Int,
        val ok: Boolean,
        val detail: String,
        /** Plain words for what this call was doing, for a screen to show. */
        val what: String,
    )

    /**
     * Name the request in words a person can read.
     *
     * Derived from the path rather than passed in at every call site: one place to keep
     * honest, and no chance of a label drifting away from the request it describes.
     */
    private fun describe(path: String): String = when {
        path.contains("/say-signed/") -> "Sending your signed record"
        path.startsWith("/kv/") && path.contains("/set/") -> "Publishing your note"
        path.startsWith("/kv/") -> "Reading your note"
        path.startsWith("/r/") -> "Reading your records"
        else -> "Talking to the service"
    }

    private val _pulse = MutableStateFlow<Pulse?>(null)
    val pulse: StateFlow<Pulse?> = _pulse

    // ---------------------------------------------------------------- reads

    /**
     * One round trip, measured.
     *
     * The measurement is the point: this app keeps telling people it is talking to a real
     * service, and a spinner is not evidence of that. Every call publishes what actually
     * happened - the host, the milliseconds, which attempt this was - so a screen can show
     * the live figure instead of an animation that would spin just as happily offline.
     */
    suspend fun get(path: String, attempt: Int = 1): Response = withContext(Dispatchers.IO) {
        val started = System.nanoTime()
        fun elapsed() = (System.nanoTime() - started) / 1_000_000

        val conn = (URL(baseUrl + path).openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            connectTimeout = TIMEOUT_MS
            readTimeout = TIMEOUT_MS
            setRequestProperty(
                "User-Agent",
                "FLOP-Passport-for-Seeker/" + dev.alexkosa.floppassport.BuildConfig.VERSION_NAME,
            )
        }
        try {
            val code = conn.responseCode
            val stream = if (code in 200..299) conn.inputStream else conn.errorStream
            val body = stream?.bufferedReader()?.use { it.readText() } ?: ""
            _pulse.value = Pulse(HOST, elapsed(), attempt, code in 200..299, "HTTP $code", describe(path))
            Response(code, body)
        } catch (t: Throwable) {
            _pulse.value = Pulse(HOST, elapsed(), attempt, false, t.javaClass.simpleName, describe(path))
            throw t
        } finally {
            conn.disconnect()
        }
    }

    /**
     * A read, retried through a transient failure.
     *
     * technocore.chat intermittently answers 503 - measured today at several failures in
     * one stretch of requests, then fifteen clean ones in a row. A single attempt turns
     * that into "could not reach the server" on a screen whose whole job is to tell
     * somebody their records are still there, which is the most alarming possible way to
     * report a hiccup.
     *
     * For anything that can be repeated without changing the outcome: every read, and
     * the identity note, which is a key-value set that overwrites rather than appends.
     *
     * NOT for a signed room message. Those append, they are sent as a GET like everything
     * else, and a retry would post the same line twice in public - the one mistake here
     * that cannot be taken back. Those keep using [get] and stay single-shot on purpose.
     */
    private suspend fun retrying(path: String, attempts: Int = 3): Response {
        var last = Response(0, "")
        repeat(attempts) { attempt ->
            last = runCatching { get(path, attempt + 1) }.getOrElse { Response(0, it.message ?: "") }
            if (last.ok) return last
            if (last.status in 400..499) return last
            if (attempt < attempts - 1) delay(400L * (attempt + 1))
        }
        return last
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
        val r = retrying(DidKey.notePath(did))
        if (r.ok) return stripBanner(r.body)

        // Caught live: the app showed NOT FOUND for a note that was sitting on the server
        // and answered 200 to five requests in a row a second later. Three 503s in a row
        // are unlucky rather than impossible here, and reporting them as absence tells
        // somebody their published identity is gone.
        //
        // So only a 404 means absent. Anything else is a failure to ask, and the caller
        // already knows how to say that.
        if (r.status != 404) {
            throw java.io.IOException("technocore.chat answered ${r.status} for the note")
        }

        // One attempt: a fallback for notes written under an older address, usually absent,
        // and waiting on it three times only delays an answer we already have.
        val legacy = runCatching { get(DidKey.legacyNotePath(did)) }.getOrElse { Response(0, "") }
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
        // Retried, unlike every other write here: this one sets a key to a fixed value, so
        // doing it twice leaves exactly the state doing it once leaves. A single transient
        // failure on this call reported the whole step as "could not reach
        // technocore.chat" - a dropped connection presented to the user as a dead end.
        val w = retrying(path)
        // Status 0 is not an answer from the service, it is the absence of one: no
        // network, no DNS, a timeout. Reporting it as "refused" told a person with Wi-Fi
        // off to wait for a busy server, and printed the raw exception under DETAIL.
        if (w.status == 0) throw java.io.IOException(w.body.ifBlank { "no connection" })
        if (!w.ok) return Result.Refused(w.status, w.body.take(300))

        // The write returned 200, so from here on the honest answer to "did anything go
        // public?" is "probably" - a read-back that cannot be made is Unconfirmed, never
        // Failed, and the caller's retry is a fixed-value set, so re-checking is free.
        val readBack = runCatching { readIdentityNote(did) }.getOrElse {
            return Result.Unconfirmed(
                "The note was accepted, but it could not be read back yet.",
            )
        }
        // The server stores the swept form of what it was sent, so that is the form to
        // compare against. Sending an invisible character and comparing against the
        // unswept value would leave the step Unconfirmed forever.
        val expected = Canonical.sweep(value)
        return if (readBack == expected) {
            Result.Verified(
                Proof(did, "", "", expected, "", 0, System.currentTimeMillis().toString()),
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
        val sig = dev.alexkosa.floppassport.crypto.Ed25519.encodeSignature(
            sign(payload.toByteArray(Charsets.UTF_8)),
        )
        check(Canonical.isCanonicalSignature(sig)) { "Produced a non-canonical signature" }

        // Single-shot on purpose: a retry here could post the same line twice in public.
        // A reply that never arrives is not the same as a write that never left: once the
        // request was sent, the record may well be in the room, and the only honest state
        // is Unconfirmed, which makes the caller read the room before offering to resend.
        // A failure to connect at all is still a plain failure - nothing was sent.
        val w = try {
            get("/r/${enc(room)}/say-signed/$did/$sig/$nonce/${enc(text)}")
        } catch (t: java.net.SocketTimeoutException) {
            if (t.message?.contains("connect", ignoreCase = true) == true) throw t
            return Result.Unconfirmed(
                "The record was sent but no answer came back in time. " +
                    "Do not resend: read the room again first.",
            )
        }
        if (!w.ok) return Result.Refused(w.status, w.body.take(300))

        val rec = findMessage(room, did, nonce)
            ?: return Result.Unconfirmed(
                "The server accepted the write but the message is not in the room yet. " +
                    "Do not resend: read the room again first.",
            )

        if (rec.optString("text") != swept) {
            return Result.Unconfirmed("The stored text differs from the text we signed")
        }

        // Check the arithmetic rather than take the service's word for it.
        //
        // Matching `from`, `nonce` and `text` only proves the service echoed back what we
        // sent. Since 05:07 UTC on 31 August the signature is stored beside the record, so
        // it can be verified the way any stranger would verify it: rebuild
        // `room|nonce|text` and check it against the key inside the DID. This app tells
        // people its records are provable; it should be the first to actually prove one.
        // A record with no `sig` predates that change and is passed through - missing is
        // "not re-verifiable", never "invalid".
        val stored = rec.optString("sig")
        if (stored.isNotEmpty()) {
            val good = runCatching {
                dev.alexkosa.floppassport.crypto.Ed25519.verify(
                    publicKey = DidKey.publicKey(did),
                    message = payload.toByteArray(Charsets.UTF_8),
                    signature = dev.alexkosa.floppassport.crypto.Ed25519.decodeSignature(stored),
                )
            }.getOrDefault(false)
            if (!good) {
                return Result.Unconfirmed("The stored record did not verify against this key")
            }
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
        // The newest window is exactly right for a record written a moment ago. The
        // throwaway parameter is the service's own advice for re-polling an unchanged URL:
        // the edge caches this read for a few seconds, and a cached list from before the
        // write would call a landed record "not in the room yet".
        val r = retrying("/r/${enc(room)}?since=0&limit=200&format=json&n=${System.currentTimeMillis()}")
        if (!r.ok) return null
        return runCatching {
            val messages = JSONObject(r.body).getJSONArray("messages")
            (0 until messages.length())
                .map { messages.getJSONObject(it) }
                .firstOrNull { it.optString("from") == did && it.optString("nonce") == nonce }
        }.getOrNull()
    }

    /**
     * Our most recent verified message in a room, if the server still has one.
     *
     * Used on open so the app can re-establish what is true rather than trusting local
     * state, and used before posting so a user who already checked in is shown their
     * existing record instead of being invited to post a second identical one. Rooms are
     * public and append-only; a duplicate cannot be taken back.
     */
    /**
     * Everything the room still holds, as the service's own export: raw JSONL, one record
     * per line, the whole retained ring.
     *
     * `?limit=200` returns the newest two hundred lines and nothing else, and every user of
     * this app writes into one shared room. Past a couple of hundred lines the earliest
     * users' records fell out of that window, so the app told them their history was gone,
     * showed step 04 as pending, and offered to post a second "first check-in" - in
     * public, for good. The export has no window. A line that fails to parse is skipped
     * rather than failing the whole read: the manual says a write landing mid-export is
     * cut back to the last complete line, and a torn tail is not a reason to call a
     * person's records missing.
     *
     * Throws on anything but a 200 with a body that parses as records, because the callers
     * act on "nothing found" by writing, and an unreachable server must never read as an
     * empty history.
     */
    private suspend fun readRoom(room: String): List<JSONObject> {
        val r = retrying("/r/${enc(room)}/export")
        if (!r.ok) throw java.io.IOException("technocore.chat answered ${r.status}")
        val records = ArrayList<JSONObject>()
        var seen = 0
        for (line in r.body.lineSequence()) {
            val trimmed = line.trim()
            if (trimmed.isEmpty()) continue
            seen++
            runCatching { JSONObject(trimmed) }.getOrNull()
                ?.takeIf { it.has("seq") && it.has("text") }
                ?.let { records.add(it) }
        }
        // A body with lines and not one of them a record is not a room - an HTML error
        // page from a proxy, a captive portal - and must not read as "no history".
        if (seen > 0 && records.isEmpty()) {
            throw java.io.IOException("technocore.chat sent something that is not a room")
        }
        return records
    }

    /** A stored signature checked the way a stranger would check it; true when none is stored. */
    private fun signatureHolds(room: String, did: String, rec: JSONObject): Boolean {
        val stored = rec.optString("sig")
        if (stored.isEmpty()) return true
        return runCatching {
            dev.alexkosa.floppassport.crypto.Ed25519.verify(
                publicKey = DidKey.publicKey(did),
                message = Canonical.messagePayload(room, rec.optString("nonce"), rec.optString("text"))
                    .toByteArray(Charsets.UTF_8),
                signature = dev.alexkosa.floppassport.crypto.Ed25519.decodeSignature(stored),
            )
        }.getOrDefault(false)
    }

    /**
     * Our most recent verified message in a room, if the server still has one.
     *
     * Used on open so the app can re-establish what is true rather than trusting local
     * state, and used before posting so a user who already checked in is shown their
     * existing record instead of being invited to post a second identical one. Rooms are
     * public and append-only; a duplicate cannot be taken back.
     */
    suspend fun findLatestMessage(room: String, did: String): Proof? {
        // A null here means "you have never checked in", and the caller acts on that by
        // posting one. So anything that is not a readable room throws rather than
        // returning null: a 503, or a 200 carrying something other than records, read as
        // "never" would put a second identical line in a public append-only room.
        val records = readRoom(room)
        return records
            .filter { it.optString("from") == did }
            // A did-note line is this identity's own plumbing, not a check-in. Counting
            // it meant that publishing - which posts one - made the very next step
            // announce "you have already checked in", and a brand new Passport reached
            // the end having never posted the record the whole app exists to post.
            .filterNot { DidNote.parse(it.optString("text")) != null }
            // Since 31 August the signature is stored beside the record. The fresh-write
            // path checks it; a record found on restore is checked the same way, so a
            // line the server attributed to us but that our key never signed is not
            // presented as our check-in.
            .filter { signatureHolds(room, did, it) }
            .maxByOrNull { it.optInt("seq") }
            ?.let {
                Proof(
                    did = did,
                    room = room,
                    nonce = it.optString("nonce"),
                    signedText = it.optString("text"),
                    signature = it.optString("sig"),
                    seq = it.optInt("seq"),
                    timestamp = it.optString("ts"),
                )
            }
    }

    /**
     * Every message from this identity the server still holds, oldest first.
     *
     * "Still holds" is the operative part: a room is compacted at 10 MiB down to half, so
     * this is the record as anyone else would find it today, not a history of everything
     * ever written. The activity screen is built on this precisely so it cannot claim a
     * past the service has already forgotten.
     */
    /** Who wrote what when in a room, as (signer, timestamp), leaving out what [ignore] matches. */
    suspend fun roomLines(room: String, ignore: (String) -> Boolean): List<Pair<String, String>> =
        readRoom(room)
            .filterNot { ignore(it.optString("text")) }
            .map { it.optString("from") to it.optString("ts") }

    suspend fun findAllMessages(room: String, did: String): List<Proof> {
        // Throws rather than returning nothing. An unreachable server and an identity with
        // no records are opposite facts, and returning the same empty list for both told
        // the user their history was gone when it was only unreachable. The same goes for
        // a 200 whose body is not a room, which is what a captive portal answers.
        return readRoom(room)
            .filter { it.optString("from") == did }
            .map {
                Proof(
                    did = did,
                    room = room,
                    nonce = it.optString("nonce"),
                    signedText = it.optString("text"),
                    signature = it.optString("sig"),
                    seq = it.optInt("seq"),
                    timestamp = it.optString("ts"),
                )
            }
            .sortedBy { it.seq }
    }

    /**
     * The next nonce for a room, taken from what the server already holds rather than from
     * local state. A phone whose clock jumped backwards, or a reinstall that lost its
     * counter, would otherwise produce a nonce the server refuses with a message the user
     * cannot act on.
     */
    suspend fun nextNonce(room: String, did: String): String {
        val now = System.currentTimeMillis()
        // Throws when the room cannot be read. Without that, an unreachable server made the
        // highest known nonce zero; a phone whose clock had once run ahead would then sign
        // a nonce below its own last one and be refused, with nothing on screen explaining
        // why.
        val highest = readRoom(room)
            .filter { it.optString("from") == did }
            .maxOfOrNull { it.optString("nonce").toLongOrNull() ?: 0L } ?: 0L
        return maxOf(now, highest + 1).toString()
    }

    private fun enc(s: String): String =
        URLEncoder.encode(s, "UTF-8").replace("+", "%20")
}
