package difficulty.A174;

import utils.ArrayUtils;

import java.util.Arrays;

public class 地下城游戏 {
    public static void main(String[] args) {
        int[][] dungeon = ArrayUtils.createArrayTwo("[[1,-3,3],[0,-2,0],[-3,-3,-3]]");
        int i = new 地下城游戏().calculateMinimumHP(dungeon);
        System.out.println(i);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];

        dp[n][m - 1] = 1;
        dp[n - 1][m] = 1;
        for(int i = n - 1; i > -1 ; i --){
            for(int j = m - 1; j > -1 ; j --){
                if(i == n - 1 && j == m - 1){
                    dp[i][j] = dungeon[i][j] > 0 ? 1 : 1 - dungeon[i][j];
                }else if(i == n - 1){
                    dp[i][j] = Math.max(1 , dp[i][j + 1] - dungeon[i][j]);
                }else if(j == m - 1){
                    dp[i][j] = Math.max(1 , dp[i + 1][j] - dungeon[i][j]);
                }else {
                    dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
                }
            }
        }


        return dp[0][0];
    }
    public int calculateMinimumHP1(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i] , Integer.MAX_VALUE);

        dp[n][m - 1] = 1;
        dp[n - 1][m] = 1;
        for(int i = n - 1; i > -1 ; i --){
            for(int j = m - 1; j > -1 ; j --){
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }


        return dp[0][0];
    }
}
