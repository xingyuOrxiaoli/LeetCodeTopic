package medium.A2906;

class MethodVersion1 :  A2906Solution{

    override fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val m = grid[0].size
        val res = Array(n) { IntArray(m) }
        val mod = 12345

        var prefix: Long = 1
        for (i in 0 until n) {
            for (j in 0 until m) {
                res[i][j] = prefix.toInt()
                prefix = (prefix * grid[i][j]) % mod
            }
        }
        prefix = 1
        for (i in n - 1 downTo -1 + 1) {
            for (j in m - 1 downTo -1 + 1) {
                res[i][j] = ((res[i][j] * prefix) % mod).toInt()
                prefix = (prefix * grid[i][j]) % mod
            }
        }
        return res
    }
}