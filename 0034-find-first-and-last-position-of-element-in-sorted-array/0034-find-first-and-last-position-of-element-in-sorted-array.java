class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{ getOptimisedIndex(nums, target, true), getOptimisedIndex(nums, target, false) };
    }

    private int getOptimisedIndex(int[] nums, int target, boolean findFirst) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {

            int mid = startIndex + (endIndex - startIndex ) / 2;
            if (nums[mid] == target) {

                if (findFirst) {
                    // Finds first occurrence
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                    endIndex = mid - 1;
                }
                else {
                    // Finds last occurrence
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    }
                    startIndex = mid + 1;
                }
            } 
            else if (nums[mid] > target) {
                endIndex = mid - 1;
            }
            else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    private int getBoundary(int[] nums, int target, boolean findFirst) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if ((nums[mid] == target && findFirst) || (nums[mid] > target)) {
                endIndex = mid - 1;
            }
            else {
                startIndex = mid + 1;
            }

        }
        if (findFirst) {
            if (startIndex < nums.length && nums[startIndex] == target) {
                return startIndex;
            }
        } else {
            if (endIndex >= 0 && nums[endIndex] == target) {
                return endIndex;
            }
        }
        return -1;
    }
}