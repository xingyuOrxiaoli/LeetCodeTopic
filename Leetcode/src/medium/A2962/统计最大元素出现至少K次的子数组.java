package medium.A2962;

public class 统计最大元素出现至少K次的子数组 {

    public static void main(String[] args) {
        int[] nums = {61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82};
        long l = new 统计最大元素出现至少K次的子数组().countSubarrays(nums, 2);
        System.out.println(l);
    }
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length , max = nums[0] , left = 0,right = 0 ;
        int[] index = new int[n];
        for(int i = 1; i < n; i++) max = Math.max(max, nums[i]);
        long res = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == max) index[right++] = i;
            if(right - left == k) res += index[left++] + 1;
            else if(right >= k) res += index[left - 1] + 1;
        }
        return res;
    }

    // 第二次写
    public long countSubarrays_2(int[] nums, int k) {
        int n = nums.length , max = nums[0] , left = 0,right = 0 ;
        int[] index = new int[n];
        for(int i = 1; i < n; i++) max = Math.max(max, nums[i]);
        long res = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == max) index[right++] = i;
            if(right - left == k) res += index[left++] + 1;
            else if(right >= k) res += index[left - 1] + 1;
        }
        return res;
    }
}
