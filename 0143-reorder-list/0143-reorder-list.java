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

      Stack<ListNode> stack = new Stack<>();
      ListNode temp = head;
      while(temp != null) {
        stack.push(temp);
        temp = temp.next;
      }
      int stackSize = stack.size();
      int count = stack.size() / 2;
      ListNode current = head;
      ListNode next = null;
      ListNode last = null;
      while (count != 0) {
        next = current.next;
        last = stack.pop();
        current.next = last;
        last.next = next;
        current = next;
        count--;
      }
      if (stackSize % 2 == 0) {
        last.next = null;
      } else {
        current.next = null;
      }
      
    }
}