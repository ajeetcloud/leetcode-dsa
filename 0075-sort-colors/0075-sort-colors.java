class Solution {
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        while (i <= p2) {
            if (nums[i] == 2) {
                // swap
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            } else if (nums[i] == 0) {
                // swap
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            }
        }
    }
}