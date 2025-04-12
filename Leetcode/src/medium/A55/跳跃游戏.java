package medium.A55;

import java.util.Arrays;

public class 跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        boolean b = new 跳跃游戏().canJump(nums);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        int max = 1,index = 0;
        while(index < max){
            if(max >= nums.length) return true;
            max = Math.max(max, nums[index] + index + 1);
            index ++;
        }
        return false;
    }
}
