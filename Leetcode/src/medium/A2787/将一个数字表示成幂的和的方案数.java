package medium.A2787;

import java.util.HashSet;

public class 将一个数字表示成幂的和的方案数 {

    public static void main(String[] args) {
        int res = new 将一个数字表示成幂的和的方案数().numberOfWays(10, 2);
        System.out.println(res);
    }
    public int numberOfWays(int n, int x) {
        int mod = 1000000007 , start = 1;
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            long cur = (long) Math.pow(i , x);
            for(int j = 0 ; j <= n ; j ++){
                dp[i][j] = dp[i - 1][j];
                if(j >= cur) dp[i][j] = (dp[i][j] + dp[i - 1][j - (int)cur]) % mod;
            }
        }
        return (int)dp[n][n];
    }
}
