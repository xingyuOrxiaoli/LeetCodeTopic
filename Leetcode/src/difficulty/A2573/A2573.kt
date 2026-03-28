package difficulty.A2573;

class MethodVersion1 :  A2573Solution{

    override fun findTheString(lcp: Array<IntArray>): String {
        val n = lcp.size
        val s = CharArray(n)

        var start = 0

        var c = 'a'
        while (c <= 'z') {
            for (j in start until n) {
                if (lcp[start][j] > 0) {
                    s[j] = c
                }
            }

            while (start < n && s[start].code > 0) {
                start++
            }

            if (start == n) {
                break
            }
            c++
        }

        if (start < n) {
            return ""
        }


        start = n - 1
        while (start >= 0) {
            for (j in n - 1 downTo 0) {
                val actualLcp =
                    if (s[start] != s[j]) 0 else (if (start == n - 1 || j == n - 1) 1 else lcp[start + 1][j + 1] + 1)
                if (lcp[start][j] != actualLcp) {
                    return ""
                }
            }
            start--
        }
        return String(s)
    }
}