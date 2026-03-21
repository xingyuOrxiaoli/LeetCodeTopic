package simple.A482;

import java.util.*

class MethodVersion1 :  A482Solution{

    override fun licenseKeyFormatting(s: String, k: Int): String {
        val res = StringBuilder(s.uppercase(Locale.getDefault()))
        var num = 0
        for (i in res.length - 1 downTo -1 + 1) {
            if (res[i] == '-') {
                res.deleteCharAt(i)
                continue
            }
            if (++num == k) {
                res.insert(i, '-')
                num = 0
            }
        }
        while (res.length > 0 && res[0] == '-') {
            res.deleteCharAt(0)
        }
        return res.toString()
    }
}