record Edge(int to, double prob) {
}

record State(int node, double prob) {
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];

            adj.get(from).add(new Edge(to, prob));
            adj.get(to).add(new Edge(from, prob));
        }

        PriorityQueue<State> maxHeapPQ = new PriorityQueue<>((a, b) -> Double.compare(b.prob(), a.prob()));
        maxHeapPQ.offer(new State(start_node, 1.0));

        double[] probResult = new double[n]; // everyone defaults to 0.0
        probResult[start_node] = 1.0;

        while (!maxHeapPQ.isEmpty()) {
            State current = maxHeapPQ.poll();

            if (current.prob() < probResult[current.node()]) {
                continue; // skip-stale
            }

            List<Edge> neighbors = adj.get(current.node());
            for (Edge edge: neighbors) {
                double newProb = current.prob() * edge.prob();
                if (newProb > probResult[edge.to()]) {
                    probResult[edge.to()] = newProb;
                    maxHeapPQ.offer(new State(edge.to(), newProb));
                }
            }
        }        
          
      return probResult[end_node];  
    }
}