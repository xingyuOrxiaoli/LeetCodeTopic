package difficulty.A329;

public class A329SolutionMethodV1  implements A329Solution{

    private Integer res = 0;
    private final boolean[][] visited = new boolean[200][200];
    private final int[][] dp = new int[200][200];
    private final int[] dx = {1 , -1 , 0 ,0};
    private final int[] dy = {0 , 0, 1 ,-1};

    @Override
    public int longestIncreasingPath(int[][] matrix) {
        int m =  matrix.length , n =  matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i , j , 1 ,matrix);
            }
        }
        return res;
    }

    private void dfs(int x, int y, int u, int[][] matrix) {
        res = Math.max(u , res);
        if(dp[x][y] != 0) {
            res = Math.max(res, dp[x][y] + u);
            return;
        }
        int m =  matrix.length , n =  matrix[0].length;
        for (int k = 0; k < 4; k++) {
            int i = x + dx[k], j = y + dy[k];
            if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] <= matrix[x][y]) {
                continue;
            }
            visited[i][j] = true;
            dfs(i,j,u + 1 , matrix);
            dp[x][y] = Math.max(dp[i][j]  + 1, dp[x][y]);
            visited[i][j] = false;
        }
    }
}