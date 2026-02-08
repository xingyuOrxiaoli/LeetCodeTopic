package simple.A2614

import kotlin.math.max
import kotlin.math.sqrt


fun isPrime(n: Int): Boolean {
    if (n == 1) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

fun diagonalPrime(nums: Array<IntArray>): Int {
    var res = 0
    val n = nums.size - 1

    for (i in nums.indices) {
        if (isPrime(nums[i][i])) {
            res = max(res, nums[i][i])
        }
        if (isPrime(nums[n - i][i])) {
            res = max(res, nums[n - i][i])
        }
    }
    return res
}

fun main() {

}

/**
 *     fun diagonalPrime(nums: Array<IntArray>): Int {
 *
 *     }
 */