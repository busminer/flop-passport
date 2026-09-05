package dev.alexkosa.floppassport.util

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator

/**
 * One short tick, and only at moments that actually settled something.
 *
 * Vibrating on every tap trains people to ignore it, which costs exactly the signal worth
 * keeping: that a step just became verified.
 */
fun confirmHaptic(context: Context) {
    runCatching {
        context.getSystemService(Vibrator::class.java)
            ?.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
    }
}
