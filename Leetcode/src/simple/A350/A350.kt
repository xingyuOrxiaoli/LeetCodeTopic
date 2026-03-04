package simple.A350


class MethodVersion1 : A350Solution {
    override fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val count1 = HashMap<Int, Int>()
        for (num in nums1!!) count1[num] = count1.getOrDefault(num, 0) + 1
        val res: MutableList<Int> = ArrayList()

        for (num in nums2!!) {
            val count = count1.getOrDefault(num, 0)
            if (count > 0) res.add(num)
            count1[num] = count - 1
        }

        return res.stream().mapToInt { i: Int? -> i!! }.toArray()
    }

}

