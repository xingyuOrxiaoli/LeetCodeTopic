package difficulty.A1900;

import java.util.*;

public class 最佳运动员的比拼回合 {
}
class Solution {
    private int[][][] F = new int[30][30][30];
    private int[][][] G = new int[30][30][30];

    private int[] dp(int n, int f, int s) {
        if (F[n][f][s] != 0) {
            return new int[]{F[n][f][s], G[n][f][s]};
        }
        // f 与 s进行比拼
        if (f + s == n + 1) {
            return new int[]{1, 1};
        }
        // F(n,f,s) = F(n, n + 1 - s, n + 1 - f)
        if (f + s > n + 1) {
            int[] res = dp(n, n + 1 - s, n + 1 - f);
            F[n][f][s] = res[0];
            G[n][f][s] = res[1];
            return new int[]{F[n][f][s], G[n][f][s]};
        }

        int earlist = Integer.MAX_VALUE, latest = Integer.MIN_VALUE;
        int n_half = (n + 1) / 2;
        if (s <= n_half) {
            // 在左侧或者中间
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < s - f; ++j) {
                    int[] res = dp(n_half, i + 1, i + j + 2);
                    earlist = Math.min(earlist, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        } else {
            // s 在右侧
            int s_prime = n + 1 - s;
            int mid = (n - 2 * s_prime + 1) / 2;
            for (int i = 0; i < f; ++i) {
                for (int j = 0; j < s_prime - f; ++j) {
                    int[] res = dp(n_half, i + 1, i + j + mid + 2);
                    earlist = Math.min(earlist, res[0]);
                    latest = Math.max(latest, res[1]);
                }
            }
        }

        F[n][f][s] = earlist + 1;
        G[n][f][s] = latest + 1;
        return new int[]{F[n][f][s], G[n][f][s]};
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        // F(n,f,s) = F(n,s,f)
        if (firstPlayer > secondPlayer) return earliestAndLatest(n , secondPlayer, firstPlayer);

        int[] res = dp(n, firstPlayer, secondPlayer);
        return new int[]{res[0], res[1]};
    }
}

class Solution2 {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int mn = (int)1e9;
        int mx = 1;
        Random rand = new Random();

        for (int t = 0; t < 800; t++) {
            List<Integer> players = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                players.add(i);
            }

            int rnd = 0;
            boolean ok = false;

            while (!ok) {
                List<Integer> temp = new ArrayList<>();
                int l = 0, r = players.size() - 1;

                while (l < r) {
                    int left = players.get(l);
                    int right = players.get(r);

                    if ((left == firstPlayer || left == secondPlayer) &&
                            (right == firstPlayer || right == secondPlayer)) {
                        ok = true;
                        break;
                    } else {
                        if (left == firstPlayer || left == secondPlayer) {
                            temp.add(left);
                        } else if (right == firstPlayer || right == secondPlayer) {
                            temp.add(right);
                        } else {
                            if (rand.nextDouble() < 0.5) {
                                temp.add(left);
                            } else {
                                temp.add(right);
                            }
                        }
                    }
                    l++;
                    r--;
                }

                if (l == r) {
                    temp.add(players.get(l));
                }

                rnd++;
                Collections.sort(temp);
                players = temp;
            }

            mn = Math.min(mn, rnd);
            mx = Math.max(mx, rnd);
        }

        return new int[]{mn, mx};
    }
}
class Solution3 {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int m = 1, N = n;
        while (n > 2) {
            n -= n/2;
            m++;
        }
        int[][][][] dp = new int[firstPlayer+1][secondPlayer+1][m+1][];
        return dfs(1, firstPlayer, secondPlayer, dp, N, m);
    }

    /**
     *
     * @param p    第几回合
     * @param f    优秀选手
     * @param s    优秀选手
     * @param dp   存储状态
     * @param n   当前回合剩余选手数量
     * @param m   最多比较次数
     * @return
     */
    private int[] dfs(int p, int f, int s, int[][][][] dp, int n, int m) {
//        if (p == m) return new int[]{p, p};
        // s与 f遇见的时候 返回结果
        if (s == (n + 1 - f)) dp[f][s][p] = new int[]{p, p};
        if (dp[f][s][p] != null) return dp[f][s][p];
        // 初始化结果值
        int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        // 分类讨论  mid 中间的位置 奇数偏向左侧  t表示是否为奇数
        int mid = n/2, t = n&1;
        // 第二名优秀选手在中间的左侧 并且第一名优秀选手序号不必第第二名选手大
        if (s <= mid + t) {
            for (int i = 1; i <= f; i++) {
                int d = s - f;
                for (int j = 1; j <= d; j++) {
                    int[] dfs = dfs(p + 1, i, i + j, dp, n - n / 2, m);
                    res[0] = Math.min(res[0], dfs[0]);
                    res[1] = Math.max(res[1], dfs[1]);
                }
            }
        }
        // 第一名优秀选手在右侧 并且第二名优秀选手序号大于第一名优秀选手
        if (f > mid) {
            int s_ = n + 1 - s, f_ = n + 1 - f;
            for (int i = 0; i < s_; i++) {
                int d = f_ - s_ - 1, s1 = i + (s - s_ + 2)/2;
                for (int j = 0; j <= d; j++) {
                    int f1 = i + j + (f - f_ + 2)/2;
                    int[] dfs = dfs(p + 1, f1, s1, dp, n - n / 2, m);
                    res[0] = Math.min(res[0], dfs[0]);
                    res[1] = Math.max(res[1], dfs[1]);
                }
            }
        }
        // 第一名优秀选手在左侧 第二名优秀选手在右侧
        if (f <= mid && s > mid + t) {
            int s_ = n + 1 - s;
            if (s_ < f) {
                for (int i = 0; i < s_; i++) {
                    int d = f - s_;
                    for (int j = 1; j <= d; j++) {
                        int[] dfs = dfs(p + 1, i + j, i + (s - s_ + 2)/2, dp, n - n / 2, m);
                        res[0] = Math.min(res[0], dfs[0]);
                        res[1] = Math.max(res[1], dfs[1]);
                    }
                }
            }
            if (s_ > f) {
                for (int i = 1; i <= f; i++) {
                    int d = s_ - f - 1;
                    for (int j = 0; j <= d; j++) {
                        int[] dfs = dfs(p + 1, i, i + j + (s - s_ + 2)/2, dp, n - n / 2, m);
                        res[0] = Math.min(res[0], dfs[0]);
                        res[1] = Math.max(res[1], dfs[1]);
                    }
                }
            }
        }
        return dp[f][s][p] = res;
    }
}