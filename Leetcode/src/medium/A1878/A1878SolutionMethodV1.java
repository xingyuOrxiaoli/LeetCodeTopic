package medium.A1878;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class A1878SolutionMethodV1 implements A1878Solution{

    @Override
    public int[] getBiggestThree(int[][] grid) {


        int n = grid.length , m = grid[0].length;
        int[][] dg = new int[n][m] , udg = new int[n][m];

        // 初始化对角线前缀和数组
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                dg[i][j] = grid[i][j];
                udg[i][j] = grid[i][j];

                int x = i - 1 , y = j - 1 ;
                int ux = i - 1 , uy = j + 1 ;
                if(x >= 0 && y >= 0) {
                    dg[i][j] += dg[x][y];
                }
                if(ux >= 0 && uy < m) {
                    udg[i][j] += udg[ux][uy];
                }
            }
        }

        // 计算答案
        Set<Integer> res = new TreeSet<>();
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                res.add(grid[i][j]);
                int k = 1;

                while (k != -1) {
                    int x1 = i - k, y1 = j;
                    int x2 = i , y2 = j - k;
                    int x3 = i + k , y3 = j;
                    int x4 = i , y4 = j + k;
                    if(x1 < 0 || y2 < 0 || x3 >=n || y4 >= m) {
                        k = -1;
                        continue;
                    }
                    k++;
                    int a = udg[x2][y2] - udg[x1][y1];
                    int b = dg[x3][y3] - dg[x2][y2];
                    int c = udg[x3][y3] - udg[x4][y4] - grid[x3][y3];
                    int d = dg[x4][y4] - dg[x1][y1] + grid[x1][y1];
                    res.add(a + b + c + d);
                }
            }
        }

        System.out.println(Arrays.toString(res.toArray()));
        return res.stream().sorted((a, b) -> b.compareTo(a)).limit(3).mapToInt(i -> i).toArray();
    }
}
