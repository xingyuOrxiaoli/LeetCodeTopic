package medium.A3546;

class MethodVersion1 :  A3546Solution{

    override fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val n = grid.size
        val m = grid[0].size
        val rows = IntArray(n)
        val cols = IntArray(m)
        var sum: Long = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                rows[i] += grid[i][j]
                cols[j] += grid[i][j]
                sum += grid[i][j].toLong()
            }
        }

        if ((sum and 1L) == 1L) {
            return false
        }

        var rowSum: Long = 0
        for (i in 0 until n) {
            rowSum += rows[i].toLong()
            if (rowSum * 2 == sum) {
                return true
            }
        }
        var colSum: Long = 0
        for (j in 0 until m) {
            colSum += cols[j].toLong()
            if (colSum * 2 == sum) {
                return true
            }
        }

        return false
    }
}