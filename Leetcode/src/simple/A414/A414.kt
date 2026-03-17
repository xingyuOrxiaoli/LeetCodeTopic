package simple.A414

import kotlin.math.max

class MethodVersion1 : A414Solution {
    override fun thirdMax(nums: IntArray): Int {
        val n = nums.size
        var res = Long.MIN_VALUE
        var a = Long.MIN_VALUE
        var b = Long.MIN_VALUE
        for (i in 0 until n) {
            val num = nums[i]
            if (num > a) {
                res = b
                b = a
                a = num.toLong()
            } else if (num > b && num.toLong() != a) {
                res = b
                b = num.toLong()
            } else if (num.toLong() != b && num.toLong() != a) {
                res = max(res.toDouble(), num.toDouble()).toLong()
            }
        }
        return (if (res == Long.MIN_VALUE) a else res).toInt()
    }


}