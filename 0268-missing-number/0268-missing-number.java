class Solution {

    // Math approach
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int sum = (int) (n * (n + 1) / 2);

        int actualSum = Arrays.stream(nums).sum();

        return sum - actualSum;
    }

    // Cyclic Sort
    public int missingNumber1(int[] nums) {
        
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