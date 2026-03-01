class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int startIndex = 1;

        backtrack(result, temp, k, n, startIndex);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int n, int startIndex) {

        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            temp.add(i); // Choose
            backtrack(result, temp, k - 1, n, i + 1); // Recurse
            temp.remove(temp.size() - 1); // Unchoose
        }
    }
}