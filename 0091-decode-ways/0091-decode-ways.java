class Solution {
    public int numDecodings(String s) {

        // DP solution
        return dpSolution(s);

        /*
        // Memo solution
        Integer[] memo = new Integer[s.length() + 1];gm
        return memoSolution(s, 0, memo);
        */

        /*
        // BT solution
        return bt(s, 0);
        */
    }

    // DP solution
    private int dpSolution(String s) {

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            int sol1 = dp[i+1];
            int sol2 = 0;

            if (i + 1 < s.length()) {
                int doubleCharNum = ((s.charAt(i) - '0') * 10) + (s.charAt(i + 1) - '0');
                if (doubleCharNum <= 26) {
                    sol2 = dp[i + 2];
                }
            }
            dp[i] = sol1 + sol2;
        }
        return dp[0];
    }


    // Memo solution
    private int memoSolution(String s, int i, Integer[] memo) {

        if (i >= s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int sol1 = memoSolution(s, i + 1, memo);

        int sol2 = 0;
        if (i + 1 < s.length()) {
            int doubleCharNum = ((s.charAt(i) - '0') * 10) + (s.charAt(i + 1) - '0');
            if (doubleCharNum <= 26) {
                sol2 = memoSolution(s, i + 2, memo);
            }
        }
        memo[i] = sol1 + sol2;
        return memo[i];
    }

    // Backtrack solution
    private int bt(String s, int i) {

        if (i >= s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int sol1 = bt(s, i + 1);

        int sol2 = 0;
        if (i + 1 < s.length()) {
            int doubleCharNum = ((s.charAt(i) - '0') * 10) + (s.charAt(i + 1) - '0');
            if (doubleCharNum <= 26) {
                sol2 = bt(s, i + 2);
            }
        }
        return sol1 + sol2;
    }
}