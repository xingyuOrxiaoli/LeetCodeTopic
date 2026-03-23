package medium.A1594;

import kotlin.math.max
import kotlin.math.min

class MethodVersion1 :  A1594Solution{

    override fun maxProductPath(grid: Array<IntArray>): Int {
        val mod = 1000000007

        val n = grid.size
        val m = grid[0].size
        val maximize = Array(n) { LongArray(m) }
        val minimum = Array(n) { LongArray(m) }

        maximize[0][0] = grid[0][0].toLong()
        minimum[0][0] = grid[0][0].toLong()
        for (i in 1 until n) {
            maximize[i][0] = maximize[i - 1][0] * grid[i][0]
            minimum[i][0] = maximize[i][0]
        }
        for (j in 1 until m) {
            maximize[0][j] = maximize[0][j - 1] * grid[0][j]
            minimum[0][j] = maximize[0][j]
        }

        for (i in 1 until n) {
            for (j in 1 until m) {
                if (grid[i][j] >= 0) {
                    maximize[i][j] =
                        (max(maximize[i - 1][j].toDouble(), maximize[i][j - 1].toDouble()) * grid[i][j]).toLong()
                    minimum[i][j] =
                        (min(minimum[i - 1][j].toDouble(), minimum[i][j - 1].toDouble()) * grid[i][j]).toLong()
                } else {
                    maximize[i][j] =
                        (min(minimum[i - 1][j].toDouble(), minimum[i][j - 1].toDouble()) * grid[i][j]).toLong()
                    minimum[i][j] =
                        (max(maximize[i - 1][j].toDouble(), maximize[i][j - 1].toDouble()) * grid[i][j]).toLong()
                }
            }
        }

        return if (maximize[n - 1][m - 1] >= 0) (maximize[n - 1][m - 1] % mod).toInt() else -1
    }
}