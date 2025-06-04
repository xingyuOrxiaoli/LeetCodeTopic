package difficulty.A154;

public class 寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) min = Math.min(min, nums[i]);
        return min;
    }
}
