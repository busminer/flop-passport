package dev.alexkosa.floppassport.util

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

/**
 * The gate in front of the private key.
 *
 * DEVICE_CREDENTIAL is allowed alongside a fingerprint on purpose: a phone with no
 * enrolled biometric would otherwise have no gate at all, and a PIN prompt is a real
 * check. If the device offers neither, the caller is told rather than being waved through,
 * because silently skipping the gate is worse than refusing.
 */
object Biometrics {

    private const val ALLOWED =
        BiometricManager.Authenticators.BIOMETRIC_STRONG or
            BiometricManager.Authenticators.DEVICE_CREDENTIAL

    fun canAuthenticate(context: Context): Boolean =
        BiometricManager.from(context).canAuthenticate(ALLOWED) ==
            BiometricManager.BIOMETRIC_SUCCESS

    fun authenticate(
        activity: FragmentActivity,
        title: String,
        subtitle: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        if (!canAuthenticate(activity)) {
            onFailure("This phone has no screen lock set up. Add a PIN or a fingerprint first.")
            return
        }
        val prompt = BiometricPrompt(
            activity,
            ContextCompat.getMainExecutor(activity),
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    onSuccess()
                }

                override fun onAuthenticationError(code: Int, message: CharSequence) {
                    // A cancel is not an error worth shouting about: the user changed their
                    // mind, which is a perfectly good outcome for a screen showing a secret.
                    if (code != BiometricPrompt.ERROR_USER_CANCELED &&
                        code != BiometricPrompt.ERROR_NEGATIVE_BUTTON
                    ) {
                        onFailure(message.toString())
                    }
                }
            },
        )
        prompt.authenticate(
            BiometricPrompt.PromptInfo.Builder()
                .setTitle(title)
                .setSubtitle(subtitle)
                .setAllowedAuthenticators(ALLOWED)
                .build(),
        )
    }
}
