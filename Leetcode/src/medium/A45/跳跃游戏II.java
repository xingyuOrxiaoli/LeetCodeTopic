package medium.A45;

import java.util.Arrays;

public class 跳跃游戏II {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        int jump1 = new 跳跃游戏II().jump1(nums);
        int jump2 = new 跳跃游戏II().jump2(nums);
        System.out.println(jump1);
        System.out.println(jump2);
    }


    // 方法一 使用动态规划
    public int jump1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0 ;i < n ;i++) {
            int step = nums[i];
            for(int j = i + 1 ; j <= i + step && j < n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }
    // 方法二 贪心
    public int jump2(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int res = 0 , maximize = 0 , dist = 0 ;
        for(int i = 0 ; i < n ; i++) {
            maximize = Math.max(maximize, i + nums[i]);
            if(i == dist){
                res ++;
                dist = maximize;
            }
            if(dist >= n - 1) break;
        }
        return res;
    }
}
