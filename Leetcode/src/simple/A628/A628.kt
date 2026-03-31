package simple.A628;

import java.util.*


class MethodVersion1 :  A628Solution{

    override fun maximumProduct(nums: IntArray): Int {
        val n: Int = nums.size
        Arrays.sort(nums)

        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 2] * nums[n - 3] * nums[n - 1])
    }
}