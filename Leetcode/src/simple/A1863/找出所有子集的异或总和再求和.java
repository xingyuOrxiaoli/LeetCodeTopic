package simple.A1863;

public class 找出所有子集的异或总和再求和 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,6,7,8};
        int i = new 找出所有子集的异或总和再求和().subsetXORSum(nums);
        System.out.println(i);
    }

    public int subsetXORSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += dfs(nums, i,0,0);
        }
        return res;
    }

    private int dfs(int[] nums, int index, int sum,int value) {
        if(index < 0) return value;
        int temp = value;
        // 选当前值
        value = dfs(nums, index - 1, sum  + 1, value ^ nums[index]);

        if(sum  >= 1){
            // 不选当前值
            value += dfs(nums, index - 1, sum, temp);
        }
        return value;
    }
}
