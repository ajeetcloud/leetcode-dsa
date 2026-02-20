class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new HashSet<>(), result);
        
        return result;
    }

    public void backtrack(int[] nums, List<Integer> temp, Set<Integer> set, List<List<Integer>> result) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                // Choose
                temp.add(nums[i]);
                set.add(nums[i]);

                // Recurse
                backtrack(nums, temp, set, result);

                // Unchoose
                set.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }

    }
}