package medium.A213;

public class 打家劫舍II {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums,0,n - 1) , rob(nums,1 , n));
    }

    private int rob(int[] nums, int start, int end) {
        int first = nums[start] , second = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i < end; i++) {
            int temp = second;
            second = Math.max(first + nums[i] , second);
            first = temp;
        }
        return second;
    }
}
