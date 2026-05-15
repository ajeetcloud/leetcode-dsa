class Solution {

    // Slow fast pointer approach
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    // Cyclic Sort - Inplace(modifies array)
    public int findDuplicate1(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int targetIdx = nums[i] - 1;
            if (nums[i] != nums[targetIdx]) {
                swap(nums, i, targetIdx);
            } else {
                i++;
            }
        }

        // Phase 2
        for (int k = 0; k < nums.length; k++) {
            int num = nums[k];
            if (num != k + 1) {
                return num;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}