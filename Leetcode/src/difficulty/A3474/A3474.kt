package difficulty.A3474;

import java.util.*


class MethodVersion1 :  A3474Solution{

    override fun generateString(str1: String, str2: String): String {
        val n: Int = str1.length
        val m: Int = str2.length
        val res = CharArray(n + m - 1)
        Arrays.fill(res, ' ')

        for (i in 0 until n) {
            if (str1[i] === 'T') {
                var j = i
                var k = 0
                while (j < i + m) {
                    val ch: Char = str2[k]
                    if (res[j] == ' ' || res[j] == ch) {
                        res[j] = ch
                    } else {
                        return ""
                    }
                    j++
                    k++
                }
            }
        }
        val old = res.clone()
        for (i in res.indices) {
            if (res[i] == ' ') {
                res[i] = 'a'
            }
        }

        for (i in 0 until n) {
            if (str1[i] == 'F') {
                if (String(res, i, m) != str2) {
                    continue
                }

                var flag = true
                for (j in i + m - 1 downTo i) {
                    if (old[j] == ' ') {
                        res[j] = 'b'
                        flag = false
                        break
                    }
                }

                if (flag) {
                    return ""
                }
            }
        }

        return String(res)
    }
}