class Solution {

    // BFS approach
    public int minReorder(int n, int[][] connections) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // If we create a String set we can store like - '0->1'
        Set<Integer> origRoute = new HashSet<>();

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            // origRoute.add(from + "->" + to);
            origRoute.add(from * n + to);
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] visited = new boolean[n];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            List<Integer> neighbors = adj.get(current);
            for (Integer neighbor : neighbors) {
                if (visited[neighbor]) {
                    continue;
                }
                queue.offer(neighbor);
                visited[neighbor] = true;
                int edge = (current * n) + neighbor;
                if (origRoute.contains(edge)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int minReorderDFS(int n, int[][] connections) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // If we create a String set we can store like - '0->1'
        Set<Integer> origRoute = new HashSet<>();

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            // origRoute.add(from + "->" + to);
            origRoute.add((from * n) + to);
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] visited = new boolean[n];
        return dfs(0, adj, origRoute, visited);
    }

    private int dfs(int originNode, List<List<Integer>> adj, Set<Integer> origRoute, boolean[] visited) {

        int n = adj.size();
        visited[originNode] = true;
        int count = 0;
        List<Integer> neighbors = adj.get(originNode);

        for (Integer neighbor : neighbors) {
            if (visited[neighbor]) {
                continue;
            }
            // String edge = originNode + "->" + neighbor;
            int edge = (originNode * n) + neighbor;
            if (origRoute.contains(edge)) {
                count++;
            }
            count += dfs(neighbor, adj, origRoute, visited);
        }

        return count;
    }
}