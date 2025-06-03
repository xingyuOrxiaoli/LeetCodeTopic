package medium.A152;

import utils.ArrayUtils;

import java.util.Arrays;

public class 乘积最大子数组 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[2,3,-2,4]");
        int i = new 乘积最大子数组().maxProduct(nums);
        System.out.println(i);
    }

    // 二维
    public int maxProduct(int[] nums) {
        int n = nums.length ;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1 ; i < n ; i ++){
            dp[i] = Math.max(nums[i] , dp[i - 1]);
            dp[i] = Math.max(dp[i] , dp[i - 1] * nums[i]);
        }
        return dp[n - 1];
    }
}
