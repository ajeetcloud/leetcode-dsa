class Solution {

    // This is nlogn solution, less optimal but more intuitive
    public int maxWidthRamp(int[] nums) {

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