package medium.A504;

import kotlin.math.abs

class MethodVersion1 :  A504Solution{

    override fun convertToBase7(num: Int): String {
        if (num == 0) {
            return "0"
        }
        val res = StringBuilder()
        val flag = num < 0

        var value = abs(num.toDouble()).toInt()
        while (value != 0) {
            res.insert(0, value % 7)
            value /= 7
        }
        if (flag) {
            res.insert(0, '-')
        }
        return res.toString()
    }
}