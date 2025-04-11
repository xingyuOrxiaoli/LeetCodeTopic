package difficulty.A51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后 {
    public static void main(String[] args) {
        List<List<String>> lists = new N皇后().solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
            System.out.println("=====================");
        }
    }

    // 方法1
    boolean[] udx,dx,visits;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        visits = new boolean[n];
        udx = new boolean[2 * n];
        dx  = new boolean[2 * n];
        dfs(0,n,res,new ArrayList<>());
        return res;
    }
    private void dfs(int i, int n, List<List<String>> res,List<String> list) {
        if(i == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        char[] row = new char[n];
        Arrays.fill(row,'.');
        for(int j = 0 ; j < n; j++){
            if(!visits[j] && !dx[j - i + n - 1] && !udx[i + j]){
                visits[j] = true;
                dx[j - i + n - 1] = true;
                udx[i + j] = true;
                row[j] = 'Q';
                list.add(new String(row));
                dfs(i+1,n,res,list);
                list.remove(list.size()-1);
                row[j] = '.';
                visits[j] = false;
                dx[j - i + n - 1] = false;
                udx[i + j] = false;
            }
        }
    }

    // 方法2
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> res = new ArrayList<>();
        visits = new boolean[n];
        udx = new boolean[2 * n];
        dx  = new boolean[2 * n];
        dfs(0,n,res,new ArrayList<>());
        return res;
    }
}
