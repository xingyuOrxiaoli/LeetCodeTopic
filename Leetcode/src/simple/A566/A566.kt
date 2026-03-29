package simple.A566;

class MethodVersion1 :  A566Solution{

    override fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        if (m * n != r * c) {
            return mat
        }

        val res = Array(r) { IntArray(c) }
        var x = 0
        var y = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                res[x][y] = mat[i][j]
                y++
                if (y == c) {
                    x++
                    y = 0
                }
            }
        }


        return res
    }
}