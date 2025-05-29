package simple.A1550;

import utils.ArrayUtils;

import java.lang.ref.Reference;

public class 存在连续三个奇数的数组 {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.createArrayOne("[1,2,34,3,4,5,7,23,12]");
        boolean b = new 存在连续三个奇数的数组().threeConsecutiveOdds(arr);
        System.out.println(b);
    }
    public boolean threeConsecutiveOdds(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            if((value & 1) == 1) {
                sum++;
                if(sum == 3) return true;
            }else sum = 0 ;
        }
        return false;
    }
}
