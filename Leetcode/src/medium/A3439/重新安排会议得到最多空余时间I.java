package medium.A3439;

public class 重新安排会议得到最多空余时间I {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length , res =  0;
        int[] s = new int[n + 1]; // 记录会议时间
        for(int i = 0; i < n; i++) s[i + 1] = s[i] + endTime[i] - startTime[i];

        for(int i = k - 1 ; i < n ; i ++){
            int right = i == n - 1 ? eventTime : startTime[i + 1] , left = i <= k - 1 ? 0 : endTime[i - k];
            res = Math.max(res, right - left - (s[i + 1] - s[i - k + 1]));
        }
        return res;
    }

    public int maxFreeTime1(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length , res =  0 , t = 0 ;
        for(int i = 0 ; i < n ; i ++){
            t += endTime[i] - startTime[i];
            int right = i == n - 1 ? eventTime: startTime[i + 1] , left = i <= k - 1 ? 0 : endTime[i - k];

            res = Math.max(res, right - left - t);
            if(i >= k - 1) t -= endTime[i - k + 1] - startTime[i - k + 1];
        }

        return res;
    }
}
