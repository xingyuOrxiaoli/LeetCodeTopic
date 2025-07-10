package medium.A289;

import utils.ArrayUtils;

public class 生命游戏 {
    public static void main(String[] args) {
        new 生命游戏().gameOfLife(ArrayUtils.createArrayTwo("[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]"));
    }
    public void gameOfLife(int[][] board) {
        int n = board.length , m = board[0].length;
        int[] dx = {-1, -1 , -1 , 0 , 0 ,1 , 1, 1} ,dy = {-1 , 0 ,1 , -1 , 1 , -1 ,0 , 1};
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                int liveSum = 0 ;
                for(int k = 0 ; k < 8 ; k ++){
                    int x = i + dx[k] , y = j + dy[k];
                    if(x < 0 || x >= n || y < 0 || y >= m) continue;
                    if(board[x][y] == 1 || board[x][y] == -1) liveSum += 1;
                }
                if(board[i][j] == 1 && (liveSum < 2 || liveSum > 3)) board[i][j] = -1;
                if(board[i][j] == 0 && liveSum == 3) board[i][j] = 2;
            }
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(board[i][j] == -1) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}
