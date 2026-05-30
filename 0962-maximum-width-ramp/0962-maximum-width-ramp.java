class Solution {

    // Stack solution
    public int maxWidthRamp(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();

        // Phase 1 - populating the stack with Indices of decreasing values
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[stack.peek()] > nums[i] || stack.isEmpty()) {
                stack.push(i);
            } 
        }

        int maxResult = 0;
        // Phase 2
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {

                int left = stack.pop();
                maxResult = Math.max(maxResult, j - left);
            }
        }
        return maxResult;
    }

    // This is nlogn solution, less optimal but more intuitive
    public int maxWidthRamp1(int[] nums) {

        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]): 
            Integer.compare(a, b));

        int minIndexSeenTillNow = nums.length;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int currIndex = indices[i];
            minIndexSeenTillNow = Math.min(minIndexSeenTillNow, indices[i]);

            int diff = currIndex - minIndexSeenTillNow;

            result = Math.max(result, diff);
        }
        return result;
        
    }
}