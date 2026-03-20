package medium.A3567;

import java.util.*;

public class A3567SolutionMethodV1 implements A3567Solution{


    @Override
    public int[][] minAbsDiff(int[][] grid, int k) {
       int n = grid.length , m = grid[0].length;
        int[][] res = new int[n - k + 1][m - k + 1];

        for (int[] re : res) {
            Arrays.fill(re, Integer.MAX_VALUE);
        }

       for(int i = k - 1 ; i < n ; i ++) {
           Map<Integer,Integer> map = new TreeMap<>();
           int t = k;
           while(t > 0) {
               int x = i - t + 1;
               for(int y = 0 ; y < k - 1 ; y ++) {
                   map.put(grid[x][y], map.getOrDefault(grid[x][y], 0) + 1);
               }
               t --;
           }
           for(int j = k - 1 ; j < m ; j ++) {
               for(int x = i - k + 1 ; x <= i ; x ++) {
                   map.put(grid[x][j], map.getOrDefault(grid[x][j], 0) + 1);
               }
               int preKey = Integer.MIN_VALUE;
               for (Integer key : map.keySet()) {
                   if(preKey != Integer.MIN_VALUE) {
                       res[i - k + 1][j - k + 1] = Math.min(res[i - k + 1][j - k + 1], key - preKey);
                   }
                   preKey = key;
               }
               if(res[i - k + 1][j - k + 1] == Integer.MAX_VALUE) {
                   res[i - k + 1][j - k + 1] = 0;
               }
               for(int x = i - k + 1 ; x <= i ; x ++) {
                   map.put(grid[x][j - k + 1], map.getOrDefault(grid[x][j - k + 1], 0) - 1);
                   if(map.getOrDefault(grid[x][j - k + 1], 0) == 0) {
                       map.remove(grid[x][j - k + 1]);
                   }
               }
           }
       }
        return res;
    }
}
