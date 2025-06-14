package medium.A209;

import utils.ArrayUtils;

public class 长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[1,4,4]");
        int i = new 长度最小的子数组().minSubArrayLen(4, nums);
        System.out.println(i);
    }
    public int minSubArrayLen(int target, int[] nums) {
        int cur = 0 , left = 0 , right = 0 , n = nums.length , res = n + 1;

        while(right < n){
            cur += nums[right];

            while(left <= right && cur >= target){
                if(res == 1) return res;
                res = Math.min(res, right - left + 1);
                cur -= nums[left ++];
            }
            right ++;
        }
        if(res > n) res = 0;
        return res;
    }
}
