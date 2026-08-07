class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
}

class Solution {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);
        List<String> found = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, found);
            }
        }
        return found;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> found) {

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#') {
            return;
        }

        TrieNode next = node.children[ch - 'a'];
        if (next == null) {
            return;
        }
        if (next.word != null){
            found.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';
        for (int[] dir: DIRECTIONS) {
            dfs(board, r + dir[0], c + dir[1], next, found);
        }
        board[r][c] = ch;
        
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }
}