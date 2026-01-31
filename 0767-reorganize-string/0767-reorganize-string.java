record Pair(char c, int freq){}

class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int maxAllowed = (s.length() + 1) / 2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int freqValue = freqMap.getOrDefault(c, 0) + 1;
            if (freqValue > maxAllowed) {
                return "";
            }
            freqMap.put(c, freqValue);
        }

        PriorityQueue<Pair> freqMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq(), a.freq()));
        for (char c: freqMap.keySet()) {
            Pair pair = new Pair(c, freqMap.get(c));
            freqMaxHeap.offer(pair);
        }

        StringBuilder result = new StringBuilder();
        Pair prev = null;
        while (!freqMaxHeap.isEmpty()) {
            Pair takeout = freqMaxHeap.poll();
            int takeoutFreq = takeout.freq();
            result.append(takeout.c());

            if (prev != null) {
                freqMaxHeap.offer(prev);
                prev = null;
            }

            if (takeoutFreq - 1 > 0) {
                prev = new Pair(takeout.c(), takeoutFreq - 1);
            }
        }
        return result.toString();
    }
}