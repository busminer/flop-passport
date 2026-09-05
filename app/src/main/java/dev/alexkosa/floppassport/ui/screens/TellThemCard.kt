package dev.alexkosa.floppassport.ui.screens

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
    val ready = PostComposer.isRealSentence(vm.contributionLine)
    var xField by remember { mutableStateOf(vm.xPostUrl) }
    var contribField by remember { mutableStateOf(vm.contributionUrl) }
    var problem by remember { mutableStateOf<String?>(null) }

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
            if (vm.xPostUrl.isNotBlank()) FlopBadge("linked", FlopState.Verified)
        }
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(
            t("Optional, and the part that actually counts."),
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
        Text(
            t(
                if (ready) {
                    "This line is what makes the post yours. Everything under it is the proof."
                } else {
                    "One sentence in your own words, please. Thousands of posts that differ " +
                        "only by a key get read as farming, and that lands on the people who " +
                        "did the work."
                },
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
        FlopField(
            value = contribField,
            onValueChange = { contribField = it; problem = null },
            label = t("Link to what you built, if there is one"),
            placeholder = "https://github.com/...",
        )
        Spacer(Modifier.height(FlopSpacing.sm))
        FlopButton(
            "publish these to my note",
            {
                val x = xField.trim()
                val c = contribField.trim()
                // Refused rather than written, because the note is public and a broken link
                // in it is worse than an empty field: it looks like evidence and leads
                // nowhere.
                problem = when {
                    x.isNotEmpty() && !looksLikeXPost(x) ->
                        "That does not look like a link to a post. It should look like " +
                            "https://x.com/you/status/123."
                    c.isNotEmpty() && !looksLikeUrl(c) ->
                        "That does not look like a link. It should start with https://"
                    else -> null
                }
                if (problem == null) {
                    if (x != vm.xPostUrl) vm.attachPostUrl(x)
                    if (c != vm.contributionUrl) vm.attachContributionUrl(c)
                }
            },
            enabled = xField.trim() != vm.xPostUrl || contribField.trim() != vm.contributionUrl,
        )
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
