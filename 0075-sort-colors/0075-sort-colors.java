class Solution {
    public void sortColors(int[] nums) {
      int lastIndex = nums.length - 1;
      int p0 = 0;
      int p2 = lastIndex;
      int temp = 0;
      int i = 0; // current element
      while (i <= p2) {
        if (nums[i] == 0) {
          // swap
          temp = nums[i];
          nums[i] = nums[p0];
          nums[p0] = temp;
          p0++;
          i++;
        } else if (nums[i] == 2) {
          // swap
          temp = nums[i];
          nums[i] = nums[p2];
          nums[p2] = temp;
          p2--;
        } else if (nums[i] == 1) {
          i++;
        }

      }
      
        
    }
}