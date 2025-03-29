package Weekly_competition.two.A153;

import java.util.ArrayList;
import java.util.List;



public class Q4操作后最大活跃区段数II {
    public static void main(String[] args) {
        int[][] q = new int[][]{
                {0,3},
                {0,2},
                {1,3},
                {2,3}
        };
        List<Integer> integers = new Q4操作后最大活跃区段数II().maxActiveSectionsAfterTrade("0100", q);
        System.out.println(integers);
    }
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') one++;
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            res.add(one + maxActiveSectionsAfterTrade(s, left, right));
        }
        return res;
    }

    private int maxActiveSectionsAfterTrade(String s, int left, int right) {
        int max = 0, zero_pre = 0, zero_cur = 0;
        boolean hasOne = false;

        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '1') {
                hasOne = true;
                if (zero_pre != 0 && zero_cur != 0) {
                    max = Math.max(max, zero_cur + zero_pre);
                }
                if (i > left && s.charAt(i - 1) == '0') {
                    zero_pre = zero_cur;
                    zero_cur = 0;
                }
            } else {
                zero_cur++;
            }
        }

        if (zero_cur != 0 && hasOne) {
            max = Math.max(max, zero_cur + zero_pre);
        }
        return max;
    }

}
