/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }
        
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                Node prev = null; // every level starts fresh

                for (int i = 0; i < levelSize; i++) {
                    // visit
                    Node node = queue.poll();
                    if (prev != null) {
                        prev.next = node;
                    }
                    prev = node;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

            }

        return root;
    }
}













