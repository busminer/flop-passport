package dev.alexkosa.flooppassport.crypto

import java.security.MessageDigest

/**
 * `did:key` (Ed25519) rendering and parsing, byte-compatible with Technocore's
 * `src/didkey.py`.
 *
 * A DID is `did:key:z` + base58btc(multicodec ed25519-pub prefix || 32-byte public key).
 * Because the codec prefix is fixed, every Ed25519 DID starts `z6Mk` and the multibase
 * part is always exactly 48 characters.
 */
object DidKey {
    const val PREFIX = "did:key:"
    private val MULTICODEC_ED25519 = byteArrayOf(0xED.toByte(), 0x01)
    const val MULTIBASE_CHARS = 48

    /** Render the DID for a raw 32-byte Ed25519 public key. */
    fun fromPublicKey(publicKey: ByteArray): String {
        require(publicKey.size == 32) { "Ed25519 public key must be 32 bytes, got ${publicKey.size}" }
        return PREFIX + "z" + Base58.encode(MULTICODEC_ED25519 + publicKey)
    }

    /** The raw 32 public-key bytes of a DID, or throw. Fails closed, like the server. */
    fun publicKey(did: String): ByteArray {
        require(did.startsWith(PREFIX)) { "bad did:key: expected ${PREFIX}z6Mk..." }
        val mb = did.substring(PREFIX.length)
        require(mb.length == MULTIBASE_CHARS && mb.startsWith("z")) {
            "bad did:key: expected $MULTIBASE_CHARS multibase characters starting 'z', got ${mb.length}"
        }
        val decoded = Base58.decode(mb.substring(1))
        require(decoded.size == 34 && decoded[0] == MULTICODEC_ED25519[0] && decoded[1] == MULTICODEC_ED25519[1]) {
            "bad did:key: only ed25519-pub (z6Mk...) keys are accepted"
        }
        return decoded.copyOfRange(2, 34)
    }

    fun isDid(value: String): Boolean = runCatching { publicKey(value) }.isSuccess

    /**
     * A Solana address is itself a base58-encoded 32-byte Ed25519 public key, so it maps
     * onto a `did:key` with no key material in between. Used only for display and for
     * proving the wallet link — never as the Passport identity itself.
     */
    fun fromSolanaAddress(base58Address: String): String {
        val raw = Base58.decode(base58Address)
        require(raw.size == 32) { "A Solana address decodes to 32 bytes, got ${raw.size}" }
        return fromPublicKey(raw)
    }

    /**
     * Technocore's identity fingerprint: the first 16 lowercase hex characters of
     * SHA-256 over the DID string itself (not the key bytes).
     */
    fun fingerprint(did: String): String {
        val digest = MessageDigest.getInstance("SHA-256").digest(did.toByteArray(Charsets.UTF_8))
        return digest.joinToString("") { "%02x".format(it) }.substring(0, 16)
    }

    /** Note path for an identity: `/kv/did-<first 2>/<remaining 14>`. */
    fun notePath(did: String): String {
        val fp = fingerprint(did)
        return "/kv/did-${fp.substring(0, 2)}/${fp.substring(2)}"
    }

    /** Legacy fallback path kept by the server: `/kv/did/<fingerprint>`. */
    fun legacyNotePath(did: String): String = "/kv/did/${fingerprint(did)}"

    /** Short form for dense UI: `z6Mk…2doK`. */
    fun abbreviate(did: String): String {
        val mb = did.substring(PREFIX.length)
        return "${mb.take(4)}…${mb.takeLast(4)}"
    }
}
