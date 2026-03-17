package medium.A1727;

import java.util.Arrays;

public class A1727SolutionMethodV2 implements A1727Solution{
    @Override
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int res = 0 ;
        int[] height = new int[m];
        int[] index = new int[m];
        for(int i = 0 ; i < m ; i++){
            index[i] = i;
        }
        int[] noZero = new int[m];

        for(int i = 0 ; i < n ; i++){
            int noZeroIndex = 0 , zeroIndex = 0 ;
            for(int j : index){
                if(matrix[i][j] == 1){
                    height[j] ++;
                    noZero[noZeroIndex ++] = j;
                } else {
                    height[j] = 0;
                    index[zeroIndex ++] = j;
                }
            }
            for(int j = zeroIndex ; j < m ; j++){
                index[j] = noZero[j - zeroIndex];
                res = Math.max(res , (m - j) * height[index[j]]);
            }
        }
        return res;
    }
}
