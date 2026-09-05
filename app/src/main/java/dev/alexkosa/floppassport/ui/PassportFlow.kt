package dev.alexkosa.floppassport.ui

/**
 * The five steps of setting up a Passport, and the honest state of each one.
 *
 * This exists so the screen can never be vague. Every button press moves exactly one step,
 * the step says out loud what it is doing and to whom, and when it finishes it leaves
 * evidence the user can open. There is no state in this app that means "something
 * happened, probably".
 */
enum class Step(val ordinal1: String, val title: String) {
    Create("01", "Create"),
    Protect("02", "Protect"),
    Publish("03", "Publish"),
    CheckIn("04", "Check in"),
    Ready("05", "Ready");

    companion object {
        val all: List<Step> = entries
    }
}

/**
 * What a step is doing right now.
 *
 * [Verified] is the only success. It is set after the record has been read back from the
 * server and matched, never on an HTTP 200 - a service can accept a write and still not
 * have it, and a green tick that means "the request did not error" is a lie the user
 * cannot detect.
 *
 * [Unconfirmed] is deliberately not a failure. The write may well have landed; what failed
 * was our confirmation of it. The difference matters because the safe action is to re-read,
 * and treating it as an error invites the user to press the button again and post twice in
 * public.
 */
sealed interface StepState {
    data object Pending : StepState

    /** [what] is shown while it runs: plain words, naming who we are talking to. */
    data class Running(val what: String) : StepState

    data class Verified(val summary: String, val evidence: Evidence? = null) : StepState

    data class Failed(
        val summary: String,
        /** Whether anything was published before this failed. The user must be told. */
        val publishedSomething: Boolean,
        val whatToDo: String,
        val detail: String? = null,
    ) : StepState

    data class Unconfirmed(
        val summary: String,
        val whatToDo: String,
        val detail: String? = null,
    ) : StepState
}

/** The raw facts behind a finished step, for the user who wants to see them. */
data class Evidence(val lines: List<Pair<String, String>>) {
    constructor(vararg pairs: Pair<String, String>) : this(pairs.toList())
}

data class FlowState(
    val steps: Map<Step, StepState> = Step.all.associateWith { StepState.Pending },
) {
    operator fun get(step: Step): StepState = steps[step] ?: StepState.Pending

    fun with(step: Step, state: StepState): FlowState =
        copy(steps = steps + (step to state))

    fun running(step: Step, what: String) = with(step, StepState.Running(what))

    val busy: Boolean get() = steps.values.any { it is StepState.Running }

    /** True only when every step has actually been verified. */
    val complete: Boolean get() = Step.all.all { steps[it] is StepState.Verified }

    /**
     * The first step that still needs the user. Drives which action the screen offers, so
     * the button on screen is always the next thing to do rather than a menu of choices.
     */
    val next: Step?
        get() = Step.all.firstOrNull { steps[it] !is StepState.Verified }

    /**
     * True when something public has already been written. The delete and retry paths read
     * this, because "start over" means something different once a record exists that
     * strangers can fetch.
     */
    val hasPublished: Boolean
        get() = steps.any { (_, s) ->
            s is StepState.Verified && s.evidence != null ||
                s is StepState.Unconfirmed ||
                (s is StepState.Failed && s.publishedSomething)
        }
}
