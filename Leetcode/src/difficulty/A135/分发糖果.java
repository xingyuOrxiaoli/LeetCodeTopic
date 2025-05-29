package difficulty.A135;

import utils.ArrayUtils;

import java.util.Arrays;

public class 分发糖果 {
    public static void main(String[] args) {
        int[] ratings = ArrayUtils.createArrayOne("[1,0,2]");
        int candy = new 分发糖果().candy(ratings);
        System.out.println(candy);
    }

    // 数组存储 之和求和
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0 ; i < n - 1 ; i ++){
            if(ratings[i] < ratings[i+1]) dp[i + 1] = dp[i] + 1;
            else dp[i + 1] = 1;
//            else if(ratings[i] > ratings[i + 1]) dp[i + 1] = 1;
//            else dp[i + 1] = dp[i];
        }
        for(int i = n - 1 ; i > 0 ; i--){
            if(ratings[i] < ratings[i - 1] && dp[i] >= dp[i - 1]) dp[i - 1] = dp[i] + 1;
        }
        return Arrays.stream(dp).sum();
    }
}
