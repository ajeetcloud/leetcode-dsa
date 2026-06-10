class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[routes.length];
        for (int r : stopToRoutes.getOrDefault(source, List.of())) {
            queue.offer(r);
            visited[r] = true;
        }

        int buses = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int route = queue.poll();

                for (int stop : routes[route]) {
                    if (stop == target) {
                        return buses;
                    }
                }

                for (int stop : routes[route]) {
                    for (int nextRoute : stopToRoutes.getOrDefault(stop, List.of())) {
                        if (!visited[nextRoute]) {
                            visited[nextRoute] = true;
                            queue.offer(nextRoute);
                        }
                    }
                }
            }
            buses++;

        }
        return -1;
        
    }
}




















