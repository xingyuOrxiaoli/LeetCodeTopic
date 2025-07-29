package medium.A347;

import utils.ArrayUtils;

import java.util.*;

public class 前K个高频元素 {
    public static void main(String[] args) {
        int[] res = new 前K个高频元素().topKFrequent(ArrayUtils.createArrayOne("[1,2]"), 2);
        System.out.println(Arrays.toString(res));
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        TreeMap<Integer, List<Integer>> heap = new TreeMap<>((o1, o2) -> o2 - o1);
        map.forEach((k1, v1) -> {
            heap.putIfAbsent(v1, new ArrayList<>());
            heap.get(v1).add(k1);
        });
        int index = 0 ;
        while(index < k){
            List<Integer> list = heap.get(heap.firstKey());
            for (Integer value : list) res[index++] = value;
            heap.remove(heap.firstKey());
        }
        return res;
    }
}
