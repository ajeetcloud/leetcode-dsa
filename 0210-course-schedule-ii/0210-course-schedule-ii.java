class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Indegree of each course
        int[] indegree = new int[numCourses];

        // Queue - ArrayDeque is faster than LinkedList
        Deque<Integer> queue = new ArrayDeque<>();

        for (int[] p: prerequisites) {
            int prereq = p[1];
            int course = p[0];
            indegree[course]++;
            adj.get(prereq).add(course);

        }

        // Seed the Queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[idx++] = node;

            // One course is covered, so reduce the indegree of its neighbors
            for (int neighbor: adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }

            
        }

        if (idx != numCourses) {
            return new int[0];
        }
        
        return result;
    }
}

