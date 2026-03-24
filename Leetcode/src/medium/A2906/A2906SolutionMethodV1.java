package medium.A2906;

public class A2906SolutionMethodV1  implements A2906Solution{

    @Override
     public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int[][] res =  new int[n][m];
        int mod = 12345;

        long prefix = 1;
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                res[i][j] = (int) prefix;
                prefix = (prefix * grid[i][j]) % mod;
            }
        }
        prefix = 1;
        for(int i = n - 1 ; i > -1 ; i --) {
            for(int j = m - 1 ; j > -1 ; j --) {
                res[i][j] = (int) ((res[i][j] * prefix) % mod);
                prefix = (prefix * grid[i][j]) % mod;
            }
        }
        return res;
    }
}