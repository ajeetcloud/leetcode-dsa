class Solution {
    public int minimumSemesters(int n, int[][] relations) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < relations.length; i++) {
            int prev = relations[i][0];
            int next = relations[i][1];
            adj.get(prev).add(next);
            indegree[next]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        // Seed the queue
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int sem = 0;
        int processed = 0;

        while (!queue.isEmpty()) {
            sem++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int course = queue.poll();
                processed++;
                for (int req: adj.get(course)) {
                    indegree[req]--;
                    if (indegree[req] == 0) {
                        queue.offer(req);
                    }
                }
            }

        }
        if (processed != n) {
            return -1;
        }
        return sem;
    }
}