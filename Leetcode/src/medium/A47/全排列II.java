package medium.A47;

import java.util.ArrayList;
import java.util.List;

public class 全排列II {

    public static void main(String[] args) {
        List<List<Integer>> lists = new 全排列II().permuteUnique(new int[]{1, 2, 3});
        System.out.println(lists);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(0,nums.length,nums,used,new ArrayList<Integer>(),res);

        return res;
    }

    private void dfs(int i, int length,int[] nums ,boolean[] used, ArrayList<Integer> temp, List<List<Integer>> res) {
        if(i == length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j = 0; j < length; j++){
            if(used[j] || (i > 0 && nums[j] == nums[j - 1] && !used[j - 1])) continue;
            temp.add(nums[j]);
            used[j] = true;
            dfs(i+1,length,nums,used,temp,res);
            used[j] = false;
            temp.remove(temp.size()-1);
        }
    }
}
