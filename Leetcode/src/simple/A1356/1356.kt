package simple.A1356

fun sortByBits(arr: IntArray): IntArray {
    val map = createBitOneNumsMap(arr)
    return arr.sortedWith(
        compareBy<Int> { map[it] }
            .thenBy { it }
    ).toIntArray()
}

private fun createBitOneNumsMap(arr: IntArray): Map<Int, Int> {
    val map = HashMap<Int, Int>()
    for (value in arr) {
        if (!map.containsKey(value)) {
            map[value] = getItemBitOneNums(value)
        }
    }
    return map
}

private fun getItemBitOneNums(value: Int): Int {
    var res = 0
    var num = value
    while (num != 0) {
        if ((num and 1) != 0) {
            res++
        }
        num /= 2
    }
    return res
}

fun main(args: Array<String>) {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    sortByBits(arr)
}