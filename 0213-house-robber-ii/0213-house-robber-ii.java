class Solution {
    public int rob(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }
      int lastIndex = nums.length - 1;
      int ans1 = robSimple(nums, 0, lastIndex - 1);
      int ans2 = robSimple(nums, 1, lastIndex);

      return Math.max(ans1, ans2);
    }

     public int robSimple(int[] nums, int startIndex, int endIndex) {
        int storage[] = new int[endIndex - startIndex + 1];
        if (storage.length == 1) {
          return nums[startIndex];
        }
        storage[0] = nums[startIndex];
        storage[1] = Math.max(nums[startIndex], nums[startIndex + 1]);
        for (int i = 2; i < storage.length; i++) {
          storage[i] = Math.max(storage[i - 1], nums[i + startIndex] + storage[i - 2]);
        }
        return storage[storage.length - 1];
     }

}