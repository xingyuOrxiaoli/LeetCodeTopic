package difficulty.A123;

import utils.ArrayUtils;

public class 买卖股票的最佳时机III {
    public static void main(String[] args) {
        int[] prices = ArrayUtils.createArrayOne("[6,1,3,2,4,7]");
        int i = new 买卖股票的最佳时机III().maxProfit(prices);
        System.out.println(i == 7);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            // 第一次进行交易
            buy1  = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);

            // 在第一次交易的基础上 进行第二次交易
            // 因为允许卖出之后当天再次买入
            buy2  = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
