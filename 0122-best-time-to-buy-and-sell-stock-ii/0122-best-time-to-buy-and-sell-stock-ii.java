class Solution {
  public int maxProfit(int[] prices) {
    int sum = 0;
    int max = prices[0];
    int min = prices[0];
    for (int i = 1; i < prices.length; i++) {
      int current = prices[i];
      if (current > max) {
        sum += (current - max);
      }
      max = current;
      min = current;
    }
    return sum;
  }
}