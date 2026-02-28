package medium.A1680


class MethodVersion1 : A1680Solution {
    override fun concatenatedBinary(n: Int): Int {

        val mod = 1000000007
        var result = 0
        var bitLengthNumber: Long = 1
        for (i in n downTo 1) {
            result += ((i * (bitLengthNumber % mod) % mod)).toInt()
            result %= mod
            bitLengthNumber = bitLengthNumber * (get(i) % mod) % mod
        }
        return result
    }

    private fun get(n: Int): Int {
        var result = 1
        while (result <= n) {
            result *= 2
        }
        return result
    }
}



fun main(args: Array<String>) {
    val n = 12
    MethodVersion1().concatenatedBinary(n).let(::println)
}