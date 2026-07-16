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

        Node leftmost = root;

        while (leftmost != null) {

            Node firstNodeOfLevel = null;
            Node tail = null;

            // Current level Sweep
            Node head = leftmost;

            while (head != null) {
                if (head.left != null) {
                    if (firstNodeOfLevel == null) {
                        firstNodeOfLevel = head.left;
                    } else {
                        tail.next = head.left;
                    }
                    tail = head.left;
                }
                if (head.right != null) {
                    if (firstNodeOfLevel == null) {
                        firstNodeOfLevel = head.right;
                    } else {
                        tail.next = head.right;
                    }
                    tail = head.right;
                }
                head = head.next;
            }
            // starts next level
            leftmost = firstNodeOfLevel;
        }
        return root;
    }
}
