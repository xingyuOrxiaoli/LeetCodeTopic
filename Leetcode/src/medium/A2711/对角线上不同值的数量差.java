package medium.A2711;

import java.util.HashSet;
import java.util.Set;

public class 对角线上不同值的数量差 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,3},
                {3,1,5},
                {3,2,1}
        };
        int[][] ints = new 对角线上不同值的数量差().differenceOfDistinctValues(grid);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        Set<Integer> set = new HashSet<>();
        // 下三角
        for(int i = 0 ; i < m ; i++) {
            int x = i;
            int y = 0;
            while (x < m && y < n) {
                res[x][y] += set.size();
                set.add(grid[x][y]);
                x += 1;
                y += 1;
            }
            set.clear();
        }
        for(int i  = 1 ; i < n ; i++){
            int x = 0;
            int y = i;
            while(x < m && y < n){
                res[x][y] += set.size();
                set.add(grid[x][y]);
                x += 1;
                y += 1;
            }
            set.clear();
        }
        for(int i = 0 ; i < m -1; i ++){
            int y = n -1;
            int x = i ;
            while(x>= 0 &&  y >= 0 ){
                res[x][y] -= set.size();
                res[x][y] = Math.abs(res[x][y]);
                set.add(grid[x][y]);
                x -= 1;
                y -= 1;
            }
            set.clear();
        }
        for (int i = 0 ; i < n; i ++) {
            int x = m - 1, y = i;
            while (x >= 0 && y >= 0) {
                res[x][y] -= set.size();
                res[x][y] = Math.abs(res[x][y]);
                set.add(grid[x][y]);
                x -= 1;
                y -= 1;
            }
            set.clear();
        }
        return res;
    }
}
