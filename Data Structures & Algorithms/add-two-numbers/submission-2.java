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
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (curr1 != null || curr2 != null) {
            int v1 = 0, v2 = 0;
            if (curr1 == null) v1 = 0; else v1 = curr1.val;
            if (curr2 == null) v2 = 0; else v2 = curr2.val;
            int sum = v1 + v2 + carry;
            if (sum > 9) {
                int res = sum % 10;
                carry = sum / 10;
                sum = res;
            } else {
                carry = 0;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        dummy = dummy.next;
        return dummy;
    }
}
