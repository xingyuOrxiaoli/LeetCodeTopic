package simple.A349

import java.util.*
import java.util.stream.Collectors

class MethodVersion1 : A349Solution {
    override fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set = Arrays.stream(nums1).boxed().collect(Collectors.toSet())
        return Arrays.stream(nums2).distinct().filter { o: Int -> set.contains(o) }.toArray()
    }


}
