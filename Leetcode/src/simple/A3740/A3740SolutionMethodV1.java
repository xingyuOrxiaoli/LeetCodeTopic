package simple.A3740;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3740SolutionMethodV1  implements A3740Solution{

    private final int[][] dict = new int[101][101];

    @Override
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            addElement(nums[i],i + 1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < n ; i ++) {
            List<Integer> list = find(i,nums[i]);
            if (list.size() < 3) {
                continue;
            }
            int distance = Math.abs(list.get(0) - list.get(1)) + Math.abs(list.get(0) - list.get(2)) + Math.abs(list.get(1) - list.get(2));
            min = Math.min(min, distance);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void addElement(int index, int val){
        int i = 0;
        while (dict[index][i] != 0) {
            i ++;
        }
        dict[index][i] = val;
    }

    private List<Integer> find(int start , int num) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (list.size() != 3 && dict[num][i] != 0) {
            int t = dict[num][i];
            if(t >= start) {
                list.add(t);
            }
            i ++;
        }

        return list;
    }

}