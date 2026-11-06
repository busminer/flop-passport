package dev.alexkosa.floppassport.crypto

import org.bouncycastle.crypto.digests.Blake2bDigest

/**
 * SS58, the address format of FLOP Network and every other Substrate chain.
 *
 * An SS58 address is a prefix byte, the 32-byte account id and a two-byte checksum, in
 * base58. The account id of an Ed25519 account is its public key, so the key a Passport
 * already holds is a FLOP account as it stands: same bytes, a different spelling. That is
 * why a Passport needs no second key and no second recovery phrase to receive FLOP.
 *
 * FLOP's devnet reports `ss58Format: 42` from `system_properties`, measured 2026-11-03, and
 * its gateway names the prefix-42 address in every enrollment statement.
 */
object Ss58 {

    const val FLOP_PREFIX = 42

    private val CONTEXT = "SS58PRE".toByteArray(Charsets.US_ASCII)

    fun encode(accountId: ByteArray, prefix: Int = FLOP_PREFIX): String {
        require(accountId.size == 32) { "An account id is 32 bytes, got ${accountId.size}" }
        require(prefix in 0..63) { "Only the one-byte prefixes are supported, got $prefix" }
        val body = byteArrayOf(prefix.toByte()) + accountId
        return Base58.encode(body + checksum(body))
    }

    /**
     * The account id inside an address, or an error saying what is wrong with it.
     *
     * Any one-byte prefix is accepted, because the same account written for Polkadot or a
     * generic wallet is still the same account, and FLOP's own gateway accepts them all.
     * The checksum is not optional: a pasted address with one wrong letter would otherwise
     * send a faucet grant into an account nobody holds.
     */
    fun decode(address: String): ByteArray {
        val raw = Base58.decode(address.trim())
        require(raw.size == 35) { "Not an SS58 account address" }
        require(raw[0].toInt() and 0xFF < 64) { "Unsupported SS58 prefix" }
        val body = raw.copyOfRange(0, 33)
        require(checksum(body).contentEquals(raw.copyOfRange(33, 35))) { "The address checksum does not match" }
        return raw.copyOfRange(1, 33)
    }

    fun isValid(address: String): Boolean = runCatching { decode(address) }.isSuccess

    /** The same account, written with FLOP's prefix. */
    fun canonical(address: String): String = encode(decode(address))

    /** The FLOP account of a Passport: its Ed25519 public key, spelled as SS58. */
    fun fromDid(did: String): String = encode(DidKey.publicKey(did))

    private fun checksum(body: ByteArray): ByteArray {
        val digest = Blake2bDigest(512)
        digest.update(CONTEXT, 0, CONTEXT.size)
        digest.update(body, 0, body.size)
        val out = ByteArray(64)
        digest.doFinal(out, 0)
        return out.copyOfRange(0, 2)
    }

    /** First and last few characters, for places too narrow for the whole thing. */
    fun abbreviate(address: String): String =
        if (address.length <= 14) address else address.take(6) + "…" + address.takeLast(6)
}
