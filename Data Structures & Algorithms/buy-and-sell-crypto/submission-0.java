class Solution {
    public int maxProfit(int[] prices) {
        int maxSell = 0;
        int minBuy = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            maxSell = Math.max(minBuy, prices[i]);
            profit = Math.max(maxSell-minBuy, profit);
        }
        return profit;
    }
}
