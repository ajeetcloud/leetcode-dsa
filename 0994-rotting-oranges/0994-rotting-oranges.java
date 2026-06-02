record OrangeLoc(int row, int col) {}

class Solution {

    private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int minutes = 0;

        Deque<OrangeLoc> rottenOranges = new ArrayDeque<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    freshCount++;
                }
                else if (grid[r][c] == 2) {
                    rottenOranges.offer(new OrangeLoc(r, c));
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        while (!rottenOranges.isEmpty() && freshCount > 0) {

            int levelSize = rottenOranges.size();

            // When this loop completes, 1 level(1 minute) is complete
            for (int i = 0; i < levelSize; i++) {
                OrangeLoc rottenLoc = rottenOranges.poll();

                for (int[] dir: DIRECTIONS) {
                    int nextRow = rottenLoc.row() + dir[0];
                    int nextCol = rottenLoc.col() + dir[1];

                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols 
                            || grid[nextRow][nextCol] != 1) {
                        continue;
                    }
                    grid[nextRow][nextCol] = 2;
                    rottenOranges.offer(new OrangeLoc(nextRow, nextCol));
                    freshCount--;
                }
            }
            minutes++;
        }

        if (freshCount > 0) {
            return -1;
        }

        return minutes;
    }
}