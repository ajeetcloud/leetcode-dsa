record Node(int dest, int cost) {}
record State(int cost, int node, int stops) {}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<Node>> adj = new ArrayList<>();        
        for (int i = 0 ; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {

            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];

            adj.get(from).add(new Node(to, cost));
        }

        // fewest stops to reach each node so far
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost(), b.cost()));
        pq.offer(new State(0, src, 0));

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int currentCost = current.cost();
            int currentNode = current.node();
            int currentStops = current.stops();

            if (currentStops >= minStops[currentNode] || currentStops > k + 1) {
                continue;
            }
            minStops[currentNode] = currentStops;
            if (currentNode == dst) {
                return currentCost;
            }

            List<Node> neighbors = adj.get(currentNode);
            for (Node neighbor: neighbors) {
                int newCost = current.cost() + neighbor.cost();
                int newStops = current.stops() + 1;
                pq.offer(new State(newCost, neighbor.dest(), newStops));
            }
        }
        return -1;
    }
}