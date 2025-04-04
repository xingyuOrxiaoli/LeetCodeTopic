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
        List<List<Integer>> lists = new 组合总和II().combinationSum2(candidates, 8);
        System.out.println(lists);
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
