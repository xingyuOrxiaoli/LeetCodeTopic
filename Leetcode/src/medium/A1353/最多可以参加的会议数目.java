package medium.A1353;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最多可以参加的会议数目 {
    public static void main(String[] args) {
        int[][] events = ArrayUtils.createArrayTwo("[[1,2],[1,2],[3,3],[1,5],[1,5]]");
        int i = new 最多可以参加的会议数目().maxEvents(events);
        System.out.println(i);
    }
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a , b )->a[0]-b[0]);

        int res = 0 , n = events.length , cur = 0 , maxEnd = 0;
        for(int i = 0 ; i < n ; i ++) maxEnd = Math.max(maxEnd, events[i][1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1 , j = 0 ; i <= maxEnd ; i ++){
            while(j < n && events[j][0] <= i) queue.offer(events[j ++][1]); // 开始时间小于i的会议  i时间已经开启的会议
            while(!queue.isEmpty() && queue.peek() < i) queue.poll();  // i时间已经结束的会议
            if(!queue.isEmpty()) {
                res ++;
                queue.poll(); // 参加结束时间最小的会议
            }
        }
        return res;
    }
}
