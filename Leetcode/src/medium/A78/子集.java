package medium.A78;

import java.util.ArrayList;
import java.util.List;

public class 子集 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = new 子集().subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>());
        boolean[] visited = new boolean[nums.length];
        for(int i = 0 ; i < nums.length ; i++) dfs(i , nums, visited,new ArrayList<>() , true);
        return res;
    }

    private void dfs(int u, int[] nums, boolean[] visited,List<Integer> temp,boolean flag) {
        if(u > nums.length)  return;
        if(temp.size() != 0 && flag) res.add(new ArrayList<>(temp));
        while(u < visited.length && visited[u]) u ++;
        if(u == visited.length) return;
        // 选
        visited[u] = true;
        temp.add(nums[u]);
        dfs(u + 1, nums, visited, temp,true);
        temp.remove(temp.size()-1);
        visited[u] = false;
        // 不选
        if(temp.size() != 0) dfs(u + 1, nums, visited, temp,false);
    }
}
