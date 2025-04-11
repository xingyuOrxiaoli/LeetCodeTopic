package difficulty.A2999;

import java.util.Arrays;

public class 统计强大整数的数目 {
    public static void main(String[] args) {
        long l = new 统计强大整数的数目().numberOfPowerfulInt(1829505, 1255574165, 7, "11223");
        long l2 = new 统计强大整数的数目().numberOfPowerfulInt(1, 6000, 4, "124");
        System.out.println(l);
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        System.out.println(String.format("%" + n + "s", low));
        low = String.format("%" + n + "s", low).replace(' ', '0'); // 对齐位数
        int pre_len = n - s.length(); // 前缀长度
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
//        return dfs(0, true, true, low, high, limit, s, pre_len, memo);
        return calculate((String.valueOf(finish)),s , limit) - calculate(String.valueOf(start -1) , s , limit) ;
    }
    public long numberOfPowerfulInt2(long start, long finish, int limit, String s) {
        return calculate((String.valueOf(finish)),s , limit) - calculate(String.valueOf(start) , s , limit) ;
    }
    private long calculate(String str, String suffix, int limit) {
        if(str.length() < suffix.length())  return 0;
        if(str.length() == suffix.length()) return str.compareTo(suffix) >= 0 ? 1 : 0;

        long res = 0 ;
        int n = str.length() - suffix.length();
        String suf = str.substring(n);

        for(int i = 0 ; i < n ; i++) {
            int value = str.charAt(i) - '0';
            if(value > limit){
                res += (long) Math.pow(limit + 1,n - i);
                return res;
            }
            res += (long)value * (long) Math.pow(limit + 1,n - i - 1);
        }
        if(suf.compareTo(suffix) >= 0){
            res ++;
        }
        return res;
    }
    private long dfs(int i, boolean limit_low, boolean limit_high,
                     String low, String high, int limit, String s,
                     int pre_len, long[] memo) {
        // 递归边界
        if (i == low.length()) {
            return 1;
        }
        if (!limit_low && !limit_high && memo[i] != -1) {
            return memo[i];
        }

        int lo = limit_low ? low.charAt(i) - '0' : 0;
        int hi = limit_high ? high.charAt(i) - '0' : 9;
        long res = 0;
        if (i < pre_len) {
            for (int digit = lo; digit <= Math.min(hi, limit); digit++) {
                res += dfs(i + 1, limit_low && digit == lo,
                        limit_high && digit == hi,
                        low, high, limit, s, pre_len, memo);
            }
        } else {
            int x = s.charAt(i - pre_len) - '0';
            if (lo <= x && x <= Math.min(hi, limit)) {
                res = dfs(i + 1, limit_low && x == lo,
                        limit_high && x == hi,
                        low, high, limit, s, pre_len, memo);
            }
        }

        if (!limit_low && !limit_high) {
            memo[i] = res;
        }
        return res;
    }
}
