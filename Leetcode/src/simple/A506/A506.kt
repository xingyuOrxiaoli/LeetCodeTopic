package simple.A506;

import java.util.*

class MethodVersion1 :  A506Solution{

    override fun findRelativeRanks(score: IntArray): Array<String> {
        val n = score.size
        val res = Array(n) { "" }

        val arr = Array(n) { IntArray(2) }
        for (i in 0 until n) {
            arr[i][0] = score[i]
            arr[i][1] = i
        }

        Arrays.sort(arr) { a: IntArray, b: IntArray ->
            b[0] - a[0]
        }
        for (i in 0 until n) {
            val site = arr[i][1]
            println(site)
            res[site] = when (i) {
                0 -> {
                    "Gold Medal"
                }
                1 -> {
                    "Silver Medal"
                }
                2 -> {
                    "Bronze Medal"
                }
                else -> {
                     (i + 1).toString() + ""
                }
            }
        }
        return res
    }
}