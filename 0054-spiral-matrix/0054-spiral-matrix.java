class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int row = 0;
        int col = 0;
        int dir = 0;

        for (int i = 0; i < m * n; i++) {
            result.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + dr[dir];
            int nextCol = col + dc[dir];

            // change direction if out of bounds
            if (nextRow >= m || nextCol >= n || nextRow < 0 || nextCol < 0 || visited[nextRow][nextCol]) {
                dir = (dir + 1) % 4;
                nextRow = row + dr[dir];
                nextCol = col + dc[dir];
            }

            row = nextRow;
            col = nextCol;
        }
        return result;
    }
}