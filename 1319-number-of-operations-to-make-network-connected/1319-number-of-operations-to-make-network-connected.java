class Solution {

    private int count;
    private int[] parent;

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        count = n;
        for (int[] connection: connections) {
            union(connection[0],connection[1]);
        }
        return count -1;
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        // unconnected nodes -> need an edge
        if (rootA != rootB) {
            parent[rootA] = rootB; // unique connection established
            count--;
        }
    }
}