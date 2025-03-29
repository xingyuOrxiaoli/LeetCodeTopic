package medium.A18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        new 四数之和().fourSum(nums,0);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0 ; i < length ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1 ; j < length ; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int z = length -1 ;
                for(int k = j + 1 ; k < length ; k++){
                    if(k > j + 1 && nums[k] == nums[k -1]) continue;

                    while(z > k && (long)nums[i] + nums[j] + nums[k] + nums[z] > target) z --;

                    if(z == k) break;
                    if((long)nums[i] + nums[j] + nums[k] + nums[z] == target){
                        List<Integer> list =  new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[z]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
}
