public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int low = Integer.MAX_VALUE;
        for (int i = 1; i <= prices.length - 1; i++) {
            low = Math.min(low, prices[i - 1]);
            max = Math.max(prices[i] - low, max);
        }
        return max;
    }
}