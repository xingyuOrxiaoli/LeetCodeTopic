package medium.A264;

import java.util.Arrays;

public class 丑数II {
    public static void main(String[] args) {

    }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int index1 = 1, index2 = 1, index3 = 1;
        for (int i = 2; i <= n; i++) {
            int temp1 = dp[index1] << 1, temp2 = dp[index2] * 3, temp3 = dp[index3] * 5;
            dp[i] = Math.min(Math.min(temp1, temp2), temp3);
            if (dp[i] == temp1) index1 ++;
            if (dp[i] == temp2) index2 ++;
            if (dp[i] == temp3) index3 ++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
