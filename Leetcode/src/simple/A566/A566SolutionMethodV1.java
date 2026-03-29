package simple.A566;

public class A566SolutionMethodV1  implements A566Solution{

    @Override
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length , n = mat[0].length;
        if(m * n != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        int x = 0 , y  = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[x][y] = mat[i][j];
                y ++ ;
                if(y == c) {
                    x ++;
                    y = 0;
                }
            }
        }


        return res;
    }
}