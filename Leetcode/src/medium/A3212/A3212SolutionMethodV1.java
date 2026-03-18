package medium.A3212;

public class A3212SolutionMethodV1 implements A3212Solution{


    @Override
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length , m = grid[0].length;
        int[][] sx = new int[n + 1][m + 1] , sy = new int[n + 1][m + 1];

        int res = 0 ;
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j++) {
                int x = 0 , y = 0 ;
                char cur = grid[i][j];
                if(cur == 'X') {
                    x = 1;
                } else if(cur == 'Y') {
                    y = 1;
                }
                sx[i + 1][j + 1] = sx[i + 1][j] + sx[i][j + 1] - sx[i][j] + x;
                sy[i + 1][j + 1] = sy[i + 1][j] + sy[i][j + 1] - sy[i][j] + y;
                if(sx[i + 1][j + 1] == sy[i + 1][j + 1] && sx[i + 1][j + 1] != 0 ) {
                    res ++;
                }

            }
        }
        return res;
    }
}
