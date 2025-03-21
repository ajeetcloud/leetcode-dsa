/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode swapPairs(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }
    ListNode c1 = head;
    ListNode c2 = c1.next;
    ListNode c3 = c2.next;
    ListNode newHead = c2;
    ListNode prevC1 = null;
    while (c2 != null) {
      c3 = c2.next;
      c2.next = c1;
      c1.next = c3;
      if (prevC1 != null) {
        prevC1.next = c2;
      }
      if (c3 == null) {
        break;
      }
      c2 = c3.next;
      prevC1 = c1;
      c1 = c3;
    }
    return newHead;
  }
}