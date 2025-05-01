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

    // Find mid node
    ListNode midNode = getMidNode(head);



    // Reverse head2
    ListNode rev = reverseNode(midNode);

    // pick one from first and one from second
    ListNode first = head;
    ListNode sec = rev;
    ListNode tmp = null;
    while (sec.next != null) {
      tmp = first.next;
      first.next = sec;
      first = tmp;

      tmp = sec.next;
      sec.next = first;
      sec= tmp;
    }
   
  }

  public ListNode getMidNode(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public ListNode reverseNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode c1 = head;
    ListNode c2 = c1.next;
    ListNode c3 = null;
    c1.next = null;
    while (c2 != null) {
      c3 = c2.next;
      c2.next = c1;
      c1 = c2;
      c2 = c3;
    }
    return c1;
  }

}