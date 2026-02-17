class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        // return getSubsets(nums, 0, nums.length - 1);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }


    // Backtracking is more space optimal
    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }




    // Not an optimal solution, involves keeping List in memory
    private List<List<Integer>> getSubsets(int[] nums, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            List<List<Integer>>base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        int currentNumber = nums[startIndex];
        List<List<Integer>> smallAns = getSubsets(nums, startIndex + 1, endIndex);

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(smallAns);

        for (List smallList: smallAns) {
            List<Integer> newList = new ArrayList<>(smallList);
            newList.add(currentNumber);
            result.add(newList);
        }
        return result;
    }
}