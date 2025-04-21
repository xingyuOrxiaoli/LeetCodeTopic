package medium.A72;

public class 编辑距离 {

    public static void main(String[] args) {
        int i = new 编辑距离().minDistance("horse", "ros");
        System.out.println(i);
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[510][510];
        int n = word1.length() , m = word2.length() ;
        if(n * m == 0) return n + m ;
        for(int i = 1 ; i <= n ; i ++) dp[i][0] = i;
        for(int j = 1 ; j <= m ; j ++) dp[0][j] = j;

        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1 ; j <= m; j ++){
                int min = Math.min(dp[i - 1][j] , dp[i][j - 1]) + 1 , temp = dp[i - 1][j - 1] ;
                if(word1.charAt(i - 1) != word2.charAt(j - 1)) temp ++;
                dp[i][j] = Math.min(temp , min);
            }
        }
        return dp[n][m];
    }
}
