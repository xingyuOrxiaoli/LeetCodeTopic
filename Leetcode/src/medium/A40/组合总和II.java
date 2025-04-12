package medium.A40;

import java.util.ArrayList;
import java.util.List;

public class 组合总和II {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for(int i = 1 ; i <= 50 ; i++){
            list.add(i);
            list.add(i);
        }
        System.out.println(list);
        int[] candidates = new int[]{
                10,1,2,7,6,1,5
        };
        List<List<Integer>> lists = new 组合总和II().combinationSum2_2(candidates, 8);
        System.out.println(lists);
    }
    // 第二次写  TODO 没有处理到 重复的问题
    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        for(int i = 0 ; i < candidates.length ; i++){
            if(!used[i]) dfs(res, used, new ArrayList<Integer>(), candidates, target, i);
        }
        return res;
    }

    private void dfs(ArrayList<List<Integer>> res, boolean[] used, List<Integer> temp, int[] candidates,int target, int i) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        while(i >=0 && used[i]) {
            i -- ;
        }

        if(i <0) return;
        if(target >= candidates[i]){
            used[i] = true;
            temp.add(candidates[i]);
            dfs(res,used,temp,candidates,target - candidates[i],i - 1);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
        // 保证第一个值是确定的  以最初的i开头定下来的组合数
        if(temp.size() > 0 ) {
            dfs(res,used,temp,candidates,target,i - 1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        int[] nums = new int[51];
        int max = 0 ;
        for(int i=0; i<  n; i++) {
            nums[candidates[i]]++;
            max = Math.max(max,candidates[i]);
        }
        for (int i=1; i<= max; i++) {
            if(nums[i] != 0) {
                dfs(res, new ArrayList<Integer>(), nums, target, i);
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums, int target, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        while(index >= 0  && nums[index] == 0) {
            index --;
        }
        if(index < 1 ) return;

        if(target >= index) {
            temp.add(index);
            nums[index] -- ;
            dfs(res, temp, nums, target - index, index);
            temp.remove(temp.size()-1);
            nums[index] ++ ;
        }
        if(temp.size() > 0) {
            dfs(res, temp, nums, target, index - 1);
        }
    }
}
