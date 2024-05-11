class Solution {
  public int maxProfit(int[] prices) {
      int minBuyPrice = prices[0];
      int maxProfit = Integer.MIN_VALUE;
      for (int i = 1; i < prices.length; i++) {
        int sellPrice = prices[i];
        maxProfit = Math.max(maxProfit, sellPrice - minBuyPrice);
        if (sellPrice < minBuyPrice) {
          minBuyPrice = sellPrice;
        }
      }
      return (maxProfit < 0) ? 0 : maxProfit; 
    }
}