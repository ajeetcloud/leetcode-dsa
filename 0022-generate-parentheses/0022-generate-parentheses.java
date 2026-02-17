class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        backtracking(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void backtracking(List<String> result, StringBuilder str, int leftCount, int rightCount, int n) {

        if (str.length() == (2 * n)) {
            result.add(str.toString());
            return;
        }
        if (leftCount < n) {
            backtracking(result, str.append("("), leftCount + 1, rightCount, n);
            str.deleteCharAt(str.length() - 1);
        }
        if (rightCount < leftCount) {
            backtracking(result, str.append(")"), leftCount, rightCount + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }

}