package simple.A697;

import java.util.*;

public class A697SolutionMethodV1  implements A697Solution{

    @Override
    public int findShortestSubArray(int[] nums) {
        Map<Integer ,int[]> map = new HashMap<>();
        int n = nums.length;
        int res = n;
        int max = 1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            map.putIfAbsent(num,new int[3]);
            int[] values = map.get(num);
            if(values[0] == 0) {
                values[0] = i + 1;
            }
            values[1] = i + 1;
            values[2]++;
            max = Math.max(max,values[2]);
        }

        for (Integer key : map.keySet()) {
            int[] values = map.get(key);
            if(values[2] == max) {
                res = Math.min(res , values[1] - values[0] + 1);
            }
        }
        return res;

    }
}