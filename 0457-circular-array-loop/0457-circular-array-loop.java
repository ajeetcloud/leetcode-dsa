class Solution {
    public boolean circularArrayLoop(int[] nums) {

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;
            while (true) {
                slow = nextStep(slow, nums[slow], size);
                if (!isCycle(nums, forward, slow)) {
                    break;
                }
                fast = nextStep(fast, nums[fast], size);
                if (!isCycle(nums, forward, fast)) {
                    break;
                }
                fast = nextStep(fast, nums[fast], size);
                if (!isCycle(nums, forward, fast)) {
                    break;
                }
                if (slow == fast) {
                    return true;
                }
            }
        }
        return false;
    }

    public int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0) {
            result = size + result;
        }
        return result;
    }

    public boolean isCycle(int[] nums, boolean prevDirection, int pointer) {
        boolean currDirection = nums[pointer] >= 0;

        if (currDirection != prevDirection) {
            return false;
        }
        if (nums[pointer] % nums.length == 0) {
            return false;
        }
        return true;
    }
}