package simple.A434

class MethodVersion1 : A434Solution {

    override fun countSegments(s: String): Int {
        var res = 0
        var pre = ' '
        for (i in 0 until s.length) {
            val cur = s[i]
            if (cur == ' ' && pre != ' ') {
                res++
            }
            pre = cur
        }
        if (pre != ' ') {
            res++
        }
        return res
    }

}