package medium.A2090;

import utils.ArrayUtils;

import java.util.Arrays;

public class 半径为k的子数组平均值 {
    public static void main(String[] args) {
        int[] res = new 半径为k的子数组平均值().getAverages(ArrayUtils.createArrayOne("[7,4,3,9,1,8,5,2,6]") , 3);
        System.out.println(Arrays.toString(res));
    }
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length , down = k * 2 + 1;
        long sum = 0 ;
        int[] res = new int[n] ;
        Arrays.fill(res,-1);
        if(n < down) return res;
        for(int  i  = 0 ; i <  down - 1; i ++) sum += nums[i];
        for(int i = k ; i < n - k  ; i ++){
            sum += nums[i + k];
            res[i] = (int)(sum / down);
            sum -= nums[i - k];
        }
        return res;
    }
}
