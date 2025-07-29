package simple.A2210;

public class 统计数组中峰和谷的数量 {
    public int countHillValley(int[] nums) {
        int n = nums.length , res = 0 , left = 0 , right = 1;
        for(int i  = 1; i < n - 1;){
            while(left >= 0 && nums[left] == nums[i]){
                left --;
            }
            right = i + 1;
            while(right < n && nums[right] == nums[i]){
                right ++;
            }
            if(left >= 0 && right < n ){
                if(nums[left] > nums[i] && nums[right] > nums[i]) res ++;
                else if(nums[left] < nums[i] && nums[right] < nums[i]) res ++;
            }
            left = i ;
            i = right;
        }

        return res;
    }
}
