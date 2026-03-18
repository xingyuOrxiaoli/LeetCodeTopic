package medium.A3070

class MethodVersion1 : A3070Solution {
    override fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
        val n = grid.size
        val m = grid[0].size
        val s = Array(n + 1) { IntArray(m + 1) }

        var res = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                s[i + 1][j + 1] = grid[i][j] + s[i][j + 1] + s[i + 1][j] - s[i][j]
                if (s[i + 1][j + 1] <= k) {
                    res++
                }
            }
        }

        return res
    }
}