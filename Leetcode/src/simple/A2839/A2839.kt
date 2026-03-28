package simple.A2839;

class MethodVersion1 :  A2839Solution{

    override fun canBeEqual(s1: String, s2: String): Boolean {
        val s = s1.toCharArray()

        for (i in 0..1) {
            val ch2 = s2[i]
            if (s[i] == ch2) {
                continue
            } else if (s[i + 2] == ch2) {
                s[i + 2] = s[i]
                s[i] = ch2
            } else {
                return false
            }
        }

        for (i in 2..3) {
            if (s[i] == s2[i]) {
                continue
            } else {
                return false
            }
        }


        return true
    }
}