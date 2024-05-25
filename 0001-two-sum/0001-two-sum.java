
class Solution {

    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      int[] result = new int[2];
      for (int i = 0; i < nums.length; i++) {
        int number = nums[i];
        int rem = target - number;
        if (map.containsKey(rem)) {
          result[0] = i;
          result[1] = map.get(rem);
        } else {
          map.put(number, i);
        }
      }
      return result;
    }
}