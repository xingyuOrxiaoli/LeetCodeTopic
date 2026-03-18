package simple.A448;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A448SolutionMethodV1 implements A448Solution{
    @Override
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if(count[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
