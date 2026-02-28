class Solution {
    public boolean exist(char[][] board, String word) {

        int row = 0;
        int col = 0;
        int index = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean result = backtrack(board, i, j, rows, cols, word, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, int rows, int cols, String word, int index) {

        // Word found
        if (index == word.length()) {
            return true;
        }

        // Bad Index of row or col
        if (row >= rows || col >= cols || row < 0 || col < 0) {
            return false;
        }

        // Wrong character found
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Choose
        char saved = board[row][col];
        // marks visited - in-place trick
        board[row][col] = '#';

        // Recurse
        boolean found = backtrack(board, row + 1, col, rows, cols, word, index + 1)
                || backtrack(board, row, col + 1, rows, cols, word, index + 1)
                || backtrack(board, row - 1, col, rows, cols, word, index + 1)
                || backtrack(board, row, col - 1, rows, cols, word, index + 1);

        // Unchoose
        board[row][col] = saved;

        return found;
    }
}