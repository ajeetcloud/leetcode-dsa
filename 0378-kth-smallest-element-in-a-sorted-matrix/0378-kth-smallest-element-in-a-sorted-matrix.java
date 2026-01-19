record Triplet(int num, int i, int j) {}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.num(), b.num()));
        int n = matrix.length;

        // Optimised version of solution
        // Rather than moving right and down, with this we just jhave to move right
        // No need for visited Set
        for (int i = 0; i < n; i++) {
            Triplet triplet = new Triplet(matrix[i][0], i, 0);
            pq.offer(triplet);
        }

        while (!pq.isEmpty() && k > 0) {
            Triplet takeout = pq.poll();
            k--;
            if (k == 0) {
                return takeout.num();
            }
            int nextCol = takeout.j() + 1;
            if (nextCol < n) {
                Triplet nextTripletInSameRow = new Triplet(matrix[takeout.i()][nextCol], takeout.i(), nextCol);
                pq.offer(nextTripletInSameRow);
            }
        }
       return 0; 
    }
}