package medium.A56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2},
                {3, 4},
        };
        int[][] merge = new 合并区间().merge_2(intervals);
        System.out.println(merge.length);
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            if(res.size() == 0 || res.get(res.size() - 1)[1] < intervals[i][0]){
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }else{
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    // 练习
    public int[][] merge_2(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        /**
         * 情况1 pre[1] > cur[0] pre[1] < cur[1]
         * 情况2 pre[1] > cur[0] pre[1] > cur[1]
         * 情况3 pre[1] < cur[0]   结束 不再有交集
         */
        int left = intervals[0][0] , right = intervals[0][1] , n = intervals.length;
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < n; i++){
            if(right < intervals[i][0]){
                res.add(new int[]{left,right});
                left  = intervals[i][0];
                right = intervals[i][1];
            }else right = Math.max(right, intervals[i][1]);
        }
        if(res.size() == 0 || res.get(res.size() - 1)[1] != right) res.add(new int[]{left,right});
        return res.toArray(new int[res.size()][]);
    }
}
