package medium.A63;

public class 不同路径II {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]
                {
                        {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                        {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0},
                        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                        {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                        {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
                };
//        obstacleGrid = new int[][]{
//                {1}
//        };
        int i = new 不同路径II().uniquePathsWithObstacles2(obstacleGrid);
        System.out.println(i);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length , n = obstacleGrid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int res = dfs(obstacleGrid , visited , 0 , 0 ,0);
        return res;
    }

    private int dfs(int[][] obstacleGrid, boolean[][] visited, int x, int y, int step) {
        if(step == obstacleGrid.length + obstacleGrid[0].length - 2){
            if(x == obstacleGrid.length-1 && y == obstacleGrid[0].length-1 && obstacleGrid[x][y] != 1) return 1;
            return 0;
        }

        int[] dx = {-1, 1, 0, 0} , dy = {0, 0, -1, 1} ;
        int res = 0 ;
        for(int i = 0 ; i < 4 ; i++){
            if(x + dx[i] >= 0 && x + dx[i] < obstacleGrid.length && y + dy[i] >= 0 && y + dy[i] < obstacleGrid[0].length && obstacleGrid[x + dx[i]][y + dy[i]] != 1 && !visited[x + dx[i]][y + dy[i]]){
                visited[x + dx[i]][y + dy[i]] = true;
                res += dfs(obstacleGrid, visited, x + dx[i], y + dy[i], step + 1) ;
                visited[x + dx[i]][y + dy[i]] = false;
            }
        }
        return res;
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
       if(obstacleGrid[0][0] == 1) return 0;
       int m = obstacleGrid.length , n = obstacleGrid[0].length;
       int[][] dp = new int[m][n];
       dp[0][0] = 1;
       for(int j = 1 ; j < n ; j ++)
           if(obstacleGrid[0][j] == 0)
               dp[0][j] = dp[0][j - 1];
       for(int  i = 1 ; i < m ; i ++)
           if(obstacleGrid[i][0] == 0)
               dp[i][0] = dp[i -1][0];

       for(int i = 1 ; i < m ; i ++)
           for(int j = 1 ; j < n ; j ++)
               if(obstacleGrid[i][j] == 0)
                   dp[i][j] = dp[i-1][j] + dp[i][j-1];
       return dp[m - 1][n - 1];
    }


}
