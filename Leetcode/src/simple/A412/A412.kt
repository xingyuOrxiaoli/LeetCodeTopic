package simple.A412

class MethodVersion1 : A412Solution {
    override fun fizzBuzz(n: Int): List<String> {
        val res: MutableList<String> = ArrayList()

        for (i in 1..n) {
            if (i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz")
            else if (i % 3 == 0) res.add("Fizz")
            else if (i % 5 == 0) res.add("Buzz")
            else res.add(i.toString())
        }
        return res
    }


}