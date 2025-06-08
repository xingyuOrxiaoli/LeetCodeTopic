package simple.A268;

public class 丢失的数字 {
    public static void main(String[] args) {

    }
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] dict = new int[n];
        for (int i = 0; i < n; i++) {
            if(nums[i] >= n) continue;
            dict[nums[i]]++;
        }
        for (int i = 0; i <= n; i++) {
            if(dict[i] == 0) return i;
        }
        return n;
    }
}
