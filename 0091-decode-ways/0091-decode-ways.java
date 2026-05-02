class Solution {
    public int numDecodings(String s) {

        Integer[] memo = new Integer[s.length() + 1];
        return memoSolution(s, 0, memo);
        
        // return bt(s, 0);
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