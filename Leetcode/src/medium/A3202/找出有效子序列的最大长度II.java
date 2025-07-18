package medium.A3202;

public class 找出有效子序列的最大长度II {

    public int maximumLength(int[] nums, int k) {
        int n = nums.length , res = 0 ;
        int[][] dp = new int[k][k];
        for(int i = 0 ; i < n ; i++){
            int t = nums[i] % k;
            for(int j = 0 ; j < k ; j ++){
                dp[j][t] = dp[t][j] + 1;
                res = Math.max(res, dp[j][t]);
            }
        }
        return res;
    }

}
