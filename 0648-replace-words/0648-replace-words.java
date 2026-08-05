class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class Solution {

    private final TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    private void insert(String w) {
        TrieNode node = root;
        for (int i = 0; i < w.length(); i++) {
            int index = w.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    private String shortestRoot(String word) {

        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return word;        // No root prefix
            }
            node = node.children[index];
            if (node.isEnd) {
                return word.substring(0, i + 1);
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        StringBuilder result = new StringBuilder();

        dictionary.forEach(this::insert);
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(shortestRoot(words[i]));
        }
        return result.toString();
    }
}