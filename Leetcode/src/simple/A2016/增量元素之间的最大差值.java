package simple.A2016;

public class 增量元素之间的最大差值 {
    public static void main(String[] args) {

    }
    public int maximumDifference(int[] nums) {
        int n = nums.length , res = -1 ;
        if(n == 0) return res;
        int min = nums[0];
        for(int i = 1 ;i < n ;i++){
            if(nums[i] <= min){
                min = nums[i];
                continue;
            }
            res = Math.max(res,nums[i]-min);
        }
        return res;
    }
}
