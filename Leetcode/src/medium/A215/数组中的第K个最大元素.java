package medium.A215;

import java.util.Arrays;

public class 数组中的第K个最大元素 {
    public static void main(String[] args) {

    }
    // 快排   计数排序(TreeSet集合优化不需要直接开那么多空间)
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - k];
    }
}
