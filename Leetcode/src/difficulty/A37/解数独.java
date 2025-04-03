package difficulty.A37;

public class 解数独 {
    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        new 解数独().solveSudoku(board);
    }
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] value = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int temp = board[i][j] - '1';
                    row[i][temp] = true;
                    col[j][temp] = true;
                    value[j / 3 + (i / 3) * 3][temp] = true;
                }
            }
        }
        dfs(row,col,value,0,0,board);
    }
    private boolean dfs(boolean[][] row, boolean[][] col, boolean[][] value, int i, int j,char[][] board) {
        while(i != 9 && board[i][j] != '.') {
            j ++;
            i += j / 9;
            j %= 9;
        }
        if(i == 9) return true;
        for(int k = 0; k < 9; k++) {
            if (!row[i][k] && !col[j][k] && !value[j / 3 + (i / 3) * 3][k]) {
                row[i][k] = true;
                col[j][k] = true;
                value[j / 3 + (i / 3) * 3][k] = true;
                board[i][j] = (char)('1' + k);
                boolean temp = dfs(row, col, value,i, j,board);
                if(temp) {
                    return true;
                }
                board[i][j] = '.';
                row[i][k] = false;
                col[j][k] = false;
                value[j / 3 + (i / 3) * 3][k] = false;
            }
        }
        return false ;
    }
}
