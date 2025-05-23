package medium.A122;

import utils.ArrayUtils;

public class 买卖股票的最佳时机II {
    public static void main(String[] args) {
        int[] prices = ArrayUtils.createArrayOne("[7,1,5,3,6,4]");
        int i = new 买卖股票的最佳时机II().maxProfit(prices);
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];
        stack[n - 1] = prices[n - 1];
        for(int i = n - 2 ; i > -1 ; i--) stack[i] = Math.max(stack[i +  1] , prices[i]);
        int res = 0  , value = 0;
        boolean isBuy = false;
        for(int i = 0 ; i < n ; i ++){
            if(stack[i] == prices[i] && !isBuy) continue;
            // 清空手中的股票
            if(isBuy){
                res += prices[i] - value;
                isBuy = false;
            }

            // 是否买入/ 复购今日买入的
            if(i < n - 1 && prices[i] < prices[i + 1]){
                isBuy = true;
                value = prices[i];
            }

        }
        return res;
    }
}
