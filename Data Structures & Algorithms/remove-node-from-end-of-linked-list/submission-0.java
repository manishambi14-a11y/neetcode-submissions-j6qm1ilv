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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int req = count - n;
        if (req == 0) {
            return head.next;
        }
        curr = head;
        ListNode prev = null;
        //ListNode next = head.next;
        count = 0;
        while (curr != null) {
            if (count == req) {
                ListNode temp = curr.next;
                prev.next = temp;
            }
            count++;
            prev = curr;
            curr = curr.next; 
        }
        return head;
    }
}









