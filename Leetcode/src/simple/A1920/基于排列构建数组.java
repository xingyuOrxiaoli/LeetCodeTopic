package simple.A1920;

import java.util.Arrays;

public class 基于排列构建数组 {

    public static void main(String[] args) {
        int n = 10;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int[] ints = new 基于排列构建数组().buildArray(nums);
        System.out.println(Arrays.toString(ints));
    }

    // 开一个新的数组
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++)  res[i] = nums[nums[i]];

        return res;
    }
}
