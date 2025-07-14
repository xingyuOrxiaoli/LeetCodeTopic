package medium.A300;

import utils.ArrayUtils;

import java.util.Arrays;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int i = new Solution().lengthOfLIS(ArrayUtils.createArrayOne("[10,9,2,5,3,7,101,18]"));
        System.out.println(i);
    }
}
class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length , res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 0 ; i < n ; i ++){
            for(int j =0 ; j < i ; j ++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}