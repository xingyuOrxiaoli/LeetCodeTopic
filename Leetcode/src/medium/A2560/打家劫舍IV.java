package medium.A2560;

import java.util.Arrays;

public class 打家劫舍IV {
    public static void main(String[] args) {

    }
    public int minCapability(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        while(min <= max){
            int mid = min + (max - min)/2 , count = 0;
            boolean visited = false;
            for (int num : nums) {
                if(num <= mid && !visited){
                    visited = true;
                    count ++;
                }else visited = false;
            }
            if(count >= k){
                max = mid - 1 ;
            }else {
                min = mid + 1 ;
            }
        }
        return min;
    }
}
