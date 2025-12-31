class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 1;
        if (s.length() == 0) {
            return 0;
        }
        char startChar = s.charAt(start);
        charIndexMap.put(startChar, 0);
        for (int i = 1; i < s.length(); i++) {
            end = i;
            char endChar = s.charAt(end);
            if (charIndexMap.containsKey(endChar)) {
                // Only move start if the duplicate is within current window
                start = Math.max(start, charIndexMap.get(endChar) + 1);
            }
            charIndexMap.put(endChar, end);
            int tempResult = end - start + 1;
            max = Math.max(max, tempResult);
        }
        return max;
    }
}