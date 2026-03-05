package simple.A383

class MethodVersion1 : A383Solution {
    override  fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val count = IntArray(26)
        val n = ransomNote.length
        val m = magazine.length
        if (n > m) return false
        for (i in 0 until m) count[magazine[i].code - 'a'.code]++
        for (i in 0 until n) {
            val ch = ransomNote[i]
            if (count[ch.code - 'a'.code] == 0) return false
            count[ch.code - 'a'.code]--
        }
        return true
    }

}