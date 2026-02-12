class Solution {
    public int findPeakElement(int[] nums) {
        
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            boolean isLeftSmaller = (mid == 0) || (nums[mid] > nums[mid - 1]);
            boolean isRightSmaller = (mid == nums.length - 1) || (nums[mid] > nums[mid + 1]);
            if (isLeftSmaller && isRightSmaller) {
                return mid;
            } 
            else if (nums[mid + 1] > nums[mid]) {
                startIndex = mid + 1;
            }
            else {
                endIndex = mid - 1;
            }
        }
        return -1;
    }
}