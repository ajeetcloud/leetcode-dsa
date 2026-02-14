class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } 
            else {
                return new int[]{-1, -1};
            }
        }

        return new int[]{getStartIndex(nums, target), getEndIndex(nums, target)};
    }


    private int getStartIndex(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (nums[mid] >= target) {
                endIndex = mid - 1;
            }
            else {
                startIndex = mid + 1;
            }

        }
        if (nums[startIndex] == target) {
            return startIndex;
        }
        return -1;
    }

    private int getEndIndex(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (nums[mid] <= target) {
                startIndex = mid + 1;
            }
            else {
                endIndex = endIndex - 1;
            }

        }
        if (nums[endIndex] == target) {
            return endIndex;
        }
        return -1;
    }
}