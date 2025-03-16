class Solution {
  public int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> result = new LinkedList<>();
    result.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      int[] lastResult = result.getLast();
      if (interval[0] <= lastResult[1]) {
        // overlap -> merge
        lastResult[1] = Math.max(lastResult[1], interval[1]);
      } else {
        result.add(interval);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}