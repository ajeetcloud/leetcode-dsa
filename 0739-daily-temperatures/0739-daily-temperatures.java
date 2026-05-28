class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];

            while (!stack.isEmpty() && currTemp > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        // For all leftovers in the stack, set result[stack.poll()] = 0
        // but not needed as stack by int array by default gets seeded with 0
        
        return result;
    }
}