package difficulty.ALCR004;

public class 只出现一次的数字II {
    public int singleNumber(int[] nums) {
        int res = 0  ;
        for(int i = 0 ; i < 32 ; i ++){
            int count =  0;
            for (int num : nums) count += (num >> i) & 1;
            res += ((count % 3) << i);
        }

        return res;
    }
}
