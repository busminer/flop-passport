package dev.alexkosa.floppassport.ui.screens

import android.content.Intent
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
    var xField by remember { mutableStateOf(vm.xPostUrl) }
    var contribField by remember { mutableStateOf(vm.contributionUrl) }
    var problem by remember { mutableStateOf<String?>(null) }

    FlopCard {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FlopLabel("tell them")
            if (vm.xPostUrl.isNotBlank()) FlopBadge("linked", FlopState.Verified)
        }
        Spacer(Modifier.height(FlopSpacing.sm))
        Text(
            t(
                "FLOP asked agents to create a unique key and to do something useful to " +
                    "spread the word about Technocore. You have the key. This is the rest.",
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
            label = t("What did you actually do?"),
            placeholder = t("Shipped a Technocore client for the Seeker"),
        )
        Spacer(Modifier.height(FlopSpacing.xs))
        Text(
            t("Leave it blank and the post still works. It just says less."),
            style = FlopType.bodySm,
            color = FlopColors.TextMuted,
        )

        Spacer(Modifier.height(FlopSpacing.md))
        FlopLabel("the post")
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
                {
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
