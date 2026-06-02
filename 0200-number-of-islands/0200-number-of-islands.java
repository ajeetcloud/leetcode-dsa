class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    explore(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    private void explore(char[][] grid, int i, int j, boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        explore(grid, i, j + 1, visited);
        explore(grid, i, j - 1, visited);
        explore(grid, i + 1, j, visited);
        explore(grid, i - 1, j, visited);
    }
}