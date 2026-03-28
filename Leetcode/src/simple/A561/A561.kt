package simple.A561;

import java.util.*

class MethodVersion1 :  A561Solution{

    override fun arrayPairSum(nums: IntArray): Int {
        Arrays.sort(nums)
        var res = 0
        var i = 0
        while (i < nums.size) {
            res += nums[i]
            i += 2
        }
        return res
    }
}