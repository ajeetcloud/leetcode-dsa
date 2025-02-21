class Solution {
    public int lengthOfLongestSubstring(String s) {
      Map<Character, Integer> map = new HashMap<>();
      int start = 0;
      int end = 0;
      int max = 0;
      int endIndex = s.length() - 1;
      int currentIndex = 0;
      while (currentIndex <= endIndex) {
        char currentChar = s.charAt(currentIndex);
        if (map.containsKey(currentChar)) {
          int prevIndex = map.get(currentChar);
          if (prevIndex >= start) {
            start = prevIndex + 1;
          }
        }
        end = currentIndex;
        max = Math.max(max, end - start + 1);
        map.put(currentChar, currentIndex);
        currentIndex++;
      }
      return max;
    }
}