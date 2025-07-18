package difficulty.A315;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class 计算右侧小于当前元素的个数 {
    public static void main(String[] args) {
        List<Integer> list = new 计算右侧小于当前元素的个数().countSmaller(ArrayUtils.createArrayOne("[26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41]"));
        System.out.println(list);
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i  = n - 1 ; i > -1 ; i --){
            if(i == 0){
                System.out.println(1);
            }
            int sum = 0 ;
            for (Integer k : map.keySet()) {
                if(k >= nums[i]) break;
                sum += map.get(k);
            }
            res.add(0, sum);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}
