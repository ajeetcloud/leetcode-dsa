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

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost(), b.cost()));
        pq.offer(new State(0, src, 0));

        while(!pq.isEmpty()) {
            State current = pq.poll();

            if (current.node() == dst) {
                return current.cost();
            }
            if (current.stops() > k) {
                continue;
            }
            List<Node> neighbors = adj.get(current.node());
            for (Node node: neighbors) {
                int newCost = current.cost() + node.cost();
                int newStops = current.stops() + 1;
                pq.offer(new State(newCost, node.dest(), newStops));
            }
        }
        return -1;
    }
}