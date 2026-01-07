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
    public ListNode reverseList(ListNode head) {
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