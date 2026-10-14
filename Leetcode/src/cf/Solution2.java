package cf;

class Solution2 {
    public int minRotations(int n, String s) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int original = dist(0, a[0]);
        for (int i = 1; i < n; i++) {
            original += dist(a[i - 1], a[i]);
        }
        int ans = original;
        ans = Math.min(ans, original - dist(0, a[0]) + dist(0, a[n - 1]));
        for (int k = 1; k < n; k++) {
            ans = Math.min(ans, original - dist(a[k - 1], a[k]) + dist(a[k - 1], a[n - 1]));
        }
        return ans;
    }

    private int dist(int x, int y) {
        int d = Math.abs(x - y);
        return Math.min(d, 10 - d);
    }
}
