package medium.A31;

import java.util.Collections;

public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};
        new 下一个排列().nextPermutation(nums);
    }
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        for(int i = length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                int temp = i + 1;
                while(temp < length && nums[temp] > nums[i -1]){
                    temp++;
                }
                if(temp == length){
                    temp = length - 1;
                }else{
                    temp = temp - 1;
                }
                nums[temp] = nums[temp] ^ nums[i - 1];
                nums[i - 1] = nums[i - 1] ^ nums[temp];
                nums[temp] = nums[temp] ^ nums[i - 1];
                reverse(nums,i,length - 1);
                return;
            }
        }
        reverse(nums , 0 , length - 1);
    }
    private void reverse(int[] nums,int start,int end) {
        while(start < end){
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[end] ^ nums[start];
            nums[start] = nums[start] ^ nums[end];
            end --;
            start ++;
        }
    }
}
