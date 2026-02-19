class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        backtrackCombinations(digits, 0, getMap(), new StringBuilder(), result);
        return result;
    }

    public void backtrackCombinations(String digits, int startIndex, Map<Character, String> map, StringBuilder temp, List<String> result) {

        if (startIndex == digits.length()) {
            result.add(temp.toString());
            return;
        }

        String str = map.get(digits.charAt(startIndex));
        for (int i = 0; i < str.length(); i++) {

            temp.append(str.charAt(i)); // Choose
            backtrackCombinations(digits, startIndex + 1, map, temp, result); // Recurse
            temp.deleteCharAt(temp.length() - 1); // Unchoose
        }

    }

    public Map getMap() {

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return map;
    }
}