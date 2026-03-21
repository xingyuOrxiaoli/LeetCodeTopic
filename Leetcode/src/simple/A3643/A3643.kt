package simple.A3643;

class MethodVersion1 :  A3643Solution{

    override fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        for (i in 0 until (k shr 1)) {
            val x1 = x + i
            val x2 = x + k - 1 - i
            for (j in 0 until k) {
                val y1 = y + j
                grid[x1][y1] = grid[x1][y1] xor grid[x2][y1]
                grid[x2][y1] = grid[x2][y1] xor grid[x1][y1]
                grid[x1][y1] = grid[x1][y1] xor grid[x2][y1]
            }
        }
        return grid
    }
}