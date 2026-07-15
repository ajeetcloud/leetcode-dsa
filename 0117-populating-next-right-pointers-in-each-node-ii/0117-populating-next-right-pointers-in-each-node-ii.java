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

            Node dummy = new Node();
            Node tail = dummy;
            Node head = leftmost;

            while (head != null) {
                if (head.left != null) {
                    tail.next = head.left;
                    tail = tail.next;
                }
                if (head.right != null) {
                    tail.next = head.right;
                    tail = tail.next;
                }
                head = head.next;
            }
            leftmost = dummy.next;
        }
        return root;
    }
}









