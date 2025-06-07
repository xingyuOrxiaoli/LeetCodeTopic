package medium.A152;

import utils.ArrayUtils;

import java.util.Arrays;

public class 乘积最大子数组 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[2,3,-2,4]");
        int i = new 乘积最大子数组().maxProduct(nums);
        System.out.println(i);
    }

    //
    public int maxProduct(int[] nums) {
       int n = nums.length;
       int[] min = new int[n] , max = new int[n];
       min[0] = nums[0];
       max[0] = nums[0];
       for (int i = 1; i < n; i++) {
           max[i] = Math.max(Math.max(max[i - 1] * nums[i] , min[i - 1] * nums[i]), nums[i]);
           min[i] = Math.min(Math.min(min[i - 1] * nums[i] , max[i - 1] * nums[i]), nums[i]);
       }

       return Arrays.stream(max).max().getAsInt();
    }
}
