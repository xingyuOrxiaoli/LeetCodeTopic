package difficulty.A3343;

public class 统计平衡排列的数目 {
    public static void main(String[] args) {
        int i = new 统计平衡排列的数目().countBalancedPermutations("123");
        System.out.println(i);
    }


    //
    public int countBalancedPermutations(String num) {
        int n = num.length() , odd = (n + 1) >> 1 , even = n >> 1;
        int res = 0 ;



        return res;
    }
}

class Solution {
    final long MOD = 1000000007;
    public int countBalancedPermutations(String num) {
        int tot = 0, n = num.length();
        int[] cnt = new int[10];
        for (char ch : num.toCharArray()) {
            int d = ch - '0';
            cnt[d]++;
            tot += d;
        }
        if (tot % 2 != 0) {
            return 0;
        }

        int target = tot / 2;
        int maxOdd = (n + 1) / 2;
        long[][] comb = new long[maxOdd + 1][maxOdd + 1];
        long[][] f = new long[target + 1][maxOdd + 1];

        for (int i = 0; i <= maxOdd; i++) {
            comb[i][i] = comb[i][0] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        f[0][0] = 1;
        int psum = 0, totSum = 0;
        for (int i = 0; i <= 9; i++) {
            /* 前 i 个数字的数目之和 */
            psum += cnt[i];
            /* 前 i 个数字的元素之和 */
            totSum += i * cnt[i];
            for (int oddCnt = Math.min(psum, maxOdd); oddCnt >= Math.max(0, psum - (n - maxOdd)); oddCnt--) {
                /* 偶数位需要填充的位数 */
                int evenCnt = psum - oddCnt;
                for (int curr = Math.min(totSum, target); curr >= Math.max(0, totSum - target); curr--) {
                    long res = 0;
                    for (int j = Math.max(0, cnt[i] - evenCnt); j <= Math.min(cnt[i], oddCnt) && i * j <= curr; j++) {
                        /* 当前数字在奇数位填充 j 位，偶数位填充 cnt[i] - j 位 */
                        long ways = comb[oddCnt][j] * comb[evenCnt][cnt[i] - j] % MOD;
                        res = (res + ways * f[curr - i * j][oddCnt - j] % MOD) % MOD;
                    }
                    f[curr][oddCnt] = res % MOD;
                }
            }
        }

        return (int)f[target][maxOdd];
    }
}

