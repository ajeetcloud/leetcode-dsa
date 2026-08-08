class Solution {

    private int[] cities;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        cities = new int[n];
        for (int i = 0; i < n; i++) {
            cities[i] = i;
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
            if (i == cities[i]) {
                count++;
            }
        }
        return count;
    }

    private int find(int x) {
        while (cities[x] != x) {
            x = cities[x];
        }
        return x;
    }

    private void union(int a, int b) {
        int cityA = find(a);
        int cityB = find(b);

        if (cityA != cityB) {
            cities[cityA] = cityB;
        }

    }
}