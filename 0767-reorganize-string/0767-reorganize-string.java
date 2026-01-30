record Pair(char c, int freq){}

class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> freqMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq(), a.freq()));
        for (char c: freqMap.keySet()) {
            Pair pair = new Pair(c, freqMap.get(c));
            freqMaxHeap.offer(pair);
        }

        String result = "";
        char currentChar = '-';

        while (!freqMaxHeap.isEmpty()) {
            Pair takeout = freqMaxHeap.poll();
            char newChar = takeout.c();
            int newCharFreq = takeout.freq();
            if (currentChar != newChar) {
                result += newChar;
                currentChar = newChar;
                newCharFreq = newCharFreq - 1;
                if (newCharFreq > 0) {
                    freqMaxHeap.offer(new Pair(newChar, newCharFreq));
                }
            } else {
                if (freqMaxHeap.isEmpty()) {
                    return "";
                }
                Pair nextTakeout = freqMaxHeap.poll();
                char nextChar = nextTakeout.c();
                int nextCharFreq = nextTakeout.freq();
                result += nextChar;
                currentChar = nextChar;
                nextCharFreq = nextCharFreq - 1;
                if (nextCharFreq > 0) {
                    freqMaxHeap.offer(new Pair(nextChar, nextCharFreq));
                }
                freqMaxHeap.offer(takeout);
            }
        }
        return result;
    }
}