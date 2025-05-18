package medium.A120;

import utils.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class 三角形最小路径和 {

    public static void main(String[] args) {
        int[][] arrayTwo = ArrayUtils.createArrayTwo("[[2],[3,4],[6,5,7],[4,1,8,3]]");
        ArrayList<List<Integer>> triangle = new ArrayList<>();
        for (int[] ints : arrayTwo) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int anInt : ints) {
                temp.add(anInt);
            }
            triangle.add(temp);
        }
        triangle.forEach(System.out::println);

        int i = new 三角形最小路径和().minimumTotal(triangle);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 0 ; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j] , dp[i][j] + triangle.get(i + 1).get(j));
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1] , dp[i][j] + triangle.get(i + 1).get(j + 1));
            }
        }
        int res  = dp[n - 1][0];
        for(int i = 1 ; i < n ; i ++) res = Math.min(res, dp[n - 1][i]);
        return res;
    }
}
