package medium.A310;

import java.util.*;

public class 最小高度树 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        List<Integer>[] graph = new ArrayList[n];
        List<Integer> path = new ArrayList<>();
        int[] parent = new int[n];
        Arrays.fill(parent , -1);
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int x = bfs(0 , parent , graph) , y = bfs(x , parent , graph);
        parent[x] = -1;
        while(y != -1){
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if((m & 1) == 0) res.add(path.get((m >> 1) - 1));
        res.add(path.get(m >> 1));
        return res;
    }

    private int bfs(int node, int[] parent, List<Integer>[] graph) {
        int n = graph.length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visit = new boolean[n];
        queue.offer(node);
        visit[node] = true;
        int pre = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            pre = cur;
            for (int v : graph[cur]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = cur;
                    queue.offer(v);
                }
            }
        }
        return pre;
    }
}
