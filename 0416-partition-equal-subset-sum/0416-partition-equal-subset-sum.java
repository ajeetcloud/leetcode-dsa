class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int n: nums) {
            sum = sum + n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        // DP solution
        return dp(nums, target);

        /*
        // Memoization solution
        Arrays.sort(nums);
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return bt(nums, 0, target, memo);
        */

    }

    private boolean dp(int[] nums, int target) {

        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[nums.length][0] = true; // rest all columns in this row should be 0.

        // recurrence relation
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j <= target; j++) {
                 dp[i][j] = dp[i + 1][j];
                if (j >= nums[i] && !dp[i][j]) {
                    dp[i][j] = dp[i + 1][j - nums[i]];
                }
            }
        }
        return dp[0][target];
    }

    // This is memoization
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

        // (i + 1, j - nums[i]) || (i + 1, j)
        memo[index][target] = bt(nums, index + 1, target - nums[index], memo) || 
                bt(nums, index + 1, target, memo);

        return memo[index][target];
    }
}