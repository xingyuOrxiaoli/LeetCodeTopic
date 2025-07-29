package medium.A322;

import java.util.Arrays;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int n = coins.length;

        Arrays.fill(dp,amount + 10);

        dp[0] = 0;
        for(int i = 1 ; i <= amount ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 10? -1 : dp[amount];
    }
}
