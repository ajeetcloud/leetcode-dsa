class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        int i = 0;
        while (i <= nums.length - 1) {
          if (nums[i] != 0) {
            nums[k] = nums[i];
            k++;
          } 
          i++;
        }
        for (int j = k; j < nums.length; j ++) {
          nums[j] = 0;
        }
    }
}