package medium.A2294;

import java.util.Arrays;

public class 划分数组使最大差为K {
    public static void main(String[] args) {

    }
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1 , left = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - left > k){
                res ++;
                left = nums[i];
            }
        }

        return res;
    }
}
