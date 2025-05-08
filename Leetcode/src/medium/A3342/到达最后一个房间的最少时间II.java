package medium.A3342;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 到达最后一个房间的最少时间II {

    public static void main(String[] args) {
        int[][] arrayTwo = ArrayUtils.createArrayTwo("[[0,0,0,0],[0,0,0,0]]");
        int i = new 到达最后一个房间的最少时间II().minTimeToReach(arrayTwo);

    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length , m = moveTime[0].length;
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<moveObject> queue = new PriorityQueue<>();
        queue.add(new moveObject(0,0,0,1));
        dist[0][0] = 0;
        int[] dx = {-1,1, 0, 0} , dy = {0,0,-1 , 1};
        while (!queue.isEmpty()) {
            moveObject move = queue.poll();
            if(visited[move.x][move.y]) continue;
            visited[move.x][move.y] = true;
            int step = move.step;
            for (int i = 0; i < 4; i++) {
                int x = move.x + dx[i];
                int y = move.y + dy[i];
                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) continue;
                dist[x][y] = Math.min(dist[x][y] , Math.max(move.w, moveTime[x][y]) + step);
                queue.add(new moveObject(dist[x][y],x ,y , (step & 1) == 1?2:1));
            }
        }
        return dist[n - 1][m -1];
    }
    class moveObject implements Comparable<moveObject> {
        Integer w ;
        Integer x ;
        Integer y;
        Integer step;

        public moveObject(int w, int x, int y,int step) {
            this.w = w;
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        public int compareTo(moveObject o) {
            return w.compareTo(o.w);
        }
    }
}
