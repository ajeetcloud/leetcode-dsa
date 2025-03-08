class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      Set<String> results = new HashSet<>();
      int k = 10;
      int start = 0;
      int end = start + k;
      int lastIndex = s.length() - 1;
      Set<String> subStrSet = new HashSet<>();
      while (end <= lastIndex) {
        String subStr = s.substring(start, end);
        if (subStrSet.contains(subStr)) {
          results.add(subStr);
        } else {
          subStrSet.add(subStr);
        }
        start++;
        end++;
      }



      return results.stream().toList();
    }
}