class Solution {
    public String smallestSubsequence(String s) {

        // Monotonic stack -> a, b, c(top)
        Deque<Character> stack = new ArrayDeque<>();
        int[] count = new int[26];

        boolean[] inStack = new boolean[26];

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c: s.toCharArray()) {

            count[c - 'a']--;
            if (inStack[c - 'a']) {
                continue;
            }
            char currentChar = c;
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {

                inStack[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
        
    }
}