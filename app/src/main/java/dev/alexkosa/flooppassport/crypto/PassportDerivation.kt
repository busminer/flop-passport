package dev.alexkosa.flooppassport.crypto

import org.bouncycastle.crypto.digests.SHA256Digest
import org.bouncycastle.crypto.generators.HKDFBytesGenerator
import org.bouncycastle.crypto.params.HKDFParameters

/**
 * Where a FLOOP Passport comes from.
 *
 * The Passport seed is not random: it is derived from one signature the user's Solana
 * wallet makes over a fixed, versioned statement. Ed25519 signatures are deterministic
 * (RFC 8032 — no randomness anywhere in the scheme), so the same wallet signing the same
 * statement produces the same 64 bytes forever, on any device.
 *
 * What that buys:
 *  - the Passport is recoverable from the wallet alone, with no words to write down;
 *  - the link between Passport and wallet is provable by construction, not asserted;
 *  - the private key is still exportable, so the identity is usable off the phone.
 *
 * What it costs, stated plainly because the UI must not overstate it: once derived, the
 * seed lives in app memory. Signing is not hardware-backed. Only the *birth* of the key
 * happens inside Seed Vault.
 *
 * The statement deliberately contains the wallet address. A wallet that refuses to show
 * the user what it is signing, or that mangles the text, changes the derived key — which
 * is why the derived DID is stored and compared on every later derivation.
 */
object PassportDerivation {

    const val STATEMENT_VERSION = "v1"

    /** The human-readable statement the wallet signs. Never change this for v1. */
    fun statement(walletAddress: String): String = buildString {
        append("FLOOP Passport key derivation $STATEMENT_VERSION\n")
        append("\n")
        append("Signing this creates your FLOOP Passport identity.\n")
        append("It is not a transaction and moves no funds.\n")
        append("\n")
        append("wallet: $walletAddress\n")
        append("app: dev.alexkosa.flooppassport\n")
    }

    private val HKDF_INFO = "FLOOP Passport seed $STATEMENT_VERSION".toByteArray(Charsets.UTF_8)

    /**
     * Turn the wallet's 64-byte signature into the 32-byte Ed25519 Passport seed.
     *
     * HKDF rather than a bare hash so the wallet signature and the identity seed are
     * cleanly domain-separated: the signature is public once shown to anyone, and this
     * makes explicit that it is input key material, not the key.
     */
    fun seedFromWalletSignature(walletSignature: ByteArray, walletAddress: String): ByteArray {
        require(walletSignature.size == 64) {
            "Expected a 64-byte Ed25519 wallet signature, got ${walletSignature.size}"
        }
        val hkdf = HKDFBytesGenerator(SHA256Digest())
        hkdf.init(
            HKDFParameters(
                walletSignature,
                walletAddress.toByteArray(Charsets.UTF_8),
                HKDF_INFO,
            )
        )
        val seed = ByteArray(32)
        hkdf.generateBytes(seed, 0, seed.size)
        return seed
    }
}
