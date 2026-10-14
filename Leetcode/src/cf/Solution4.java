package cf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution4 {
    private static final int SIG = 10;

    private int[] pos;

    private static class Node {
        Node[] ch = new Node[SIG];
        int id = -1;
    }

    private static class Res {
        int[] vals;
        long inv;

        Res(int[] vals, long inv) {
            this.vals = vals;
            this.inv = inv;
        }
    }

    public int minInversions(String[] words, int[] target) {
        int n = words.length;
        pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[target[i]] = i;
        }
        Node root = new Node();
        for (int i = 0; i < n; i++) {
            Node cur = root;
            for (char c : words[i].toCharArray()) {
                int x = c - 'a';
                if (cur.ch[x] == null) {
                    cur.ch[x] = new Node();
                }
                cur = cur.ch[x];
            }
            cur.id = i;
        }
        return (int) dfs(root).inv;
    }

    private Res dfs(Node u) {
        List<Res> kids = new ArrayList<>();
        for (int i = 0; i < SIG; i++) {
            if (u.ch[i] != null) {
                kids.add(dfs(u.ch[i]));
            }
        }
        long inv = 0;
        int total = u.id >= 0 ? 1 : 0;
        for (Res k : kids) {
            inv += k.inv;
            total += k.vals.length;
        }
        if (u.id >= 0) {
            int p = pos[u.id];
            for (Res k : kids) {
                inv += lowerCount(k.vals, p);
            }
        }
        if (kids.size() >= 2) {
            inv += minCross(kids);
        }
        int[] vals = new int[total];
        int t = 0;
        if (u.id >= 0) {
            vals[t++] = pos[u.id];
        }
        for (Res k : kids) {
            System.arraycopy(k.vals, 0, vals, t, k.vals.length);
            t += k.vals.length;
        }
        Arrays.sort(vals);
        return new Res(vals, inv);
    }

    private long minCross(List<Res> kids) {
        int n = kids.size();
        long[][] cross = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    cross[i][j] = countInv(kids.get(i).vals, kids.get(j).vals);
                }
            }
        }
        int m = 1 << n;
        long[][] cost = new long[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int b = Integer.numberOfTrailingZeros(j);
                cost[j][i] = cost[j ^ (1 << b)][i] + cross[b][i];
            }
        }
        long[] dp = new long[m];
        Arrays.fill(dp, Long.MAX_VALUE / 4);
        dp[0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    int prev = i ^ (1 << j);
                    dp[i] = Math.min(dp[i], dp[prev] + cost[prev][j]);
                }
            }
        }
        return dp[m - 1];
    }


    private long countInv(int[] a, int[] b) {
        long res = 0;
        int j = 0;
        for (int x : a) {
            while (j < b.length && b[j] < x) {
                j++;
            }
            res += j;
        }
        return res;
    }
    private int lowerCount(int[] a, int x) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}
