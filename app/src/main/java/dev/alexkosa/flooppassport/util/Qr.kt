package dev.alexkosa.flooppassport.util

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel

/**
 * QR rendering, drawn in FLOOP's own colours rather than the default black on white.
 *
 * Two choices worth stating. The modules are Ice White on Base, because a white card
 * dropped into a dark interface is the one element that would break the screen; scanners
 * only need contrast and polarity, both of which this keeps. And error correction is set
 * to H, the highest level, so a code photographed off a phone screen at an angle, or
 * partly glared out, still reads - which is exactly how these get scanned.
 */
object Qr {

    fun encode(
        content: String,
        sizePx: Int = 512,
        foreground: Int = 0xFFF5F7FA.toInt(),
        background: Int = 0xFF0A1128.toInt(),
        quietZoneModules: Int = 2,
    ): ImageBitmap {
        val hints = mapOf(
            EncodeHintType.ERROR_CORRECTION to ErrorCorrectionLevel.H,
            EncodeHintType.MARGIN to quietZoneModules,
            EncodeHintType.CHARACTER_SET to "UTF-8",
        )
        val matrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, sizePx, sizePx, hints)
        val bitmap = Bitmap.createBitmap(matrix.width, matrix.height, Bitmap.Config.ARGB_8888)
        val row = IntArray(matrix.width)
        for (y in 0 until matrix.height) {
            for (x in 0 until matrix.width) {
                row[x] = if (matrix.get(x, y)) foreground else background
            }
            bitmap.setPixels(row, 0, matrix.width, 0, y, matrix.width, 1)
        }
        return bitmap.asImageBitmap()
    }

    /**
     * A Solana Pay request URI.
     *
     * Deliberately not a transaction. Twelve apps on a Seeker register this scheme, so the
     * link opens the user's own wallet on its own send screen with the recipient filled in,
     * and they confirm there. The app never builds a transfer, never asks for a signature,
     * and never needs an RPC endpoint - which also means there is no new way for it to be
     * wrong about someone's money.
     */
    fun solanaPay(recipient: String, label: String? = null, message: String? = null): String =
        buildString {
            append("solana:").append(recipient)
            val params = buildList {
                label?.let { add("label=" + android.net.Uri.encode(it)) }
                message?.let { add("message=" + android.net.Uri.encode(it)) }
            }
            if (params.isNotEmpty()) append("?").append(params.joinToString("&"))
        }
}
