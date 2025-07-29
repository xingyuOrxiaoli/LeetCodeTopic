package medium.A2134;

import utils.ArrayUtils;

import java.util.Arrays;

public class 最少交换次数来组合所有的1II {
    public static void main(String[] args) {
        int res = new 最少交换次数来组合所有的1II().minSwaps(ArrayUtils.createArrayOne("[0,1,1,1,0,0,1,1,0]"));
        System.out.println(res);
    }
    public int minSwaps(int[] nums) {
        int  n = nums.length ,res = n , sum = 0 , count = 0;
        for(int i = 0 ; i < n ; i++)
            if(nums[i] == 1) sum ++;

        for(int i = 0 ; i < sum ; i ++)
            if(nums[i] == 1) count++;
        for(int i = 0 ; i < n ; i ++){
            res = Math.min(res, sum - count);
            if(nums[i] == 1) count --;
            if(nums[(i + sum) % n] == 1) count ++;
        }
        return res;
    }
}
