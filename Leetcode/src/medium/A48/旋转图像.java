package medium.A48;

public class 旋转图像 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        new 旋转图像().rotate(matrix);
    }
    // leetcode给了三个方法，其中一个是先 水平翻转 之后再对角线翻转
    // 自己想的方法
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = n >> 1;
        int start , end  = n - 1 ;
        for(int k = 0 ; k < m ; k++) {
            start = k;
            end   = n - 1 - k ;
            for(int j = start ; j < end ; j++) {
                // 替换四轮
                int x = start, y =  j ;
                int pre = matrix[x][y];
                for(int t = 0 ; t < 4 ; t ++){
                    int temp = y;
                    y = n - x - 1;
                    x = temp ;
                    temp = matrix[x][y];
                    matrix[x][y] = pre;
                    pre = temp;
                }
            }
        }
    }
}
