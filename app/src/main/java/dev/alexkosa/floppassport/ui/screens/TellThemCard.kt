package dev.alexkosa.floppassport.ui.screens

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.foundation.layout.heightIn
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import dev.alexkosa.floppassport.ui.designsystem.FlopShapes
import dev.alexkosa.floppassport.i18n.t
import dev.alexkosa.floppassport.proof.PostComposer
import dev.alexkosa.floppassport.proof.looksLikeUrl
import dev.alexkosa.floppassport.proof.looksLikeXPost
import dev.alexkosa.floppassport.ui.PassportViewModel
import dev.alexkosa.floppassport.ui.designsystem.FlopBadge
import dev.alexkosa.floppassport.ui.designsystem.FlopButton
import dev.alexkosa.floppassport.ui.designsystem.FlopButtonSecondary
import dev.alexkosa.floppassport.ui.designsystem.FlopCard
import dev.alexkosa.floppassport.ui.designsystem.FlopColors
import dev.alexkosa.floppassport.ui.designsystem.FlopLabel
import dev.alexkosa.floppassport.ui.designsystem.FlopSpacing
import dev.alexkosa.floppassport.ui.designsystem.FlopState
import dev.alexkosa.floppassport.ui.designsystem.FlopType

/**
 * The second half of what FLOP actually asked for.
 *
 * On 24 August 2026 the project's own account named two things and attached the airdrop to
 * both: create a unique `did:key`, and do something useful to spread the word about
 * Technocore. Everything else in this app serves the first. Nothing served the second,
 * even though the post composer and the note's `x:` and `contribution:` fields were
 * written and tested months before this screen existed.
 *
 * What it does, in the order a person does it:
 *
 *  1. they write one line about what they actually did - their line, not ours, and it goes
 *     first in the post, because a bare identity post says nothing and reads as farming;
 *  2. the app builds the post around it: the full DID, never abbreviated, the link to
 *     their note so a stranger can check the key, and the credit line that tells the
 *     ecosystem where this person came from;
 *  3. they post it, then paste the link back, and the note starts carrying it.
 *
 * The third step is the one worth the trouble. A post carrying a DID proves the poster had
 * the text; a note carrying the post, at an address derived from the key, is the other
 * half of the pair. Together a reader can check both ends against one key. Rooms are
 * trimmed within the hour, so a record claiming the same thing is gone by evening - this
 * lives at the key's own address, and the app rewrites it before the seven days run out.
 */
@Composable
fun TellThemCard(vm: PassportViewModel) {
    val did = vm.did ?: return
    val context = LocalContext.current
    val clipboard = LocalClipboardManager.current

    val draft = vm.postDraft() ?: return
    // One place decides. The hint under the field and the state of the button are the
    // same fact shown twice, and they must never disagree with each other.
    // Two conditions, not one. A line can be a real sentence and still leave a post over
    // the limit, and X does not refuse those - it cuts them, most likely through the middle
    // of the key, which is the one thing in the post that has to survive whole.
    val ready = PostComposer.isRealSentence(vm.contributionLine) && draft.fits
    var xField by rememberSaveable { mutableStateOf(vm.xPostUrl) }
    var contribField by rememberSaveable { mutableStateOf(vm.contributionUrl) }
    var problem by remember { mutableStateOf<String?>(null) }
    var askForLink by remember { mutableStateOf(false) }

    // The question arrives when it is easiest to answer: the person is looking at this
    // screen again, having just posted, with the link still in their clipboard or one tap
    // away in the other app. A reminder tomorrow asks somebody to reconstruct what they
    // were doing; this asks somebody who already knows.
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME && vm.awaitingLink && vm.xPostUrl.isBlank()) {
                askForLink = true
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    if (askForLink) {
        FlopLinkPrompt(
            value = xField,
            onValueChange = { xField = it; problem = null },
            onDismiss = {
                askForLink = false
                problem = null
                vm.stopAwaitingLink()
            },
            error = problem,
            onSave = {
                val x = xField.trim()
                // The same check the card's own button makes. Without it this dialog took
                // any string at all - the word "yes" was enough - wrote it into the public
                // note as `x: yes`, read it back, lit the sixth tick and announced that
                // everything was done. The one control in the app that handed out a green
                // tick for nothing.
                if (!looksLikeXPost(x)) {
                    problem = "That does not look like a link to a post. It should look " +
                        "like https://x.com/you/status/123."
                } else {
                    vm.attachPostUrl(x)
                    problem = null
                    askForLink = false
                    vm.stopAwaitingLink()
                }
            },
        )
    }

    FlopCard {
        // Numbered like the ladder above it, because it is the same sequence continuing.
        // The five steps build the identity; this one is what the identity was for, and a
        // person who has just been walked through five numbered steps reads an unnumbered
        // box as something else entirely.
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FlopLabel("06  tell them")
            // Green only once the note came back from the server carrying the link. A URL
            // typed into a field on this phone is not evidence of anything to anyone else.
            if (vm.nameLinked) FlopBadge("linked", FlopState.Verified)
            else if (vm.xPostUrl.isNotBlank()) FlopBadge("publishing", FlopState.Active)
        }
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(
            t(
                "Three things, in this order: write your line, post it, then come back and " +
                    "paste the link. The last one is what makes it permanent, and it is the " +
                    "one people forget.",
            ),
            style = FlopType.h3,
            color = FlopColors.IceWhite,
        )
        Spacer(Modifier.height(FlopSpacing.xs))
        Text(
            t(
                "FLOP asked agents to do two things: create a unique key, and do something " +
                    "useful to spread the word about Technocore. The five steps above did " +
                    "the first. Nobody can do the second for you, so this writes the post " +
                    "and you decide whether to send it.",
            ),
            style = FlopType.bodyMd,
            color = FlopColors.TextMuted,
        )

        Spacer(Modifier.height(FlopSpacing.md))

        // Their sentence, first in the post and first on the screen. Measured on X, bare
        // identity posts drew nothing while the one that landed was somebody shipping a
        // thing, so this field is the post rather than a decoration on it.
        FlopField(
            value = vm.contributionLine,
            onValueChange = { vm.saveContributionLine(it) },
            label = t(PostComposer.ASK),
            // The example differs between people, for the same reason the wording does:
            // an example is a suggestion, and one suggestion shown to everybody comes back
            // as one sentence written by everybody.
            // Not translated, on purpose. The post itself goes out in English because
            // that is the language this audience reads, so the example has to model the
            // language the line should be written in. The question above it is translated;
            // what to write is explained in the reader's language, and the shape of a good
            // answer is shown in the language it will be posted in.
            placeholder = vm.exampleLine,
        )
        Spacer(Modifier.height(FlopSpacing.xs))
        // Says why, not just that. A required field with no reason attached reads as an
        // obstacle; this one is the difference between a contributor and a bot, and the
        // person filling it in is the one it protects.
        val complaint = PostComposer.whyNotASentence(vm.contributionLine)
        val short = PostComposer.charactersStillNeeded(vm.contributionLine)
        Text(
            t(
                when {
                    ready -> "This line is what makes the post yours. Everything under it is the proof."
                    !draft.fits -> "A little too long. Trim it and the whole post fits, key included."
                    // Counts down while the person types, so the disabled button below has
                    // a reason on screen instead of a person having to stop, look away and
                    // guess how much more it wants.
                    short > 0 -> "{n} more characters and the button below wakes up."
                    complaint != null -> complaint
                    else -> "Write one line only you would write. Posts that differ from each " +
                        "other by nothing but a key get read as farming, and that lands on " +
                        "the people who did the work."
                },
                "n" to short.toString(),
            ),
            style = FlopType.bodySm,
            color = if (ready) FlopColors.TextMuted else FlopColors.Cyan,
        )

        Spacer(Modifier.height(FlopSpacing.md))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FlopLabel("the post")
            // Quiet, and next to the thing it changes. A prominent button here would read
            // as "this draft is a rough one", which it is not.
            Text(
                t("say it another way"),
                style = FlopType.bodySm,
                color = FlopColors.Cyan,
                modifier = Modifier.clickable { vm.nextWording() },
            )
        }
        Spacer(Modifier.height(FlopSpacing.xs))
        // Shown in full, exactly as it will be posted. A preview that abbreviates the DID
        // would hide the one thing that has to be right.
        Text(draft.text, style = FlopType.code, color = FlopColors.IceWhite)
        Spacer(Modifier.height(FlopSpacing.xs))
        Text(
            "${draft.weightedLength} / 280",
            style = FlopType.bodySm,
            color = if (draft.fits) FlopColors.TextMuted else FlopColors.ErrorRed,
        )

        Spacer(Modifier.height(FlopSpacing.sm))
        Row(horizontalArrangement = Arrangement.spacedBy(FlopSpacing.sm)) {
            FlopButton(
                "post it",
                enabled = ready,
                onClick = {
                    vm.postHandedOff()
                    context.startActivity(
                        Intent.createChooser(
                            Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, draft.text)
                            },
                            null,
                        ),
                    )
                },
                modifier = Modifier.weight(1f),
            )
            FlopButtonSecondary(
                "copy",
                { clipboard.setText(AnnotatedString(draft.text)) },
                modifier = Modifier.weight(1f),
            )
        }

        Spacer(Modifier.height(FlopSpacing.lg))
        FlopLabel("pin it to your identity")
        Spacer(Modifier.height(FlopSpacing.xs))
        Text(
            t(
                "Paste the link to your post. It goes into your identity note, so the note " +
                    "points at the post and the post carries the key. Anyone can then check " +
                    "both ends against one key.",
            ),
            style = FlopType.bodySm,
            color = FlopColors.TextMuted,
        )
        Spacer(Modifier.height(FlopSpacing.sm))
        FlopField(
            value = xField,
            onValueChange = { xField = it; problem = null },
            label = t("Link to your post"),
            placeholder = "https://x.com/you/status/...",
        )
        Spacer(Modifier.height(FlopSpacing.sm))
        FlopButton(
            "publish these to my note",
            {
                val x = xField.trim()
                // Refused rather than written, because the note is public and a broken link
                // in it is worse than an empty field: it looks like evidence and leads
                // nowhere.
                problem = if (x.isNotEmpty() && !looksLikeXPost(x)) {
                    "That does not look like a link to a post. It should look like " +
                        "https://x.com/you/status/123."
                } else {
                    null
                }
                if (problem == null) vm.attachLinks(post = x, contribution = "")
            },
            // Enabled while anything has changed, and again whenever the note does not yet
            // carry the link: the fields are saved locally before the write, so a refused
            // write left them equal to what was stored, the button grey, the badge stuck on
            // "publishing", and nothing at all to press.
            enabled = !vm.linkPublishing && xField.trim().isNotEmpty() && !vm.nameLinked,
        )
        vm.linkPublishError?.let {
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(it), style = FlopType.bodySm, color = FlopColors.ErrorRed)
        }
        problem?.let {
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(t(it), style = FlopType.bodySm, color = FlopColors.ErrorRed)
        }
    }
}

/**
 * A text field in the app's own colours.
 *
 * Material's default outline and label colours are its own palette, and the design system
 * this app follows is explicit that colours outside the canonical set are off-brand. So
 * every colour here comes from FlopColors, including the ones Material only shows for a
 * moment.
 */
@Composable
private fun FlopField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, style = FlopType.bodySm) },
        placeholder = { Text(placeholder, style = FlopType.bodySm) },
        singleLine = true,
        textStyle = FlopType.bodyMd,
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = FlopColors.IceWhite,
            unfocusedTextColor = FlopColors.IceWhite,
            focusedBorderColor = FlopColors.Cyan,
            unfocusedBorderColor = FlopColors.Border,
            focusedLabelColor = FlopColors.Cyan,
            unfocusedLabelColor = FlopColors.TextMuted,
            focusedPlaceholderColor = FlopColors.Grey,
            unfocusedPlaceholderColor = FlopColors.Grey,
            cursorColor = FlopColors.Cyan,
            focusedContainerColor = FlopColors.Base,
            unfocusedContainerColor = FlopColors.Base,
        ),
    )
}


/**
 * "Did you post it? Paste the link."
 *
 * Deliberately a dialog rather than a highlight on the card behind it. Somebody returning
 * from another app is not reading this screen, they are re-orienting on it, and a coloured
 * border is not what breaks through that. Dismissing is one tap and costs nothing: the
 * field stays on the card, the step stays open, and the reminders still run.
 */
@Composable
private fun FlopLinkPrompt(
    value: String,
    onValueChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onSave: () -> Unit,
    error: String? = null,
) {
    Dialog(onDismissRequest = onDismiss, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        Column(
            Modifier
                .padding(FlopSpacing.lg)
                .fillMaxWidth()
                .background(FlopColors.Surface, FlopShapes.lg)
                .border(1.dp, FlopColors.Cyan.copy(alpha = 0.45f), FlopShapes.lg)
                // A dialog is measured with no maximum height, and a scroll inside
                // infinity is a crash rather than a scroll. Nine tenths of the screen
                // is the ceiling: enough that nothing is cramped, bounded enough that
                // the buttons at the bottom stay reachable at any font size.
                .heightIn(max = (LocalConfiguration.current.screenHeightDp * 0.9f).dp)
                .verticalScroll(rememberScrollState())
                .padding(FlopSpacing.lg),
        ) {
            FlopLabel("06  tell them")
            Spacer(Modifier.height(FlopSpacing.sm))
            Text(
                t("Did you post it?"),
                style = FlopType.h3,
                color = FlopColors.IceWhite,
            )
            Spacer(Modifier.height(FlopSpacing.xs))
            Text(
                t(
                    "Paste the link here and your name is attached to your key for good. " +
                        "This is the part people mean to do later and then do not.",
                ),
                style = FlopType.bodySm,
                color = FlopColors.TextMuted,
            )
            Spacer(Modifier.height(FlopSpacing.md))
            FlopField(
                value = value,
                onValueChange = onValueChange,
                label = t("Link to your post"),
                placeholder = "https://x.com/you/status/...",
            )
            Spacer(Modifier.height(FlopSpacing.md))
            error?.let {
                Text(t(it), style = FlopType.bodySm, color = FlopColors.ErrorRed)
                Spacer(Modifier.height(FlopSpacing.sm))
            }
            FlopButton(t("attach it"), onSave, enabled = value.trim().isNotEmpty())
            Spacer(Modifier.height(FlopSpacing.sm))
            // Equal weight, and it says what it does. Nobody is trapped in this dialog.
            FlopButtonSecondary(t("not yet"), onDismiss)
        }
    }
}
