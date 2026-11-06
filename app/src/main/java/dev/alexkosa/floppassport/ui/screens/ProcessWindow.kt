package dev.alexkosa.floppassport.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.i18n.tu
import dev.alexkosa.floppassport.ui.ActivityState
import dev.alexkosa.floppassport.ui.FlopViewModel
import dev.alexkosa.floppassport.ui.FlopViewModel.DayResult
import dev.alexkosa.floppassport.ui.FlopViewModel.DayStep
import dev.alexkosa.floppassport.ui.FlopViewModel.Live
import dev.alexkosa.floppassport.ui.FlopViewModel.PingTarget
import dev.alexkosa.floppassport.ui.FlopViewModel.RunKind
import dev.alexkosa.floppassport.ui.FlopViewModel.Stage
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButton
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonGreen
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopType
import dev.alexkosa.floppassport.ui.designsystem.raisedCard
import dev.alexkosa.floppassport.ui.designsystem.well
import kotlinx.coroutines.delay

/**
 * Everything that takes time happens here, in its own window, as a process you can watch.
 *
 * A wait on a network this young can run to minutes, and a line of text saying "working" looks
 * exactly like a hung screen. So the window says what is happening, why that is fine, how long
 * it has been, which try this is, and how the server answers a ping. It only ever shows what
 * the view model knows: closing it costs nothing, because the job does not live here.
 */
@Composable
fun BoxScope.ProcessWindow(vm: PassportViewModel, flop: FlopViewModel, onRetryDay: () -> Unit) {
    val run = flop.run
    val open = run != null && !run.minimized

    BackHandler(open) { flop.closeRun() }

    AnimatedVisibility(open, enter = fadeIn(), exit = fadeOut()) {
        Box(
            Modifier
                .fillMaxSize()
                .background(FlopColors.Ink.copy(alpha = 0.72f))
                .clickable(remember { MutableInteractionSource() }, indication = null) { flop.closeRun() },
        )
    }
    AnimatedVisibility(
        open,
        modifier = Modifier.align(Alignment.BottomCenter),
        enter = slideInVertically { it },
        exit = slideOutVertically { it },
    ) {
        val current = flop.run ?: return@AnimatedVisibility
        val maxHeight = (LocalConfiguration.current.screenHeightDp * 0.88f).dp
        Column(
            Modifier
                .fillMaxWidth()
                .heightIn(max = maxHeight)
                .clip(FlopShapes.sheet)
                .background(Brush.verticalGradient(listOf(FlopColors.SurfaceRaised, FlopColors.Base)))
                .border(1.dp, Brush.verticalGradient(0f to FlopColors.IceWhite.copy(alpha = 0.14f), 0.2f to Color.Transparent), FlopShapes.sheet)
                .clickable(remember { MutableInteractionSource() }, indication = null) {}
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(Modifier.width(44.dp).height(4.dp).background(FlopColors.SurfaceLight, FlopShapes.pill))
            when (current.kind) {
                RunKind.Ask -> AskWindow(flop, current.question.orEmpty())
                RunKind.Day -> DayWindow(vm, flop, onRetryDay)
            }
        }
    }
}

/** The elapsed clock and the countdown, ticking once a second while a run is alive. */
@Composable
private fun rememberNow(): Long {
    var now by remember { mutableLongStateOf(System.currentTimeMillis()) }
    LaunchedEffect(Unit) {
        while (true) {
            now = System.currentTimeMillis()
            delay(500)
        }
    }
    return now
}

private fun clock(seconds: Long): String = "%d:%02d".format(seconds / 60, seconds % 60)

@Composable
private fun WindowHeader(title: String, pill: String, state: FlopState) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        FlopLabel(title, modifier = Modifier.weight(1f))
        FlopBadge(pill, state)
    }
}

/** The big turning ring: a wheel while working, draining while it counts down to the next try. */
@Composable
private fun WaitRing(live: Live?, now: Long) {
    val turn by rememberInfiniteTransition(label = "turn").animateFloat(
        0f, 360f, infiniteRepeatable(tween(1200, easing = LinearEasing), RepeatMode.Restart), label = "turning",
    )
    val left = live?.waitLeft(now)
    val toNext = live?.secondsToNext(now)
    val elapsed = live?.secondsSoFar(now) ?: 0
    Box(Modifier.size(124.dp), contentAlignment = Alignment.Center) {
        Canvas(Modifier.size(124.dp).rotate(if (left == null) turn else -90f)) {
            val stroke = Stroke(width = 10.dp.toPx(), cap = StrokeCap.Round)
            val inset = stroke.width / 2
            val arc = androidx.compose.ui.geometry.Size(size.width - stroke.width, size.height - stroke.width)
            val at = androidx.compose.ui.geometry.Offset(inset, inset)
            drawArc(FlopColors.SurfaceLight, 0f, 360f, false, at, arc, style = stroke)
            drawArc(FlopColors.Cyan, 0f, if (left == null) 270f else 360f * left, false, at, arc, style = stroke)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(clock(toNext ?: elapsed), style = FlopType.h2, color = FlopColors.IceWhite)
            if (toNext != null) {
                Text(t("to next try"), style = FlopType.bodySm.copy(fontSize = 11.sp), color = FlopColors.TextMuted)
            }
        }
    }
}

/** While the model is full nobody has to sit out our timer: they can knock themselves. */
@Composable
private fun KnockNow(live: Live?, flop: FlopViewModel) {
    if (live == null || live.nextAt == 0L) return
    if (live.stage != Stage.Full && live.stage != Stage.Settling) return
    FlopButton("knock now", { flop.knockNow() })
    Text(
        t("A refused knock costs nothing. Knock as often as you like."),
        style = FlopType.bodySm,
        color = FlopColors.TextMuted,
        textAlign = TextAlign.Center,
    )
}

/** The green check that replaces the ring: it worked. */
@Composable
private fun DoneMark(size: Dp = 96.dp) {
    Box(
        Modifier
            .size(size)
            .background(Brush.verticalGradient(listOf(FlopColors.GreenTop, FlopColors.Green, FlopColors.GreenDeep)), FlopShapes.pill),
        contentAlignment = Alignment.Center,
    ) {
        Text("✓", style = FlopType.h1.copy(fontSize = 44.sp), color = FlopColors.Base)
    }
}

/** Facts in small wells: how long, which try, how the server answers. */
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Facts(live: Live, flop: FlopViewModel, now: Long) {
    FlowRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Fact(t("elapsed {t}", "t" to clock(live.secondsSoFar(now))))
        if (live.attempts > 0) {
            Fact(t("try {n} of {m}", "n" to live.attempt.toString(), "m" to live.attempts.toString()))
        }
        when (live.target) {
            PingTarget.Gateway -> flop.gatewayPing?.let { p ->
                Fact(p.ms?.let { t("gateway ping {n} ms", "n" to it.toString()) } ?: t("the gateway does not answer a ping"))
            }
            PingTarget.Faucet -> flop.faucetPing?.let { p ->
                Fact(p.ms?.let { t("faucet ping {n} ms", "n" to it.toString()) } ?: t("the faucet does not answer a ping"))
            }
            null -> Unit
        }
    }
}

@Composable
private fun Fact(text: String) {
    Text(
        text,
        style = FlopType.label.copy(letterSpacing = 0.sp),
        color = FlopColors.TextMuted,
        modifier = Modifier.well().padding(horizontal = 10.dp, vertical = 6.dp),
    )
}

/** What is happening and why it is fine, fading from one stage to the next. */
@Composable
private fun StageWords(stage: Stage?) {
    Crossfade(stage, label = "stage") { s ->
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                t(s?.title ?: "One moment."),
                style = FlopType.cardTitle.copy(fontSize = 19.sp, lineHeight = 25.sp),
                color = FlopColors.IceWhite,
                textAlign = TextAlign.Center,
            )
            if (s != null) {
                Spacer(Modifier.height(FlopSpacing.xs))
                Text(t(s.text), style = FlopType.bodyMd, color = FlopColors.TextMuted, textAlign = TextAlign.Center)
            }
        }
    }
}

private enum class Mark { Todo, Running, Done, Off, Failed }

/** One line of the process: a raised number that turns into a tick. */
@Composable
private fun StepLine(number: String, title: String, note: String?, mark: Mark) {
    val pulse by rememberInfiniteTransition(label = "pulse").animateFloat(
        0.55f, 1f, infiniteRepeatable(tween(700), RepeatMode.Reverse), label = "pulsing",
    )
    val (fill, ink) = when (mark) {
        Mark.Done -> FlopColors.Green to FlopColors.Base
        Mark.Running -> FlopColors.Cyan.copy(alpha = pulse) to FlopColors.Base
        Mark.Failed -> FlopColors.Base to FlopColors.ErrorRed
        Mark.Off, Mark.Todo -> FlopColors.SurfaceLight to FlopColors.TextMuted
    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .size(30.dp)
                .background(fill, FlopShapes.sm)
                .then(if (mark == Mark.Failed) Modifier.border(1.dp, FlopColors.ErrorRed, FlopShapes.sm) else Modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                when (mark) {
                    Mark.Done -> "✓"
                    Mark.Failed -> "!"
                    Mark.Off -> "–"
                    else -> number
                },
                style = FlopType.label.copy(fontSize = 13.sp),
                color = ink,
            )
        }
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Text(t(title), style = FlopType.bodyMd, color = if (mark == Mark.Todo) FlopColors.TextMuted else FlopColors.IceWhite)
            if (!note.isNullOrBlank()) {
                Text(
                    note,
                    style = FlopType.bodySm,
                    color = when (mark) {
                        Mark.Done -> FlopColors.Green
                        Mark.Failed -> FlopColors.ErrorRed
                        else -> FlopColors.TextMuted
                    },
                )
            }
        }
    }
}

/** The promise that matters most, said as soon as it is true. */
@Composable
private fun SafeNote(text: String, good: Boolean = true) {
    val c = if (good) FlopColors.Green else FlopColors.ErrorRed
    Text(
        t(text),
        style = FlopType.bodySm,
        color = c,
        modifier = Modifier
            .fillMaxWidth()
            .background(c.copy(alpha = 0.1f), FlopShapes.md)
            .padding(horizontal = 12.dp, vertical = 10.dp),
    )
}

@Composable
private fun AnswerCard(label: String, answer: String, footer: String?) {
    Column(Modifier.fillMaxWidth().raisedCard().padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
        FlopLabel(label)
        Text(answer, style = FlopType.bodyMd, color = FlopColors.IceWhite)
        footer?.let { Text(it, style = FlopType.label.copy(letterSpacing = 0.sp), color = FlopColors.Cyan) }
    }
}

private fun cost(c: Double?): String = c?.let { "%.3f".format(it) } ?: "—"

// ------------------------------------------------------------------ one question

@Composable
private fun AskWindow(flop: FlopViewModel, question: String) {
    val now = rememberNow()
    val live = flop.live
    val result = flop.askResult
    when {
        result?.answer != null -> {
            WindowHeader("ask the model", "done", FlopState.Verified)
            DoneMark()
            Text(t("Answered"), style = FlopType.title, color = FlopColors.Green)
            Text(
                t("cost {c} FLOP · {s} s", "c" to cost(result.cost), "s" to result.seconds.toString()),
                style = FlopType.label.copy(letterSpacing = 0.sp),
                color = FlopColors.TextMuted,
            )
            AnswerCard(question, result.answer, null)
            FlopButtonGreen("done", { flop.closeRun() })
        }
        result != null -> {
            WindowHeader("ask the model", "not now", FlopState.Neutral)
            Text(
                t("The model did not answer"),
                style = FlopType.cardTitle.copy(fontSize = 19.sp),
                color = FlopColors.IceWhite,
                textAlign = TextAlign.Center,
            )
            Text(t(result.failure.orEmpty()), style = FlopType.bodyMd, color = FlopColors.TextMuted, textAlign = TextAlign.Center)
            AnswerCard("your question", question, null)
            FlopButton("try again", { flop.ask(question) })
            FlopButtonSecondary("close", { flop.closeRun() })
        }
        else -> {
            val waiting = live?.nextAt?.let { it != 0L } == true
            WindowHeader("ask the model", if (waiting) "waiting" else "working", FlopState.Active)
            WaitRing(live, now)
            StageWords(live?.stage)
            live?.let { Facts(it, flop, now) }
            KnockNow(live, flop)
            val stage = live?.stage
            val connected = stage != null && stage != Stage.Enter
            StepLine("1", "Connect your Passport", null, if (connected) Mark.Done else Mark.Running)
            StepLine(
                "2", "Ask the model", question,
                when {
                    stage == Stage.Cost -> Mark.Done
                    connected -> Mark.Running
                    else -> Mark.Todo
                },
            )
            StepLine("3", "Get the answer", null, if (stage == Stage.Cost) Mark.Running else Mark.Todo)
            FlopButtonSecondary("minimise · it keeps going", { flop.minimizeRun() })
        }
    }
}

// ------------------------------------------------------------------ the whole day

@Composable
private fun DayWindow(vm: PassportViewModel, flop: FlopViewModel, onRetryDay: () -> Unit) {
    val now = rememberNow()
    val day = flop.dayToday
    val live = flop.live
    val streak = vm.activity.streak(ActivityState.today())
    val signResult = day[DayStep.Sign]
    val fundResult = day[DayStep.Fund]
    val askResult = day[DayStep.Ask]
    val signed = signResult is DayResult.Done
    val allDone = signed && fundResult is DayResult.Done && askResult is DayResult.Done

    when {
        day.running -> {
            val waiting = live?.nextAt?.let { it != 0L } == true
            WindowHeader(
                t("my day · step {n} of 3", "n" to day.stepNumber.coerceAtLeast(1).toString()),
                if (waiting) "waiting" else "working",
                FlopState.Active,
            )
            WaitRing(live, now)
            StageWords(live?.stage)
            live?.let { Facts(it, flop, now) }
            KnockNow(live, flop)
        }
        allDone -> {
            WindowHeader("my day", "done", FlopState.Verified)
            DoneMark()
            Text(t("Your day is closed"), style = FlopType.title, color = FlopColors.Green, textAlign = TextAlign.Center)
            Text(t("See you tomorrow."), style = FlopType.bodyMd, color = FlopColors.TextMuted)
        }
        signed -> {
            WindowHeader("my day", "not now", FlopState.Neutral)
            DoneMark(64.dp)
            Text(
                t("Today is signed"),
                style = FlopType.cardTitle.copy(fontSize = 19.sp),
                color = FlopColors.IceWhite,
            )
        }
        else -> {
            WindowHeader("my day", "not today", FlopState.Failure)
            Text(
                t("Could not sign today"),
                style = FlopType.cardTitle.copy(fontSize = 19.sp),
                color = FlopColors.IceWhite,
            )
        }
    }

    StepLine("1", "Sign today", note(signResult), mark(signResult))
    StepLine("2", "Get 25 FLOP", note(fundResult), mark(fundResult))
    StepLine("3", "Ask the model", note(askResult), mark(askResult))

    when {
        signed -> SafeNote(t("Your day is signed. Your streak of {n} is safe whatever happens next.", "n" to streak.toString()))
        !day.running -> SafeNote("Today is not signed yet. One missed day a week is forgiven; two in a row end the streak.", good = false)
    }

    day.answer?.let { answer ->
        AnswerCard(t("question of the day: {q}", "q" to t(flop.questionOfTheDay())), answer, null)
    }

    if (day.running) {
        FlopButtonSecondary("minimise · it keeps going", { flop.minimizeRun() })
    } else if (allDone) {
        FlopButtonGreen("done", { flop.closeRun() })
    } else {
        FlopButton("try again", onRetryDay)
        FlopButtonSecondary("close", { flop.closeRun() })
    }
}

private fun mark(r: DayResult?): Mark = when (r) {
    DayResult.Running -> Mark.Running
    is DayResult.Done -> Mark.Done
    is DayResult.Skipped -> Mark.Off
    is DayResult.Failed -> Mark.Failed
    else -> Mark.Todo
}

@Composable
private fun note(r: DayResult?): String? = when (r) {
    is DayResult.Done -> t(r.note)
    is DayResult.Skipped -> t(r.why)
    is DayResult.Failed -> t(r.why)
    else -> null
}

// ------------------------------------------------------------------ minimised

/** The job, one line high, above the tabs on every tab. It stays until it has been seen. */
@Composable
fun ProcessPill(flop: FlopViewModel) {
    val run = flop.run ?: return
    if (!run.minimized) return
    val now = rememberNow()
    val live = flop.live
    val busy = flop.runBusy
    val failed = !busy && when (run.kind) {
        RunKind.Ask -> flop.askResult?.answer == null
        RunKind.Day -> flop.dayToday[DayStep.Ask] !is DayResult.Done || flop.dayToday[DayStep.Fund] !is DayResult.Done
    }
    val tint = when {
        busy -> FlopColors.Cyan
        failed -> FlopColors.TextMuted
        else -> FlopColors.Green
    }
    val line = when {
        busy && live != null -> {
            val next = live.secondsToNext(now)
            t(live.stage.title) + " · " + clock(next ?: live.secondsSoFar(now))
        }
        busy -> tu("working")
        failed -> t(if (run.kind == RunKind.Ask) "The model did not answer" else "Part of your day waits")
        else -> t(if (run.kind == RunKind.Ask) "Answered" else "Your day is closed")
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 6.dp)
            .raisedCard(rim = tint.copy(alpha = 0.5f))
            .clickable { flop.openRun() }
            .padding(horizontal = 14.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(Modifier.size(10.dp).background(tint, FlopShapes.pill))
        Spacer(Modifier.width(10.dp))
        Text(line, style = FlopType.bodySm, color = FlopColors.IceWhite, modifier = Modifier.weight(1f), maxLines = 1)
        Text(tu("open"), style = FlopType.label, color = tint)
    }
}
