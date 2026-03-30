package difficulty.A329;

import java.util.LinkedList;
import java.util.Queue;

public class A329SolutionMethodV2 implements A329Solution{


    @Override
    public int longestIncreasingPath(int[][] matrix) {
        int[] dx = {-1, 1, 0, 0} , dy = {0,0,1,-1};
        int m = matrix.length , n =  matrix[0].length;
        int[][] in = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    int x = i + dx[k] , y = j + dy[k];
                    if(x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y]){
                        in[x][y]++;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(in[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        int res = 0;
        while(!q.isEmpty()){
            res ++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int x = cur[0] , y = cur[1];
                for(int k = 0 ; k < 4 ; k ++) {
                    int x1 = x + dx[k];
                    int y1 = y + dy[k];
                    if(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x1][y1] > matrix[x][y]){
                        in[x1][y1] --;
                        if(in[x1][y1] == 0){
                            q.add(new int[]{x1, y1});
                        }
                    }
                }
            }
        }
        return res;
    }

}