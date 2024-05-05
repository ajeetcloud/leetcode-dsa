class Solution {
    public int minCostII(int[][] costs) {
      int n = costs.length;
      int k = costs[0].length;
      // DP solution
      int[] prevRow = costs[0].clone();
      int prevMin = Integer.MAX_VALUE;
      int prevSecondMin = -1;
      int prevMinIndex = -1;
      for (int i = 0; i < k; i++) {
        if (prevRow[i] < prevMin) {
          prevSecondMin = prevMin;
          prevMin = prevRow[i];
          prevMinIndex = i;
        } else if (prevRow[i] < prevSecondMin) {
          prevSecondMin = prevRow[i];
        }
      }
      for (int i = 1; i < n; i++) {
        int[] currentRow = costs[i].clone();
        int index = -1;
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        // fill currentRow[j]
        for (int j = 0; j < k; j++) {
          if (j == prevMinIndex) {
            currentRow[j] = currentRow[j] + prevSecondMin;
          } else {
            currentRow[j] = currentRow[j] + prevMin;
          }

          if (currentRow[j] < min) {
            secMin = min;
            min = currentRow[j];
            index = j;
          } else if (currentRow[j] < secMin) {
            secMin = currentRow[j];
          }
        }
        // update prevMin, prevSecondMin & prevMinIndex
        prevMin = min;
        prevSecondMin = secMin;
        prevMinIndex = index;
      }
     return prevMin;
    }
}