package medium.A3440;

import medium.A146.LRU缓存;
import utils.ArrayUtils;

public class 重新安排会议得到最多空余时间II {
    public static void main(String[] args) {
        int[] startTime = ArrayUtils.createArrayOne("[1,3]");
        int[] endTime = ArrayUtils.createArrayOne("[2,5]");
        int i = new 重新安排会议得到最多空余时间II().maxFreeTime(5 , startTime, endTime);
        System.out.println(i);
    }
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n  = startTime.length , left = 0 ,tl = 0 , right = 0 , res = 0 ;
        int[] tr = new int[n + 1];
        tr[n - 1] = eventTime - endTime[n - 1];
        for(int i = n - 2 ; i > -1; i --) tr[i] = Math.max(tr[i + 1] , startTime[i+1] - endTime[i]);

        for(int i = 0 ; i < n ; i ++){
            left = i == 0 ? 0 : endTime[i - 1];
            right = i == n - 1 ? eventTime : startTime[i + 1];
            int t = endTime[i] - startTime[i];
            if(tr[i + 1] >= t || tl >= t) res = Math.max(res , right - left);
            else res = Math.max(res , right - left - endTime[i] + startTime [i]);

            tl = Math.max(tl , startTime[i] - left);
        }
        return res;
    }
}
