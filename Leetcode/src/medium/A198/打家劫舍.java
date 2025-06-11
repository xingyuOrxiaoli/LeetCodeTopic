package medium.A198;

import utils.ArrayUtils;

import java.util.Arrays;

public class 打家劫舍 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[2,1,1,2]");
        int rob = new 打家劫舍().rob(nums);
        System.out.println(rob);
    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int  n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2] , dp[i - 1]);
        }
        return dp[n - 1];
    }
}
