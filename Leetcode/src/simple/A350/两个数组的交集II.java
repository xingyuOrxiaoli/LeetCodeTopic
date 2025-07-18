package simple.A350;

import java.util.*;
import java.util.stream.Collectors;

public class 两个数组的交集II {
    public static void main(String[] args) {

    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> count1 = new HashMap<>();
        for (int num : nums1) count1.put(num,count1.getOrDefault(num,0) + 1);
        List<Integer> res = new ArrayList<>();

        for(int num : nums2){
            int count = count1.getOrDefault(num,0);
            if(count > 0) res.add(num);
            count1.put(num,count - 1);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
