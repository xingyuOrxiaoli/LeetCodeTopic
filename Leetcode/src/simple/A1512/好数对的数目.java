package simple.A1512;

public class 好数对的数目 {
    public int numIdenticalPairs(int[] nums) {
        int res = 0 , n = nums.length;
        for(int i = 0 ; i < n ; i ++){
            for(int j = i + 1 ; j < n ; j ++){
                if(nums[i] == nums[j]) res ++;
            }
        }
        return res;
    }
}
