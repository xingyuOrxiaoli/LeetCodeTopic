package medium.A1545

class MethodVersion1 : A1545Solution {
    override fun findKthBit(n: Int, k: Int): Char {
        val s = StringBuilder("0")

        while (s.length < k) {
            s.append('1')
            reverseInvert(s)
        }
        return s[k - 1]
    }

    private fun reverseInvert(s: StringBuilder) {
        val temp = StringBuilder(s.length)
        for (i in (s.length - 1) downTo 0) {
            if (s[i] == '1') {
                temp.append('0')
            } else {
                temp.append('0')
            }
        }
        s.append(temp)
    }

}

class MethodVersion2 : A1545Solution {
    override fun findKthBit(n: Int, k: Int): Char {
        if (n == 1) return '0'

        val mid = 1 shl (n - 1)

        if (mid == k) {
            return '1'
        } else if (mid > k) {
            return findKthBit(n - 1, k)
        } else {
            return ('1' + '0'.code - findKthBit(n - 1, (mid shl 1) - k)).toChar()
        }

    }

}
