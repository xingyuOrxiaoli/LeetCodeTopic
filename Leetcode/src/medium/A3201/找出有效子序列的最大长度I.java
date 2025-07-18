package medium.A3201;

public class 找出有效子序列的最大长度I {
    public int maximumLength(int[] nums) {
        int n = nums.length , res = 0 ;
        int[][] dp = new int[2][2];
        for(int i = 0 ; i < n ; i++){
            int t = nums[i] % 2;
            for(int j = 0 ; j < 2 ; j ++){
                dp[j][t] = dp[t][j] + 1;
                res = Math.max(res, dp[j][t]);
            }
        }
        return res;
    }
}
