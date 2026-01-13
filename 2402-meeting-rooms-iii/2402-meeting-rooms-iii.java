class RoomInfo {

    long meetingEndtime;
    int roomNumber;

    public RoomInfo(long meetingEndtime, int roomNumber) {
        this.meetingEndtime = meetingEndtime;
        this.roomNumber = roomNumber;
    }
}


class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] freqMap = new int[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<RoomInfo> usedRooms = new PriorityQueue<>(
            (a, b) -> a.meetingEndtime != b.meetingEndtime 
            ? Long.compare(a.meetingEndtime, b.meetingEndtime)
            : Integer.compare(a.roomNumber, b.roomNumber));

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }
        for (int i = 0; i < meetings.length; i++) {
            long currentStart = meetings[i][0];
            long currentEnd = meetings[i][1];
            // freeing up used rooms is important
            while (!usedRooms.isEmpty() && currentStart >= usedRooms.peek().meetingEndtime) {
                RoomInfo roomToBeMadeAvailable = usedRooms.poll();
                availableRooms.offer(roomToBeMadeAvailable.roomNumber);
            }
            if (!availableRooms.isEmpty()) {
                int roomNo = availableRooms.poll();
                usedRooms.offer(new RoomInfo(currentEnd, roomNo));
                freqMap[roomNo]++;
            } else {
                // check for earliest available room
                if (!usedRooms.isEmpty()) {
                    RoomInfo nextAvailableRoom = usedRooms.poll();
                    int nextAvailableRoomNo = nextAvailableRoom.roomNumber;
                    long nextMeetingEndtime = nextAvailableRoom.meetingEndtime;
                    RoomInfo currentMeeting = new RoomInfo(nextMeetingEndtime + currentEnd - currentStart, nextAvailableRoomNo);
                    usedRooms.offer(currentMeeting);
                    freqMap[nextAvailableRoomNo]++;
                }
            }
        }
        int maxMeetings = 0;
        int roomNumberResult = -1;
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] > maxMeetings) {
                maxMeetings = freqMap[i];
                roomNumberResult = i;
            }
        }
        return roomNumberResult;
    }
}