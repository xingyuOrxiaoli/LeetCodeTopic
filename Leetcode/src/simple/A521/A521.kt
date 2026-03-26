package simple.A521;

import kotlin.math.max

class MethodVersion1 :  A521Solution{

    override fun findLUSlength(a: String, b: String): Int {
        val n = a.length
        val m = b.length
        if (n != m) {
            return max(n.toDouble(), m.toDouble()).toInt()
        }

        for (i in 0 until n) {
            if (a[i] != b[i]) {
                return n
            }
        }

        return -1
    }
}