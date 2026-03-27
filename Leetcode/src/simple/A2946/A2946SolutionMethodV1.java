package simple.A2946;

public class A2946SolutionMethodV1  implements A2946Solution{

    @Override
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length , m = mat[0].length;

        for(int j =0 ; j < m ; j ++) {
            int y = (50 * m + j + k) % m;
            for(int i = 0 ; i < n ; i ++) {
                if(mat[i][j] != mat[i][y]) {
                    return false;
                }
            }
            k = -k;
        }
        return true;
    }
}