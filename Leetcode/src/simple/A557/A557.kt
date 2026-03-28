package simple.A557;

class MethodVersion1 :  A557Solution{

    override fun reverseWords(s: String): String {
        val res = StringBuilder()
        val n = s.length

        var start = 0
        for (i in 0 until n) {
            if (s[i] != ' ') {
                res.insert(start, s[i])
            } else {
                res.append(" ")
                start = i + 1
            }
        }
        return res.toString()
    }
}