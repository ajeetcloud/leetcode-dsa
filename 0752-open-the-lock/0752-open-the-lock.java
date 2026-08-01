class Solution {
    public int openLock(String[] deadends, String target) {

        String start = "0000";

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new ArrayDeque<>();

        if (visited.contains(start)) {
            return -1;
        }

        queue.offer(start);
        visited.add(start);
        int level = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();
                if (target.equals(current)) {
                    return level;
                }

                List<String> neighbors = getNeighbors(current);
                for (String neighbor: neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private List<String> getNeighbors(String current) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < current.length(); i++) {
            char[] nextChars = getNextChars(current.charAt(i));

            String neighbor1 = current.substring(0, i) + nextChars[0] + current.substring(i + 1);
            String neighbor2 = current.substring(0, i) + nextChars[1] + current.substring(i + 1);

            result.add(neighbor1);
            result.add(neighbor2);
        }
        return result;
    }

    private char[] getNextChars(char c) {

        char[] result = new char[2];

        result[0] = (c == '0') ? '9' : (char)(c - 1);
        result[1] = (c == '9') ? '0' : (char)(c + 1);

        return result;
    }

}