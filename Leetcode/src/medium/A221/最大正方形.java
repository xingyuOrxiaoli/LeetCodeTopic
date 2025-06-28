package medium.A221;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

public class 最大正方形 {
    public static void main(String[] args) {

    }

    // 暴力解
    public int maximalSquare(char[][] matrix) {
        int res  =  0 ;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int n = matrix.length , m = matrix[0].length;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if('1' == matrix[i][j]){
                    res = Math.max(res, 1);
                    int temp = Math.min(n - i , m - j);
                    if(temp <= res) break;
                    for(int k = 1 ; k < temp ; k ++){
                        boolean flag = true;
                        if(matrix[i + k][j + k] == '0') break;
                        for(int z = 0 ; z < k ;  z ++){
                            if(matrix[i + k][j + z] == '0' || matrix[i + z ][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) res = Math.max(res, k + 1);
                        else break;
                    }
                }
            }
        }
        return res * res;
    }

    //    使用动态规划实现
    public int maximalSquare_dp(char[][] matrix) {
        int n = matrix.length , m = matrix[0].length ,res = 0;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if('1' == matrix[i][j]){
                    if(i == 0 ||  j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i - 1][j - 1] , Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }

}
