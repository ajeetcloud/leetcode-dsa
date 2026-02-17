class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        return getSubsets(nums, 0, nums.length - 1);
    }

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