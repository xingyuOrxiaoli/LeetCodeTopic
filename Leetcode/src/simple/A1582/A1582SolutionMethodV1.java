package simple.A1582;

import java.util.ArrayList;
import java.util.List;

public class A1582SolutionMethodV1 implements A1582Solution {
    @Override
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[] rowSum = new int[m], colSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int item = mat[i][j];
                rowSum[i] += item;
                colSum[j] += item;
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }

}
