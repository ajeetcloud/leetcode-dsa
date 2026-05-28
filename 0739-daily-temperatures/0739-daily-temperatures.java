class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            int currTemp = temperatures[i];

            while (!stack.isEmpty() && currTemp > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);

        }
        
        return result;
    }
}