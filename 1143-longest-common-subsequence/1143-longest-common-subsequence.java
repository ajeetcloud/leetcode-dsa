class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        

        // DP approach
        return dpSolution(text1, text2);

        /*
        // Memo approach
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return memoSolution(text1, text2, 0, 0, memo);
        */

        /*
        BT approach
        return bt(text1, text2, 0, 0);
        */
    }

    // DP approach
    private int dpSolution(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][ j + 1];
                } 
                else {
                    dp[i][j] = Math.max(dp[i][ j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    // Memo approach
    private int memoSolution(String s1, String s2, int index1, int index2, Integer[][] memo) {

        if (index1 >= s1.length() || index2 >= s2.length()) {
            return 0;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            memo[index1][index2] = 1 + memoSolution(s1, s2, index1 + 1, index2 + 1, memo);
            return memo[index1][index2];
        }
        
        int sol1 = memoSolution(s1, s2, index1, index2 + 1, memo);
        int sol2 = memoSolution(s1, s2, index1 + 1, index2, memo);

        memo[index1][index2] = Math.max(sol1, sol2);
        return memo[index1][index2];
    }

    // BT approach
    private int bt(String s1, String s2, int index1, int index2) {

        if (index1 >= s1.length() || index2 >= s2.length()) {
            return 0;
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 1 + bt(s1, s2, index1 + 1, index2 + 1);
        }
        int sol1 = bt(s1, s2, index1, index2 + 1);
        int sol2 = bt(s1, s2, index1 + 1, index2);

        return Math.max(sol1, sol2);
    }
}