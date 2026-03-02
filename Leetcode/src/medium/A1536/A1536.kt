package medium.A1536

class MethodVersion1 : A1536Solution{
    override fun minSwaps(grid: Array<IntArray>): Int {
        val n = grid.size
        val zeros = IntArray(n)

        for(i in 0 until n) {
            for(j in n - 1 downTo 0) {
                if(j == 0 || grid[i][j] != 0) {
                    zeros[i] = n - 1 - j
                    break
                }
            }
        }
        var res = 0

        for(i in 0 until n) {
            var prev = zeros[i]
            val curMin = n - 1 - i
            if(prev >= curMin) {
                continue
            }
            for(j in i + 1 until n) {
                res ++
                val curVal = zeros[j]
                zeros[j] = prev
                if(curVal >= curMin) {
                    break
                } else if (j == n - 1) {
                    return -1
                }
                prev = curVal
            }
        }
        return res
    }

}
