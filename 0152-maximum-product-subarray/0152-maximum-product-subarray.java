class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int currentNum = nums[i];
            int candidate1 = currentNum * maxDp[i - 1];
            int candidate2 = currentNum * minDp[i - 1];

            maxDp[i] = Math.max(currentNum, Math.max(candidate1, candidate2));
            minDp[i] = Math.min(currentNum, Math.min(candidate1, candidate2));

            result = Math.max(result, maxDp[i]);
        }

        return result;
    }
}