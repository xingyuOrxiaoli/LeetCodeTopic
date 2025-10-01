package simple.A1518

import jdk.nashorn.internal.objects.Global.println

object 换水问题 {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var res = numBottles
        var cur = numBottles
        while(cur >= numExchange){
            res += cur / numExchange
            cur = cur / numExchange + cur % numExchange
        }
        return res
    }
}

fun main(args: Array<String>) {
    println(换水问题.numWaterBottles(2, 3))
}