package simple.A605;

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MethodVersion1 :  A605Solution{

    override fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        val m: Int = flowerbed.size
        var i = 0
        var n = n
        while (i < m) {
            if (flowerbed[i] == 1) {
                i++
                i++
                continue
            }
            if (i == m - 1 || flowerbed[i + 1] == 0) {
                n--
                flowerbed[i] = 1
                i++
            }
            if (n == 0) {
                return true
            }
            i++
        }
        return n <= 0
    }
}