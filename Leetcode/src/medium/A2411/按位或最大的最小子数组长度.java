package medium.A2411;

import java.util.Arrays;

public class 按位或最大的最小子数组长度 {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n] , count = new int[30];
        Arrays.fill(count , -1);
        for (int i = n - 1; i > -1; i--) {
            int t = i ;
            for(int j = 0; j < 30; j++){
                if((nums[i] & (1 << j)) == 0){
                    if(count[j] != -1) t = Math.max(t , count[j]);
                }else count[j] = i;
            }
            res[i] = t - i + 1;
        }
        return res;
    }
}
