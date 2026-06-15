record Edge(int to, int time) {}
record State(int node, long time) {}

class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int from = roads[i][0];
            int to = roads[i][1];
            int time = roads[i][2];
            adj.get(from).add(new Edge(to, time));
            adj.get(to).add(new Edge(from, time));
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time(), b.time()));
        pq.add(new State(0, 0));

        int[] ways = new int[n];
        ways[0] = 1;

        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int currentNode = current.node();
            long currentTime = current.time();

            if (currentTime > time[currentNode]) {
                continue;
            }

            List<Edge> neighbors = adj.get(current.node());
            for (Edge neighbor: neighbors) {
                long newTime = currentTime + neighbor.time();
                if (newTime < time[neighbor.to()] ) {
                    ways[neighbor.to()] = ways[currentNode];
                    time[neighbor.to()] = newTime;
                    pq.offer(new State(neighbor.to(), newTime));
                }
                else if (newTime == time[neighbor.to()]) {
                    ways[neighbor.to()] = (ways[neighbor.to()] + ways[currentNode]) % MOD;
                }
            }
        }
        return (int) ways[n-1];
    }
}