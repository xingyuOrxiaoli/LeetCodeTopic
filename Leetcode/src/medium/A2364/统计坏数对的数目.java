package medium.A2364;


import java.util.*;

public class 统计坏数对的数目 {

    public static void main(String[] args) {
        int[] nums = {};
        long l = new 统计坏数对的数目().countBadPairs(nums);

    }
    public long countBadPairs(int[] nums) {
        long res = 0;
        int n  = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            res += i - map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return res ;
    }
}
