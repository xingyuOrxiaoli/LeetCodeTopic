package medium.A46;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = new 全排列().permute(nums);
        System.out.println(permute);
    }

    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = new boolean[10];
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(0,nums,temp);
        return res;
    }

    private void dfs(int index, int[] nums, List<Integer> temp) {
        if(index == nums.length) res.add(new ArrayList<>(temp));
        else{
            for(int i = 0 ; i < nums.length ; i++) {
                if(used[i]) continue;
                else{
                    used[i] = true;
                    temp.add(nums[i]);
                    dfs(index + 1, nums, temp);
                    temp.remove(temp.size() - 1);
                    used[i] = false;
                }
            }
        }
    }


}
