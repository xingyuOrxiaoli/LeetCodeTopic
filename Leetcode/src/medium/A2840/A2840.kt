package medium.A2840;

class MethodVersion1 :  A2840Solution{

    override fun checkStrings(s1: String, s2: String): Boolean {
        val odds = IntArray(26)
        val evens = IntArray(26)
        for (i in s1.indices) {
            if ((i and 1) == 0) {
                odds[s1[i].code - 'a'.code]++
            } else {
                evens[s1[i].code - 'a'.code]++
            }
        }
        for (i in s2.indices) {
            val c = s2[i]
            if ((i and 1) == 0) {
                if (odds[c.code - 'a'.code] > 0) {
                    odds[c.code - 'a'.code]--
                } else {
                    return false
                }
            } else {
                if (evens[c.code - 'a'.code] > 0) {
                    evens[c.code - 'a'.code]--
                } else {
                    return false
                }
            }
        }
        return true
    }
}