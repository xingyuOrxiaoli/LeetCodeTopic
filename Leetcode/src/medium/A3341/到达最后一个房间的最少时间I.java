package medium.A3341;

import utils.ArrayUtils;

import java.util.*;

public class 到达最后一个房间的最少时间I {
    public static void main(String[] args) {
        int[][] moveTime = ArrayUtils.createArrayTwo("[[0,0,0],[0,0,0]]");
        int i = new 到达最后一个房间的最少时间I().minTimeToReach(moveTime);
        System.out.println(i);
    }

    // dp解法  卡在703
    public int minTimeToReach1(int[][] moveTime) {
        int n = moveTime.length , m = moveTime[0].length;
        moveTime[0][0] = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 && j == 0) continue;
                int temp = Integer.MAX_VALUE;
                if( i > 0) temp = moveTime[i-1][j] ;
                if( j > 0) temp = Math.min(moveTime[i][j-1] ,temp) ;
                if(temp == Integer.MAX_VALUE) temp = 0;
                temp ++;
                if(moveTime[i][j] < temp) moveTime[i][j] = temp;
                else moveTime[i][j] ++;
            }
        }
        return moveTime[n-1][m-1];
    }
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length , m = moveTime[0].length;
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        int[] dx = {-1, 1,0 ,0} , dy = {0,0,-1,1};// 上下左右
        PriorityQueue<Integer> queue_val = new PriorityQueue();
        TreeMap<Integer, List<Integer>> map_addr =  new TreeMap<>();
        queue_val.add(0);
        ArrayList<Integer> lab = new ArrayList<>();
        lab.add(0);
        map_addr.put(0,lab);
        while(!queue_val.isEmpty()){
            Integer key = queue_val.poll();
            List<Integer> list = map_addr.get(key);
            Integer addr = list.get(0);
            list.remove(0);

            int x = addr / 100 , y = addr % 100;
            if(visited[x][y]) continue;
            visited[x][y] = true;

            for(int i = 0 ; i < 4 ; i++){
                int newX = x + dx[i] , newY = y + dy[i];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY]) continue;
                int newDist = Math.max(dist[x][y],moveTime[newX][newY]) + 1;
                if(dist[newX][newY] > newDist){
                    dist[newX][newY] = newDist;
                    queue_val.add(newDist);
                    List<Integer> temp = map_addr.getOrDefault(newDist, new ArrayList<>());
                    temp.add(newX * 100 + newY);
                    map_addr.put(newDist,temp);
                }
                if(newX == n - 1 && newY == m - 1) return dist[n-1][m-1];
            }
        }
        return dist[n-1][m-1];
    }
}
