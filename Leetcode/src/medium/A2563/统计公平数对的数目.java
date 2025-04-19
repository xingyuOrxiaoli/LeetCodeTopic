package medium.A2563;

import java.util.Arrays;

public class 统计公平数对的数目 {

    public static void main(String[] args) {
        int[] nums = {
                0,0,0,0,0,0
        };
        long l = new 统计公平数对的数目().countFairPairs2(nums, 0, 0);
        System.out.println(l);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length , left = n, right = n ;
        long res = 0 ;
        for(int i = 0 ; i < n ; i++){
            while(right > 0 && upper - nums[i] < nums[right - 1] ) right --;
            while(left  > 0 && lower - nums[i] <= nums[left - 1]) left --;
            res += Math.min(i , right) - Math.min(i , left);
        }
        return res;
    }
    public long countFairPairs2(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length , left = n - 1, right = n - 1;
        long res = 0 ;
        for(int i = 0 ; i < n ; i++){
            while(right >= 0 && upper - nums[i] < nums[right] ) right --;
            while(left  >= 0 && lower - nums[i] <= nums[left]) left --;
            res += Math.max(i , right) - Math.max(i , left);
        }
        return res;
    }
}
