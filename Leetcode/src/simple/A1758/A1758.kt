package simple.A1758

import kotlin.math.min

class MethodVersion1 : A1758Solution{
    override fun minOperations(s: String): Int {
        var first = 0
        var second = 0
        var cur = '1'

        for (c in s) {
            if(cur != c) {
                first ++
            } else {
                second ++
            }
            cur = ('1' - cur + '0'.code).toChar()
        }
        return min(first,second)
    }

}