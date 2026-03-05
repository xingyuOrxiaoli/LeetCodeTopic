package simple.A392

class MethodVersion1 : A392Solution{

    override fun isSubsequence(s: String, t: String): Boolean {
        val n = s.length
        val m = t.length
        var i = 0
        var j = 0

        while (i < n && j < m) {
            if (s[i] == t[j]) {
                i++
            }
            j++
        }
        return i == n
    }
}