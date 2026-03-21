package simple.A485;

import kotlin.math.max

class MethodVersion1 :  A485Solution{

    override fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var res = 0
        var temp = 0
        val n = nums.size

        for (i in 0 until n) {
            if (nums[i] == 1) {
                temp++
            } else {
                res = max(res.toDouble(), temp.toDouble()).toInt()
                temp = 0
            }
        }

        res = max(res.toDouble(), temp.toDouble()).toInt()
        return res
    }
}