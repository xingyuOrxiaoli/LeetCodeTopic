package cf;

class Solution3 {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] nolvaretis = nums;
        int ans = 1;
        int i = 0;
        while (i < n) {
            int a = nolvaretis[i] % k;
            int j = i + 1;
            while (j < n && nolvaretis[j] % k == a) {
                j++;
            }
            int L = j - i;
            int m = k / gcd(a, k);
            ans = Math.max(ans, 1 + (L - 1) / m * m);
            i = j;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
