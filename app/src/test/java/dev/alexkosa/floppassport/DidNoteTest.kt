package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.crypto.DidKey
import dev.alexkosa.floppassport.technocore.DidNote
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The `did-note` convention, which is the only thing standing between "a note exists" and
 * "the key vouched for this note". Both sides have to compute the same bytes or the line
 * is worse than useless, so the shape is pinned here.
 */
class DidNoteTest {

    private val did = ReferenceVectors.identities[0].did
    private val body = "agent: FLOP Passport for Seeker room: flop-passport"

    @Test
    fun `the line is the exact shape FLOP published`() {
        val line = DidNote.line(did, body)
        assertTrue(line.startsWith("did-note "))
        val parts = line.split(" ")
        assertEquals(3, parts.size)
        assertEquals(DidKey.fingerprint(did), parts[1])
        assertEquals(16, parts[1].length)
        assertEquals(64, parts[2].length)
        assertTrue("hash is lowercase hex", parts[2].matches(Regex("[0-9a-f]{64}")))
    }

    @Test
    fun `the hash is SHA-256 of the note body`() {
        // A known value, so a future refactor cannot quietly change what gets hashed.
        assertEquals(
            "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
            DidNote.hashOf(""),
        )
        assertEquals(DidNote.hashOf(body), DidNote.hashOf(body))
        assertTrue(DidNote.hashOf(body) != DidNote.hashOf(body + " "))
    }

    @Test
    fun `a line round-trips through parse`() {
        val parsed = DidNote.parse(DidNote.line(did, body))
        assertNotNull(parsed)
        assertEquals(DidKey.fingerprint(did), parsed!!.fingerprint)
        assertEquals(DidNote.hashOf(body), parsed.hash)
    }

    @Test
    fun `parsing fails closed on anything that is not exactly the shape`() {
        val fp = DidKey.fingerprint(did)
        val hash = DidNote.hashOf(body)
        listOf(
            "did-note $fp",
            "did-note $hash",
            "did-note $fp $hash extra",
            "didnote $fp $hash",
            "did-note ${fp.uppercase()} $hash",
            "did-note $fp ${hash.uppercase()}",
            "did-note ${fp.dropLast(1)} $hash",
            "did-note $fp ${hash.dropLast(1)}",
            "I am posting a did-note $fp $hash",
            "",
        ).forEach { assertNull("should not parse: $it", DidNote.parse(it)) }
    }

    @Test
    fun `surrounding whitespace is tolerated because the sweep adds it`() {
        // The server's single-line sweep replaces control characters with spaces and trims,
        // so a line can come back padded without anybody having changed its meaning.
        val padded = "  " + DidNote.line(did, body) + "  "
        assertNotNull(DidNote.parse(padded))
    }

    @Test
    fun `a matching note is vouched for`() {
        val verdict = DidNote.check(did, body, listOf(DidNote.line(did, body)))
        assertEquals(DidNote.Verdict.MATCHES, verdict)
    }

    @Test
    fun `a note edited by somebody else is reported as changed`() {
        // Exactly the attack FLOP described: the namespace is world-writable, so a stranger
        // rewrites the note. The signed line still carries the old hash, and the mismatch
        // is what tells a reader to ignore what they are looking at.
        val tampered = body + " x: https://evil.example"
        assertEquals(
            DidNote.Verdict.CHANGED,
            DidNote.check(did, tampered, listOf(DidNote.line(did, body))),
        )
    }

    @Test
    fun `the newest line wins`() {
        val old = DidNote.line(did, "agent: old text")
        val current = DidNote.line(did, body)
        assertEquals(
            DidNote.Verdict.MATCHES,
            DidNote.check(did, body, listOf(current, old)),
        )
    }

    @Test
    fun `a line for a different identity is ignored`() {
        val other = ReferenceVectors.identities[1].did
        assertEquals(
            DidNote.Verdict.MISSING,
            DidNote.check(did, body, listOf(DidNote.line(other, body))),
        )
    }

    @Test
    fun `no line and no note both read as missing rather than as failure`() {
        assertEquals(DidNote.Verdict.MISSING, DidNote.check(did, body, emptyList()))
        assertEquals(DidNote.Verdict.MISSING, DidNote.check(did, null, listOf(DidNote.line(did, body))))
        assertEquals(DidNote.Verdict.MISSING, DidNote.check(did, "  ", listOf(DidNote.line(did, body))))
    }

    @Test
    fun `chatter in the room does not confuse the check`() {
        val noise = listOf(
            "FLOP Passport for Seeker. First signed check-in.",
            "did-note is a good idea",
            DidNote.line(did, body),
        )
        assertEquals(DidNote.Verdict.MATCHES, DidNote.check(did, body, noise))
    }
}
