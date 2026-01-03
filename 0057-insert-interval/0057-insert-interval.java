class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end = intervals.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (intervals[mid][0] < newInterval[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // insert at start position
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < start; i++) {
            list.add(intervals[i]);
        }
        list.add(newInterval);
        for (int i = start; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        // invoke merge interval
        return mergeInterval(list.toArray(new int[list.size()][]));
    }

    public int[][] mergeInterval(int[][] intervals) {
        LinkedList<int[]>result = new LinkedList<>();
        result.add(intervals[0]);
        int i = 1;
        while (i < intervals.length) {
            int[] lastInserted = result.getLast();
            int[] currentInterval = intervals[i];
            if (lastInserted[1] >= currentInterval[0]) {
                // merge
                lastInserted[1] = Math.max(lastInserted[1], currentInterval[1]);
            } else {
                result.add(currentInterval);
            }
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
