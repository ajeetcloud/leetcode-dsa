class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        int i = 1;
        while (i < intervals.length) {
            int[] lastInserted = result.getLast();
            int[] currentInterval = intervals[i];
            if (lastInserted[1] >= currentInterval[0]) {
                // overlap -> merge
                lastInserted[1] = Math.max(lastInserted[1], currentInterval[1]);
            } else {
                result.add(currentInterval);
            }
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}