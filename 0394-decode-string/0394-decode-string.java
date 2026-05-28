class Solution {
    public String decodeString(String s) {

        // Use 2 Stacks
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            } else if (c == '['){
                countStack.push(currentNumber);
                stringStack.push(currentString);

                currentNumber = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                int num = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < num; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}