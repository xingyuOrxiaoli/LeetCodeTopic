package medium.A334;

public class 递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length , first = nums[0], second = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > second) return true;
            else if(nums[i] > first) second = nums[i];
            else first = nums[i];
        }
        return false;
    }
}
