class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int midEven = left + (right - left) / 2;
            if (midEven % 2 == 1) {
                midEven--;
            }
            if (nums[midEven] == nums[midEven + 1]) {
                // answer is in second half
                left = midEven + 2;
            } else {
                right = midEven;
            }
        }
        return nums[left]; 
    }
}