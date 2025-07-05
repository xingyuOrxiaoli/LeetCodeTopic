package medium.A238;

public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int zero = 0 , n = nums.length;
        long s = 1 ;
        for(int i = 0 ; i < n ; i ++){
            if(nums[i] == 0) zero ++;
            else s *= nums[i];
            if(zero == 2) break;
        }
        int[] res =  new int[n];
        if(zero != 2){
            if(zero == 1){
                for(int i = 0 ; i < n ; i ++)
                    if(nums[i] == 0) {
                        res[i] = (int) s;
                        continue;
                    }
            }else{
                for (int i = 0 ; i < n ; i ++)
                    res[i] = (int) (s / nums[i]);
            }
        }

        return res;
    }
}
