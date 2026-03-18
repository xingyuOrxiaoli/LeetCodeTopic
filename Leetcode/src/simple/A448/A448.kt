package simple.A448

class MethodVersion1: A448Solution {
    override fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val n = nums.size
        val count = IntArray(n + 1)
        for (i in 0 until n) {
            count[nums[i]]++
        }
        val res: MutableList<Int> = ArrayList()
        for (i in 1 until n + 1) {
            if (count[i] == 0) {
                res.add(i)
            }
        }
        return res
    }
}