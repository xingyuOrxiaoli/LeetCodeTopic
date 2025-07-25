package simple.A643;

public class 子数组最大平均数I {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0;
        int sum = 0 , n = nums.length;
        for(int i = 0  ; i < k ; i++) sum += nums[i];
        res = (double)sum / k;
        for(int i = k ; i <  n ; i ++){
            sum += nums[i];
            sum -= nums[i - k];
            res  = Math.max(res, (double) sum / k);
        }
        return res;
    }
}
