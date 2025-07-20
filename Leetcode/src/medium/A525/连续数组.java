package medium.A525;

import java.util.*;

public class 连续数组 {
    public int findMaxLength(int[] nums) {
        int n = nums.length , res = 0 , count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i <  n ; i ++){
            if(nums[i] == 1) count ++;
            else count --;
            if(count == 0) res = i + 1;
            if(map.containsKey(count)) res = Math.max(res , i - map.get(count));
            else map.put(count , i);
        }
        return res ;
    }
}
