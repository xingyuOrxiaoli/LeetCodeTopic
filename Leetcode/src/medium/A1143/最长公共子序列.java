package medium.A1143;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length() , m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i  = 0 ; i < n ; i ++){
            char ch1 = text1.charAt(i);
            for(int j = 0 ; j < m ; j ++){
                char ch2 = text2.charAt(j);
                if(ch1 == ch2) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1] , dp[i + 1][j]);
            }
        }
        return dp[n][m];
    }
}
