class Solution {
    public int mostBooked(int n, int[][] meetings) {

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>(); // stores room numbers
        PriorityQueue<int[]> occupiedRooms = new PriorityQueue<>((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); // stores availability(end) time, room number
        int[] meetingCount = new int[n];
        Arrays.sort(meetings, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }
        for (int[] meeting: meetings) {
            int start = meeting[0];
            int end = meeting[1];
            // update occupiedRooms & freeRooms
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start) {
                int roomNumber = (int) occupiedRooms.poll()[1]; // roomNumber
                freeRooms.offer(roomNumber);
            }
            if (!freeRooms.isEmpty()) {
                int roomNumber = freeRooms.poll();
                occupiedRooms.offer(new int[]{end, roomNumber});
                meetingCount[roomNumber]++;
            } else {
                int[] takeout = occupiedRooms.poll();
                int takeoutEndtime = takeout[0];
                int takeoutRoom = takeout[1];

                int newEndtime = takeoutEndtime + (end - start);
                occupiedRooms.offer(new int[]{newEndtime, takeoutRoom});
                meetingCount[takeoutRoom]++;
            }
        }

        int maxCount = 0;
        int resultRoom = 0;
        for (int i = 0; i < meetingCount.length; i++) {
            if (meetingCount[i] > maxCount) {
                maxCount = meetingCount[i];
                resultRoom = i;
            }
        }
        return resultRoom;
    }
}