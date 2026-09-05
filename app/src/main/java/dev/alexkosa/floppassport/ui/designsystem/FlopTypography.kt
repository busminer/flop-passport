package dev.alexkosa.floppassport.ui.designsystem

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.alexkosa.floppassport.R

/**
 * Space Mono for the brand voice — headlines, navigation, status labels, DIDs, hashes,
 * signatures, every piece of protocol data. Inter for prose a human reads.
 *
 * Both are bundled rather than fetched: an identity screen that falls back to Roboto
 * because the network was down is off-brand at exactly the moment the product is trying
 * to feel trustworthy. Licences are recorded in assets/flop-official/SOURCES.md.
 */
object FlopType {
    val Mono = FontFamily(
        Font(R.font.space_mono_regular, FontWeight.Normal),
        Font(R.font.space_mono_bold, FontWeight.Bold),
    )
    val Body = FontFamily(Font(R.font.inter_regular, FontWeight.Normal))

    val h1 = TextStyle(fontFamily = Mono, fontWeight = FontWeight.Bold, fontSize = 32.sp, lineHeight = 35.2.sp)
    val h2 = TextStyle(fontFamily = Mono, fontWeight = FontWeight.Bold, fontSize = 24.sp, lineHeight = 28.8.sp)
    val h3 = TextStyle(fontFamily = Mono, fontWeight = FontWeight.Bold, fontSize = 18.sp, lineHeight = 23.4.sp)

    val bodyMd = TextStyle(fontFamily = Body, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 21.sp)
    val bodySm = TextStyle(fontFamily = Body, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.8.sp)

    /** Uppercase technical labels: STATUS, PROOF 0003, TECHNOCORE READY. */
    val label = TextStyle(fontFamily = Mono, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 12.sp)

    /** DIDs, signatures, nonces — anything the user may copy verbatim. */
    val code = TextStyle(fontFamily = Mono, fontWeight = FontWeight.Normal, fontSize = 13.sp, lineHeight = 18.2.sp)
}
