package medium.A3567

import java.util.*
import kotlin.math.min

class MethodVersion1 : A3567Solution {

    override fun minAbsDiff(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val n = grid.size
        val m = grid[0].size
        val res = Array(n - k + 1) { IntArray(m - k + 1) }

        for (re in res) {
            Arrays.fill(re, Int.MAX_VALUE)
        }

        for (i in k - 1 until n) {
            val map: MutableMap<Int, Int> = TreeMap()
            var t = k
            while (t > 0) {
                val x = i - t + 1
                for (y in 0 until k - 1) {
                    map[grid[x][y]] = map.getOrDefault(grid[x][y], 0) + 1
                }
                t--
            }
            for (j in k - 1 until m) {
                for (x in i - k + 1..i) {
                    map[grid[x][j]] = map.getOrDefault(grid[x][j], 0) + 1
                }
                var preKey = Int.MIN_VALUE
                for (key in map.keys) {
                    if (preKey != Int.MIN_VALUE) {
                        res[i - k + 1][j - k + 1] =
                            min(res[i - k + 1][j - k + 1].toDouble(), (key - preKey).toDouble()).toInt()
                    }
                    preKey = key
                }
                if (res[i - k + 1][j - k + 1] == Int.MAX_VALUE) {
                    res[i - k + 1][j - k + 1] = 0
                }
                for (x in i - k + 1..i) {
                    map[grid[x][j - k + 1]] = map.getOrDefault(grid[x][j - k + 1], 0) - 1
                    if (map.getOrDefault(grid[x][j - k + 1], 0) == 0) {
                        map.remove(grid[x][j - k + 1])
                    }
                }
            }
        }
        return res
    }

}