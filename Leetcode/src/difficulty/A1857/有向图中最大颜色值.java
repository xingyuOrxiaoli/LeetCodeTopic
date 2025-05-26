package difficulty.A1857;

import utils.ArrayUtils;

import java.util.*;

public class 有向图中最大颜色值 {
    public static void main(String[] args) {
        int[][] edges = ArrayUtils.createArrayTwo("[[0,1],[0,2],[2,3],[3,4]]");
        int i = new 有向图中最大颜色值().largestPathValue("abaca", edges);
        System.out.println(i);
    }

    // paths 更新的时候直接遍历
    List<List<Integer>> paths = new ArrayList<>() ;
    public int largestPathValue(String colors, int[][] edges) {
        int node_size = colors.length();
        int[] in = new int[node_size];
        for (int i = 0; i < node_size; i++) {
            paths.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            paths.get(x).add(y);
            in[y]++;
        }
        final int[] res = {0};
        int node_sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 初始化
        for(int i = 0 ; i < node_size ; i++){
            if(in[i] == 0) queue.add(i);
        }
        int[][] dp = new int[node_size][26];
        while (!queue.isEmpty()){
            node_sum ++;
            int index = queue.poll();

            // 添加 [0,index] 区间 颜色为 colors.charAt(index) - 'a' 的值 +1
            dp[index][colors.charAt(index) - 'a'] ++;
            // 添加下一个元素
            paths.get(index).forEach(next->{
                // 更新入度
                in[next] --;
                for(int i = 0 ; i < 26 ; i ++){
                    dp[next][i] = Math.max(dp[next][i] , dp[index][i]);
                }
                if(in[next] == 0) queue.add(next);
            });
        }

        if(node_sum != node_size) return -1;

        Arrays.stream(dp).forEach(array->res[0] = Math.max(res[0],Arrays.stream(array).max().getAsInt()));

        return res[0];
    }


}
