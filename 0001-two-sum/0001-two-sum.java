
class Solution {

    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int number = nums[i];
        int rem = target - number;
        if (map.containsKey(rem)) {
          return new int[] { map.get(rem), i };
        } 
        map.put(number, i);
      }
      return null;
    }
}