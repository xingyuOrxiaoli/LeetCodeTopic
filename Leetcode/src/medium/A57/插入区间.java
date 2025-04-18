package medium.A57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 插入区间 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval = {
                4,8
        };
        int[][] insert = new 插入区间().insert_1(intervals, newInterval);
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

    // 练习1
    public int[][] insert_1(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int left = 0 , right = 0;
        for(int i = 0 ; i < n ; i++) {
            if(left == -1) res.add(intervals[i]);
            else{
                /**
                 * 情况1 new[1] < left    前面
                 * 情况2 new[0] > right   后面
                 * 情况3 new[0] > left && new[0] < right 交集
                 * 情况4 new[0] < left && new[1] > left  交集
                 */
                left  = intervals[i][0];
                right = intervals[i][1];
                // 情况1 new[1] < left    前面
                if(left > newInterval[1]){
                    res.add(newInterval);
                    res.add(intervals[i]);
                    left = -1;
                    continue;
                }
                // 情况2 new[0] > right   后面
                if(newInterval[0] > right){
                    res.add(intervals[i]);
                }
                // 情况3 new[0] >= left && new[0] <= right 交集
                // 情况4 new[0] <= left && new[1] >= left  交集
                if((newInterval[0] >= left && newInterval[0] <= right) || (newInterval[0] <= left && newInterval[1] >= left)){
                    newInterval[0] = Math.min(newInterval[0],left);
                    newInterval[1] = Math.max(newInterval[1],right);
                    System.out.println(newInterval[1] );
                }
            }
        }
        if(left != -1) res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}
