package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.ui.FlowState
import dev.alexkosa.floppassport.ui.Step
import dev.alexkosa.floppassport.ui.StepState
import dev.alexkosa.floppassport.ui.checkInText
import dev.alexkosa.floppassport.proof.looksLikeXPost
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The rules a release must not lose.
 *
 * Each of these is a defect that was actually found in this app, not a hypothetical. A
 * green test here means the specific way the app once lied to somebody cannot come back by
 * an edit that looks harmless.
 */
class FlowGatingTest {

    private fun verified(vararg steps: Step): FlowState {
        var state = FlowState()
        steps.forEach { state = state.with(it, StepState.Verified("done")) }
        return state
    }

    @Test
    fun `nothing is complete until every step is verified`() {
        assertFalse(FlowState().complete)
        assertFalse(verified(Step.Create).complete)
        assertFalse(verified(Step.Create, Step.Protect, Step.Publish, Step.CheckIn).complete)
        assertTrue(
            verified(Step.Create, Step.Protect, Step.Publish, Step.CheckIn, Step.Ready)
                .complete,
        )
    }

    @Test
    fun `a failed step is not a finished step`() {
        val state = verified(Step.Create, Step.Protect, Step.Publish, Step.CheckIn)
            .with(
                Step.Ready,
                StepState.Failed(
                    summary = "no",
                    publishedSomething = false,
                    whatToDo = "try again",
                ),
            )
        assertFalse(state.complete)
        assertEquals(Step.Ready, state.next)
    }

    @Test
    fun `an unconfirmed step is not a finished step either`() {
        val state = verified(Step.Create, Step.Protect, Step.Publish)
            .with(
                Step.CheckIn,
                StepState.Unconfirmed(summary = "sent", whatToDo = "check again"),
            )
        assertFalse(state.complete)
        assertEquals(Step.CheckIn, state.next)
    }

    @Test
    fun `a running step is not a finished step, and the flow says it is busy`() {
        val state = verified(Step.Create).with(Step.Protect, StepState.Running("working"))
        assertFalse(state.complete)
        assertTrue(state.busy)
        assertEquals(Step.Protect, state.next)
    }

    @Test
    fun `the next step is always the first one that is not verified`() {
        assertEquals(Step.Create, FlowState().next)
        assertEquals(Step.Protect, verified(Step.Create).next)
        // Verifying a later step out of order does not move the pointer past an earlier
        // one: a person cannot be sent to step 05 with step 03 still owed.
        assertEquals(Step.Protect, verified(Step.Create, Step.Ready).next)
    }

    @Test
    fun `the first signed line differs between two identities`() {
        val a = "did:key:z6Mkq2w8fJHnRES8sLV8ZC9YeiRG2eBJnLsqbvhyvg3zU1qs"
        val b = "did:key:z6Mkw1JAVEwLgronRpuuzvHTyiiUgdoQGqkHG8VXH847dqcJ"
        assertNotEquals(checkInText(a), checkInText(b))
        // And the same identity always writes the same sentence, so the app can find its
        // own record again instead of posting a second one.
        assertEquals(checkInText(a), checkInText(a))
        assertTrue(checkInText(a).startsWith("FLOP Passport for Seeker."))
    }

    @Test
    fun `the word yes is not a link to a post`() {
        // The return prompt used to accept any non-empty string and write it into the
        // public note, which lit the sixth tick for nothing.
        assertFalse(looksLikeXPost("yes"))
        assertFalse(looksLikeXPost("done"))
        assertFalse(looksLikeXPost(" "))
        assertFalse(looksLikeXPost("https://x.com/alex"))
        assertTrue(looksLikeXPost("https://x.com/AlexKosa1/status/2091830155270672521"))
    }
}
