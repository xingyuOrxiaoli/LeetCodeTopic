package simple.A1404

fun numSteps(s: String): Int {
    var res = 0
    var steps = 0
    s.reversed().forEachIndexed { index, item ->
        if (item == '0') {
            res += steps + 1
        } else {
            if(steps == 0 && index != s.length - 1) {
                steps = 1
                res += steps + 1
            } else if(steps == 1) {
                res += 1
            }
        }
    }

    return res
}
fun main(args: Array<String>) {
    val s = "1010101010101110"
    val numSteps = numSteps(s)
    println(numSteps)
}

