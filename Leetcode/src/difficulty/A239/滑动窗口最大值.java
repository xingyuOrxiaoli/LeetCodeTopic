package difficulty.A239;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[9,10,9,-7,-4,-8,2,-6]");
        int[] ints = new 滑动窗口最大值().maxSlidingWindow(nums, 5);
        System.out.println(Arrays.toString(ints));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length , index = 0;
        int[] res = new int[n - k + 1];

        TreeMap<Integer,Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
        for(int i = 0; i < k; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        res[index] = map.firstKey();
        for(int i = k ; i < n ; i ++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            Integer value = map.get(nums[index]);

            if(value == 1) map.remove(nums[index]);
            else map.put(nums[index], value - 1);

            res[++index] = map.firstKey();
        }


        return res;
    }
}
