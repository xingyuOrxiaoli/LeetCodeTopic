package difficulty.A85;

public class 最大矩形 {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int i = new 最大矩形().maximalRectangle(matrix);
        System.out.println(i);
    }

    // 暴力解法  过了
    public int maximalRectangle(char[][] matrix) {
        int res = 0 , rows =  matrix.length , cols = matrix[0].length;
        int[][] left = new int[rows][cols];
        for(int i = 0 ; i < rows ; i ++){
            for(int j = 0 ; j < cols ; j ++){
                if(matrix[i][j] == '1'){
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        for(int i = 0 ; i < rows ; i ++){
            for(int j = 0 ; j < cols ; j ++){
                if(matrix[i][j] == '0') continue;
                int min = left[i][j];
                res = Math.max(res,min);
                for(int  k = i - 1; k >= 0 ; k-- ){
                    min = Math.min(min, left[k][j]);
                    if(min == 0) break;
                    res = Math.max(res, (i - k + 1) * min);
                }
            }
        }

        return res;
    }
}
// 参考LeetCode给的单调队列进行优化的代码
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}
