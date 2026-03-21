package simple.A476;

class MethodVersion1 :  A476Solution{

    override fun findComplement(num: Int): Int {
        var res = 0
        val upper = Int.MAX_VALUE
        for (i in 1..31) {
            if ((upper shr i) >= num) {
                continue
            }
            res = (upper shr (i - 1)) xor num
            break
        }

        return res
    }
}