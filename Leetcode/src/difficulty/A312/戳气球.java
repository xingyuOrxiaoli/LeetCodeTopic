package difficulty.A312;

public class 戳气球 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] value = new int[n + 2];
        value[0] = 1 ;
        value[ n + 1] = 1;
        for(int i  = 0 ; i < n ; i ++) value[i + 1] = nums[i];
        for(int i = n - 1 ; i > -1 ; i --){
            for(int j = i + 2 ; j <= n + 1 ; j ++){
                for(int k = i + 1 ; k < j ; k ++){
                    int temp = value[i] * value[k] * value[j];
                    temp += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], temp);
                }
            }
        }
        return dp[0][n + 1];
    }

}
