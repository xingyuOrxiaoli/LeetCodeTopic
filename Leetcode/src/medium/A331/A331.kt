package medium.A331;

class MethodVersion1 :  A331Solution{

    override fun isValidSerialization(preorder: String): Boolean {
        val n = preorder.length
        var count = 1
        var i = 0
        while (i < n) {
            val ch = preorder[i]
            if (ch == ',') {
                i++
                continue
            } else if (ch == '#') {
                count--
            } else {
                while (i < n && preorder[i] != ',') {
                    i++
                }
                count++
            }
            if (count == 0 && i != n - 1) {
                return false
            }
            i++
        }
        return count == 0
    }
}