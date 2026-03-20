package simple.A461;

class MethodVersion1 :  A461Solution{

    override fun hammingDistance(x: Int, y: Int): Int {
        var res = 0
        var a = x
        var b = y
        while (a != 0 || b != 0) {
            if ((a and 1) != (b and 1)) {
                res++
            }
            a = a shr 1
            b = b shr 1
        }
        return res
    }
}