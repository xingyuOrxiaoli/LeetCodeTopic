package medium.A15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new 三数之和().threeSum(nums);
        System.out.println(lists);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0 ; i  < length ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int k = length - 1 ;
            for(int j = i + 1 ; j < length ; j++){

                if(j > i + 1 && nums[j] == nums[j -1]) continue;

                while(j < k && nums[i] + nums[j] + nums[k] > 0) k --;

                if( j == k ) break;
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
