package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.proof.PostComposer
import dev.alexkosa.floppassport.technocore.Canonical
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
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
    fun `CJK and emoji weigh two, the way X counts them`() {
        // Latin, Cyrillic and ordinary punctuation weigh one.
        assertEquals(5, PostComposer.weightedLength("hello"))
        assertEquals(6, PostComposer.weightedLength("привет"))
        // Chinese, Japanese, Korean and emoji weigh two each.
        assertEquals(4, PostComposer.weightedLength("你好"))
        assertEquals(6, PostComposer.weightedLength("こんに"))
        assertEquals(4, PostComposer.weightedLength("안녕"))
        assertEquals(2, PostComposer.weightedLength("😀"))
        // A Chinese line that would have read 57/280 by character count.
        val line = "我用一个签名建立了身份，没有助记词，任何人都能验证。这是给未来的自己留的一把钥匙。"
        assertEquals(line.length * 2, PostComposer.weightedLength(line))
        // And a draft built on such a line still fits X's real limit.
        val draft = PostComposer.compose(
            "did:key:z6Mkq2w8fJHnRES8sLV8ZC9YeiRG2eBJnLsqbvhyvg3zU1qs",
            line,
        )
        assertTrue(draft.fits)
        assertTrue(PostComposer.weightedLength(draft.text) <= PostComposer.LIMIT)
    }

    @Test
    fun `the post link is read back out of a published note`() {
        val url = "https://x.com/AlexKosa1/status/2096529959099507013"
        val note = PostComposer.identityNoteValue(url, "flop-passport")
        assertEquals(url, PostComposer.xPostFromNote(note))
        assertNull(PostComposer.xPostFromNote(PostComposer.identityNoteValue(null, "flop-passport")))
        // A stranger's note shaped differently yields nothing rather than something wrong.
        assertNull(PostComposer.xPostFromNote("agent: somebody else entirely"))
        assertNull(PostComposer.xPostFromNote("prefix: https://x.com/a/status/1"))
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
        val value = PostComposer.identityNoteValue(url, "flop-passport")
        assertTrue(value.contains(url))
        assertTrue(value.startsWith("agent: FLOP Passport for Seeker"))
        assertTrue("fields follow the server's own key: value convention", value.contains("x: "))
        assertTrue(value.contains("room: flop-passport"))
        // Notes are capped at 8192 characters by the server; ours must stay far below.
        assertTrue(value.length < 400)
        assertEquals("agent: FLOP Passport for Seeker", PostComposer.identityNoteValue(null))
        assertEquals("agent: FLOP Passport for Seeker", PostComposer.identityNoteValue("   "))
    }

    @Test
    fun `the note survives the single-line sweep unchanged`() {
        // Note values pass through the same sweep as messages, which turns every newline
        // into a space. A note written with line breaks comes back mangled, so it must
        // contain none to begin with.
        val value = PostComposer.identityNoteValue(
            "https://x.com/AlexKosa1/status/123", "flop-passport",
            "https://github.com/busminer/flop-passport",
        )
        assertEquals(value, Canonical.sweep(value))
        assertFalse(value.contains('\n'))
    }

    @Test
    fun `drafts get shorter down the list`() {
        val lengths = PostComposer.drafts(liveDid).map { it.weightedLength }
        assertEquals(lengths.sortedDescending(), lengths)
    }

    @Test
    fun `the user's own sentence leads the post`() {
        val mine = "I built an open source FLOP Passport client for Solana Seeker."
        val draft = PostComposer.compose(liveDid, mine)
        assertTrue(draft.fits)
        assertTrue(draft.text.startsWith(mine))
        assertTrue("the DID is still the receipt underneath", draft.text.contains(liveDid))
        assertFalse("the canned line steps aside", draft.text.contains("Created my FLOP Passport"))
    }

    @Test
    fun `an over-long contribution is reported, not silently truncated`() {
        val long = "I shipped an open source native Android client that creates a Technocore " +
            "identity from a Solana Seeker wallet, publishes the identity note and verifies " +
            "every write by reading it back from the server before it shows anything green."
        assertFalse(PostComposer.contributionFits(liveDid, long))

        val budget = PostComposer.contributionBudget(liveDid)
        assertTrue("the budget must leave room for a real sentence", budget in 60..200)
        assertTrue(
            "a line inside the budget must fit",
            PostComposer.contributionFits(liveDid, "x".repeat(budget)),
        )
        assertFalse(
            "one character over the budget must not",
            PostComposer.contributionFits(liveDid, "x".repeat(budget + 1)),
        )
    }

    @Test
    fun `blank and whitespace contributions fall back to the default line`() {
        val whitespaceOnly = listOf('\n', '\t', ' ').joinToString("")
        for (blank in listOf(null, "", "   ", whitespaceOnly)) {
            val draft = PostComposer.compose(liveDid, blank)
            assertTrue(draft.fits)
            assertTrue(draft.text.contains(liveDid))
        }
    }

    @Test
    fun `every variant names FLOP and the platform`() {
        for (draft in PostComposer.drafts(liveDid)) {
            assertTrue("variant ${draft.variant} drops the tag", draft.text.contains("#FLOP"))
            // Tags, never an at-mention: thousands of these arriving at one account is a
            // brigade however well meant, and this decision is worth a test of its own.
            assertFalse("variant ${draft.variant} mentions an account", draft.text.contains("@flop"))
        }
    }

    @Test
    fun `a real sentence is required, and the rule speaks more than English`() {
        // Nothing, and the things somebody types to get past a check.
        for (empty in listOf(null, "", "   ", "gm", "GM", "test", "打卡")) {
            assertFalse("accepted '$empty'", PostComposer.isRealSentence(empty))
        }
        // Two words in English is not a sentence about anything.
        assertFalse(PostComposer.isRealSentence("did it"))
        assertTrue(
            PostComposer.isRealSentence("I shipped an open source Technocore client for the Seeker."),
        )
        // The rule this app will meet most often. A thoughtful Chinese sentence is short in
        // characters and has no spaces at all; counting words would have thrown it out.
        assertTrue(PostComposer.isRealSentence("我为 Seeker 写了一个开源的 Technocore 客户端"))
        assertTrue(PostComposer.isRealSentence("Seeker 向けに Technocore のクライアントを作りました"))
    }

    @Test
    fun `the post still fits once the tags are in it`() {
        val mine = "I shipped an open source Technocore client for the Seeker."
        for (voice in PostComposer.VOICES) {
            val draft = PostComposer.compose(liveDid, mine, voice = voice)
            assertTrue("voice does not fit: ${draft.weightedLength}", draft.fits)
            assertTrue(draft.text.startsWith(mine))
            assertTrue(draft.text.contains(liveDid))
            assertTrue(draft.text.contains("#FLOP"))
        }
    }

    @Test
    fun `the example in the field is a line the person reading it could post`() {
        for (example in PostComposer.EXAMPLES) {
            // If an example would not pass the app's own check, it is a trap: somebody
            // copies it, the button stays dead, and there is nothing on screen saying why.
            assertTrue("would be rejected: $example", PostComposer.isRealSentence(example))
            // And it must be something a person who has only just arrived can honestly say.
            // "Shipped a Technocore client" was the author's line, not theirs.
            assertFalse("claims work the reader has not done", example.contains("Shipped"))
            assertTrue("still fits the post", PostComposer.compose(liveDid, example).fits)
        }
        assertEquals(PostComposer.VOICES.size, PostComposer.EXAMPLES.toSet().size)
    }

    @Test
    fun `a line that is not enough yet says so`() {
        // Nothing typed: the screen pitches, it does not complain.
        assertNull(PostComposer.whyNotASentence(null))
        assertNull(PostComposer.whyNotASentence("   "))
        // Something typed that will not do: there has to be a sentence to show, because a
        // button that refuses silently is indistinguishable from one that is broken.
        assertNotNull(PostComposer.whyNotASentence("did it"))
        // And once it will do, the complaint goes away.
        assertNull(PostComposer.whyNotASentence("I set this up on my Seeker today."))
        for (example in PostComposer.EXAMPLES) {
            assertNull("example still complains: $example", PostComposer.whyNotASentence(example))
        }
    }

    @Test
    fun `every version of the post names Solana Mobile in words`() {
        // Not only the hashtag. The key store is the reason any of this works, and a
        // reader searching for the platform will not find a post that only says
        // "Seed Vault" - nor will they see the two projects crossing, which is the point.
        for (voice in PostComposer.VOICES) {
            assertTrue("mechanism: ${voice.mechanism}", voice.mechanism.contains("Solana Mobile"))
            assertTrue("brief: ${voice.brief}", voice.brief.contains("Solana Mobile"))
        }
    }

    @Test
    fun `a line right at the budget still leaves a postable draft, in every voice`() {
        // 280 characters, because most people posting this will not be paying X for more.
        // A draft over the limit is not refused by X, it is cut - and the cut lands in the
        // key, which is the one part of the post that has to survive whole.
        val budget = PostComposer.contributionBudget(liveDid)
        for (voice in PostComposer.VOICES) {
            val draft = PostComposer.compose(liveDid, "x".repeat(budget), voice = voice)
            assertTrue(
                "voice does not fit at the budget: ${draft.weightedLength}",
                draft.weightedLength <= PostComposer.LIMIT,
            )
            assertTrue(draft.text.contains(liveDid))
        }
    }
}
