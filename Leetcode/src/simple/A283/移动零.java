package simple.A283;

import utils.ArrayUtils;

import java.util.Arrays;

public class 移动零 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[0,1,0,3,12]");
        new 移动零().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int left = 0 , right = 0 , n = nums.length;
        while(right < n){
            if(nums[right] != 0){
                nums[left ++] = nums[right];
            }
            right++;
        }
        while (left < right){
            nums[left++] = 0;
        }
    }
}
