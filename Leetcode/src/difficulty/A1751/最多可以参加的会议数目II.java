package difficulty.A1751;

import java.util.Arrays;

public class 最多可以参加的会议数目II {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events,(a , b)-> a[1] - b[1]);
        int[][] dp = new int[n + 1][ k + 1];
        for (int i = 0; i < n; i++) {
            int pre = find(events,events[i][0] , i); // 结束时间小于等于开始时间的事件
            for(int j = 1 ;j <= k ;j++)
                dp[i + 1][j] = Math.max(dp[i][j] , dp[pre][j - 1] + events[i][2]);
        }

        return dp[n][k];
    }

    private int find(int[][] events, int target , int right) {
        int left = 0;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (events[mid][1] < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
