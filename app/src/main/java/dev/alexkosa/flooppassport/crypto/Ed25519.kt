package dev.alexkosa.flooppassport.crypto

import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters
import org.bouncycastle.crypto.signers.Ed25519Signer
import java.util.Base64

/**
 * Raw Ed25519 (RFC 8032) over BouncyCastle.
 *
 * BouncyCastle rather than the platform: Android Keystore cannot hold an Ed25519 key at
 * all — it offers EC P-256 and RSA — so the platform can only ever encrypt this seed, not
 * sign with it. That trade-off is recorded in docs/DECISIONS.md; treating it honestly is
 * why the UI never claims hardware-backed signing.
 */
object Ed25519 {

    /** Raw 32-byte public key for a 32-byte seed. */
    fun publicKeyFromSeed(seed: ByteArray): ByteArray {
        require(seed.size == 32) { "Ed25519 seed must be 32 bytes, got ${seed.size}" }
        return Ed25519PrivateKeyParameters(seed, 0).generatePublicKey().encoded
    }

    /** Raw 64-byte signature over [message]. */
    fun sign(seed: ByteArray, message: ByteArray): ByteArray {
        require(seed.size == 32) { "Ed25519 seed must be 32 bytes, got ${seed.size}" }
        val signer = Ed25519Signer()
        signer.init(true, Ed25519PrivateKeyParameters(seed, 0))
        signer.update(message, 0, message.size)
        return signer.generateSignature()
    }

    fun verify(publicKey: ByteArray, message: ByteArray, signature: ByteArray): Boolean {
        if (publicKey.size != 32 || signature.size != 64) return false
        val signer = Ed25519Signer()
        signer.init(false, Ed25519PublicKeyParameters(publicKey, 0))
        signer.update(message, 0, message.size)
        return signer.verifySignature(signature)
    }

    /** base64url, unpadded — the 86-character form Technocore expects. */
    fun encodeSignature(signature: ByteArray): String =
        Base64.getUrlEncoder().withoutPadding().encodeToString(signature)

    fun decodeSignature(encoded: String): ByteArray =
        Base64.getUrlDecoder().decode(encoded)
}
