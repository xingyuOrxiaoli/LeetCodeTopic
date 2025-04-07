package difficulty.A44;

public class 通配符匹配 {
    public static void main(String[] args) {
        boolean match = new 通配符匹配().isMatch("aa","*");
        System.out.println(match);
    }

    // 方法一  动态规划
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for(int j = 1 ; j <= pLen ; j++) {
            if(p.charAt(j - 1) == '*') dp[0][j] = true;
            else break;
        }
        for(int i = 1 ; i <= sLen ; i++) {
            for(int j = 1 ; j <= pLen ; j++) {
                if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; //  为空 || 不为空
                }
                if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1] [ j -1];
                }
            }
        }
        return dp[sLen][pLen];
    }

    // 贪心
//    public boolean isMatch2(int[] nums) {
//    }
}
