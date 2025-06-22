package medium.A216;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {
    public static void main(String[] args) {
        List<List<Integer>> lists = new 组合总和III().combinationSum3(3, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited = new boolean[10];
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k , n , new ArrayList<Integer>() , 0 ,0);
        return res;
    }

    private void dfs(int k, int n, ArrayList<Integer> path, int start ,int sum) {
        if(k == 0){
            if(sum == n) res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start + 1 ; i <= 9 ; i++){
            path.add(i);
            dfs(k - 1 , n , path , i , sum + i);
            path.remove(path.size()-1);
        }
    }
}
