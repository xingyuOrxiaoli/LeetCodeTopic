package medium.A560;

import java.util.*;

public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length , res = 0;
        int[] s = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>(n + 1);
        for(int i = 0 ; i < n ; i++) s[i + 1] = s[i] + nums[i];

        for (int value : s) {
            res += map.getOrDefault(value - k , 0);
            map.merge(value , 1, Integer::sum);
        }
        return res;
    }
}
