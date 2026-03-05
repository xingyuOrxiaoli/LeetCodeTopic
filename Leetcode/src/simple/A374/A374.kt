package simple.A374

class MethodVersion1 : A374Solution , GuessGame(){
    override fun guessNumber(n: Int): Int {
        var left = 0
        var right = n

        while (left < right){
            val mid = left + (right - left) / 2
            val guessResult = guess(mid)
            if(guessResult == 0) {
                return mid
            } else if (guessResult == 1) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }

}