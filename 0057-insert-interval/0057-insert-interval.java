class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> list = new ArrayList<>();
      int find = newInterval[0];
      int left = 0;
      int right = intervals.length - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (intervals[mid][0] < find) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      // left is the insert position
      for (int i = 0; i < left; i++) {
        list.add(intervals[i]);
      }
      list.add(newInterval);
      for (int i = left; i < intervals.length; i++) {  
        list.add(intervals[i]);
      }
      // merge interval
      LinkedList<int[]> result = new LinkedList<>();
      result.add(list.get(0));
      for (int i = 1; i < list.size(); i++) {
        int[] interval = list.get(i);
        int[] lastResult = result.getLast();
        if (interval[0] <= lastResult[1]) {
          // merge
          lastResult[1] = Math.max(lastResult[1], interval[1]);
        } else {
          result.add(interval);
        }
      }
      return result.toArray(new int[result.size()][]);
    }
}