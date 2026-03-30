class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = wordDict.stream().collect(Collectors.toSet());

        int startIndex = 0;

        return dp(s, dict);

        /*
        // Memoization code
        Boolean[] memo = new Boolean[s.length() + 1];
        return memo(s, dict, startIndex, memo);
        */

        /*
        // Simple Backtracking
        return bt(s, dict, startIndex);
        */
    }

    // DP is iterative
    private boolean dp(String s, Set<String> dict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (dict.contains(str) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }

    // Memoization
    private boolean memo(String s, Set<String> dict, int startIndex, Boolean[] memo) {

        if (startIndex >= s.length()) {
            memo[startIndex] = true;
            return true;
        }

        if (memo[startIndex] != null) {
            return memo[startIndex];
        }

        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String str = s.substring(startIndex, endIndex);
            if (dict.contains(str) && memo(s, dict, endIndex, memo)) {
                memo[startIndex] = true;
                return true;
            }
        }
        memo[startIndex] = false;
        return false;
    }

    // Simple Backtracking
    private boolean bt(String s, Set<String> dict, int startIndex) {

        if (startIndex >= s.length()) {
            return true;
        }

        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String str = s.substring(startIndex, endIndex);
            if (dict.contains(str) && bt(s, dict, endIndex)) {
                return true;
            }
        }
        return false;
    }
}