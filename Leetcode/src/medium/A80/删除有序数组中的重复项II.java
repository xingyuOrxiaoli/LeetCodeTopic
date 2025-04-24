package medium.A80;

import java.util.Arrays;

public class 删除有序数组中的重复项II {
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,1,2,2,3};
        int i = new 删除有序数组中的重复项II().removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int res = 0, n = nums.length;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if(nums[i] == nums[res] && !flag){
                nums[++res] = nums[i];
                flag = true;
            }else if(nums[i] != nums[res]){
                res ++;
                nums[res] = nums[i];
                flag = false;
            }
        }
//        if(flag) nums[++res] = nums[n - 1]; ;
        return res + 1;
    }
}
