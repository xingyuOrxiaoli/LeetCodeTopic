package medium.A54;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1}
        };
//        matrix = new int[][]{
//                {1},
//        };
        List<Integer> integers = new 螺旋矩阵().spiralOrder_2(matrix);
        System.out.println(integers);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length , m = matrix[0].length;
        int i = 0 , j = 0 , k = 0;

        while ( i >= 0 && j >=0 && i < n  && j < m && matrix[i][j] != -101){
            res.add(matrix[i][j]);
            matrix[i][j] = -101;
            if(i == k && j != m - 1) j ++;
            else if(i != n - 1 && j == m - 1) i ++;
            else if(i == n -1 && j > k)  j -- ;
            else if(j == k) {
                i -- ;
                if( i == k + 1) {
                    k ++;
                    n -- ;
                    m -- ;
                }
            }
        }
        return res;
    }


    // 练习二
    public List<Integer> spiralOrder_2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length , n =  matrix[0].length;
        int i = 0 , j = 0 , k = 0;
        while(i > -1 &&  i < m && j > -1 && j < n && matrix[i][j] != 101){
            res.add(matrix[i][j]);
            matrix[i][j] = 101;
            if(i == k && j != n - 1 - k) j ++;
            else if(j == n - k - 1 && i != m - 1 - k)  i++;
            else if(i == m - k - 1 && j > k) j --;
            else if(j == k){
                i -- ;
                if(i == k + 1 ) k ++;
            }
        }
        return res;
    }
}
