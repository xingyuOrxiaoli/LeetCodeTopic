package medium.A207;

import utils.ArrayUtils;

import java.util.*;

public class 课程表 {
    public static void main(String[] args) {
        int[][] prerequisites = ArrayUtils.createArrayTwo("[[1,0],[1,2],[0,1]]");
        boolean b = new 课程表().canFinish(3, prerequisites);
        System.out.println(b);
    }

    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            if(prerequisite[0] == prerequisite[1]) return false;
            inDegree[prerequisite[0]]++;
            edges[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int res = 0 ;
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            res ++;
            for (Integer next : edges[node]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return res == numCourses;
    }
}
