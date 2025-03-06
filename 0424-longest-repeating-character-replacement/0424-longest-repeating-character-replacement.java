class Solution {
  public int characterReplacement(String s, int k) {
    int start = 0;
    int end = 0;
    int lastIndex = s.length() - 1;
    int[] freqMap = new int[26];
    int result = 0;
    int maxFreq = 0;
    int windowLength = 0;
    int currentChar = 0;
    int leavingChar = 0;
    while (end <= lastIndex) {
      currentChar = s.charAt(end) - 'A';
      freqMap[currentChar]++;
      maxFreq = Math.max(maxFreq, freqMap[currentChar]);
      windowLength = end - start + 1;
      if (windowLength - maxFreq <= k) {
        result = Math.max(result, windowLength);
      } else {
        leavingChar = s.charAt(start) - 'A';
        freqMap[leavingChar]--;
        start++;
      }
      end++;
    }
    return result;
  }
}