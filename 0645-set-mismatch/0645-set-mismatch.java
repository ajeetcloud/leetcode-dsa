class Solution {
    public int[] findErrorNums(int[] nums) {

        int i = 0;
        // 1st iteration
        while (i < nums.length) {
            int idx = nums[i] - 1;
            if (nums[idx] == nums[i]) {
                i++;
            } else {
                swap(nums, i, idx);
            }
        }

        int duplicate = -1;
        int missing = -1;
        // 2nd iteration
        for (i = 0; i < nums.length; i++) {
            int idx = nums[i] - 1;
            if (idx != i) {
                duplicate = nums[i];
                missing = i + 1;
                return new int[] {duplicate, missing};
            }
        }
        return new int[] {-1, -1};
    }

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}