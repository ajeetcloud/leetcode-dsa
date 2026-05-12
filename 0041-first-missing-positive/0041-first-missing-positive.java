class Solution {



    
    public int firstMissingPositive(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int idx = nums[i] - 1;
            if (idx < 0 || idx >= nums.length) {
                i++;
            } 
            else if (nums[i] != nums[idx]) {
                swap(nums, i, idx);
            } 
            else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            int num = nums[k];
            if (num != k + 1) {
                return k + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}