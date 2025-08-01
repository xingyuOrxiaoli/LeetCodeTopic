package difficulty.A329;

public class 矩阵中的最长递增路径 {
    int res = 0;
    boolean[][] visited = new boolean[200][200];
    int[][] dp = new int[200][200];
    int[] dx = {1 , -1 , 0 ,0} ,dy = {0 , 0, 1 ,-1};

    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length , m = matrix[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dfs(i , j , 1 ,matrix);

        return res;
    }

    private void dfs(int x, int y ,int u, int[][] matrix) {
        res = Math.max(res, u);
        if(dp[x][y] != 0) res = Math.max(res , u + dp[x][y]);
        else {
            int n = matrix.length, m = matrix[0].length;
            for (int k = 0; k < 4; k++) {
                int new_x = x + dx[k], new_y = y + dy[k];
                if (new_x > -1 && new_y > -1 && new_x < n && new_y < m && !visited[new_x][new_y] && matrix[new_x][new_y] < matrix[x][y]) {
                    visited[new_x][new_y] = true;
                    dfs(new_x, new_y, u + 1, matrix);
                    dp[x][y] = Math.max(dp[new_x][new_y] + 1, dp[x][y]);
                    visited[new_x][new_y] = false;
                }
            }
        }
    }
}
