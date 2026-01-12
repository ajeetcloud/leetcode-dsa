class Solution {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // for storing endtime

        int result = 1;
        minHeap.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int minEndTimeHeap = minHeap.peek();
            int currentStartTime =  currentInterval[0];
            if (minEndTimeHeap > currentStartTime) {
                result++;
            } else {
                minHeap.poll();
            }
            minHeap.offer(currentInterval[1]);
        }
        return minHeap.size();
    }
}