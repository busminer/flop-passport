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
 * Alex overrode the old 4dp rule for 3.0: cards 20, buttons 16, wells 14, sheets 30, so that a
 * surface reads as something you can press. FLOP's own marks stay as FLOP drew them.
 */
object FlopShapes {
    val none = RoundedCornerShape(0.dp)
    val sm = RoundedCornerShape(8.dp)
    val md = RoundedCornerShape(14.dp)
    val button = RoundedCornerShape(16.dp)
    val lg = RoundedCornerShape(20.dp)
    val sheet = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
    val pill = RoundedCornerShape(percent = 50)
}
