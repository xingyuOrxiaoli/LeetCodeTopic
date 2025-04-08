package medium.A31;

import java.util.Arrays;
import java.util.Collections;

public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};

        // 3 2 1
        // 3 1 2
        new 下一个排列().nextPermutation(nums);

        int[] nums2 = new int[]{1,3,2};
        new 下一个排列().nextPermutation2(nums2);
        System.out.println(Arrays.toString(nums2));
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

    public void nextPermutation2(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        for(int i = n - 2 ; i >= 0 ; i --){
            if(nums[i]  <  nums[i + 1]){
                // 先进行从 i + 1 到  n - 1 进行下坠
                for(int j = i + 1 ; j < n - 1 && flag; j++){
                    if(flag && nums[j + 1] <= nums[i]){
                        // 找到i元素的位置
                        nums[j] = nums[j] ^ nums[i];
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[j] ^ nums[i];
                        flag = false;
                    }
                }
                if(flag){
                    nums[i] = nums[i] ^ nums[n - 1];
                    nums[n - 1] = nums[i] ^ nums[n - 1];
                    nums[i] = nums[i] ^ nums[n - 1];
                }
                int left = i + 1  , right = n - 1;
                while(left < right){
                    nums[left] = nums[left] ^ nums[right];
                    nums[right] = nums[right] ^ nums[left];
                    nums[left] = nums[left] ^ nums[right];
                    left ++;
                    right --;
                }
                return;
            }
        }
        // 最大值
        for(int i = 0 ; i < (n >> 1) ; i++){
            nums[i]  = nums[i] ^ nums[n - 1 - i ];
            nums[n - 1 - i] = nums[n - i - 1] ^ nums[i];
            nums[i] = nums[i] ^ nums[n - 1 - i];
        }
    }
}
