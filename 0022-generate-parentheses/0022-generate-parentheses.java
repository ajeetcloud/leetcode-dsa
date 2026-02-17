class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);

        return result;
    }

    private void backtracking(List<String> result, String str, int leftCount, int rightCount, int n) {

        if (str.length() == (2 * n)) {
            result.add(str);
            return;
        }
        if (leftCount < n) {
            backtracking(result, str + "(", leftCount + 1, rightCount, n);
        }
        if (rightCount < leftCount) {
            backtracking(result, str + ")", leftCount, rightCount + 1, n);
        }
    }

}