class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int i = 0;
        int evenIndex = 0;
        int oddIndex = 1;
        int n = nums.length;
        while (evenIndex < n && oddIndex < n) {
            if (nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            } 
            else if (nums[oddIndex] % 2 != 0) {
                oddIndex += 2;
            } 
            else {
                swap(nums, evenIndex, oddIndex);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}