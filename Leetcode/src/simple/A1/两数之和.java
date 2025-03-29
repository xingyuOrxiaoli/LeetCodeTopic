package simple.A1;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        int [] nums1 = {2,7,11,15};
        System.out.println(new 两数之和().twoSum(nums1,9));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2] ;
        Map<Integer,Integer> map = new HashMap<>();

        int length = nums.length;
        for(int i = 0 ; i < length ; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
