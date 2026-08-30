package dev.alexkosa.flooppassport

import dev.alexkosa.flooppassport.proof.PostComposer
import dev.alexkosa.flooppassport.technocore.Canonical
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PostComposerTest {

    private val did = ReferenceVectors.identities[0].did
    private val liveDid = "did:key:z6Mkw1JAVEwLgronRpuuzvHTyiiUgdoQGqkHG8VXH847dqcJ"

    @Test
    fun `the chosen draft always fits X's limit`() {
        for (d in listOf(did, liveDid)) {
            val draft = PostComposer.compose(d)
            assertTrue(
                "variant ${draft.variant} was ${draft.weightedLength} weighted characters",
                draft.fits,
            )
        }
    }

    @Test
    fun `a link costs 23 characters, not its real length`() {
        val long = "https://technocore.chat/kv/did-ef/9b53055830b478"
        assertEquals(23, PostComposer.weightedLength(long))
        assertEquals(23 + 6, PostComposer.weightedLength("hello $long"))
    }

    @Test
    fun `the DID is never abbreviated`() {
        // An abbreviated key cannot be verified by anyone, which is the whole point of
        // publishing it, so every variant must carry it in full.
        for (draft in PostComposer.drafts(liveDid)) {
            assertTrue("variant ${draft.variant} dropped the DID", draft.text.contains(liveDid))
            assertFalse("variant ${draft.variant} abbreviated the DID", draft.text.contains("…"))
        }
    }

    @Test
    fun `every variant credits the app`() {
        for (draft in PostComposer.drafts(liveDid)) {
            assertTrue(draft.text.contains("@AlexKosa1"))
        }
    }

    @Test
    fun `the post never promises an allocation`() {
        val forbidden = listOf(
            "airdrop", "eligible", "eligibility", "allocation", "reward",
            "guaranteed", "qualify", "points",
        )
        for (draft in PostComposer.drafts(liveDid)) {
            val lower = draft.text.lowercase()
            for (word in forbidden) {
                assertFalse(
                    "variant ${draft.variant} promises something we cannot: '$word'",
                    lower.contains(word),
                )
            }
        }
    }

    @Test
    fun `it reads like a person wrote it`() {
        val text = PostComposer.compose(liveDid).text
        assertFalse("no em-dashes", text.contains("—"))
        assertFalse("no marketing bullets", text.contains("•"))
        assertTrue("short lines separated by blank lines", text.contains("\n\n"))
        for (line in text.lines().filter { it.isNotBlank() && !it.startsWith("did:key") }) {
            assertTrue("line too long to read on a phone: $line", line.length <= 90)
        }
    }

    @Test
    fun `the verification link points at the durable note, not a room`() {
        val draft = PostComposer.compose(liveDid).text
        assertTrue(draft.contains("/kv/did-"))
        assertFalse("rooms are trimmed, so a room link rots", draft.contains("/r/"))
    }

    @Test
    fun `the identity note carries the X post so the link outlives the rooms`() {
        val url = "https://x.com/AlexKosa1/status/123"
        val value = PostComposer.identityNoteValue(url, "floop-passport")
        assertTrue(value.contains(url))
        assertTrue(value.startsWith("agent: FLOOP Passport for Seeker"))
        assertTrue("fields follow the server's own key: value convention", value.contains("x: "))
        assertTrue(value.contains("room: floop-passport"))
        // Notes are capped at 8192 characters by the server; ours must stay far below.
        assertTrue(value.length < 400)
        assertEquals("agent: FLOOP Passport for Seeker", PostComposer.identityNoteValue(null))
        assertEquals("agent: FLOOP Passport for Seeker", PostComposer.identityNoteValue("   "))
    }

    @Test
    fun `the note survives the single-line sweep unchanged`() {
        // Note values pass through the same sweep as messages, which turns every newline
        // into a space. A note written with line breaks comes back mangled, so it must
        // contain none to begin with.
        val value = PostComposer.identityNoteValue(
            "https://x.com/AlexKosa1/status/123", "floop-passport",
            "https://github.com/busminer/floop-passport",
        )
        assertEquals(value, Canonical.sweep(value))
        assertFalse(value.contains('\n'))
    }

    @Test
    fun `drafts get shorter down the list`() {
        val lengths = PostComposer.drafts(liveDid).map { it.weightedLength }
        assertEquals(lengths.sortedDescending(), lengths)
    }
}
