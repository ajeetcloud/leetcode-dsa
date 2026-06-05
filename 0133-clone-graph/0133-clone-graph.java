/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;P
        neighbors = _neighbors;
    }
}
*/

class Solution {

    // Serves as visited
    Map<Node, Node> cloned = new HashMap<>();

    // This is BFS solution
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Node copy = new Node(node.val);
        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(node);
        cloned.put(node, copy);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (Node neighbor: current.neighbors) {
                
                if (!cloned.containsKey(neighbor)) {
                    Node neighborCopy = new Node(neighbor.val);
                    queue.offer(neighbor);
                    cloned.put(neighbor, neighborCopy);
                }
                cloned.get(current).neighbors.add(cloned.get(neighbor));
            
            }
        }
        return copy;
    }


    // This is Recursive DFS - recusrion might pose a risk
    public Node cloneGraphDFS(Node node) {

        if (node == null) {
            return null;
        }
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }

        Node copy = new Node(node.val);
        cloned.put(node, copy);

        for (Node neighbor: node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }
}


















