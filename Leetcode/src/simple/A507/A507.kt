package simple.A507;

class MethodVersion1 :  A507Solution{

    override fun checkPerfectNumber(num: Int): Boolean {
        val n = (num shr 1)
        var sum = 0
        for (i in n downTo 1) {
            if (num % i == 0) {
                sum += i
            }
        }

        return sum == num
    }
}