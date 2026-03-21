package simple.A485;

public class A485SolutionMethodV1  implements A485Solution{

    @Override
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0 , temp = 0 , n = nums.length ;

        for(int i = 0 ; i < n ; i++) {
            if(nums[i] == 1) {
                temp ++;
            } else {
                res = Math.max(res,temp);
                temp = 0;
            }
        }

        res = Math.max(res,temp);
        return res;
    }
}