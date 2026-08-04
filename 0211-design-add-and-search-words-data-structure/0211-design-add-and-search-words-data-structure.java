class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {

        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (i == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode child : node.children) {
                boolean result = dfs(word, i + 1, child);
                if (result) {
                    return true;
                }
            }
            return false;
        }
        return dfs(word, i + 1, node.children[c - 'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
