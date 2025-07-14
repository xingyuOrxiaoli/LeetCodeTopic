package simple.A303;

public class 区域和检索_数组不可变 {
}
class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if(left != 0) return nums[right] - nums[left - 1];
        return nums[right];
    }
}