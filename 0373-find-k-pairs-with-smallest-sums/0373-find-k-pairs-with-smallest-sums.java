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
            int i = takeout.i();
            int j = takeout.j();

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length && !seen.contains(i + "," + (j + 1))) {
                Triplet ans1 = new Triplet(nums1[i] + nums2[j + 1], i, j + 1);
                pq.offer(ans1); 
                seen.add(i + "," + (j + 1)); 
            }     
            if (i + 1 < nums1.length && !seen.contains((i + 1) + "," + j)) {
                Triplet ans2 = new Triplet(nums1[i + 1] + nums2[j], i + 1, j);
                pq.offer(ans2);
                seen.add((i + 1) + "," + j);     
            } 
        }
        return result;
    }
} 