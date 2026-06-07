class Solution {

    int[] parent;


    // Performs union of 'a' and 'b'
    private boolean union(int a, int b) {

        int leaderA = find(a);
        int leaderB = find(b);

        if (leaderA == leaderB) {
            return false;
        }
        parent[leaderA] = leaderB;
        return true;

    }

    // Finds Leader
    private int find(int n) {

        while (parent[n] != n) {
            n = parent[n];    
        }
        return n;
    }


    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        parent = new int[n];
        // Ever node is its own leader by default
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge: edges) {
            // cycle detection
            if (!union(edge[0], edge[1])) {
                return false;
            }            
        }

        return true;
    }


    // This is vanilla dfs solution
    public boolean validTreeDFS(int n, int[][] edges) {

        // For a tree: E = V - 1
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];   
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] visited = new boolean[n];

        dfs(0, adj, visited);

        for (boolean v: visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    // Only check for connectivity is needed now
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int neighbor: adj.get(node)) {
            dfs(neighbor, adj, visited);
        }
    }
}