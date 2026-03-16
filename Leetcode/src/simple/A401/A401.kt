package simple.A401

class MethodVersion1 : A401Solution {
    override fun readBinaryWatch(turnedOn: Int): List<String> {
        val res: MutableList<String> = ArrayList()
        for (h in 0..11) {
            for (m in 0..59) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(String.format("%d:%02d", h, m))
                }
            }
        }
        return res
    }
}