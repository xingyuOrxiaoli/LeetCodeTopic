package medium.A3212

class MethodVersion1: A3212Solution {

    override fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val sx = Array(n + 1) { IntArray(m + 1) }
        val sy = Array(n + 1) { IntArray(m + 1) }

        var res = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                var x = 0
                var y = 0
                val cur = grid[i][j]
                if (cur == 'X') {
                    x = 1
                } else if (cur == 'Y') {
                    y = 1
                }
                sx[i + 1][j + 1] = sx[i + 1][j] + sx[i][j + 1] - sx[i][j] + x
                sy[i + 1][j + 1] = sy[i + 1][j] + sy[i][j + 1] - sy[i][j] + y
                if (sx[i + 1][j + 1] == sy[i + 1][j + 1] && sx[i + 1][j + 1] != 0) {
                    res++
                }
            }
        }
        return res
    }


}