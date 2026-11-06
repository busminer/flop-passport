package dev.alexkosa.floppassport.ui.screens

import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import dev.alexkosa.floppassport.crypto.Ss58
import dev.alexkosa.floppassport.flop.FlopAmount
import dev.alexkosa.floppassport.flop.FlopStatus
import dev.alexkosa.floppassport.i18n.LocalTranslator
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.i18n.tu
import dev.alexkosa.floppassport.ui.ActivityState
import dev.alexkosa.floppassport.ui.FlopViewModel
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.Step
import dev.alexkosa.floppassport.ui.StepState
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButton
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopType
import dev.alexkosa.floppassport.ui.designsystem.raisedCard

/**
 * Home. The Passport first, because it is what a person comes back to; the day second, as one
 * raised button; what is going on at FLOP third. Everything that takes time opens the process
 * window, so nothing on this screen ever has to say "working".
 */
@Composable
fun TodayScreen(
    vm: PassportViewModel,
    flop: FlopViewModel,
    onOpenAsk: () -> Unit,
    onOpenGuide: () -> Unit,
    onOpenPulse: () -> Unit,
) {
    val activity = vm.activity
    val today = ActivityState.today()
    val streak = activity.streakInfo(today)
    val known = activity.lastChecked != null
    val signed = activity.checkedInToday

    LaunchedEffect(Unit) {
        flop.refreshAccount()
        flop.refreshPing()
        flop.refreshCommunity()
        if (!activity.checking) vm.refreshActivity()
    }

    FlopScreen {
        FlopHeader("today", trailing = longDate(today))

        // Only when something stops the day. Said first, with the button that fixes it.
        vm.restoreError?.let { message ->
            Notice(message, FlopColors.ErrorRed) {
                FlopButtonSecondary("check again", {
                    vm.refreshFromServer()
                    vm.refreshActivity(force = true)
                })
            }
        }
        if (!vm.restoring && vm.restoreError == null && vm.flow[Step.Publish] !is StepState.Verified) {
            Notice(
                "Your identity note was deleted after seven quiet days. Publish it again to keep signing your days. Your streak is not lost.",
                FlopColors.ErrorRed,
            ) {
                FlopButton("publish again", { vm.publish() }, enabled = !vm.flow.busy)
            }
        }

        PassportHero(vm, flop, signed = signed, known = known, streak = streak)
        MyDay(vm, flop, signed = signed, onOpenAsk = onOpenAsk)
        flop.statusNow.referral?.let { ReferralCard(it) }
        StatusCard(flop, compact = true, onMore = onOpenGuide)

        flop.community?.let { c ->
            Text(
                t("{n} Passport holders · {m} signed today", "n" to "%,d".format(c.passports), "m" to c.signedToday.toString()),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
                modifier = Modifier.clickable(onClick = onOpenPulse).padding(vertical = FlopSpacing.xs),
            )
        }
        Spacer(Modifier.height(FlopSpacing.xs))
    }
}

/**
 * Alex's referral link, once FLOP has issued it and the site carries it.
 *
 * Says plainly whose link it is and who it may count for, shows where it goes, and offers the
 * way around it. The words live here, so the site can change the link and nothing else.
 */
@Composable
private fun ReferralCard(link: String) {
    val context = LocalContext.current
    Column(
        Modifier.fillMaxWidth().raisedCard().padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(t("Join FLOP with Alex's link"), style = FlopType.cardTitle, color = FlopColors.IceWhite)
        Text(
            t("This is Alex Kosa's personal referral link from FLOP, and it may count for him. It gives you nothing extra from this app. Prefer not to? Go to flop.finance yourself."),
            style = FlopType.bodySm,
            color = FlopColors.TextMuted,
        )
        FlopButton(
            t("open {host}", "host" to FlopStatus.hostOf(link)),
            { runCatching { context.startActivity(Intent(Intent.ACTION_VIEW, link.toUri())) } },
        )
    }
}

/** A calendar day the way this person's language writes it. */
@Composable
fun longDate(day: String, withYear: Boolean = false): String {
    val locale = java.util.Locale.forLanguageTag(LocalTranslator.current.lang.code)
    val pattern = if (withYear) "d MMM yyyy" else "d MMMM"
    return runCatching {
        java.time.LocalDate.parse(day).format(java.time.format.DateTimeFormatter.ofPattern(pattern, locale))
    }.getOrDefault(day)
}

@Composable
private fun PassportHero(
    vm: PassportViewModel,
    flop: FlopViewModel,
    signed: Boolean,
    known: Boolean,
    streak: ActivityState.Streak,
) {
    val today = ActivityState.today()
    val activity = vm.activity
    val cached = flop.cachedStats
    val days = if (known) streak.days else cached?.streak ?: 0
    val best = if (known) activity.bestStreak(today) else cached?.best ?: 0
    val firstDay = if (known) activity.firstDay else cached?.firstDay
    val haveNumber = known || cached != null
    val since = firstDay?.let { ActivityState.daysBetween(it, today) + 1 }

    val accent = when {
        signed -> FlopColors.Green
        streak.atRisk -> FlopColors.ErrorRed
        else -> FlopColors.Cyan
    }

    Column(
        Modifier
            .fillMaxWidth()
            .raisedCard(glow = if (signed) FlopColors.Green else FlopColors.Cyan)
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            StreakRing(days, best, haveNumber)
            Spacer(Modifier.width(FlopSpacing.md))
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                FlopLabel(t("passport · {name}", "name" to (vm.walletAddress?.let { Ss58.abbreviate(it) } ?: "Seeker")))
                Text(
                    t(if (days > 0) "Days in a row: {n}" else "Start your streak today", "n" to days.toString()),
                    style = FlopType.cardTitle,
                    color = FlopColors.IceWhite,
                )
                if (firstDay != null && since != null) {
                    Text(
                        t("Registered {date} · day {n} with us", "date" to longDate(firstDay), "n" to since.toString()),
                        style = FlopType.bodySm,
                        color = FlopColors.TextMuted,
                    )
                }
            }
        }
        if (known) WeekRow(activity, today)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.weight(1f)) {
                FlopBadge(
                    when {
                        !known -> "reading your days"
                        signed -> "today signed"
                        streak.atRisk -> "sign today or the streak ends"
                        else -> "today not signed yet"
                    },
                    when {
                        !known -> FlopState.Neutral
                        signed -> FlopState.Verified
                        streak.atRisk -> FlopState.Failure
                        else -> FlopState.Active
                    },
                )
            }
            flop.balance.value?.let {
                Text(FlopAmount.format(it), style = FlopType.number.copy(fontSize = 16.sp), color = accent.takeIf { signed } ?: FlopColors.IceWhite)
                Spacer(Modifier.width(FlopSpacing.xs))
                Text("FLOP", style = FlopType.label, color = FlopColors.TextMuted)
            }
        }
        streak.forgiven.firstOrNull()?.let { day ->
            Text(
                t("{day} was missed and forgiven: one missed day a week is.", "day" to longDate(day)),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
        }
    }
}

/** Green fills towards the best streak ever, so the ring has somewhere to go. */
@Composable
private fun StreakRing(days: Int, best: Int, known: Boolean) {
    val share = days.toFloat() / maxOf(best, 7)
    val sweep by animateFloatAsState(share.coerceIn(0f, 1f), tween(300), label = "streak")
    Box(Modifier.size(104.dp), contentAlignment = Alignment.Center) {
        Canvas(Modifier.size(104.dp)) {
            val stroke = Stroke(width = 9.dp.toPx(), cap = StrokeCap.Round)
            val inset = stroke.width / 2
            val arc = androidx.compose.ui.geometry.Size(size.width - stroke.width, size.height - stroke.width)
            val at = androidx.compose.ui.geometry.Offset(inset, inset)
            drawArc(FlopColors.SurfaceLight, 0f, 360f, false, at, arc, style = stroke)
            if (sweep > 0f) drawArc(FlopColors.Green, -90f, 360f * sweep, false, at, arc, style = stroke)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                // A dash until there is a number. A zero while the room is still being asked
                // read as "you lost it" on every launch of 1.0.
                if (known) days.toString() else "—",
                style = FlopType.h1,
                color = FlopColors.IceWhite,
            )
            Text(tu("in a row"), style = FlopType.label.copy(fontSize = 9.sp, letterSpacing = 0.sp), color = FlopColors.TextMuted)
        }
    }
}

/** The last seven days at a glance; today dashed until it is signed. */
@Composable
private fun WeekRow(activity: ActivityState, today: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        activity.lastWeek(today).forEach { (day, done) ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.size(30.dp), contentAlignment = Alignment.Center) {
                    if (day == today && !done) {
                        Canvas(Modifier.size(30.dp)) {
                            drawRoundRect(
                                FlopColors.Cyan,
                                cornerRadius = androidx.compose.ui.geometry.CornerRadius(9.dp.toPx()),
                                style = Stroke(width = 2.dp.toPx(), pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f))),
                            )
                        }
                    } else {
                        Box(
                            Modifier
                                .size(30.dp)
                                .background(if (done) FlopColors.Green else FlopColors.Base, FlopShapes.sm)
                                .border(1.dp, if (done) FlopColors.GreenDeep else FlopColors.SurfaceLight, FlopShapes.sm),
                            contentAlignment = Alignment.Center,
                        ) {
                            if (done) Text("✓", style = FlopType.label.copy(fontSize = 13.sp), color = FlopColors.Base)
                        }
                    }
                }
                Spacer(Modifier.height(3.dp))
                Text(day.takeLast(2).trimStart('0'), style = FlopType.label.copy(fontSize = 10.sp, letterSpacing = 0.sp), color = FlopColors.TextMuted)
            }
        }
    }
}

@Composable
private fun MyDay(vm: PassportViewModel, flop: FlopViewModel, signed: Boolean, onOpenAsk: () -> Unit) {
    val run = flop.dayToday
    val canSign = vm.flow[Step.Publish] is StepState.Verified && vm.flow[Step.CheckIn] is StepState.Verified
    val funded = flop.fundedToday
    val asked = flop.askedToday
    val allDone = signed && funded && asked
    val done = listOf(signed, funded, asked).count { it }

    Section(
        "my day on flop",
        accent = if (allDone) FlopColors.Green.copy(alpha = 0.6f) else FlopColors.Border,
        trailing = { Text(t("{n} of 3", "n" to done.toString()), style = FlopType.label, color = FlopColors.Cyan) },
    ) {
        DayRow("1", "Sign today", "Your Passport signs one public line. That line is your streak.", signed)
        DayRow(
            "2",
            "Get 25 FLOP",
            flop.nextFaucetAt?.let { t("From FLOP's faucet. Next in {time}.", "time" to until(it)) }
                ?: "From FLOP's faucet, once a day. Practice coins, no price.",
            funded,
        )
        DayRow("3", "Ask the model", "One question of the day, paid in FLOP.", asked)

        Spacer(Modifier.height(FlopSpacing.xs))
        when {
            !canSign && !vm.restoring -> FlopButton("finish your passport first", {}, enabled = false)
            allDone -> {
                Text(t("Your day is done."), style = FlopType.bodyMd, color = FlopColors.Green)
                FlopButtonSecondary("ask the model something else", onOpenAsk)
            }
            run.running -> FlopButton(t("step {n} of 3", "n" to run.stepNumber.coerceAtLeast(1).toString()), { flop.openRun() })
            else -> {
                FlopButton(
                    "do my day",
                    { flop.doMyDay(alreadySigned = signed) { vm.signToday() } },
                    enabled = !vm.restoring && !vm.activity.checking && !flop.runBusy,
                )
                Prose("One press, all three steps in order. What is already done is skipped.")
            }
        }
    }
}

@Composable
private fun DayRow(number: String, title: String, detail: String, done: Boolean) {
    Row(Modifier.fillMaxWidth().padding(vertical = 3.dp), verticalAlignment = Alignment.Top) {
        Box(
            Modifier
                .size(30.dp)
                .background(if (done) FlopColors.Green else FlopColors.Base, FlopShapes.sm)
                .border(1.dp, if (done) FlopColors.GreenDeep else FlopColors.SurfaceLight, FlopShapes.sm),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                if (done) "✓" else number,
                style = FlopType.label.copy(fontSize = 13.sp),
                color = if (done) FlopColors.Base else FlopColors.TextMuted,
            )
        }
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Text(t(title), style = FlopType.cardTitle.copy(fontSize = 14.5.sp), color = FlopColors.IceWhite)
            Text(t(detail), style = FlopType.bodySm, color = FlopColors.TextMuted)
        }
    }
}
