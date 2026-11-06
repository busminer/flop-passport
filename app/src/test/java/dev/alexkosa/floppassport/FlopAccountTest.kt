package dev.alexkosa.floppassport

import dev.alexkosa.floppassport.crypto.Ss58
import dev.alexkosa.floppassport.flop.FlopAmount
import dev.alexkosa.floppassport.flop.FlopChain
import java.math.BigDecimal
import java.math.BigInteger
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * A Passport's FLOP account, and the two pieces of chain encoding the app does by hand.
 *
 * Expected values were produced independently in Python (hashlib's blake2b) on
 * 2026-11-03, and the faucet signer's address and balance were read from the live devnet
 * the same day, so these are checked against the network rather than against this code.
 */
class FlopAccountTest {

    private val faucetSigner = "5DZsAQuavUAM7A6XvoTkDQgtQdRCMcALdUd6Bx4FSoFMF8ux"
    private val faucetSignerKey = "4279ad3f80ad40e45bd5c848dd6800b9ebb3e8dcd3b4be3058fb6e5c623c111b"

    @Test
    fun anAddressFromTheLiveNetworkRoundTrips() {
        val id = Ss58.decode(faucetSigner)
        assertEquals(faucetSignerKey, id.joinToString("") { "%02x".format(it) })
        assertEquals(faucetSigner, Ss58.encode(id))
    }

    @Test
    fun aPassportIsAlreadyAFlopAccount() {
        // Alex's live Passport. The FLOP address is the same Ed25519 key, spelled for FLOP.
        assertEquals(
            "5FcqBspY6ioVRoHumDxaLtQHi9qQYPb8FRZRmK6brFM21Vir",
            Ss58.fromDid("did:key:z6Mkq2w8fJHnRES8sLV8ZC9YeiRG2eBJnLsqbvhyvg3zU1qs"),
        )
    }

    @Test
    fun oneWrongLetterIsRefused() {
        val typo = faucetSigner.replaceRange(10, 11, if (faucetSigner[10] == 'a') "b" else "a")
        assertFalse(Ss58.isValid(typo))
        assertFalse(Ss58.isValid("not an address"))
        assertFalse(Ss58.isValid(""))
        assertTrue(Ss58.isValid("  $faucetSigner\n"))
    }

    @Test
    fun theBalanceKeyMatchesTheOneTheNodeAnswered() {
        assertEquals(
            "0x26aa394eea5630e07c48ae0c9558cef7b99d880ec681799c0cf30e8886371da9" +
                "186f68574cfee59efa182cb996f38355" + faucetSignerKey,
            FlopChain.accountStorageKey(Ss58.decode(faucetSigner)),
        )
    }

    @Test
    fun freeBalanceIsReadFromTheRightBytes() {
        // nonce, consumers, providers, sufficients, then free = 25 FLOP little-endian.
        val free = BigInteger("25000000000000000000")
        val le = free.toByteArray().reversedArray().copyOf(16)
        val hex = "0x" + "05000000" + "00000000" + "01000000" + "00000000" +
            le.joinToString("") { "%02x".format(it) } + "00".repeat(48)
        assertEquals(free, FlopChain.freeFromAccountInfo(hex))
        assertEquals(BigInteger.ZERO, FlopChain.freeFromAccountInfo(null))
    }

    @Test
    fun amountsReadLikeMoney() {
        assertEquals("25", FlopAmount.format(FlopAmount.fromRaw("25000000000000000000")))
        assertEquals("9977072", FlopAmount.format(FlopAmount.fromRaw("9977072284426292435000000")))
        assertEquals("0.006", FlopAmount.format(BigDecimal("0.006")))
        assertEquals("0", FlopAmount.format(FlopAmount.fromRaw("garbage")))
    }
}
