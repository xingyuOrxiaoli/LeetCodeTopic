package simple.A2176;

public class 统计数组中相等且可以被整除的数对 {

    public static void main(String[] args) {
        int[] nums = {3,1,2,2,2,1,3};
        int i = new 统计数组中相等且可以被整除的数对().countPairs(nums, 2);
        System.out.println(i);
    }
    public int countPairs(int[] nums, int k) {
        int n = nums.length , res = 0;
        for(int i = 0 ; i < n ; i++)
            for(int j = i + 1 ; j < n ; j++)
                if(nums[i] == nums[j] && (i * j) % k == 0) res++;
        return res;
    }
}
