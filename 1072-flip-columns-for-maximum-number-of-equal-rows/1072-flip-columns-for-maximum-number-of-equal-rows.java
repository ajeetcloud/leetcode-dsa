class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        Map<String, Integer> patternCount = new HashMap<>();
        int maxCount = 0;

        for (int[] row: matrix) {
            int first = row[0];
            StringBuilder sb = new StringBuilder();
            for (int val: row) {
                sb.append(val ^ first);
            }
            String key = sb.toString();
            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
            maxCount = Math.max(maxCount, patternCount.get(key));
        }

        return maxCount;

    }
}