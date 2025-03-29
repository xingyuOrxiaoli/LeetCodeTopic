package medium.A2680;

public class 最大或值 {
    public static void main(String[] args) {
        int[] nums = new int[]{12,9};
        long l = new 最大或值().maximumOr(nums, 1);
        System.out.println(l);
    }
    public long maximumOr(int[] nums, int k) {
        // 参考题解
        int length = nums.length;
        long res = 0;
        long[] s = new long[length + 10];
        // s[i] 表示 从0到i的元素进行 | 操作的结果
        for(int i = length - 1 ; i >= 0 ; i--){
            s[i] = s[i + 1] | nums[i];
        }

        // pre表示 从 0到i-1 的元素 | 操作的结果
        long pre = 0;
        for(int i = 0 ; i < length ; i++){
            res = Math.max(res,pre | ((long)nums[i] << k) | s[i+1]);
            pre |= nums[i];
        }

        return res;
    }
}