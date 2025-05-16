class Solution {
    // Greedy
    public int minMeetingRooms(int[][] intervals) {
        int[]startTimes = new int[intervals.length];
        int[]endTimes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
          startTimes[i] = intervals[i][0];
          endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int i = 0;
        int j = 0;
        int max = 0;
        int count = 0;
        while (i < startTimes.length && j < startTimes.length) {
          if (startTimes[i] < endTimes[j]) {
            count++;
            max = Math.max(max, count);
            i++;
          } else {
            count--;
            j++;
          }
        }
      return max;
    }
}