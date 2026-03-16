package medium.A1878

import java.util.*

class MethodVersion1 : A1878Solution {
    override fun getBiggestThree(grid: Array<IntArray>): IntArray {
        val n = grid.size
        val m = grid[0].size
        val dg = Array(n) { IntArray(m) }
        val udg = Array(n) { IntArray(m) }


        // 初始化对角线前缀和数组
        for (i in 0 until n) {
            for (j in 0 until m) {
                dg[i][j] = grid[i][j]
                udg[i][j] = grid[i][j]

                val x = i - 1
                val y = j - 1
                val ux = i - 1
                val uy = j + 1
                if (x >= 0 && y >= 0) {
                    dg[i][j] += dg[x][y]
                }
                if (ux >= 0 && uy < m) {
                    udg[i][j] += udg[ux][uy]
                }
            }
        }


        // 计算答案
        val res: MutableSet<Int> = TreeSet()
        for (i in 0 until n) {
            for (j in 0 until m) {
                res.add(grid[i][j])
                var k = 1

                while (k != -1) {
                    val x1 = i - k
                    val y1 = j
                    val x2 = i
                    val y2 = j - k
                    val x3 = i + k
                    val y3 = j
                    val x4 = i
                    val y4 = j + k
                    if (x1 < 0 || y2 < 0 || x3 >= n || y4 >= m) {
                        k = -1
                        continue
                    }
                    k++
                    val a = udg[x2][y2] - udg[x1][y1]
                    val b = dg[x3][y3] - dg[x2][y2]
                    val c = udg[x3][y3] - udg[x4][y4] - grid[x3][y3]
                    val d = dg[x4][y4] - dg[x1][y1] + grid[x1][y1]
                    res.add(a + b + c + d)
                }
            }
        }

        println(res.toTypedArray().contentToString())
        return res.stream().sorted { a: Int?, b: Int -> b.compareTo(a!!) }.limit(3).mapToInt { i: Int? -> i!! }
            .toArray()
    }
}