class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < citations.length; i++) {
            int citation = citations[i];
            int papers = n - i;
            if (citation >= papers) {
                return papers;
            }
        }
        return 0;
    }
}