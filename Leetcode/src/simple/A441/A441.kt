package simple.A441

class MethodVersion1 : A441Solution {

    override fun arrangeCoins(n: Int): Int {
        var res = 0
        var m = n
        while (m> 0) {
            res ++;
            if(res > m){
                res --;
            }
            m -= res;
        }
        return res

    }

}