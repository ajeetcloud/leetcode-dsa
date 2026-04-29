class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i, i);
            count += expandFromCenter(s, i, i + 1);
        }
        return count;
    }

    private int expandFromCenter(String s, int startIndex, int endIndex) {

        int count = 0;
        while (startIndex >= 0 && endIndex < s.length() && s.charAt(startIndex) == s.charAt(endIndex)) {
            count++;
            startIndex--;
            endIndex++;
        }
        return count;
    }
}