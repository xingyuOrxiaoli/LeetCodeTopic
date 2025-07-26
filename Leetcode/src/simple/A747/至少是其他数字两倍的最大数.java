package simple.A747;

import java.util.Arrays;

public class 至少是其他数字两倍的最大数 {
    public int dominantIndex(int[] nums) {
        int res = -1 , n = nums.length , max = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > max){
                max = nums[i];
                res = i;
            }
        }
        int finalMax = max;
        int second_max = Arrays.stream(nums).filter(value -> value != finalMax).max().getAsInt();
        if(second_max * 2 <= max) return res;
        return -1;
    }
}
