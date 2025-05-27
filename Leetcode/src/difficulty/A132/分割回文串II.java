package difficulty.A132;

import java.util.Arrays;

public class 分割回文串II {
    public static void main(String[] args) {
        int i = new 分割回文串II().minCut1("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj");
        System.out.println(i);
    }
    public int minCut1(String s) {
        int n = s.length();
        if(check(s,0,s.length()-1)) return 0;
        int res = 20000;
        for(int i = 1 ; i < n; i++){
            int left = minCut(s.substring(0,i));
            int right = minCut(s.substring(i));
            res = Math.min(res,left+right + 1);
        }

        return res;
    }
    private boolean check(String str, int i , int j) {
        if(str.length() == 1) return true;
        while (i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i ++;
                j --;
            }else return false;
        }
        return true;
    }

    // 动态规划
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0 ;i < n ; i++) Arrays.fill(dp[i], true);

        for(int i = n - 1; i > -1 ; i--)
            for(int j = i + 1 ; j < n ; j ++)
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j -1];
        int[] res = new int[n];
//        int min = 2000010;
        Arrays.fill(res, 200010);
        for(int i = 0 ; i < n ; i++){
            if(dp[0][i]) {
                res[i] = 0;
            }
            else {
                for(int j = 0 ; j < i ; j++)
                    if(dp[j + 1][i]) res[i] = Math.min(res[j] + 1 ,res[i]);
            }
        }

        return res[n - 1];
    }
}
