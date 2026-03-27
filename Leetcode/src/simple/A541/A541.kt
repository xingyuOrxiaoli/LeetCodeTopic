package simple.A541;

class MethodVersion1 :  A541Solution{

    override fun reverseStr(s: String, k: Int): String {
        val n = s.length
        val m = n / (k shl 1)
        val res = StringBuilder()
        var start = 0
        for (i in 0 until m) {
            for (j in 0 until k) {
                res.insert(i * 2 * k, s[start++])
            }
            for (j in 0 until k) {
                res.append(s[start++])
            }
        }

        val t = n % (k shl 1)
        if (t < k) {
            for (i in n - 1 downTo start) {
                res.append(s[i])
            }
        } else {
            for (i in n - t + k - 1 downTo start) {
                res.append(s[i])
            }
            for (i in n - t + k until n) {
                res.append(s[i])
            }
        }

        return res.toString()
    }
}