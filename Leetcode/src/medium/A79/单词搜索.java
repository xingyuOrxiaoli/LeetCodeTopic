package medium.A79;

public class 单词搜索 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
//        board = new char[][]{
//                {'a','a'}
//        };
        boolean abcced = new 单词搜索().exist(board, "ABCCED");
        System.out.println(abcced);
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length , n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(dfs(i,j,board,visited,word,0)) return true;
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board,boolean[][] visited, String word, int index) {
        if (index == word.length() - 1)  return true;
        int[] dx = {-1, 1, 0, 0} , dy = {0 , 0 , -1 , 1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k] , y = j + dy[k];
            if(x > -1 && y > -1 && x < visited.length && y < visited[0].length && !visited[x][y] && word.charAt(index + 1) == board[x][y]) {
                visited[x][y] = true;
                if(dfs(x,y,board,visited,word,index+1)) return true;
                visited[x][y] = false;
            }
        }
        return false;
    }
}
