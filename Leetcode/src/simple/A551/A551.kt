package simple.A551;

class MethodVersion1 :  A551Solution{

    override fun checkRecord(s: String): Boolean {
        var a = 0
        var l = 0
        for (i in s.indices) {
            if (s[i] == 'A') {
                a++
                l = 0
            } else if (s[i] == 'L') {
                l++
            } else {
                l = 0
            }
            if (l == 3 || a == 2) {
                return false
            }
        }
        return true
    }
}