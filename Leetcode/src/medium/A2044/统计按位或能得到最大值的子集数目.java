package medium.A2044;

public class 统计按位或能得到最大值的子集数目 {
    int res ;
    boolean[] visited;
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length , target = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) target |= nums[i];

        dfs(0 ,0, target , nums);

        return res;
    }

    private void dfs(int index, int value, int target, int[] nums) {
        if(value == target) res ++;
        if(index == nums.length) return;
        for(int i = index ; i < nums.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i , value | nums[i] , target , nums);
                visited[i] = false;
            }
        }
    }
}
