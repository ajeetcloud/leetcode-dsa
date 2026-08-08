class Solution {

    private int[] parent;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) {
                count++;
            }
        }
        return count;
    }

    private int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    private void union(int a, int b) {
        int cityA = find(a);
        int cityB = find(b);

        if (cityA != cityB) {
            parent[cityA] = cityB;
        }

    }
}