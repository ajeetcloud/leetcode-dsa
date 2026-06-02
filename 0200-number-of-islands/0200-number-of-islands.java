record Location(int i, int j) {
}

class Solution {

    private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    // BFS
    public int numIslandsBFS(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Deque<Location> queue = new ArrayDeque<>();

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int startRow, int startCol, boolean[][] visited) {

        int rows = grid.length;
        int cols = grid[0].length;

        Deque<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(startRow, startCol));
        visited[startRow][startCol] = true; // Mark on Enqueue!

        while (!queue.isEmpty()) {
            Location loc = queue.poll();

            for (int[] dir : DIRECTIONS) {
                int nextRow = loc.i() + dir[0];
                int nextCol = loc.j() + dir[1];

                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                    continue;
                }

                if (grid[nextRow][nextCol] == '1') {
                    queue.offer(new Location(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }

            }
        }
    }

    // Recursive DFS
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
    }
}