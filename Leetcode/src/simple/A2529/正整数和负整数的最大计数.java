package simple.A2529;

public class 正整数和负整数的最大计数 {
    public int maximumCount(int[] nums) {
        int n = nums.length , left = 0 , right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) left = mid + 1;
            else right = mid - 1;
        }
        int neg = left;
        left = 0 ;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) right = mid - 1;
            else left = mid + 1;
        }
        int pos = n - left;
        return Math.max(pos, neg);
    }
}
