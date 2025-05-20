class Solution {

    public int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      int i = 0;
      while (i < intervals.length) {
        int startTime = intervals[i][0];
        int endTime = intervals[i][1];
        if (!minHeap.isEmpty() && startTime >= minHeap.peek()) {
          minHeap.poll();
        }
        minHeap.offer(endTime);
        i++;
      }
      return minHeap.size();
    }

    // Greedy
    public int minMeetingRoomsGreedy(int[][] intervals) {
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