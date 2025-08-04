package medium.A面试题01_08;

import utils.ArrayUtils;

public class 零矩阵 {
    public static void main(String[] args) {
        new 零矩阵().setZeroes(ArrayUtils.createArrayTwo("[[1,1,1],[1,0,1],[1,1,1]]"));
    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int[] row = new int[n] , col = new int[m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if(row[i] == 1 || col[j] == 1) matrix[i][j] = 0;



    }
}
