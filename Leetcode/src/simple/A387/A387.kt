package simple.A387

class MethodVersion1 : A387Solution {
    override fun firstUniqChar(s: String): Int {
        val count = IntArray(26)
        for (c in s) {
            count[c - 'a'] ++
        }
        s.forEachIndexed { index, c ->
            if(count[c - 'a'] == 1) {
                return index
            }
        }
        return -1
    }

}