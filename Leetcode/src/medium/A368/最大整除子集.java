package medium.A368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大整除子集 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<Integer> integers = new 最大整除子集().largestDivisibleSubset(nums);
        System.out.println(integers);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 1) return res;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int maxSize = 0, maxVal = nums[0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        if(maxSize == 0) {
            res.add(nums[0]);
            return res;
        }
        for(int i = n  - 1; i >= 0 && maxSize>= 0; i--) {
            if(dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize -- ;
            }
        }
        return res;
    }
}
