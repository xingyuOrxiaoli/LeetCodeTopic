package simple.A696

import kotlin.math.min

class Solution {
    fun countBinarySubstrings(s: String): Int {
        var res = 0
        var ch = s[0]
        var pre = 0
        val list: MutableList<Int> = ArrayList()
        for (c in s) {
            if (ch != c) {
                list.add(pre)
                pre = 0
                ch = c
            }
            pre++
        }
        list.add(pre)
        for (i in 0 until list.size - 1) {
            res += min(list[i], list[i + 1])
        }

        return res
    }
}