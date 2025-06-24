package simple.A2200;

import java.util.ArrayList;
import java.util.List;

public class 找出数组中的所有K近邻下标 {
    public static void main(String[] args) {

    }
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length , start = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == key) {
                int left = Math.max(0 , i - k);
                left = Math.max(left , start + 1);

                int right = Math.min(i + k , nums.length - 1);

                while(left <= right){
                    res.add(left ++);
                }
                start = right;
            }
        }
        return res;
    }
}
