record Triplet(int sum, int i, int j){}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.sum(), b.sum()));
        Triplet firstAnswer = new Triplet(nums1[0] + nums2[0], 0 , 0);
        pq.offer(firstAnswer);
        seen.add("0,0");
        int count = 0;
        while (!pq.isEmpty() && count < k) {
            Triplet takeout = pq.poll();
            count++;
            int takeout_i = takeout.i();
            int takeout_j = takeout.j();

            result.add(Arrays.asList(nums1[takeout_i], nums2[takeout_j]));

            if (takeout_j + 1 < nums2.length) {
                Triplet ans1 = new Triplet(nums1[takeout_i] + nums2[takeout_j + 1], takeout_i, takeout_j + 1);
                if (!seen.contains(takeout_i + "," + (takeout_j + 1))) {
                    pq.offer(ans1); 
                    seen.add(takeout_i + "," + (takeout_j + 1));
                }  
            }     
            if (takeout_i + 1 < nums1.length) {
                Triplet ans2 = new Triplet(nums1[takeout_i + 1] + nums2[takeout_j], takeout_i + 1, takeout_j);
                if (!seen.contains((takeout_i + 1) + "," + takeout_j)) {
                    pq.offer(ans2);
                    seen.add((takeout_i + 1) + "," + takeout_j);     
                }
            } 
        }
        return result;
    }
} 