class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Step 1: Guard
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Step 2: Fill the map
        Map<String, List<String>> patternToWords = new HashMap<>();
        if (!wordSet.contains(beginWord)) {
            updatePatternToWords(patternToWords, beginWord);
        }
        for (String word: wordSet) {
            updatePatternToWords(patternToWords, word);
        }
        
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();

                if (currentWord.equals(endWord)) {
                    return level;
                }

                // neighbors
                for (int j = 0; j < currentWord.length(); j++) {
                    String pattern = currentWord.substring(0, j) + "*" + currentWord.substring(j + 1);
                    List<String> neighbors = patternToWords.getOrDefault(pattern, List.of());

                    for (String neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private void updatePatternToWords(Map<String, List<String>> patternToWords, String word) {

        for (int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
            patternToWords.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
        }
    }
}
