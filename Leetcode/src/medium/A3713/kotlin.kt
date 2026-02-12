package medium.A3713

import java.util.*
import kotlin.math.max


fun longestBalanced(s: String): Int {
    var res = 1
    val n = s.length
    val dict = IntArray(26)
    for (i in 0 until n) {
        Arrays.fill(dict, 0)
        for (j in i until n) {
            val curIndex = s[j] - 'a'
            dict[curIndex]++
            val target = dict[curIndex]
            val curVal = j - i + 1
            if (curVal > res && check(dict, target)) {
                res = max(res, curVal)
            }
        }
    }
    return res
}

private fun check(dict: IntArray, target: Int): Boolean {
    for (value in dict) {
        if (value != target && value != 0) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    longestBalanced("aba")
}