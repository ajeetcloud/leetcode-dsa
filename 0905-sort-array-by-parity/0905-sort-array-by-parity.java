class Solution {
    public int[] sortArrayByParity(int[] nums) {
      int evenIndex = 0;
      int i = 0;
      while (i < nums.length) {
        int num = nums[i];
        if (num % 2 == 0) {
          // swap
          int temp = nums[evenIndex];
          nums[evenIndex] = nums[i];
          nums[i] = temp;
          evenIndex++;
        }
        i++;
      }
      return nums; 
    }
}