class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, new ArrayList<>(), result, target, 0);
        
        return result;
    }

    public void backtrack(int[] candidates, List<Integer> temp, List<List<Integer>> result, int target, int startIndex) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            // Choose
            temp.add(num);

            // Rercurse
            backtrack(candidates, temp, result, target - num, i);

            // Unchoose
            temp.remove(temp.size() - 1);
        }

    }

}