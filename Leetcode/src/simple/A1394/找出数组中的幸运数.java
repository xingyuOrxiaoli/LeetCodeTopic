package simple.A1394;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.TreeSet;

public class 找出数组中的幸运数 {
    public static void main(String[] args) {
        int[] arrayOne = ArrayUtils.createArrayOne("[2,2,2,3,3]");
        int lucky = new 找出数组中的幸运数().findLucky(arrayOne);
        System.out.println(lucky);
    }
    public int findLucky(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<> ();
        TreeSet<Integer> set = new TreeSet<> ();
        for(int i = 0 ;i < n ; i ++){
            int cur = arr[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if(set.contains(cur))set.remove(cur);
            if(map.get(cur) ==  arr[i])set.add(cur);
        }

        return set.size() == 0 ? -1 :set.last();
    }

    public int findLucky2(int[] arr) {
        int n = arr.length;
        int[] nums = new int[501];
        for(int i = 0 ;i < n ; i ++)
            nums[arr[i]]++;
        for(int i = 500 ; i > 0; i --)
            if(nums[i] == i) return i;
        return -1;
    }
}
