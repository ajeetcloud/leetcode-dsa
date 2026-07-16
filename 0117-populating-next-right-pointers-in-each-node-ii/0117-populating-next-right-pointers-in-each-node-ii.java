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
            Node firstNode = null;
            Node tail = null;

            Node head = leftmost;
            while (head != null) {
                if (head.left != null) {
                    if (firstNode == null) {
                        firstNode = head.left;
                        tail = head.left;
                    } else {
                        tail.next = head.left;
                    }
                    tail = head.left;
                }

                if (head.right != null) {
                    if (firstNode == null) {
                        firstNode = head.right;
                        tail = head.right;
                    } else {
                        tail.next = head.right;
                    }
                    tail = head.right;
                }
                head = head.next;
            }
            leftmost = firstNode;
        }
        return root;
    }
}
