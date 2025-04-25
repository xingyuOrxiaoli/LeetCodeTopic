package medium.A2845;

import java.util.*;

public class 统计趣味子数组的数目 {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(1);
        nums.add(9);
        nums.add(6);

        long l = new 统计趣味子数组的数目().countInterestingSubarrays(nums, 3, 0);
        System.out.println(l);
    }

    // 暴力解法
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res = 0 ;
        int n = nums.size();
        int[] s = new int[n + 1];
        for(int i = 0 ; i < n ; i++) {
            if (nums.get(i) % modulo == k) s[i + 1] = 1;
            s[i + 1] += s[i];
        }

        for(int i = 1 ; i <= n ; i++) {
            for (int j = i; j <= n; j++)
                if ((s[j] - s[i - 1]) % modulo == k) res++;
        }
        return res;
    }
    // 优化
    public long countInterestingSubarrays2(List<Integer> nums, int modulo, int k) {
        long res = 0 ;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0  , n = nums.size();
        for(int i = 0 ; i < n ; i++) {
            left += nums.get(i) % modulo == k ? 1 : 0;
            res += map.getOrDefault((left - k + modulo) % modulo, 0);
            map.put(left % modulo , map.getOrDefault(left % modulo, 0) + 1);
        }
        return res;
    }

}
