package simple.A3487;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 删除后的最大子数组元素和 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int i = new 删除后的最大子数组元素和().maxSum(nums);
        System.out.println(i);
    }
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int target = nums[length -1];
        int res = target ;
        for(int i = length -2  ; i > -1 ; i--){
            if(nums[i] != target && nums[i] >= 0 ){
                res += nums[i];
                target = nums[i];
            }
        }
        return res;
    }
    public int maxSum1(int[] nums) {
        int n = nums.length  ,res = 0 , max = Integer.MIN_VALUE , count = 0;
        HashSet<Integer> map = new HashSet<>();
        for(int i  = 0 ; i <  n ; i++){
            max = Math.max(max , nums[i]);
            if(map.contains(nums[i]) || nums[i] <= 0) continue;
            map.add(nums[i]);
            res += nums[i];
            count = 1;
        }
        if(count == 0) res = max;
        return res;
    }
}
