package simple.A344

class MethodVersion1 : A344Solution {
    override fun reverseString(s: CharArray?) {
        var left = 0
        var right = s!!.size - 1
        while (left < right) {
            s[left] = (s[left].code xor s[right].code).toChar()
            s[right] = (s[right].code xor s[left].code).toChar()
            s[left] = (s[left++].code xor s[right--].code).toChar()
        }
    }

}