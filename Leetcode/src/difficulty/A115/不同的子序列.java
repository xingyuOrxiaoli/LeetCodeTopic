package difficulty.A115;

public class 不同的子序列 {
    public static void main(String[] args) {
        int i = new 不同的子序列().numDistinct("rabbbit", "rabbit");
        System.out.println(i);
    }

    public int numDistinct(String s, String t) {
        int n = s.length() , m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = n ; i > -1 ; i --) dp[i][m] = 1;

        for(int i = n - 1 ; i > -1 ; i --){
            for(int j = m - 1 ; j > -1 ; j --){
                if(s.charAt(i) == t.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                else dp[i][j] = dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}
// 优化成一维数组  TODO 以后仔细回顾
class Solution {
    public int numDistinct(String s, String t) {
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        if (cs.length < ct.length) {
            return 0;
        }

        int[] dp = new int[ct.length + 1];
        dp[0] = 1;
        for (int i = 0, l; i < cs.length - 1; i++) {
            // sLen = [0, i) + [i, sLen)
            // tLen = [0, j) + [j, tLen)
            // [i, sLen) >= [j, tLen) --> sLen-i >= tLen-j --> j >= tLen-sLen+i
            l = Math.max(ct.length - cs.length + i, 0);
            for (int j = Math.min(i, ct.length - 1); j >= l; j--) {
                dp[j + 1] += cs[i] == ct[j] ? dp[j] : 0;
            }
        }

        return dp[ct.length] + (cs[cs.length - 1] == ct[ct.length - 1] ? dp[ct.length - 1] : 0);
    }
}