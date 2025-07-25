package simple.A1009;

public class 十进制整数的反码 {
    public int bitwiseComplement(int n) {
        int res = 0  , bit = 0;
        if(n == 0) return 1;
        while(n != 0){
            int t = n & 1;
            t ^= 1;
            t <<= bit ++ ;
            res += t;
            n >>= 1;
            // bit ++;
        }
        return res;
    }
}
