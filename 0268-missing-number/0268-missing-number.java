class Solution {
    public int missingNumber(int[] nums) {
        
        int i = 0;
        while (i < nums.length) {
            int idx = nums[i];
            if (idx == nums.length || nums[i] == nums[idx]) {
                i++; 
            } else {
                swap(nums, i, idx);
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (k != nums[k]) {
                return k;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}