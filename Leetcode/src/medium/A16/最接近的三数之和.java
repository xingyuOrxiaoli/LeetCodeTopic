package medium.A16;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-84,92,26,19,-7,9,42,-51,8,30,-100,-13,-38};
        int i = new 最接近的三数之和().threeSumClosest1(nums, 78);
        System.out.println(i);
    }
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE ;
        for(int i = 0  ; i < n - 2; i++){
            int j = i + 1 , k = n - 1;
            int pre = Math.abs(res - target) ;
            int cur = Math.abs(target - nums[i] - nums[j] - nums[k]);
            while(j < k){
                if(cur <= pre) {
                    res = nums[i] + nums[j] + nums[k];
                }

                pre = Math.min(pre, cur);
                int temp = nums[i] + nums[j] + nums[k] - target ;
                if(temp == 0) return target;
                if(temp < 0) {
                    j ++;
                }else{
                    k --;
                }
                cur = Math.abs(target - nums[i] - nums[j] - nums[k]);
            }
        }
        return res;
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = 10000000;
        for(int i = 0 ; i < length - 2; i++){
            if(i > 0 && nums[i] == nums[i -1]) continue;

            int left = i + 1 ,right = length - 1;
            while(right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return target;
                if(Math.abs(sum - target) < Math.abs(res - target)) res = sum;
                int temp = 0;
                if(sum > target){
                    temp = right - 1;
                    while(left < temp && nums[temp] == nums[right]) temp --;
                    right = temp;
                }else{
                    temp = left + 1;
                    while(temp < right && nums[temp] == nums[left]) temp ++;
                    left = temp;
                }
            }
        }
        return res;
    }
}
