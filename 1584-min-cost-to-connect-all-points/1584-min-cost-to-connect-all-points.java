record Edge(int weight, int u, int v) {}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;

        // Step 1: find every edge and its weight
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1;  j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(weight, i , j));
            }
        }

        // Step 2: Sort with weight
        edges.sort((a, b) -> Integer.compare(a.weight(), b.weight()));

        // Step 3: Kruskal with union-find
        DSU dsu = new DSU(n);
        int totalCost = 0;
        int edgesUsed = 0;
        
        for (Edge edge: edges) {
            if (dsu.union(edge.u(), edge.v())) { // if separate, they would join
                totalCost += edge.weight();
                edgesUsed++;
            }
            // n nodes, will need max (n-1) edges for MST
            if (edgesUsed == n - 1) {
                break;
            }
        }
        return totalCost;
    }
}

class DSU {

    private final int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;      // Everyone is there own leader in the beginning
        }
    }

    int find (int x) {
        while (parent[x] != x) { // till node is its own leader
            x = parent[x];
        }
        return x; // leader of x
    }

    boolean union(int u, int v) {
        
        int leaderU = find(u);
        int leaderV = find(v);
        if (leaderU == leaderV) {
            return false;
        }
        parent[leaderU] = leaderV;
        return true;
    }





}

























