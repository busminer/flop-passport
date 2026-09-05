package dev.alexkosa.flooppassport

import dev.alexkosa.flooppassport.proof.looksLikeUrl
import dev.alexkosa.flooppassport.proof.looksLikeXPost
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The two shape checks standing between a mistyped paste and a public note.
 *
 * The note is world-readable and is offered to strangers as evidence, so a broken link in
 * it is worse than an empty field: it looks like proof and leads nowhere. These checks
 * cannot tell whether a post is really this person's - only a reader opening it and
 * finding the DID can do that - so they are deliberately shallow, and the tests pin that
 * they stay shallow rather than drifting into pretending to authenticate anything.
 */
class ShareLinkTest {

    @Test
    fun `a real post link is accepted, on either host`() {
        assertTrue(looksLikeXPost("https://x.com/AlexKosa1/status/2091830155270672521"))
        assertTrue(looksLikeXPost("https://twitter.com/AlexKosa1/status/2091830155270672521"))
        assertTrue(looksLikeXPost("https://www.x.com/AlexKosa1/status/1"))
        // Trailing query junk is what a share sheet actually hands you.
        assertTrue(looksLikeXPost("https://x.com/AlexKosa1/status/2091830155270672521?s=20"))
        assertTrue(looksLikeXPost("  https://x.com/AlexKosa1/status/2091830155270672521  "))
    }

    @Test
    fun `a profile, a search or a bare handle is not a post`() {
        assertFalse(looksLikeXPost("https://x.com/AlexKosa1"))
        assertFalse(looksLikeXPost("@AlexKosa1"))
        assertFalse(looksLikeXPost("https://x.com/search?q=flop"))
        assertFalse(looksLikeXPost("https://x.com/AlexKosa1/status/"))
        assertFalse(looksLikeXPost(""))
        assertFalse(looksLikeXPost("   "))
    }

    @Test
    fun `plain http is refused, because a note is read by strangers`() {
        assertFalse(looksLikeXPost("http://x.com/AlexKosa1/status/1"))
        assertFalse(looksLikeUrl("http://github.com/busminer/floop"))
    }

    @Test
    fun `a lookalike host does not pass`() {
        // The check exists to catch a bad paste, but it must not wave through the one
        // paste that is actively hostile: a host that merely contains the real one.
        assertFalse(looksLikeXPost("https://x.com.evil.tld/a/status/1"))
        assertFalse(looksLikeXPost("https://notx.com/a/status/1"))
    }

    @Test
    fun `an ordinary https link counts as a contribution link`() {
        assertTrue(looksLikeUrl("https://github.com/busminer/floop"))
        assertTrue(looksLikeUrl("https://flop.alexkosa.dev"))
        assertFalse(looksLikeUrl("github.com/busminer/floop"))
        assertFalse(looksLikeUrl("https://localhost"))
        assertFalse(looksLikeUrl(""))
    }
}
