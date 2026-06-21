class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();
        if (n == 1 || n == 2) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int to = edge[0];
            int from = edge[1];

            adj.get(to).add(from);
            adj.get(from).add(to);

            degree[to]++;
            degree[from]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Leaf node
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int rem = n;
        while (!queue.isEmpty() && rem > 2) {

            int outerLayerSize = queue.size(); // level size

            for (int i = 0; i < outerLayerSize; i++) {

                int current = queue.poll();
                rem--;

                List<Integer> neighbors = adj.get(current);
                for (int neighbor: neighbors) {
                    degree[neighbor]--;
                    // New leaf in the inner layer
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }

        }

        // At this point the queue should have either 1 or 2 entry
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}