package medium.A面试题04_01;

import java.util.*;

public class 节点间通路 {

    public static void main(String[] args) {
//        new 节点间通路().findWhetherExistsPath()
    }


    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        Map<Integer  ,List<Integer>> map = new HashMap<>();
        for (int[] c : graph) {
            List<Integer> list = map.computeIfAbsent(c[0] , k -> new ArrayList<>());
            list.add(c[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            Integer curNode = queue.poll();
            visited[curNode] = true;
            for (int next : map.getOrDefault(curNode , new ArrayList<>())) {
                if (!visited[next]) {
                    queue.add(next);
                    if(next == target) return true;
                }
            }
        }
        return false;
    }
}
