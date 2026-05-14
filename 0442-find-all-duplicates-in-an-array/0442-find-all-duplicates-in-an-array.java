class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        int i = 0;

        // Phase 1
        while (i < nums.length) {
            int targetIdx = nums[i] - 1;
            if (nums[i] == nums[targetIdx]) {
                i++;
            }
            else {
                swap(nums, i, targetIdx);
            }
        }

        List<Integer> result = new ArrayList<>();

        // Phase 2
        for (int k = 0; k < nums.length; k++) {
            int num = nums[k];
            if (num != k + 1) {
                result.add(num);
            }
        }
        return result;
    }

    private void swap (int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}