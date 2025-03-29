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
      int count = 0;
      ListNode tempLeft = null;
      ListNode c1 = null;
      ListNode temp = head;
      if (left == right) {
        return head;
      }
      boolean normalCase = true;
      if (left >= 2) {
        while (count < left - 2) {
          temp = temp.next;
          count++;
        }
        c1 = temp.next;
        tempLeft = c1;
      } else {
        c1 = temp;
        tempLeft = head;
        normalCase = false;
      }
      // System.out.println(temp.val);
      // temp is before reverse window
      count = 0;
      ListNode c2 = c1.next;
      ListNode c3 = null;
      while (c2 != null && count < (right - left)) {
        c3 = c2.next;
        c2.next = c1;
        c1 = c2;
        c2 = c3;
        count++;
      }

      temp.next = c1;
      tempLeft.next = c2;

      return normalCase ? head : c1;
    }
}