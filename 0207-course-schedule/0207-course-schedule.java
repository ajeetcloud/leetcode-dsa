class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesCovered = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll(); // course is consumed, reduce its neighbors indegree
            nodesCovered++;

            for (int neighbor: adj.get(course)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (nodesCovered == numCourses) {
            return true;
        }

        return false;
    }
}