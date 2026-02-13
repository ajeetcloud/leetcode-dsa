class Solution {
    public int findMin(int[] nums) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        // no rotation case
        if (nums[startIndex] < nums[endIndex]) {
            return nums[startIndex];
        }

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // Fixed reference in Rotated Array - 0
            if (nums[mid] > nums[0]) {
                startIndex = mid + 1;
            }
            else {
                endIndex = mid - 1;
            }
        }
        return -1;
    }
}