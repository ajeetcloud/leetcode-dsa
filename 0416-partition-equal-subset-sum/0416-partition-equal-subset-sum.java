class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int n: nums) {
            sum = sum + n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return bt(nums, 0, target, memo);
    }

    private boolean bt(int[] nums, int index, int target, Boolean[][] memo) {

        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (index >= nums.length) {
            return false;
        }

        if (memo[index][target] != null) {
            return memo[index][target];
        }

        memo[index][target] = bt(nums, index + 1, target - nums[index], memo) || 
                bt(nums, index + 1, target, memo);

        return memo[index][target];
    }
}