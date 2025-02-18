/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

      ListNode hare = head;
      ListNode tortoise = head;
      while (hare != null && hare.next != null) {
        hare = hare.next.next;
        tortoise = tortoise.next;
        if (hare == tortoise) {
          break;
        }
      }
      if (hare == null || hare.next == null) {
        return null;
      }

      hare = head;
      while (hare != tortoise) {
        hare= hare.next;
        tortoise = tortoise.next;
      }
      return tortoise;
    }
}