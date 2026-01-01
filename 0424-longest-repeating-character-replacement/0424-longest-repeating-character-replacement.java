class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int start = 0 ;
        int end = 0;
        int maxFreqInWindow = 0;
        int maxWindowResult = 0;
        while (end < s.length()) {
            int windowLength = end - start + 1;
            char currentChar = s.charAt(end);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
            maxFreqInWindow = Math.max(maxFreqInWindow, freqMap.get(currentChar));
            if (windowLength - maxFreqInWindow <= k) {
                maxWindowResult = Math.max(maxWindowResult, windowLength);
                end++;
            } else {
                char leavingChar = s.charAt(start);
                int leavingCharFreq = freqMap.get(leavingChar);
                freqMap.put(leavingChar, leavingCharFreq - 1);
                start++;
                end++;
            }
        }
        return maxWindowResult;
    }
}