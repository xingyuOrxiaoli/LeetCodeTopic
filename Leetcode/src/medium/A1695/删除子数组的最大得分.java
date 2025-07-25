package medium.A1695;

import utils.ArrayUtils;

import java.util.HashMap;

public class 删除子数组的最大得分 {
    public static void main(String[] args) {
        int res = new 删除子数组的最大得分().maximumUniqueSubarray(ArrayUtils.createArrayOne("[5,2,1,2,5,2,1,2,5]"));
        System.out.println(res);
    }
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0 , t_res  = 0 , n = nums.length , left = 0 ;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i <  n ; i ++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num,map.getOrDefault(num , 0 ) + 1);
                t_res += num;
                res = Math.max(res, t_res);
            }else{
                int t = nums[left ++ ];
                while(t != num){
                    if(map.get(t) == 1) map.remove(t);
                    else map.put(t, map.get(t) - 1);
                    t_res -= t;
                    t = nums[left ++ ];
                }
            }
        }
        return res;
    }
}
