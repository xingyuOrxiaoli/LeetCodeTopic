package medium.A994;

import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        int n = grid.length , m = grid[0].length , res = 0;
        int[] dx = {1, -1, 0, 0 }, dy = {0, 0, -1, 1 };
        Queue<Integer> queueX = new LinkedList<>() , queueY = new LinkedList<>() , levels = new LinkedList<>() ;
        for(int i  = 0 ; i < n ; i ++)
            for(int j = 0 ; j < m ; j ++)
                if(grid[i][j] == 2){
                    queueX.add(i);
                    queueY.add(j);
                    levels.add(0);
                }

        while(!queueX.isEmpty() && !queueY.isEmpty()){
            int x = queueX.poll() , y = queueY.poll() , level = levels.poll() ;
            res = level;
            for(int i = 0 ; i < 4 ; i ++){
                int newX = x + dx[i] , newY = y + dy[i] ;
                if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1){
                    queueX.add(newX);
                    queueY.add(newY);
                    levels.add(level + 1);
                    grid[newX][newY] = 2;
                }
            }
        }

        for(int i  = 0 ; i < n ; i ++)
            for(int j = 0 ; j < m ; j ++)
                if(grid[i][j] == 1) return  -1;
        return res;
    }
}
