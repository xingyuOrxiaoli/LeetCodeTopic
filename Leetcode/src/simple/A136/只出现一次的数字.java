package simple.A136;

public class 只出现一次的数字 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
