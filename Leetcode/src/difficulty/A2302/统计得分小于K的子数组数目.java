package difficulty.A2302;

public class 统计得分小于K的子数组数目 {

    public static void main(String[] args) {
        int[] nums = {2,1,4,3,5};
        long l = new 统计得分小于K的子数组数目().countSubarrays(nums, 10);
        System.out.println(l);
    }

    // 暴力解法
    public long countSubarrays(int[] nums, long k) {
        long res = 0 , sum = 0 ;
        for(int i = 0 , j = 0 ; i < nums.length ; i++){
            sum += nums[i];
            while(j <= i && sum * (i - j + 1) >= k) sum -= nums[j++];
            res += i - j + 1;
        }
        return res;
    }
}
