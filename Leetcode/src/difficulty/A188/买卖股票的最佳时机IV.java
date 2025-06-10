package difficulty.A188;

import utils.ArrayUtils;

import java.util.Arrays;

public class 买卖股票的最佳时机IV {
    public static void main(String[] args) {
        int[] prices = ArrayUtils.createArrayOne("[2,4,1]");
        int i = new 买卖股票的最佳时机IV().maxProfit(2, prices);
        System.out.println(i);
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] buy = new int[k] , sell = new int[k];
        Arrays.fill(buy,-prices[0]);
        for(int i = 0 ; i < n ; i++){

            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0]+prices[i]);
            for(int j = 1 ; j < k ; j++){
                buy[j] = Math.max(buy[j] , sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j] , buy[j] + prices[i]);
            }
        }

        return sell[k - 1];
    }
}
