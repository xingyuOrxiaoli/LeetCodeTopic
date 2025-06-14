package medium.A210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 课程表II {
    public static void main(String[] args) {

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses] , res = new int[numCourses];
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) edges[i] = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            edges[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            res[count ++] = node;
            for (Integer next : edges[node]) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }
        return (count == numCourses) ? res : new int[0];
    }
}
