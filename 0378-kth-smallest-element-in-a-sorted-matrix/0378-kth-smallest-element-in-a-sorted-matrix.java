record Triplet(int num, int i, int j) {}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int smallestNum = matrix[0][0];
        int n = matrix.length;
        Triplet smallestTriplet = new Triplet(smallestNum, 0, 0);
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.num(), b.num()));
        pq.offer(smallestTriplet);
        Set<Pair> seen = new HashSet<>();
        seen.add(new Pair<>(0,0));
        while (!pq.isEmpty() && k > 0) {
            Triplet takeout = pq.poll();
            k--;
            int i = takeout.i();
            int j = takeout.j();
            if (k == 0) {
                return takeout.num();
            }

            Pair pair1 = new Pair<>(i + 1, j);
            if (i + 1 < n && !seen.contains(pair1)) {
                Triplet triplet1 = new Triplet(matrix[i + 1][j] , i + 1, j);
                pq.offer(triplet1);
                seen.add(pair1);
            }
            Pair pair2 = new Pair<>(i, j + 1);
            if (j + 1 < n && !seen.contains(pair2)) {
                Triplet triplet2 = new Triplet(matrix[i][j + 1] , i, j + 1);
                pq.offer(triplet2);
                seen.add(pair2);
            }
        }
        return 0;
    }
}