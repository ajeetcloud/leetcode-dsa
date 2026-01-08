/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode midnode = midpoint(head);
        ListNode secondHalf = midnode.next;
        midnode.next = null;
        ListNode revHead = revLinkList(secondHalf);
        ListNode currentNode = head;
        ListNode nextFwdNode = head.next;
        ListNode nextRevNode = revHead;
        while (nextFwdNode != null && nextRevNode != null) {
            currentNode.next = nextRevNode;
            ListNode temp = nextRevNode.next;
            nextRevNode.next = nextFwdNode;

            currentNode = nextFwdNode;

            nextFwdNode = nextFwdNode.next;
            nextRevNode = temp;
        }
        if (nextFwdNode != null) {
            nextFwdNode.next = null;
        }
        
    }

    public ListNode midpoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode revLinkList(ListNode head) {
        ListNode c1 = null;
        ListNode c2 = head;
        ListNode c3 = null;
        while (c2 != null) {
           c3 = c2.next;
           c2.next = c1;

           c1 = c2;
           c2 = c3; 
        }
        return c1;
    }
}