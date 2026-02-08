@file:Suppress("UNUSED_CHANGED_VALUE")

package difficulty.A321

import kotlin.math.max
import kotlin.math.min


/**
 * 数组nums组成长度为k的数字最大的数
 */
fun getMaxNums(nums: IntArray, k: Int): IntArray {
    val res = IntArray(k)
    var index = -1

    // 可以前进的次数
    var count = nums.size - k

    for (num in nums) {
        while (index > -1 && count != 0 && res[index] < num) {
            index--
            count--
        }
        if (index < k - 1) res[++index] = num
        else count--
    }


    return res
}

/**
 * 合并两个数组 组成最大的数
 */
fun mergeMaxNum(first: IntArray, second: IntArray): IntArray {
    val n = first.size
    val m = second.size
    val k = n + m
    val res = IntArray(k)

    var index1 = 0
    var index2 = 0
    for (i in 0 until k) {
        if (index1 == n) {
            res[i] = second[index2++]
            continue
        }
        if (index2 == m) {
            res[i] = first[index1++]
            continue
        }
        if(compare(first,index1,second,index2)) {
            res[i] = first[index1 ++]
        } else {
            res[i] = second[index2 ++]
        }
    }

    return res
}

/**
 * 比较两个数的大小
 */
fun compare(first: IntArray,  i:Int, second: IntArray,j:Int): Boolean {
    val n = first.size
    val m = second.size
    var index1 = i
    var index2 = j
    while (index1 < n && index2 < m) {
        if(first[index1] != second[index2]) {
            return first[index1] - second[index2] > 0
        }
        index1 ++
        index2 ++
    }

    return (n - index1) - (m - index2) > 0
}

fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
    val n = nums1.size
    val m = nums2.size
    var res = IntArray(k)
    // 对于nums1 至少取 k - m个元素
    val start = max(0, k - m)
    // 至多取n个元素
    val end = min(k, n)
    for (i in start..end) {
        val first = getMaxNums(nums1, i)
        val second = getMaxNums(nums2, k - i)
        val third = mergeMaxNum(first, second)
        if (compare(third, 0,res,0)) {
            res = third
        }
    }
    return res
}

fun main() {
    val nums1: IntArray = intArrayOf(3,4,6,5)
    val nums2: IntArray = intArrayOf(9,1,2,5,8,3)
    val maxNumber = maxNumber(nums1, nums2, 5)
    println(maxNumber.toString())
}