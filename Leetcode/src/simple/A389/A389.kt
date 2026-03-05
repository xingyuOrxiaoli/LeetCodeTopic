package simple.A389

class MethodVersion1 : A389Solution {
    override fun findTheDifference(s: String, t: String): Char {
        val count = IntArray(26)

        s.forEach { ch -> count[ch - 'a'] ++ }
        t.forEach { ch ->
            if(count[ch - 'a'] == 0) {
                return ch
            }
            count[ch - 'a']--
        }

        return ' '
    }
}