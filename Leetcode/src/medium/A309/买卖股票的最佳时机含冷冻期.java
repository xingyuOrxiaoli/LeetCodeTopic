package medium.A309;

public class 买卖股票的最佳时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 0 买入  1卖出  2冷却期
        dp[0][0] = -prices[0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1] , dp[n - 1][2]);
    }
}
