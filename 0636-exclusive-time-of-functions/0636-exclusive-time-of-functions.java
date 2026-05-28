

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        int prevTime = 0;

        for (String log: logs) {

            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            String type = split[1];
            int time = Integer.parseInt(split[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    int timeDiff = time - prevTime;
                    result[stack.peek()] += timeDiff;
                } 
                prevTime = time;
                stack.push(id);
            } 
            else {
                result[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return result;
    }
}