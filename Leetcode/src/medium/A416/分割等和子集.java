package medium.A416;

public class 分割等和子集 {

    public static void main(String[] args) {
        int[] nums =  new int[]{1,5,11,5};
        boolean b = new 分割等和子集().canPartition(nums);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum  = 0 ,max = 0;
        for(int i = 0 ; i < n ; i++) {
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        int avg = sum  >> 1;
        if( (sum & 1) == 1 || max > avg) return false;
        if(max == avg) return true;
        boolean[][] dp = new boolean[n][sum + 1];


        for(int i = 0 ; i < n ; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1 ; i < n ; i++) {
            for(int j = 0 ; j <= sum ; j++) {
                if(j >= nums[i]) {
                    dp[i][j] = dp[i-1][j] || dp[i -1][j - nums[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][sum];
    }
}
