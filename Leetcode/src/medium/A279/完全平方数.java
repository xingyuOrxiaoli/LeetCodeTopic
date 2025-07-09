package medium.A279;

public class 完全平方数 {
    public static void main(String[] args) {
        int i = new 完全平方数().numSquares(12);
        System.out.println(i);
    }
    public int numSquares(int n) {
        int res = 0 ;
        int[] dp = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j <= Math.sqrt(i) ; j++){
                min = Math.min(min, dp[i - j * j]) ;
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
