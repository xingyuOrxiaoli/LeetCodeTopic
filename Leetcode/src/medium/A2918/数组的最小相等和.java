package medium.A2918;

import utils.ArrayUtils;

public class 数组的最小相等和 {
    public static void main(String[] args) {
        int[] nums1 = ArrayUtils.createArrayOne("[2,0,2,0]");
        int[] nums2 = ArrayUtils.createArrayOne("[1,4]");
        long l = new 数组的最小相等和().minSum(nums1, nums2);
        System.out.println(l);
    }

    public long minSum(int[] nums1, int[] nums2) {
        long zero1 = 0, zero2 = 0 , max1 = 0 , max2 = 0 ;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) zero1++;
            else max1 += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) zero2++;
            else max2 += nums2[i];
        }

        if((zero1 == 0 && max2 + zero2 > max1 ) || (zero2 ==0 && max1 + zero1 > max2)) return  -1;

        return Math.max(zero1 + max1 , zero2+ max2);
    }
}
