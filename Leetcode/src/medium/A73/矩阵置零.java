package medium.A73;

import java.util.Arrays;

public class 矩阵置零 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        new 矩阵置零().setZeroes(matrix);
        System.out.println(Arrays.toString(matrix));
    }
    // 方法1
    public void setZeroes(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        boolean[] row = new boolean[n] , col = new boolean[m] ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                    int x = i , y = j;
                    do matrix[x --][j] = 0 ; while (x > -1);
                    do matrix[i][y --] = 0 ; while (y > -1);
                }else if(col[j] || row[i]) matrix[i][j] = 0;
            }
        }
    }
}
