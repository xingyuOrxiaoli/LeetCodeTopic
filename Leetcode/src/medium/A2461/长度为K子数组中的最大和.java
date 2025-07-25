package medium.A2461;

import java.util.HashMap;

public class 长度为K子数组中的最大和 {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0 , t = 0;
        int n = nums.length , count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i  = 0 ; i <  k - 1 ; i ++){
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
            if(map.get(key) == 1) count ++;
            t += key;
        }
        for (int i = k - 1; i < n; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
            if(map.get(key) == 1) count ++;
            t += key;
            if(k == count) res = Math.max(res , t);
            key = nums[i - k + 1];
            map.put(key, map.getOrDefault(key, 0) - 1);
            if(map.get(key) == 0) count --;
            t -= key;
        }
        return res;
    }
}
