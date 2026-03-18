package simple.A415

class MethodVersion1 : A415Solution {

    override fun addStrings(num1: String, num2: String): String {
        val res = StringBuilder()
        var n = num1.length - 1
        var m = num2.length - 1
        var t = 0

        while (n > -1 && m > -1) {
            t += num1[n--].code - '0'.code + num2[m--].code - '0'.code
            res.insert(0, t % 10)
            t /= 10
        }
        while (n > -1) {
            t += num1[n--].code - '0'.code
            res.insert(0, t % 10)
            t /= 10
        }
        while (m > -1) {
            t += num2[m--].code - '0'.code
            res.insert(0, t % 10)
            t /= 10
        }
        if (t != 0) res.insert(0, t)

        return res.toString()
    }

}