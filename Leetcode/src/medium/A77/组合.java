package medium.A77;

import java.util.*;

public class 组合 {

    public static void main(String[] args) {
        List<List<Integer>> combine = new 组合().combine(4, 2);
        System.out.println(combine);

    }
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        boolean[] st = new boolean[n];
        dfs(st ,n, k,new ArrayList<Integer>());
        return result;
    }

    private void dfs(boolean[] st,int max,  int k, ArrayList<Integer> temp) {
        if(temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = max - 1; i > -1 ; i--){
            if(!st[i]){
                temp.add(i + 1);
                st[i] = true;
                dfs(st ,i, k , temp);
                st[i] = false;
                temp.remove(temp.size()- 1);
            }
        }
    }
}
