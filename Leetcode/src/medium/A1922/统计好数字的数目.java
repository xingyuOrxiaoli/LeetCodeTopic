package medium.A1922;

import simple.A2843.统计对称整数的数目;

public class 统计好数字的数目 {
    public static void main(String[] args) {
        // 806166225460393
        int i = new 统计好数字的数目().countGoodNumbers(50);
        System.out.println(i);
    }
    final long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long res = 1 ;
        long odd =  n >> 1 , even = (n + 1) >> 1;
        //  odd  四种
        //  even 0 2 4 6 8
        if(odd == 0) return 5;
        long temp = 5;
        while(even != 0 ){
            if((even & 1) == 1) res = (res * temp) % mod;
            temp = (temp * temp) % mod;
            even = even >> 1;
        }
        temp = 4;
        while (odd != 0){
            if((odd & 1) == 1) res = (res * temp) % mod;
            temp = (temp * temp) % mod;
            odd = odd >> 1;
        }
        return (int) res;
    }
    public int countGoodNumbers2(long n) {
        return (int)(quick_mul(5, (n + 1) >> 1) + quick_mul(5, n >> 1));
    }
    // 快速幂函数 a的b次幂
    private long quick_mul(long a, long b){
        long res = 1 , temp = a;
        while(b != 0){
            if((b & 1) ==1) res = (res * temp) % mod;
            temp = (temp * temp) % mod;
            b = b >> 1;
        }
        return res;
    }
}
