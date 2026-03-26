package difficulty.A3548;

import java.util.HashSet

class MethodVersion1 :  A3548Solution{

    override fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        var total: Long = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                total += grid[i][j].toLong()
            }
        }

        return check(grid, total) || check(rotate(grid), total)
    }

    private fun rotate(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val newGrid = Array(n) { IntArray(m) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                newGrid[j][m - 1 - i] = grid[i][j]
            }
        }
        return newGrid
    }

    private fun check(grid: Array<IntArray>, total: Long): Boolean {
        val m = grid.size
        val n = grid[0].size
        if (isPartitionGrid(grid, total)) {
            return true
        }
        reverse(grid)
        return isPartitionGrid(grid, total)
    }

    private fun isPartitionGrid(grid: Array<IntArray>, total: Long): Boolean {
        val m = grid.size
        val n = grid[0].size
        var s: Long = 0
        val dict: MutableSet<Long> = HashSet()
        dict.add(0L)

        for (i in 0 until m - 1) {
            for (j in 0 until n) {
                val x = grid[i][j]
                s += x.toLong()
                if (i > 0 || j == 0 || j == n - 1) {
                    dict.add(x.toLong())
                }
            }

            val t = s shl 1
            if (n == 1) {
                if (t == total || t - grid[0][0] == total || t - grid[i][0] == total) {
                    return true
                }
                continue
            }

            if (dict.contains(t - total)) {
                return true
            }

            if (i == 0) {
                for (j in 0 until n) {
                    dict.add(grid[i][j].toLong())
                }
            }
        }
        return false
    }

    private fun reverse(grid: Array<IntArray>) {
        val m = grid.size
        var i = 0
        var j = m - 1
        while (i < j) {
            val t = grid[i]
            grid[i] = grid[j]
            grid[j] = t
            i++
            j--
        }
    }
}