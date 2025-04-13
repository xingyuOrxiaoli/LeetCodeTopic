package medium.A57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 插入区间 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {6,9},
        };
        int[] newInterval = {
                -1,0
        };
        int[][] insert = new 插入区间().insert(intervals, newInterval);
        for (int[] ints : insert) {
            System.out.println(Arrays.toString(ints));
        }
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0 ) return new int[][]{
                newInterval
        };
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0] ,end = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0] ,right = intervals[i][1];
            // 两个区间 有交集
            if(end >= left && start <= right) {
                start = Math.min(start , left);
                end   = Math.max(end , right);
                continue;
            }
            if(end < left && start <= end) {
                // 在区间左侧侧  完成插入了
                res.add(new int[]{start,end});
                end = start - 1;
            }
            // 当前插入区间在右侧 则插入
            res.add(new int[]{left,right});
        }
        if(end >= intervals[intervals.length-1][1]) res.add(new int[]{start,end});

        return res.toArray(new int[0][]);
    }
}
