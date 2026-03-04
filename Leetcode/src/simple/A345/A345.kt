package simple.A345

class MethodVersion1 : A345Solution {
    override fun reverseVowels(s: String): String {
        val res = StringBuilder(s)
        var l = 0
        var r = s.length - 1
        while (l < r) {
            val lc = s[l]
            if (isValid(lc)) {
                val rc = s[r]
                if (isValid(rc)) {
                    res.deleteCharAt(l)
                    res.insert(l, rc)
                    res.deleteCharAt(r)
                    res.insert(r, lc)
                    l++
                }
                r--
            } else {
                l++
            }

        }


        return res.toString()
    }

    private fun isValid(ch: Char): Boolean {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
    }

}