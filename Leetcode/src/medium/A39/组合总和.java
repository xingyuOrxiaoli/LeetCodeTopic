package medium.A39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        List<List<Integer>> lists = new 组合总和().combinationSum(candidates, 8);
        System.out.println(lists);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++){
            dfs(res,new ArrayList<>(),candidates,target,i);
        }

        return res;
    }

    private void dfs(List<List<Integer>> res,List<Integer> temp, int[] candidates, int target,int index) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(index < 0){
            return;
        }
        if (target >= candidates[index]) {
            temp.add(candidates[index]);
            dfs(res, temp, candidates, target - candidates[index], index);
            temp.remove(temp.size() - 1);
        }
        if(temp.size() > 0) {
            dfs(res, temp, candidates, target, index - 1);
        }
    }
}
