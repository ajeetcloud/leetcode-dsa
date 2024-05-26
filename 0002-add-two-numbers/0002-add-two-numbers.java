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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode resultHead = null;
      ListNode resultTail = null;
      int carry= 0;
      int sum = 0;
      ListNode newNode;
      while (l1 != null && l2 != null) {
        sum = l1.val + l2.val + carry;
        if (sum > 9) {
          sum = sum % 10;
          carry = 1;
        } else {
          carry = 0;
        }
        newNode = new ListNode();
        newNode.val = sum;
        if (resultHead == null) {
          resultHead = newNode;
          resultTail = newNode;
        } else {
          resultTail.next = newNode;
          resultTail = newNode;
        }
        l1 = l1.next;
        l2 = l2.next;
      }
      while (l1 != null) {
        sum = l1.val + carry;
         if (sum > 9) {
          sum = sum % 10;
          carry = 1;
        } else {
          carry = 0;
        }
        newNode = new ListNode();
        newNode.val = sum;
        resultTail.next = newNode;
        resultTail = newNode;
        l1 = l1.next;
      }

      while (l2 != null) {
        sum = l2.val + carry;
         if (sum > 9) {
          sum = sum % 10;
          carry = 1;
        } else {
          carry = 0;
        }
        newNode = new ListNode();
        newNode.val = sum;
        resultTail.next = newNode;
        resultTail = newNode;
        l2 = l2.next;
      }

      if (carry == 1) {
        newNode = new ListNode();
        newNode.val = carry;
        resultTail.next = newNode;
      }


      return resultHead;
    }
}