package medium.A2610;

import java.util.ArrayList;
import java.util.List;

public class 转换二维数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,1,2,3,1};
        List<List<Integer>> matrix = new 转换二维数组().findMatrix(nums);
        System.out.println(matrix);
    }
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        // 考虑到条件： 1 <= nums[i] <= nums.length
        // 并且 1 <= nums.length <= 200
        // 因此可以使用一个short类型做一个哈希表
        short[] map = new short[length + 1];
        for(int num : nums){
            int temp = map[num];
            if(temp == res.size()){
                res.add(new ArrayList<Integer>());
            }
            res.get(temp).add(num);
            map[num] ++;
        }

        return res;
    }
}
