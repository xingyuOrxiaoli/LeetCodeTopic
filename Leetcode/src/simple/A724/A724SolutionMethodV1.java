package simple.A724;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A724SolutionMethodV1  implements A724Solution{

    @Override
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i < n; i++) {
            if(sum - nums[i] == (left << 1)) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}