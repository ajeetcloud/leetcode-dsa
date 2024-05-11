class Solution {
    public int maxSubArray(int[] nums) {
      int maxSum = nums[0];
      int overallSum = nums[0];
      int curr = 0;
      for (int i = 1; i < nums.length; i++) {
        overallSum += nums[i];
        curr = nums[i];
        if (overallSum < nums[i]) {
          overallSum = nums[i];
        }
        if (overallSum > maxSum) {
          maxSum = overallSum;
        }
      }

      return maxSum;
    }
}