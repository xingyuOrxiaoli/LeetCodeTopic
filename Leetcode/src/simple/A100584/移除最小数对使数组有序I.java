package simple.A100584;

import java.util.Arrays;

public class 移除最小数对使数组有序I {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        int i = new 移除最小数对使数组有序I().minimumPairRemoval(nums);
        System.out.println(i);
    }
    public int minimumPairRemoval(int[] nums) {
        int res = 0;
        while (!check(nums)) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] + nums[i + 1] < minSum) {
                    minSum = nums[i] + nums[i + 1];
                    minIndex = i;
                }
            }
            nums[minIndex] = nums[minIndex] + nums[minIndex + 1];
            for (int i = minIndex + 1; i < nums.length - 1; i++) {
                nums[i] = nums[i + 1];
            }
            nums = Arrays.copyOf(nums, nums.length - 1);

            res++;
        }

        return res;
    }

    private boolean check(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
