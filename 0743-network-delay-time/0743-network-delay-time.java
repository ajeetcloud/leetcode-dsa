record Edge(int to, int weight) {}

record State(int node, int cost) {}

class Solution { 
    public int networkDelayTime(int[][] times, int n, int k) {

        // n if from 1...n
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill Adjacency list
        for (int[] time: times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];

            adj.get(from).add(new Edge(to, weight));
        }

        // Fill dist array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost(), b.cost()));
        pq.offer(new State(k, 0));

        while (!pq.isEmpty()) {

            State current = pq.poll();
            // Cheaper path is already present
            if (current.cost() > dist[current.node()]) {
                continue;
            }

            List<Edge> adjacentEdges = adj.get(current.node());
            for (Edge edge: adjacentEdges) {
                int newDist = current.cost() + edge.weight();
                if (newDist < dist[edge.to()]) {
                    dist[edge.to()] = newDist;
                    pq.offer(new State(edge.to(), newDist));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                // In case of disconnected graph, always unreachable
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}  