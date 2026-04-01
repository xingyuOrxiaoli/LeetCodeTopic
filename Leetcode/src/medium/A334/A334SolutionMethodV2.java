package medium.A334;

import java.util.ArrayList;
import java.util.List;

public class A334SolutionMethodV2 implements A334Solution{


    List<Integer> list = new ArrayList<>();

    @Override
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int k = 2;
        for(int i = 0; i < n; i++){
            int j = getIndex(nums[i]);
            if(j == k) {
                return true;
            }
            if(j == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(j, nums[i]);
            }
        }

        return false;
    }

    private int getIndex(int num) {
        int left = -1 , right = list.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if(list.get(mid) < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}