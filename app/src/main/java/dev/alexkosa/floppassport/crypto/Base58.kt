package dev.alexkosa.floppassport.crypto

/**
 * Bitcoin-alphabet base58 (base58btc), as used by both `did:key` multibase
 * encoding and Solana address encoding.
 */
object Base58 {
    private const val ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
    private val INDEX = IntArray(128) { -1 }.also { idx ->
        ALPHABET.forEachIndexed { i, c -> idx[c.code] = i }
    }

    fun encode(input: ByteArray): String {
        if (input.isEmpty()) return ""
        // Leading zero bytes become leading '1' characters.
        var leadingZeros = 0
        while (leadingZeros < input.size && input[leadingZeros].toInt() == 0) leadingZeros++

        val buffer = input.copyOf()
        val encoded = CharArray(input.size * 2)
        var outputStart = encoded.size
        var inputStart = leadingZeros
        while (inputStart < buffer.size) {
            encoded[--outputStart] = ALPHABET[divmod(buffer, inputStart, 256, 58)]
            if (buffer[inputStart].toInt() == 0) inputStart++
        }
        repeat(leadingZeros) { encoded[--outputStart] = ALPHABET[0] }
        return String(encoded, outputStart, encoded.size - outputStart)
    }

    fun decode(input: String): ByteArray {
        if (input.isEmpty()) return ByteArray(0)
        val input58 = ByteArray(input.length)
        input.forEachIndexed { i, c ->
            val digit = if (c.code < 128) INDEX[c.code] else -1
            require(digit >= 0) { "Invalid base58 character '$c' at $i" }
            input58[i] = digit.toByte()
        }
        var leadingZeros = 0
        while (leadingZeros < input58.size && input58[leadingZeros].toInt() == 0) leadingZeros++

        val decoded = ByteArray(input.length)
        var outputStart = decoded.size
        var inputStart = leadingZeros
        while (inputStart < input58.size) {
            decoded[--outputStart] = divmod(input58, inputStart, 58, 256).toByte()
            if (input58[inputStart].toInt() == 0) inputStart++
        }
        while (outputStart < decoded.size && decoded[outputStart].toInt() == 0) outputStart++
        return ByteArray(leadingZeros) + decoded.copyOfRange(outputStart, decoded.size)
    }

    private fun divmod(number: ByteArray, firstDigit: Int, base: Int, divisor: Int): Int {
        var remainder = 0
        for (i in firstDigit until number.size) {
            val digit = number[i].toInt() and 0xFF
            val temp = remainder * base + digit
            number[i] = (temp / divisor).toByte()
            remainder = temp % divisor
        }
        return remainder
    }
}
