class Solution {
  public int[][] merge(int[][] intervals) {
    List<int[]> list = new ArrayList<>();
    list.add(intervals[0]);
    int i = 1;
    int currList = 0;
    while (i <= intervals.length - 1) {
      int[] curr = list.get(currList);
      int[] currInterval = intervals[i];
      if (currInterval[0] <= curr[1]) {
        // merge
        curr[1] = Math.max(curr[1], currInterval[1]);
      } else {
        list.add(currInterval);
        currList++;
      }
      i++;
    }
    return list.toArray(new int[list.size()][]);
  }
}