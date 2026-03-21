package simple.A1886;

class MethodVersion1 :  A1886Solution{

    override fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val n = mat.size
        var zero = true
        var one = true
        var two = true
        var three = true
        var x1 = 0
        var y2 = n - 1
        while (x1 < n && y2 > -1) {
            var y1 = 0
            var x2 = 0
            while (y1 < n && x2 < n) {
                zero = zero and (mat[x1][y1] == target[x1][y1])
                one = one and (mat[x1][y1] == target[x2][y2])
                two = two and (mat[x1][y1] == target[n - x1 - 1][n - y1 - 1])
                three = three and (mat[x2][y2] == target[x1][x2])

                if (!(zero || one || two || three)) {
                    return false
                }
                y1++
                x2++
            }
            x1++
            y2--
        }
        return true
    }
}