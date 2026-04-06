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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode resTail = null;
        ListNode res = head;
        int count = 0;
        while (fast != null) {
            fast = fast.next;
            count++;
            if (count == k) {
                ListNode curr = slow;
                ListNode prev = null;
                while (curr != fast) {
                    ListNode temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
                //prev has reversed pointer
                if (resTail != null) {
                    resTail.next = prev;
                } else {
                    res = prev;
                }
                slow.next = fast;
                resTail = slow;
                slow = fast;
                count = 0;
            }
        }
        return res;
    }
}














