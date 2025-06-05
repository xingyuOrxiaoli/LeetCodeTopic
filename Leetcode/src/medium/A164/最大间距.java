package medium.A164;

import utils.ArrayUtils;

import java.util.Arrays;

public class 最大间距 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[3,6,9,1]");
        int i = new 最大间距().maximumGap(nums);
        System.out.println(i);
    }
    // sort排序之后遍历
    public int maximumGap(int[] nums) {
        int n = nums.length , res = 0 ;
        Arrays.sort(nums);
        for(int i = 1 ; i < n ; i++) res = Math.max(res , nums[i] - nums[i-1]);
        return res;
    }
}
