package simple.A190;

public class 颠倒二进制位 {
    public static void main(String[] args) {
        int i = new 颠倒二进制位().reverseBits(964176192);
        System.out.println(i);
    }
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0 ; i < 32 ; i++){
            // System.out.print(n & 1);
            res <<= 1;
            res +=( n & 1);
            n >>>= 1;
        }

        return res;
    }
    public int reverseBits2(int n) {
        int res = 0;
        for(int i = 0 ; i < 32 && n != 0; i++){
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }

        return res;
    }
}
