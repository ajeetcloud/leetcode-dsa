class Solution {
    public int minCost(int[][] costs) {
      int n = costs.length;
      // DP solution
      int[][] storage = new int[n][3];
      storage[0][0] = costs[0][0];
      storage[0][1] = costs[0][1];
      storage[0][2] = costs[0][2];
      for (int i = 1; i < n; i++) {
        storage[i][0] = costs[i][0] + Math.min(storage[i - 1][1], storage[i - 1][2]);
        storage[i][1] = costs[i][1] + Math.min(storage[i - 1][0], storage[i - 1][2]);
        storage[i][2] = costs[i][2] + Math.min(storage[i - 1][0], storage[i - 1][1]);
      }
      return Math.min(storage[n - 1][0], Math.min(storage[n - 1][1], storage[n - 1][2]));
    }
}