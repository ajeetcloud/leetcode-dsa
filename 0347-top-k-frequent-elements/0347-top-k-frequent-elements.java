class Solution {
    public int[] topKFrequent(int[] nums, int k) {

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