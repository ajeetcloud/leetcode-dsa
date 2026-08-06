class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class Trie {

    private final TrieNode root;
    private List<List<String>> result;

    private static final int LIMIT = 3;

    public Trie() {
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

    public void suggest(String searchWord) {
        result = new ArrayList<>();
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            prefix.append(c);
            if (node != null) {
                node = node.children[c - 'a'];
            }
            List<String> suggestions = new ArrayList<>();
            if (node != null) {
                collect(node, prefix, suggestions);
            }
            result.add(suggestions);
        }
    }

    private void collect(TrieNode node, StringBuilder path, List<String> output) {
        if (node == null) {
            return;
        }
        if (output.size() == LIMIT) {
            return;
        }
        if (node.isEnd) {
            output.add(path.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (output.size() == LIMIT) {
                return;
            }
            if (node.children[i] != null) {
                path.append((char) (i + 'a'));
                collect(node.children[i], path, output);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public List<List<String>> getResult() {
        return this.result;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (int i = 0; i < products.length; i++) {
            trie.addWord(products[i]);
        }

        trie.suggest(searchWord);

        return trie.getResult();
    }
}