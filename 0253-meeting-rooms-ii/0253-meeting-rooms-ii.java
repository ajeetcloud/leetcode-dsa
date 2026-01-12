class Solution {
    
    public int minMeetingRooms1(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // for storing endtime

        int result = 1;
        minHeap.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int minEndTimeHeap = minHeap.peek();
            int currentStartTime =  currentInterval[0];
            // find the maximum overlap, that is the answer
            if (minEndTimeHeap > currentStartTime) {
                result++; // need a new room
            } else {
                minHeap.poll(); // don't need a new room
            }
            minHeap.offer(currentInterval[1]);
        }
        return minHeap.size(); // can return result also
    }

     public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int rooms = 0;
        int j = 0;
        for (int i = 0; i < startTimes.length; i++) {
            if (startTimes[i] < endTimes[j]) {
                rooms++;
            } else {
                j++;
            }
        }
        return rooms;
     }
}