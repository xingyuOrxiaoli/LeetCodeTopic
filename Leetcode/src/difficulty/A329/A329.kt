package difficulty.A329;

import java.util.*

class MethodVersion1 :  A329Solution{

    override fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)
        val m = matrix.size
        val n = matrix[0].size
        val `in` = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                for (k in 0..3) {
                    val x = i + dx[k]
                    val y = j + dy[k]
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y]) {
                        `in`[x][y]++
                    }
                }
            }
        }
        val q: Queue<IntArray> = LinkedList()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (`in`[i][j] == 0) {
                    q.add(intArrayOf(i, j))
                }
            }
        }

        var res = 0
        while (!q.isEmpty()) {
            res++
            val size = q.size
            for (i in 0 until size) {
                val cur = q.poll()
                val x = cur[0]
                val y = cur[1]
                for (k in 0..3) {
                    val x1 = x + dx[k]
                    val y1 = y + dy[k]
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x1][y1] > matrix[x][y]) {
                        `in`[x1][y1]--
                        if (`in`[x1][y1] == 0) {
                            q.add(intArrayOf(x1, y1))
                        }
                    }
                }
            }
        }
        return res
    }
}