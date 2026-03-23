package medium.A1594;

import java.util.Arrays;

public class A1594SolutionMethodV1  implements A1594Solution{

    @Override
    public int maxProductPath(int[][] grid) {
        int mod = 1000000007;

        int n = grid.length, m = grid[0].length;
        long[][] maximize = new long[n][m];
        long[][] minimum  = new long[n][m];

        maximize[0][0] = grid[0][0];
        minimum[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            maximize[i][0] = maximize[i - 1][0] * grid[i][0];
            minimum[i][0] = maximize[i][0];
        }
        for (int j = 1; j < m; j++) {
            maximize[0][j] = maximize[0][j - 1] * grid[0][j];
            minimum[0][j] =  maximize[0][j];
        }

        for (int i = 1 ; i < n ; i ++) {
            for(int j =1 ; j < m ;j ++) {
                if(grid[i][j] >= 0) {
                    maximize[i][j] = Math.max(maximize[i - 1][j] , maximize[i][j - 1]) * grid[i][j];
                    minimum[i][j] = Math.min(minimum[i - 1][j] , minimum[i][j - 1]) * grid[i][j];
                } else {
                    maximize[i][j] = Math.min(minimum[i - 1][j] , minimum[i][j - 1]) * grid[i][j];
                    minimum[i][j] = Math.max(maximize[i - 1][j] , maximize[i][j - 1]) * grid[i][j];
                }
            }
        }

        return maximize[n - 1][m - 1] >= 0 ? (int) (maximize[n - 1][m - 1] % mod) : -1;
    }

}