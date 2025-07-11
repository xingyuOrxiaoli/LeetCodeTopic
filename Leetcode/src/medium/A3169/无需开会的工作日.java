package medium.A3169;

import utils.ArrayUtils;

import java.util.Arrays;

public class 无需开会的工作日 {
    public static void main(String[] args) {
        int i = new 无需开会的工作日().countDays(6, ArrayUtils.createArrayTwo("[[2,3],[1,5],[2,2]]"));
        System.out.println(i);
    }
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int res = 0 , cur = 0 , n = meetings.length;
        for(int i = 0 ; i < n ; i ++){
            if(cur < meetings[i][0]) res += meetings[i][0] - cur - 1;
            cur = Math.max(cur , meetings[i][1]);
        }
        res += days - cur;
        return res ;
    }
}
