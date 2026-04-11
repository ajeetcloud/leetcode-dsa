class Solution {
    public int rob(int[] nums) {

        return spaceOptimalDP(nums);

        // return normalDP(nums);
    }

    private int spaceOptimalDP(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int option1 = nums[0];
        int option2 = Math.max(nums[0], nums[1]);
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            option1 = nums[i] + option1;
            option1 = Math.max(option1, option2);
            
            // swap option1 & option2
            int temp = option1;
            option1 = option2;
            option2 = temp;

        }
        return Math.max(option1, option2);

    }

    private int normalDP(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}