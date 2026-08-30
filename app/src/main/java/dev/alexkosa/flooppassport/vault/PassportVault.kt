package dev.alexkosa.flooppassport.vault

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.core.content.edit
import dev.alexkosa.flooppassport.crypto.DidKey
import dev.alexkosa.flooppassport.crypto.Ed25519
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

/**
 * Where the Passport seed lives on the device.
 *
 * The seed is stored only as ciphertext, wrapped by an AES-256-GCM key that lives in the
 * Android Keystore and never leaves it. StrongBox is requested when the device offers it
 * and the actual level achieved is recorded, because claiming hardware backing we do not
 * have would be worse than claiming nothing.
 *
 * What this is NOT: hardware-backed signing. Android Keystore has no Ed25519, so it can
 * wrap this seed but cannot sign with it. The seed is decrypted into process memory for
 * the moment of a signature and dropped. The honest summary, and the one the UI shows, is
 * "protected by your device, recoverable from your wallet" — not "held in secure hardware".
 *
 * Losing this file is not losing the Passport: the wallet rebuilds the same identity.
 * That is the whole reason the derivation is what it is.
 */
class PassportVault(context: Context) {

    private val prefs = context.getSharedPreferences("floop_passport_vault", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_ALIAS = "floop_passport_wrap_v1"
        private const val TRANSFORM = "AES/GCM/NoPadding"
        private const val GCM_TAG_BITS = 128
        private const val IV_BYTES = 12

        private const val P_CIPHERTEXT = "seed_ciphertext"
        private const val P_IV = "seed_iv"
        private const val P_DID = "did"
        private const val P_WALLET = "wallet_address"
        private const val P_SECURITY = "security_level"
        private const val P_CREATED = "created_at"
    }

    enum class SecurityLevel { STRONGBOX, TEE, SOFTWARE, NONE }

    val hasPassport: Boolean get() = prefs.contains(P_CIPHERTEXT) && prefs.contains(P_DID)
    val did: String? get() = prefs.getString(P_DID, null)
    val walletAddress: String? get() = prefs.getString(P_WALLET, null)
    val createdAt: Long get() = prefs.getLong(P_CREATED, 0L)
    val securityLevel: SecurityLevel
        get() = runCatching { SecurityLevel.valueOf(prefs.getString(P_SECURITY, "NONE")!!) }
            .getOrDefault(SecurityLevel.NONE)

    /**
     * Store a derived seed. Returns the DID, having checked that the seed really produces
     * it — a vault that silently stored the wrong bytes would only surface as an
     * unexplainable 403 from Technocore days later.
     */
    fun store(seed: ByteArray, expectedDid: String, walletAddress: String): String {
        require(seed.size == 32) { "Passport seed must be 32 bytes, got ${seed.size}" }
        val actual = DidKey.fromPublicKey(Ed25519.publicKeyFromSeed(seed))
        require(actual == expectedDid) {
            "Refusing to store a seed that does not produce the expected DID"
        }

        val level = ensureWrapKey()
        val cipher = Cipher.getInstance(TRANSFORM).apply { init(Cipher.ENCRYPT_MODE, wrapKey()) }
        val ciphertext = cipher.doFinal(seed)

        prefs.edit {
            putString(P_CIPHERTEXT, encode(ciphertext))
            putString(P_IV, encode(cipher.iv))
            putString(P_DID, actual)
            putString(P_WALLET, walletAddress)
            putString(P_SECURITY, level.name)
            if (!prefs.contains(P_CREATED)) putLong(P_CREATED, System.currentTimeMillis())
        }
        return actual
    }

    /**
     * Sign with the Passport, without handing the seed to the caller.
     *
     * The narrow interface is the point: no screen, no network code and no logger ever
     * holds the seed, so there is no path by which it can be printed, serialised or sent.
     */
    fun sign(message: ByteArray): ByteArray {
        val seed = decryptSeed()
        try {
            return Ed25519.sign(seed, message)
        } finally {
            seed.fill(0)
        }
    }

    /**
     * The seed in the clear. Only for the export and recovery screens, which are behind a
     * biometric prompt. Callers must zero it when done.
     */
    fun exportSeed(): ByteArray = decryptSeed()

    fun delete() {
        prefs.edit { clear() }
        runCatching {
            KeyStore.getInstance("AndroidKeyStore").apply { load(null) }.deleteEntry(KEY_ALIAS)
        }
    }

    private fun decryptSeed(): ByteArray {
        val ct = prefs.getString(P_CIPHERTEXT, null) ?: error("No Passport stored on this device")
        val iv = prefs.getString(P_IV, null) ?: error("Passport ciphertext has no IV")
        val cipher = Cipher.getInstance(TRANSFORM).apply {
            init(Cipher.DECRYPT_MODE, wrapKey(), GCMParameterSpec(GCM_TAG_BITS, decode(iv)))
        }
        return cipher.doFinal(decode(ct))
    }

    private fun wrapKey(): SecretKey {
        val ks = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
        return (ks.getEntry(KEY_ALIAS, null) as? KeyStore.SecretKeyEntry)?.secretKey
            ?: error("The Passport wrapping key is missing from the Keystore")
    }

    /**
     * Create the wrapping key if it is absent, preferring StrongBox and falling back.
     *
     * The fallback is not cosmetic: StrongBox generation throws on devices that advertise
     * it but cannot satisfy the spec, and an app that does not catch that simply fails to
     * create a Passport at all on those phones.
     */
    private fun ensureWrapKey(): SecurityLevel {
        val ks = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
        if (ks.containsAlias(KEY_ALIAS)) return securityLevel

        fun spec(strongBox: Boolean) = KeyGenParameterSpec.Builder(
            KEY_ALIAS,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT,
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setKeySize(256)
            .apply { if (strongBox) setIsStrongBoxBacked(true) }
            .build()

        val gen = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")

        runCatching {
            gen.init(spec(strongBox = true))
            gen.generateKey()
        }.onSuccess { return SecurityLevel.STRONGBOX }

        gen.init(spec(strongBox = false))
        gen.generateKey()
        return SecurityLevel.TEE
    }

    private fun encode(b: ByteArray): String = android.util.Base64.encodeToString(
        b, android.util.Base64.NO_WRAP,
    )

    private fun decode(s: String): ByteArray = android.util.Base64.decode(
        s, android.util.Base64.NO_WRAP,
    )
}
