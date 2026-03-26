package difficulty.A3548;


import java.util.HashSet;
import java.util.Set;


public class A3548SolutionMethodV1  implements A3548Solution{

    @Override
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        long total = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                total += grid[i][j];
            }
        }

        return check(grid,total) || check(rotate(grid),total);
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int[][] newGrid = new int[n][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                newGrid[j][m - 1 - i] = grid[i][j];
            }
        }
        return newGrid;
    }

    private boolean check(int[][] grid, long total) {
        int m = grid.length , n = grid[0].length;
        if(isPartitionGrid(grid,total)) {
            return true;
        }
        reverse(grid);
        return isPartitionGrid(grid,total);
    }

    private boolean isPartitionGrid(int[][] grid, long total) {
        int m = grid.length , n = grid[0].length;
        long s = 0;
        Set<Long> dict = new HashSet<>();
        dict.add(0l);

        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n; j++) {
                int x = grid[i][j];
                s += x;
                if(i > 0 || j == 0 || j == n - 1) {
                    dict.add((long) x);
                }
            }

            long t = s << 1;
            if(n == 1) {
                if(t == total || t - grid[0][0] == total || t - grid[i][0] == total) {
                    return true;
                }
                continue;
            }

            if(dict.contains(t- total )) {
                return true;
            }

            if(i == 0) {
                for(int j = 0; j < n; j++) {
                    dict.add((long) grid[i][j]);
                }
            }
        }
        return false;
    }

    private void reverse(int[][] grid) {
        int m = grid.length;
        for(int i = 0 , j = m - 1; i < j; i++ , j--) {
            int[] t = grid[i];
            grid[i] = grid[j];
            grid[j] = t;
        }
    }
}