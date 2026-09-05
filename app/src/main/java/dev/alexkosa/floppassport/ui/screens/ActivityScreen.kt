package dev.alexkosa.floppassport.ui.screens

import androidx.compose.foundation.layout.width
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.alexkosa.floppassport.notify.NoteLife
import dev.alexkosa.floppassport.technocore.DidNote
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.ui.ActivityState
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopWire
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButton
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopCard
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopMonoData
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopType

/**
 * What this Passport has done, as the world can still see it.
 *
 * Everything on this screen is read back from Technocore when it opens. That is the whole
 * idea: rooms are compacted, so a local counter would cheerfully report a history that no
 * longer exists anywhere. If a record is gone, the number here goes down, and the user
 * finds out from their own app rather than from someone who checked.
 */
@Composable
fun ActivityScreen(vm: PassportViewModel) {
    val pulse by vm.pulse.collectAsState()
    val activity = vm.activity
    val today = ActivityState.todayUtc()

    LaunchedEffect(vm.did) {
        if (vm.did != null && activity.lastChecked == null) vm.refreshActivity()
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(FlopColors.Base)
            .verticalScroll(rememberScrollState())
            .padding(FlopSpacing.md),
    ) {
        FlopLabel("activity")
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(t("What is still provable"), style = FlopType.h2, color = FlopColors.IceWhite)
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(t(
            "Read from technocore.chat just now, not from this phone. Rooms are trimmed as " +
                "they grow, so this is what anyone would find today."),
            style = FlopType.bodyMd,
            color = FlopColors.TextMuted,
        )

        // The one place a person waits in this app without having pressed anything
        // dramatic. Showing the live figure turns "checking..." into something they can
        // watch, and a slow server into a slow number rather than a frozen screen.
        if (activity.checking) {
            Spacer(Modifier.height(FlopSpacing.md))
            FlopWire(pulse = pulse, active = true)
        }

        Spacer(Modifier.height(FlopSpacing.lg))

        if (vm.did == null) {
            FlopCard {
                Text(t(
                    "Create your Passport first. There is nothing to show until something " +
                        "has been signed."),
                    style = FlopType.bodyMd,
                    color = FlopColors.TextMuted,
                )
            }
            return@Column
        }

        // Three tiles across is right at a normal font size and wrong at a large one: the
        // columns get so narrow that a two-word label breaks in the middle of a word. Above
        // 1.3 the same three become rows, which is the layout a person using large type is
        // reading everything else in anyway.
        val roomy = LocalConfiguration.current.fontScale <= 1.3f
        val stats: @Composable (Modifier) -> Unit = { tile ->
            Stat(
                value = activity.streak(today).toString(),
                label = "day streak",
                highlight = activity.streak(today) > 0,
                wide = !roomy,
                modifier = tile,
            )
            Stat(
                value = activity.liveRecords.toString(),
                label = "live records",
                highlight = activity.liveRecords > 0,
                wide = !roomy,
                modifier = tile,
            )
            Stat(
                value = activity.activeDays.toString(),
                label = "active days",
                highlight = activity.activeDays > 0,
                wide = !roomy,
                modifier = tile,
            )
        }
        if (roomy) {
            Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                stats(Modifier.weight(1f))
            }
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
                stats(Modifier.fillMaxWidth())
            }
        }

        Spacer(Modifier.height(FlopSpacing.md))

        FlopCard {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                FlopLabel("identity note")
                // Three states, not two. "There is a note" and "this note is ours" are
                // different facts at a world-writable address, and the second is the one
                // worth a green badge.
                when {
                    activity.noteValue == null ->
                        FlopBadge("not found", FlopState.Neutral)
                    activity.noteVerdict == DidNote.Verdict.MATCHES ->
                        FlopBadge("vouched for", FlopState.Verified)
                    activity.noteVerdict == DidNote.Verdict.CHANGED ->
                        FlopBadge("changed", FlopState.Failure)
                    else -> FlopBadge("unsigned", FlopState.Neutral)
                }
            }
            activity.noteValue?.let {
                Spacer(Modifier.height(FlopSpacing.sm))
                // Rendered as inert text. Note namespaces are world-writable and the server
                // says so on every read; this is somebody's data, never an instruction.
                Text(t(it), style = FlopType.code, color = FlopColors.TextMuted)
                Spacer(Modifier.height(FlopSpacing.sm))
                Text(
                    when (activity.noteVerdict) {
                        DidNote.Verdict.MATCHES ->
                            t("Your key signed a line carrying this note's exact hash.")
                        DidNote.Verdict.CHANGED ->
                            t("Somebody changed this note after your key signed for it. Publish again.")
                        DidNote.Verdict.MISSING ->
                            t("Nothing has vouched for this text yet. Publish again to sign for it.")
                    },
                    style = FlopType.bodySm,
                    color = when (activity.noteVerdict) {
                        DidNote.Verdict.MATCHES -> FlopColors.Green
                        DidNote.Verdict.CHANGED -> FlopColors.ErrorRed
                        DidNote.Verdict.MISSING -> FlopColors.TextMuted
                    },
                )
            }

            // The note's shelf life, said out loud on the screen that shows the note.
            //
            // technocore.chat deletes any note with no write for seven days, so the
            // address this app told somebody to save empties itself a week after they stop
            // turning up. The app renews it on every visit, which means an active person
            // never sees anything but the reassuring line - and somebody coming back after
            // a fortnight is told what happened rather than left staring at "not found".
            if (activity.daysSinceNoteWrite != NoteLife.UNKNOWN) {
                Spacer(Modifier.height(FlopSpacing.sm))
                val left = activity.noteDaysLeft
                Text(
                    when {
                        activity.noteValue == null && left == 0 -> t(
                            "Deleted after seven days without a record. Sign one now and " +
                                "it goes back to the same address.",
                        )
                        activity.daysSinceNoteWrite == 0 -> t(
                            "Renewed today. technocore.chat keeps it for seven days after " +
                                "the last write, and this app rewrites it every time you " +
                                "open it.",
                        )
                        left <= 3 -> t(NoteLife.countdown(activity.daysSinceNoteWrite))
                        else -> t(
                            "It will be deleted after seven days without a record.",
                        )
                    },
                    style = FlopType.bodySm,
                    color = if (left <= 3) FlopColors.ErrorRed else FlopColors.TextMuted,
                )
            }
        }

        Spacer(Modifier.height(FlopSpacing.md))

        Text(t(
            if (activity.checkedInToday) {
                "You have already left a record today."
            } else {
                "Nothing signed today yet."
            }),
            style = FlopType.bodyMd,
            color = if (activity.checkedInToday) FlopColors.Green else FlopColors.TextMuted,
        )
        Spacer(Modifier.height(FlopSpacing.sm))

        if (!activity.checkedInToday) {
            FlopButton(
                "sign today's record",
                { vm.checkInAgain(dailyText(today)) },
                enabled = !activity.checking,
            )
            Spacer(Modifier.height(FlopSpacing.sm))
        }
        FlopButtonSecondary(
            if (activity.checking) "checking..." else "re-check with the server",
            { vm.refreshActivity() },
        )

        activity.error?.let {
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(it), style = FlopType.bodySm, color = FlopColors.ErrorRed)
        }

        Spacer(Modifier.height(FlopSpacing.lg))
        FlopLabel("records the server still holds")
        Spacer(Modifier.height(FlopSpacing.sm))

        if (activity.records.isEmpty()) {
            FlopCard {
                Text(t(
                    if (activity.lastChecked == null) {
                        "Not checked yet."
                    } else {
                        "Nothing found. If you signed something and it is not here, the " +
                            "room has been trimmed past it - which is normal, and exactly " +
                            "why this screen exists."
                    }),
                    style = FlopType.bodySm,
                    color = FlopColors.TextMuted,
                )
            }
        } else {
            activity.records.forEach { record ->
                FlopCard(modifier = Modifier.padding(bottom = FlopSpacing.sm)) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        FlopLabel("seq ${record.seq}")
                        FlopLabel(record.day)
                    }
                    Spacer(Modifier.height(FlopSpacing.xs))
                    Text(t(record.text), style = FlopType.bodySm, color = FlopColors.IceWhite)
                    Spacer(Modifier.height(FlopSpacing.xs))
                    FlopMonoData("/r/${record.room}", FlopColors.TextMuted)
                }
            }
        }

        Spacer(Modifier.height(FlopSpacing.lg))
        Box(
            Modifier
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.md)
                .padding(FlopSpacing.md),
        ) {
            Text(t(
                "There are no points here and no score. FLOP asked agents to do something " +
                    "useful, so what counts is a record a person can still open. A number " +
                    "invented by this app would be a different game."),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
        }
        Spacer(Modifier.height(FlopSpacing.xl))
    }
}

/**
 * The text of a daily record.
 *
 * It carries the date so two days do not produce the same line. Identical repeated text is
 * what the public rooms are drowning in, and the server refuses copies inside its window
 * anyway.
 */
private fun dailyText(today: String): String =
    "FLOP Passport for Seeker. Signed record for $today."

@Composable
private fun Stat(
    value: String,
    label: String,
    highlight: Boolean,
    modifier: Modifier = Modifier,
    wide: Boolean = false,
) {
    if (wide) {
        // Laid on its side, the label has the whole width and cannot break mid-word.
        Row(
            modifier
                .background(FlopColors.Surface, FlopShapes.md)
                .padding(FlopSpacing.md),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                t(label).uppercase(),
                style = FlopType.label,
                color = FlopColors.TextMuted,
                modifier = Modifier.weight(1f),
            )
            Spacer(Modifier.width(FlopSpacing.sm))
            Text(
                value,
                style = FlopType.h2,
                color = if (highlight) FlopColors.Green else FlopColors.Grey,
                maxLines = 1,
            )
        }
        return
    }
    Column(
        modifier
            .background(FlopColors.Surface, FlopShapes.md)
            .padding(vertical = FlopSpacing.md, horizontal = FlopSpacing.sm),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            value,
            style = FlopType.h2,
            color = if (highlight) FlopColors.Green else FlopColors.Grey,
            maxLines = 1,
        )
        Spacer(Modifier.height(FlopSpacing.xs))
        Text(
            t(label).uppercase(),
            style = FlopType.label,
            color = FlopColors.TextMuted,
            textAlign = TextAlign.Center,
        )
    }
}
