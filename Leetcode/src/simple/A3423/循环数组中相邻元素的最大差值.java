package simple.A3423;

import utils.ArrayUtils;

public class 循环数组中相邻元素的最大差值 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[1,2,4]");
        int i = new 循环数组中相邻元素的最大差值().maxAdjacentDistance(nums);
        System.out.println(i);
    }

    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length , res =  Math.abs(nums[n - 1] - nums[0]) ;
        for(int i = 0 ; i < nums.length ; i ++){
           res  = Math.max(res, Math.abs(nums[i] - nums[(i + 1) % n]));
        }

        return  res;
    }
}
