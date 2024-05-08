class Solution {
    public void sortColors(int[] nums) {
      // sort 0
      int lastIndex= nums.length - 1;
      int zeroIndex = 0;
      int i = 0;
      while (i <= lastIndex) {
        if (nums[i] == 0) {
          // swap
          int temp = nums[i];
          nums[i] = nums[zeroIndex];
          nums[zeroIndex] = temp;
          zeroIndex++;
        }
        i++;
      }
      // sort 2
      int j = lastIndex;
      int twoIndex = lastIndex;
      while (j >= 0) {
        if (nums[j] == 2) {
          // swap
          int temp = nums[j];
          nums[j] = nums[twoIndex];
          nums[twoIndex] = temp;
          twoIndex--;
        }
        j--;
      }
        
    }
}