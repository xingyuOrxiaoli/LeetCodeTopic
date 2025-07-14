package medium.A304;

public class 二维区域和检索_矩阵不可变 {
}
class NumMatrix {
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        this.sum = new int[matrix.length + 1][matrix[0].length + 1];
        int n = matrix.length , m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i + 1][j + 1] = matrix[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}