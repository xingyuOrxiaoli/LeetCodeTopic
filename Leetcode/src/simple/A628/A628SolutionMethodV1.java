package simple.A628;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A628SolutionMethodV1  implements A628Solution{

    @Override
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[n - 1] , nums[n - 2] * nums[n - 3] * nums[n - 1]);
    }
}