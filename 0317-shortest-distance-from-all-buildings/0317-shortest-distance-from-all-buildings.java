record Cell(int r, int c) {}

class Solution {
    public int shortestDistance(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] totalDist = new int[rows][cols];
        int[][] reachCount = new int[rows][cols];

        // Find total buildings
        int totalBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                }
            }
        }

        // BFS from every building
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    bfsFromBuilding(grid, i, j, totalDist, reachCount);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0 && reachCount[i][j] == totalBuildings) {
                    minDistance = Math.min(minDistance, totalDist[i][j]);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void bfsFromBuilding(int[][] grid, int startR, int startC, int[][] totalDist, int[][] reachCount) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> queue = new ArrayDeque<>();

        queue.offer(new Cell(startR, startC));
        visited[startR][startC] = true;

        int distance = 0;
        int[][] dirVector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            distance++;

            for (int i = 0; i < levelSize; i++) {
                Cell currentCell = queue.poll();
                int r = currentCell.r();
                int c = currentCell.c();

                for (int[] dir : dirVector) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];

                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols
                            && !visited[nextR][nextC] && grid[nextR][nextC] == 0) {

                        totalDist[nextR][nextC] += distance;
                        reachCount[nextR][nextC]++;
                        queue.offer(new Cell(nextR, nextC));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }

    }
}
