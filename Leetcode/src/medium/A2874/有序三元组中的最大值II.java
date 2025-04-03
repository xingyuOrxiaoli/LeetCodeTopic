package medium.A2874;

public class 有序三元组中的最大值II {
    public static void main(String[] args) {
        int[] nums = new int[]{12,6,1,2,7};
        long l = new 有序三元组中的最大值II().maximumTripletValue(nums);
        System.out.println(l);
    }

    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int n = nums.length;
        int i = 0 , max = 0 ;
        for(int  k = 0 ; k < n; k++) {
            res = Math.max(res, (long)max * nums[k]);
            max = Math.max(max , i - nums[k]);
            i   = Math.max(i , nums[k]);
        }
        return res;
    }
}
