class Solution {
    public int minCost(int[][] costs) {
      int n = costs.length;
      // DP solution
      // Can be done using the costs matrix also, inplace, in this solution
      // also we are ensure Space: 0(1), as prevRow and currentRow have constant sizes - 3
      int[] prevRow = costs[0].clone();
      for (int i = 1; i < n; i++) {
        int[] currentRow = costs[i].clone();
        currentRow[0] = currentRow[0] + Math.min(prevRow[1], prevRow[2]);
        currentRow[1] = currentRow[1] + Math.min(prevRow[0], prevRow[2]);
        currentRow[2] = currentRow[2] + Math.min(prevRow[0], prevRow[1]);
        prevRow = currentRow;
      }
      return Math.min(prevRow[0], Math.min(prevRow[1], prevRow[2]));
    }
}