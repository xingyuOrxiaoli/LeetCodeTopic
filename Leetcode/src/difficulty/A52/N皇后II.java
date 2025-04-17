package difficulty.A52;

import difficulty.A51.N皇后;

import java.util.ArrayList;
import java.util.List;

public class N皇后II {
    public static void main(String[] args) {
        for(int i = 1 ; i < 10 ; i++){
            if( new N皇后II().totalNQueens_2(i) == new N皇后II().totalNQueens(i)){
                System.out.println("[INFO]通过测试案例 n = " + i);
            }else{
                System.out.println("[WARN]未通过测试案例 n = " + i  + "\t我的答案为:"+  new N皇后II().totalNQueens_2(i) +"\t标准答案:" +  new N皇后II().totalNQueens(i));
            }
        }
    }

    // 方法1
    public int totalNQueens(int n) {
        return new N皇后().solveNQueens(n).size();
    }

    // 第二次写
    public int totalNQueens_2(int n) {
       boolean[] col = new boolean[n] , row = new boolean[n] , dg = new boolean[2 * n] , udg = new boolean[2 * n];
       int res = dfs(0 , n ,row, dg, udg);
       return res;
    }

    private int dfs(int i, int n, boolean[] row, boolean[] dg, boolean[] udg) {
        if(i == n) return 1;
        int res = 0;
        for(int j = 0; j < n; j++) {
            if(!row[j] && !dg[j - i + n - 1] && !udg[i + j]){
                row[j] = true;
                dg[j - i + n - 1] = true;
                udg[i + j] = true;
                res += dfs(i + 1 , n , row, dg, udg);
                row[j] = false;
                dg[j - i + n - 1] = false;
                udg[i + j] = false;
            }
        }
        return res;
    }

}
