class Solution {

    public int minReorder(int n, int[][] connections) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        Set<String> origRoute = new HashSet<>();

        for (int[] connection: connections) {
            int from = connection[0];
            int to = connection[1];
            origRoute.add(from + "->" + to);
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] visited = new boolean[n];
        return dfs(0, adj, origRoute, visited);
    }

    private int dfs(int originNode, List<List<Integer>> adj, Set<String> origRoute, boolean[] visited) {

        visited[originNode] = true;
        int count = 0;
        List<Integer> neighbors = adj.get(originNode);

        for (Integer neighbor: neighbors) {
            if (visited[neighbor]) {
                continue;
            }
            String edge = originNode + "->" + neighbor;
            if (origRoute.contains(edge)) {
                count++;
            }
            count += dfs(neighbor, adj, origRoute, visited);
        }

        return count;
    }
}