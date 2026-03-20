package simple.A459

class MethodVersion1 : A459Solution {

    override fun repeatedSubstringPattern(s: String): Boolean {
        return (s + s).indexOf(s, 1) != s.length
    }

}