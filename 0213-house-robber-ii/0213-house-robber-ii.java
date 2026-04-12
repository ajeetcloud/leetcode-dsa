class Solution {

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int endIndex = nums.length - 1;
        return Math.max(robLinear(nums, 0, endIndex - 1), robLinear(nums, 1, endIndex));
    }

    private int robLinear(int[] nums, int startIndex, int endIndex) {

        int prevPrev = nums[startIndex];
        int prev = Math.max(nums[startIndex], nums[startIndex + 1]);

        for (int i = startIndex + 2; i <= endIndex; i++) {
            
            int current = Math.max(nums[i] + prevPrev, prev);
            prevPrev = prev;
            prev = current;
        }
        return prev;
    }
}