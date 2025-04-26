package difficulty.A2444;

public class 统计定界子数组的数目 {

    public static void main(String[] args) {

        int[] nums = {1,1,1,1};
        long l = new 统计定界子数组的数目().countSubarrays(nums, 1, 1);
        System.out.println(l);

    }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0 ;
        int max = -1 , min = -1 , left =  0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > maxK || nums[i] < minK){
                max = -1;
                min = -1;
                left = i + 1;
            }
            if(nums[i] == maxK) max = i;
            if(nums[i] == minK) min = i;
            if(max != -1 && min != -1) res += Math.min(max,min) - left + 1;
        }
        return res;
    }

}
