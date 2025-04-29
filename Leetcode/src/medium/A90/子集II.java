package medium.A90;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class 子集II {

    public static void main(String[] args) {
        long res = 22;
        for (int i = 0 ; i < 10 ; i ++) {
            res *= 22;
            System.out.println(res);
        }
        System.out.println(res * 22);
        int[] nums = {10,10,10,10,10,10,10,10,10,10};
        nums = new int[]{4,4,4,1,4};
        List<List<Integer>> listList = new 子集II().subsetsWithDup(nums);
        for (List<Integer> list : listList) {
            System.out.println(list);
        }
    }

    Map<Long,Boolean> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited ;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums,0,0,new ArrayList<Integer>());
        return res;
    }
    private void dfs(int[] nums,int n,long value,List<Integer> list) {
        if(n > nums.length)  return;
        if(map.getOrDefault(value,true)) {
            map.put(value,false);
            res.add(new ArrayList<>(list));
        }
        for(int i = n ; i < nums.length ; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums,i + 1, (long) (value + Math.pow(11,nums[i] + 10)),list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}