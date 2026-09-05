package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

/** The 4/8/16/24/32 rhythm and the engineered radii from design.md. */
object FlopSpacing {
    val xs = 4.dp
    val sm = 8.dp
    val md = 16.dp
    val lg = 24.dp
    val xl = 32.dp
}

/**
 * Radii are deliberately small. The brand is "foundry precision": 4dp is the default card
 * radius, 8dp is reserved for hero surfaces, and full rounding belongs to status pills
 * only. A 24dp card would read as a generic consumer app, not as FLOP.
 */
object FlopShapes {
    val none = RoundedCornerShape(0.dp)
    val sm = RoundedCornerShape(2.dp)
    val md = RoundedCornerShape(4.dp)
    val lg = RoundedCornerShape(8.dp)
    val pill = RoundedCornerShape(percent = 50)
}
