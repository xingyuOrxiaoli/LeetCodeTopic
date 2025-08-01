package medium.A2419;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 按位与最大的最长子数组 {
    public int longestSubarray(int[] nums) {
        int res  = 1 , max = Arrays.stream(nums).max().getAsInt() , n = nums.length , left = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == max) res = Math.max(res, i - left + 1);
            else left = i + 1;
        }
        return res ;
    }
}
