package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.ui.graphics.Color

/**
 * FLOP Network Design System V3.0 — canonical swatches and derived tokens.
 *
 * Source of truth: https://flop.finance/design.md, archived under design/official/.
 * Nothing outside this file may introduce a colour: the design system is explicit that
 * colours outside the canonical set plus derived tokens are off-brand.
 */
object FlopColors {
    // Canonical swatches
    val Base = Color(0xFF0A1128)
    val Grey = Color(0xFF5C6670)
    val Blue = Color(0xFF0466C8)
    val Cyan = Color(0xFF00B4D8)
    val Green = Color(0xFF32D74B)
    val IceWhite = Color(0xFFF5F7FA)
    val ErrorRed = Color(0xFFFF453A)

    // Derived tokens
    val Surface = Color(0xFF151D32)
    val SurfaceLight = Color(0xFF232A3E)
    val Border = SurfaceLight
    val CyanHover = Color(0xFF3DC5E0)
    val TextSecondary = Color(0xFFA1A7AE)

    // Depth, added for 3.0: mixes of the swatches above, no new hue. Alex asked for raised,
    // convex surfaces on 4 November 2026, over the old flat rule.
    val SurfaceRaised = Color(0xFF1B2440)
    val Ink = Color(0xFF050812)
    val CyanDeep = Color(0xFF0092B4)
    val CyanPlinth = Color(0xFF007A99)
    val GreenTop = Color(0xFF5BE26F)
    val GreenDeep = Color(0xFF22A838)
    val GreenPlinth = Color(0xFF178A2B)
    val SecondaryTop = Color(0xFF2A3350)
    val SecondaryBottom = Color(0xFF1A2238)
    val SecondaryPlinth = Color(0xFF0F1528)

    /**
     * Semantic aliases. The design system is strict about which swatches are text-safe on
     * Base: Ice White 17.4:1, Green 9.8:1, TextSecondary 7.7:1 and Cyan 7.6:1 pass;
     * Blue at 3.3:1 and Grey at 3.2:1 are structural only and must never carry body text.
     */
    val TextPrimary = IceWhite
    val TextMuted = TextSecondary
    val Verified = Green
    val Active = Cyan
    val Failure = ErrorRed
    val StructuralFill = Blue
    val NonTextChrome = Grey
}
