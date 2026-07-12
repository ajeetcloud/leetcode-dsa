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

        Node leftmost = root; // entry point of current level

        while (leftmost.left != null) { // more levels to be covered
            Node head = leftmost;

            while (head != null) {
                head.left.next = head.right; // Rule A - for same parent
                if (head.next != null) {
                    head.right.next = head.next.left; // Rule B - for different parent
                }
                head = head.next;
            }
            leftmost = leftmost.left; // go 1 level down
        }
        return root;
    }
}
