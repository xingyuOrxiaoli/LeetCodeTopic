package simple.A3392;

public class 统计符合条件长度为3的子数组数目 {

    public static void main(String[] args) {

        int[] nums = {1,2,1,4,1};
        int i = new 统计符合条件长度为3的子数组数目().countSubarrays(nums);
        System.out.println(i);
    }

    public int countSubarrays(int[] nums) {
        int res = 0 , n = nums.length;
        for(int i = 0 ; i < n - 2 ; i++){
            if((nums[i] + nums[i + 2]) * 2 == nums[ i + 1]) res ++;
        }
        return res;
    }
}
