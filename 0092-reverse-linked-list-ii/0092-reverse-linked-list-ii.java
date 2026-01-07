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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }
        // Arrive at left - starting point
        ListNode temp = head;
        ListNode leftNode = null;
        ListNode prevLeftNode = null;
        int count = left - 1;
        while (count > 0) {
            prevLeftNode = temp;
            temp = temp.next;
            count--;
        }
        if (prevLeftNode == null) {
            leftNode = head;
        } else {
            leftNode = prevLeftNode.next;
        } 
        // Reverse the direction
        ListNode c1 = leftNode;
        ListNode c2 = c1.next;
        ListNode c3 = null;
        count = right - left;
        while (count > 0 && c2 != null) {
            c3 = c2.next;
            c2.next = c1;

            c1 = c2;
            c2 = c3;

            count--;
        }
        leftNode.next = c3;
        if (prevLeftNode == null) {
            return c1;
        } else {
            prevLeftNode.next = c1;
        }
        return head;
    }
}