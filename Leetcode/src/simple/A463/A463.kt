package simple.A463;

class MethodVersion1 :  A463Solution{

    override fun islandPerimeter(grid: Array<IntArray>): Int {
        var res = 0
        val n = grid.size
        val m = grid[0].size
        val dx = intArrayOf(-1, 0)
        val dy = intArrayOf(0, -1)

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == 1) {
                    res += 4
                    for (k in 0..1) {
                        val x = i + dx[k]
                        val y = j + dy[k]
                        if (x > -1 && y > -1 && grid[x][y] == 1) {
                            res -= 2
                        }
                    }
                }
            }
        }

        return res
    }
}