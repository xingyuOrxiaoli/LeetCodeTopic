package medium.A1498;

import utils.ArrayUtils;

import java.util.Arrays;


/**
 * x = 1   y = 1   2y = 2
 * x = 2   y = 3   2y = 6
 * x = 3   y = 7   2y = 14
 * x = 4   y = 13  2y = 26
 * y = 5   y = 25  2y = 50
 *
 * 5
 * 4 3 2 1
 * 3 2 1
 * 2 1     2
 * 1
 */
public class 满足条件的子序列数目 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[2,3,3,4,6,7]");
        int i = new 满足条件的子序列数目().numSubseq(nums, 12);
        System.out.println(i);
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        final int mod = 1000000007;

        int n = nums.length , left = 0, right = n- 1 ;
        long res  = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1; //  一个元素 A11
        Arrays.setAll(dp, i ->{
            if(i == 0) return 1;
            else return (dp[i - 1] << 1) % mod;
        });

        while (left <= right) {
            if(nums[left] + nums[right] > target) {
                right --;
            }else {
//                if(nums[left] * 2 <= target)   res ++; // 一个本身
                int x = right - left;
                // 求An nv  -> 与处理好
                res += dp[x];
                res %= mod;
                left ++;
            }
        }
        return (int)res;
    }
}
