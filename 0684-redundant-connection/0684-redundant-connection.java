class Solution {

    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        
        parent = new int[edges.length + 1];

        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if (!union(a, b)){
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int x) {

        while (x != parent[x]) {
            parent[x] = parent[parent[x]]; // path halving
            x = parent[x]; 
        }
        return x;
    }

    private boolean union (int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false; // already a path exists
        }
        parent[rootA] = rootB;
        return true;
    }
}