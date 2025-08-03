package medium.A面试题01_07;

public class 旋转矩阵 {
    public void rotate(int[][] matrix) {
        int n = matrix.length , mid  = n >> 1;
        // 先对折
        for(int i = 0 ; i < mid ; i ++){
            for(int j = 0 ; j < n ; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 再主对角线
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < i ; j ++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
