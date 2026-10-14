package cf;

class Solution1 {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
        int best = Integer.MIN_VALUE;
        int[] ans = {-1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target && nums[i] > nums[j]) {
                    int prod = nums[i] * nums[j];
                    if (prod > best) {
                        best = prod;
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
        }
        return ans;
    }
}
