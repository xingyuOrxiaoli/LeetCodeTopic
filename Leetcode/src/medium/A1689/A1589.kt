package medium.A1689

fun minPartitions(n: String): Int {
    var res = 0
    n.forEach { res = Math.max(res, it - '0') }
    return res
}