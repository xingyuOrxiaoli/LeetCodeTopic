package simple.A405

class MethodVersion1 : A405Solution {

    private val MAX_NUM = 0xffffffffL
    override fun toHex(num: Int): String {
        if (num == 0) return "0"
        val res = StringBuilder()

        var t = num.toLong()
        if (t < 0) {
            t = (MAX_NUM + num + 1)
        }

        while (t != 0L) {
            res.append(getHex((t % 16).toInt()))
            t /= 16
        }

        return res.reverse().toString()
    }
    private fun getHex(i: Int): Char {
        if (i < 10) {
            return (i + '0'.code).toChar()
        }
        return  when (i) {
            10 -> 'a'
            11 -> 'b'
            12 -> 'c'
            13 -> 'd'
            14 -> 'e'
            15 -> 'f'
            else -> ' '
        }
    }
}