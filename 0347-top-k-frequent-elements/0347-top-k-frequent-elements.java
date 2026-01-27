class Solution {

    // Bucket Sort
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] freqBuckets = new List[nums.length + 1];
        for (int i = 0; i < freqBuckets.length; i++) {
            freqBuckets[i] = new ArrayList<>();
        } 
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            freqBuckets[entry.getValue()].add(entry.getKey()); 
        }
        List<Integer> flattened = new ArrayList<>();
        for (int i = freqBuckets.length - 1; i >= 0; i--) {
            for (int n: freqBuckets[i]) {
                flattened.add(n);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = flattened.get(i);
        }
        return result;
    }

    public int[] topKFrequent1(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> freqMinHeap = new PriorityQueue<>((a, b) -> Integer.compare(freqMap.get(a), freqMap.get(b)));
        
        for (int num: freqMap.keySet()) {
            freqMinHeap.offer(num);
            if (freqMinHeap.size() > k) {
                freqMinHeap.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!freqMinHeap.isEmpty()) {
            result[i++] = freqMinHeap.poll();
        }
        return result;
    }
}