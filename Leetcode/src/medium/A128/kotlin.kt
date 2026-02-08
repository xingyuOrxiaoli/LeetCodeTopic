package medium.A128

import java.util.TreeSet

fun longestConsecutive(nums: IntArray): Int {
    var res = 0
    var temp = 0
    val set: MutableSet<Int> = TreeSet()
    for (num in nums) {
        set.add(num)
    }
    for (num in set) {
        temp ++
        if(!set.contains(num + 1)) {
            res = Math.max(res, temp)
            temp = 0
        }
    }
    return res
}