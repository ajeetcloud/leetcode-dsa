class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        // Phase 1: Create adj Map & indegree
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {

            String recipe = recipes[i];
            List<String> ingrForRecipe = ingredients.get(i);

            for (String ing: ingrForRecipe) {

                adj.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
                indegree.put(recipe, indegree.getOrDefault(recipe, 0) + 1);
            }
            
        }

        // Phase 2: Create supply Queue
        Deque<String> supplyQueue = new ArrayDeque<>();
        for (String supply: supplies) {
            supplyQueue.offer(supply);
        }

        List<String> result = new ArrayList<>();

        // Phase 3: Iterate on queue
        while (!supplyQueue.isEmpty()) {
            String current = supplyQueue.poll();

            List<String> neighbors = adj.getOrDefault(current, Collections.emptyList());
            for (String neighbor: neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    result.add(neighbor);
                    supplyQueue.offer(neighbor);
                }
            }   
        }

        return result;
    }
}