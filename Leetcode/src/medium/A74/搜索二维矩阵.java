package medium.A74;

public class 搜索二维矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int a = (int) 1e5;
        System.out.println(a);
        boolean b = new 搜索二维矩阵().searchMatrix2(matrix, 3);
        System.out.println(b);
    }
    // 方法1 矩阵二分
    public boolean searchMatrix1(int[][] matrix, int target) {

        return false;
    }

    // 方法2 拆分为一维度
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length , m = matrix[0].length ,  x , y , left = 0 , right = n * m - 1 , mid = (left + right)  >> 1;
        while (left <= right) {
            x = mid / m ;
            y = mid % m ;
            if(matrix[x][y] == target) return true;
            if(matrix[x][y] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            mid = (left + right) >> 1;
        }
        return false;
    }


}
