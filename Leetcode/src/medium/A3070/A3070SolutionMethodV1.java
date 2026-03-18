package medium.A3070;

public class A3070SolutionMethodV1 implements A3070Solution{
    @Override
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length , m = grid[0].length;
        int[][] s = new int[n + 1][m + 1];

        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                s[i + 1][j + 1] = grid[i][j] + s[i][j + 1] + s[i + 1][j] - s[i][j];
                if(s[i + 1][j + 1] <= k) {
                    res ++;
                }
            }
        }

        return res;
    }
}
