package medium.A2616;

import java.util.Arrays;

public class 最小化数对的最大差值 {
    public static void main(String[] args) {

    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0 ,right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2 ,count = 0;
            for(int i = 0 ; i < nums.length - 1; i++){
                if(nums[i + 1] - nums[i] <= mid){
                    count ++;
                    i++;
                }
            }
            if(count >= p){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }
}
