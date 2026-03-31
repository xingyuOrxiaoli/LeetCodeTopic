package simple.A674;

public class A674SolutionMethodV1  implements A674Solution{

    @Override
    public int findLengthOfLCIS(int[] nums) {
        int res = 1 , cur = 1;
        int n = nums.length , pre = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] > pre) {
                cur ++;
                res = Math.max(res, cur);
            } else {
                cur = 1;
            }
            pre = nums[i];
        }
        return res;
    }
}