package medium.A53;

public class 最大子数组和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = new 最大子数组和().maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length , max =  nums[0];
        int[] dp = new int[n];
        dp[0] = max;
        for (int i = 1; i < n; i++) {
            if(dp[i -1 ] >= 0){
                dp[i] = dp[i - 1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
