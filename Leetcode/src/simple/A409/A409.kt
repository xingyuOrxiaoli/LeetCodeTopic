package simple.A409

import java.util.HashSet

class MethodVersion1 : A409Solution {

    override fun longestPalindrome(s: String): Int {
        val set: MutableSet<Char> = HashSet()

        var res = 0
        for (c in s.toCharArray()) {
            if (set.contains(c)) {
                res += 2
                set.remove(c)
            } else {
                set.add(c)
            }
        }
        if (!set.isEmpty()) {
            res++
        }

        return res
    }

}