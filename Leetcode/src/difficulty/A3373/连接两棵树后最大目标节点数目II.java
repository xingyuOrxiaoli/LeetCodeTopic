package difficulty.A3373;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 连接两棵树后最大目标节点数目II {
    public static void main(String[] args) {

        int[][] edges1 = ArrayUtils.createArrayTwo("[[0,1],[0,2],[2,3],[2,4]]");
        int[][] edges2 = ArrayUtils.createArrayTwo("[[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]");

        int[] res = new Method1().maxTargetNodes(edges1, edges2);
        System.out.println(Arrays.toString(res));
    }


}

// 超时
class Method1{
    // 方法1  超时   816 / 825 个通过的测试用例
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length , m = edges2.length;
        int[] count1 = build(edges1 , 0 );
        int[] count2 = build(edges2 , 1);
        int[] res = new int[n + 1];
        int max = Arrays.stream(count2).max().getAsInt();
        for(int i = 0 ; i <= n ; i ++) res[i] = count1[i] + max;
        return res;
    }

    private int[] build(int[][] edges, int u) {
        int n = edges.length;
        int[] res = new int[n + 1];

        List<List<Integer>> dg = new ArrayList<>();
        for(int i = 0 ; i <= n ; i ++) dg.add(new ArrayList<>());
        for(int[] edge : edges) {
            dg.get(edge[0]).add(edge[1]);
            dg.get(edge[1]).add(edge[0]);
        }

        for(int i = 0 ; i <= n ; i ++) res[i] = dfs(i,-1,dg, u);

        return res;
    }

    private int dfs(int node, int parent, List<List<Integer>> dg , int u) {
        int res = (u + 1) % 2 ;
        for (Integer next : dg.get(node)) {
            if(next == parent) continue;
            res += dfs(next,node,dg , u + 1);
        }
        return res;
    }
}


// 优化 染色法

class Method2{
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] color1 = new int[n] ,color2 = new int[m] ,count1 = new int[n] ,count2 = new int[m] ,res = new int[n];
        count1 = build(edges1,color1 , n);
        count2 = build(edges2,color2 , m);

        for(int i = 0 ; i < n ; i ++) res[i] = count1[color1[i]] + Math.max(count2[0],count2[1]);

        return res ;
    }

    private int[] build(int[][] edges, int[] color,int n) {
        int[] res = new int[n];
        List<List<Integer>> dg = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++) dg.add(new ArrayList<>());
        for(int[] edge : edges) {
            dg.get(edge[0]).add(edge[1]);
            dg.get(edge[1]).add(edge[0]);
        }
        res[0] = dfs(0,-1,dg,0,color);
        res[1] = n - res[0];
        return res;
    }

    private int dfs(int node, int parent, List<List<Integer>> dg, int floor, int[] color) {
        int res = (floor + 1) % 2 ;
        color[node] = floor % 2;
        for (Integer next : dg.get(node)) {
            if(next == parent) continue;
            res += dfs(next,node,dg , floor + 1, color);
        }
        return res;
    }
}

