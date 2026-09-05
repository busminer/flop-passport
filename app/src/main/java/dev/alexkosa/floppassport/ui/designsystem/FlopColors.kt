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
