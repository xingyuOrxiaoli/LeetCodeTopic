package medium.A2841;

import utils.ArrayUtils;

import java.util.*;

public class 几乎唯一子数组的最大和 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i : ArrayUtils.createArrayOne("[8,1,9,7,8,7]")) {
            nums.add(i);
        }
        long res = new 几乎唯一子数组的最大和().maxSum(nums , 4 ,4);
        System.out.println(res);
    }
    public long maxSum(List<Integer> nums, int m, int k) {
        long res  = 0 , t;
        int n = nums.size() , count = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i < k ; i ++){
            int key = nums.get(i);
            map.put(key,map.getOrDefault(key,0) + 1);
            if(map.get(key) == 1) count ++ ;
            res += key;
        }
        t = res;
        if(count < m) res = 0;

        for(int i = k ; i < n ; i ++){
            int key = nums.get(i) , oldKey = nums.get(i - k);
            map.put(oldKey,map.getOrDefault(oldKey,0) - 1);
            t -= oldKey;
            if(map.get(oldKey) == 0) count --;

            map.put(key,map.getOrDefault(key,0) + 1);
            t += key;
            if(map.get(key) == 1) count ++;
            if(count >= m) res = Math.max(res, t);
        }
        return res;
    }
}
