package simple.A2873;

public class 有序三元组中的最大值I {
    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
        long l = new 有序三元组中的最大值I().maximumTripletValue(nums);
        System.out.println(l);
    }
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;

        // 暴力解法 可以过
//        for(int i = 0 ; i < n ; i++){
//            for(int j = i + 1 ; j < n ; j++){
//                for(int k = j + 1 ; k < n ; k++){
//                    res = Math.max(res,(long)(nums[i] - nums[j]) * nums[k]);
//                }
//            }
//        }
        // 优化
        int inums = 0 , ijnums = 0 ;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (long)ijnums * nums[i]);
            ijnums = Math.max(ijnums, inums - nums[i]);
            inums = Math.max(inums, nums[i]);
        }
        return res;
    }
}
