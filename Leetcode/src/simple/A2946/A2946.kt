package simple.A2946;

class MethodVersion1 :  A2946Solution{

    override fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
        val n = mat.size
        val m = mat[0].size
        var k = k
        for (j in 0 until m) {
            val y = (50 * m + j + k) % m
            for (i in 0 until n) {
                if (mat[i][j] != mat[i][y]) {
                    return false
                }
            }
            k = -k
        }
        return true
    }
}