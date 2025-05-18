package simple.A121;

import utils.ArrayUtils;

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = ArrayUtils.createArrayOne("[7,1,5,3,6,4]");
        int i = new 买卖股票的最佳时机().maxProfit(prices);
        System.out.println(i);
    }
    // 单调队列
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = prices[n - 1];
        for(int i = n - 2 ; i > -1 ; i --) rightMax[i] = Math.max(rightMax[i + 1], prices[i]);
        int res = 0 ;
        for(int i = 0 ; i < n - 1 ; i ++) res = Math.max(res , rightMax[i] - prices[i]);
        return res;
    }
    // 单调队列 优化2
    public int maxProfit2(int[] prices) {
        int res = 0 , max = -1 , n = prices.length;
        for(int i = n - 1 ; i > -1 ; i--){
            res = Math.max(res, max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        return res;
    }
}
