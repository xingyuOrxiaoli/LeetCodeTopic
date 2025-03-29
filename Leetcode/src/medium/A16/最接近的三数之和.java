package medium.A16;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int i = new 最接近的三数之和().threeSumClosest(nums, 1);
        System.out.println(i);
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
