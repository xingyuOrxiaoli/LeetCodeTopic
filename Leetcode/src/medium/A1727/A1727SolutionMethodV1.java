package medium.A1727;

import java.util.Arrays;

public class A1727SolutionMethodV1 implements A1727Solution{
    @Override
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int res = 0 ;
        int[] height = new int[m];

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 1){
                    height[j] ++;
                } else {
                    height[j] = 0;
                }
            }
            int[] t = height.clone();
            Arrays.sort(t);
            for(int j = 0 ; j < m ; j++){
                res = Math.max(res , t[j] * (m - j));
            }
        }
        return res;
    }
}
