package medium.A313;

import utils.ArrayUtils;

import java.util.Arrays;

public class 超级丑数 {
    public static void main(String[] args) {
        int i = new 超级丑数().nthSuperUglyNumber(5911, ArrayUtils.createArrayOne("[2,3,5,7]"));
        System.out.println(i);
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length ;
        long min = Long.MAX_VALUE ;
        long[] dp = new long[n + 1] ;
        int[] noteIndex = new int[m];
        long[] note = new long[m];
        Arrays.fill(noteIndex , 1);
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                long temp = dp[noteIndex[j]] * primes[j];
                note[j] = temp;
                if(min > temp) min = temp;
            }
            for(int j = 0 ; j < m ; j ++)
                if(note[j] == min) noteIndex[j] ++;
            dp[i] = min;
            min = Long.MAX_VALUE;
        }
        return (int)dp[n];
    }
}