package difficulty.A52;

import difficulty.A51.N皇后;

import java.util.ArrayList;
import java.util.List;

public class N皇后II {
    public static void main(String[] args) {
        int i = new N皇后II().totalNQueens(8);
        System.out.println(i);
    }

    // 方法1
    public int totalNQueens(int n) {
        return new N皇后().solveNQueens(n).size();
    }

}
