public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        
        for (int i = 1; i < len; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
            if (i == 1) {
                buy[i] = Math.max(-prices[0], -prices[1]);
            } else {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
            }
        }
        return sell[len - 1];
    }
}