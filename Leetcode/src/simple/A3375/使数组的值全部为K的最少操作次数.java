package simple.A3375;

public class 使数组的值全部为K的最少操作次数 {
    public static void main(String[] args) {
     int[] nums = new int[]{};
        int i = new 使数组的值全部为K的最少操作次数().minOperations(nums, 2);
        System.out.println(i);
    }

    public int minOperations(int[] nums, int k) {
        int[] sum = new int[101];
        int n = nums.length , kind = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < k ) return -1;
            if(sum[nums[i]] == 0 && nums[i] > k ) kind ++;
            sum[nums[i]] ++;
        }
        return kind;
    }
}
