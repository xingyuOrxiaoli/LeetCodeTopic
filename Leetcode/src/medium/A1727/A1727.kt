package medium.A1727

import kotlin.math.max

class MethodVersion1 : A1727Solution {
    override fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size
        var res = 0
        val height = IntArray(m)
        val index = IntArray(m)
        for (i in 0 until m) {
            index[i] = i
        }
        val noZero = IntArray(m)

        for (i in 0 until n) {
            var noZeroIndex = 0
            var zeroIndex = 0
            for (j in index) {
                if (matrix[i][j] == 1) {
                    height[j]++
                    noZero[noZeroIndex++] = j
                } else {
                    height[j] = 0
                    index[zeroIndex++] = j
                }
            }
            for (j in zeroIndex until m) {
                index[j] = noZero[j - zeroIndex]
                res = max(res.toDouble(), ((m - j) * height[index[j]]).toDouble()).toInt()
            }
        }
        return res
    }
}