package medium.A790;

public class 多米诺和托米诺平铺 {

    public static void main(String[] args) {
        int i = new 多米诺和托米诺平铺().numTilings(4);
        System.out.println(i);
    }

    // https://leetcode.cn/problems/domino-and-tromino-tiling/submissions/627529540/?envType=daily-question&envId=2025-05-05
    public int numTilings1(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2] + 2 * dp[i - 3];

        return dp[n];
    }
    static final int MOD = 1000000007;

    public int numTilings(int n) {
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }

    // 显示最快 0ms
    public int numTilings2(int n) {
        if (n <= 2) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % MOD;
        }
        return (int)dp[n];
    }
}
