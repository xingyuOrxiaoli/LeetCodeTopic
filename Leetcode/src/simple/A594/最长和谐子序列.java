package simple.A594;

import utils.ArrayUtils;

import java.util.Arrays;

public class 最长和谐子序列 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[1,3,2,2,5,2,3,7]");
        int lhs = new 最长和谐子序列().findLHS(nums);
        System.out.println(lhs);
    }
    public int findLHS(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int left = 0  ,right = left , n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != nums[left] && left == right){
                right = i; // 第二个元素
            }
            if(nums[i] - nums[left] > 1){
                if(nums[left] + 1 == nums[right]) res = Math.max(res , i - left);
                left = right;
                i --;
//                if(nums[right] != nums[i]) right = i;
            }
        }
        if(nums[right] - nums[left] == 1) {
            res = Math.max(res, n - left);
        }
        return res;
    }
}
