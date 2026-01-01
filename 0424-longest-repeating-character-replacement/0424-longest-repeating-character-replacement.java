class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int[] freqMap = new int[26];
        int maxFreq = 0;
        int maxResult = 0;
        for (int end = 0; end < s.length(); end++) {
            int currentChar = s.charAt(end) - 'A';
            freqMap[currentChar]++;
            maxFreq = Math.max(maxFreq, freqMap[currentChar]);
            int windowSize = end - start + 1;
            if (windowSize - maxFreq <= k) {
                maxResult = Math.max(maxResult, windowSize);
            } else {
                int leavingChar = s.charAt(start) - 'A';
                freqMap[leavingChar]--;
                start++;
            }
        }
        return maxResult;
    }
}