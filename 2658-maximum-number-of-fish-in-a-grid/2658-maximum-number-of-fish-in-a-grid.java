class Solution {
  public int findMaxFish(int[][] grid) {
    int maxRowsIndex = grid.length - 1;
    int maxColsIndex = grid[0].length - 1;
    int sum = 0;
    for (int i = 0; i <= maxRowsIndex; i++) {
      for (int j = 0; j <= maxColsIndex; j++) {
        if (grid[i][j] != 0) {
          int currSum = findMaxFishSum(grid, i, j, maxRowsIndex, maxColsIndex);
          if (currSum > sum) {
            sum = currSum;
          }
        }
      }
    }
    return sum;
  }

  private int findMaxFishSum(int[][] grid, int i, int j, int maxRowsIndex, int maxColsIndex) {
    if (i > maxRowsIndex || j > maxColsIndex || i < 0 || j < 0 || grid[i][j] == 0) {
      return 0;
    }

    int sum = grid[i][j];
    grid[i][j] = 0;
    sum += findMaxFishSum(grid, i + 1, j, maxRowsIndex, maxColsIndex);
    sum += findMaxFishSum(grid, i - 1, j, maxRowsIndex, maxColsIndex);
    sum += findMaxFishSum(grid, i, j + 1, maxRowsIndex, maxColsIndex);
    sum += findMaxFishSum(grid, i, j - 1, maxRowsIndex, maxColsIndex);

    return sum;
  }
}