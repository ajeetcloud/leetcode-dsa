class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Phase 1: Build undirected adjacency map for emails
        for (List<String> account: accounts) {
            String name = account.get(0);
            String anchor = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);

                // both directions
                graph.computeIfAbsent(anchor, k -> new ArrayList<>()).add(email);
                graph.computeIfAbsent(email, k -> new ArrayList<>()).add(anchor);
            }
        }

        // Phase 2: one DFS launch per component
        Set<String> visited = new HashSet<>();
        List<List<String>> merged = new ArrayList<>();
        for (String email: graph.keySet()) {
            if (visited.contains(email)) {
                continue;
            }
            List<String> component = new ArrayList<>();
            dfs(email, graph, visited, component);
            Collections.sort(component);
            List<String> group = new ArrayList<>();

            group.add(emailToName.get(email));
            group.addAll(component);
            merged.add(group);
        }
        return merged;
    }

    private void dfs(String email, Map<String, List<String>> graph, Set<String> visited, List<String> component) {
        visited.add(email);
        component.add(email);
        for (String next: graph.getOrDefault(email, List.of())) {
            if (!visited.contains(next)) {
                dfs(next, graph, visited, component);
            }
        }
    }
}


















