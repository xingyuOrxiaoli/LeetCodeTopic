package medium.A153;

import java.util.Arrays;

public class 寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {

    }
    // 遍历  百分之百
    public int findMin1(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) min = Math.min(min, nums[i]);
        return min;
    }
    public int findMin2(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }
}
