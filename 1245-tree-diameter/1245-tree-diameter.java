class Solution {

    int diameter = 0;
    List<List<Integer>> adj;

    public int treeDiameter(int[][] edges) {

        int n = edges.length + 1;
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        heightDfs(0, -1);
        return diameter;
    }

    private int heightDfs(int node, int parent) {
        
        int best1 = 0;
        int best2 = 0;

        List<Integer> neighbors = adj.get(node);

        for (int neighbor: neighbors) {
            if (neighbor == parent) {
                continue;
            }
            int childHeight = 1 + heightDfs(neighbor, node);
            if (childHeight > best1) {
                best2 = best1;
                best1 = childHeight;
            }
            else if (childHeight > best2) {
                best2 = childHeight;
            }
        }
        diameter = Math.max(diameter, best1 + best2);
        return best1;
    }
}