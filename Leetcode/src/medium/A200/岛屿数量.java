package medium.A200;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        int i = new 岛屿数量().numIslands(grid);
        System.out.println(i);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length , n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0 ;
        int[] dx = {-1, 1, 0, 0} , dy = {0, 0, -1, 1} ;
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(grid[i][j] == '1' && !visited[i][j]){

                    Queue<Integer> queueX = new LinkedList<>() , queueY = new LinkedList<>() ;
                    queueX.add(i);
                    queueY.add(j);
                    visited[i][j] = true;
                    res ++;
                    while(!queueX.isEmpty()){
                        int curX = queueX.poll() , curY = queueY.poll();
                        for(int k = 0; k < 4; k ++){
                            int x = curX + dx[k] , y = curY + dy[k];
                            if (x > -1 && x < m && y > -1 && y < n && grid[x][y] == '1' && !visited[x][y]) {
                                visited[x][y] = true;
                                queueX.add(x);
                                queueY.add(y);
                            }
                        }
                    }

                }
            }
        }
        return res;
    }
}
