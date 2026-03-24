package simple.A492;

import kotlin.math.sqrt

class MethodVersion1 :  A492Solution{

    override fun constructRectangle(area: Int): IntArray {
        val res = IntArray(2)
        for (i in 1 ..sqrt(area.toDouble()).toInt()) {
            if (area % i == 0) {
                res[0] = area / i
                res[1] = i
            }
        }
        return res
    }
}