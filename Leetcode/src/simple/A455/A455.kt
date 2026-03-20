package simple.A455

import java.util.*

class MethodVersion1 : A455Solution {


    override fun findContentChildren(g: IntArray, s: IntArray): Int {
        Arrays.sort(g)
        Arrays.sort(s)
        var res = 0
        var i = 0
        var j = 0
        while (i < g.size && j < s.size) {
            if (g[i] <= s[j]) {
                i++
                res++
            }
            j++
        }
        return res
    }

}