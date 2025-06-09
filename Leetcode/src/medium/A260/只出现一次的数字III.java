package medium.A260;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 只出现一次的数字III {
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>() , visited =new HashMap<>() ;
        for (int i = 0; i < nums.length; i++) {
            if(visited.containsKey(nums[i])) continue;
            Integer value = map.getOrDefault(nums[i], 0);
            if(value == 1) {
                visited.put(nums[i], 1);
                map.remove(nums[i]);
            }else{
                map.put(nums[i], value + 1);
            }
        }
        int i = 0 ;
        for (Integer num : map.keySet()) {
            res[i ++] = num;
        }
        return res;
    }
}
