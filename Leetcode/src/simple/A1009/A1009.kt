package simple.A1009

class MethodVersion1 : A1009Solution{
    override fun bitwiseComplement(n: Int): Int {
        var res = 0
        if (n == 0) {
            return 1
        }
        var m = n
        var bit = 0
        while (m != 0) {
            var temp = m and 1
            temp = temp xor 1
            temp = temp shl bit++
            res += temp
            m = m shr 1
        }
        return res
    }

}