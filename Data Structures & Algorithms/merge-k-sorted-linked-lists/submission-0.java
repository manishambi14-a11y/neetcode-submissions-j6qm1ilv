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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode finalNode = new ListNode(0);
        ListNode finalNodeTail = finalNode;
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            //merge with Final
            ListNode res = mergeNodes(curr, finalNode.next);
            finalNodeTail.next = res;
        }
        return finalNode.next;
    }
    private ListNode mergeNodes(ListNode src, ListNode des) {
        ListNode res = new ListNode(0);
        ListNode resTail = res;
        if (des == null) {
            resTail.next = src;
        } else {
            ListNode curr1 = des;
            ListNode curr2 = src;
            while (curr1 != null && curr2 != null) {
                if (curr1.val < curr2.val) {
                    resTail.next = new ListNode(curr1.val);
                    resTail = resTail.next;
                    curr1 = curr1.next;
                } else {
                    resTail.next = new ListNode(curr2.val);
                    resTail = resTail.next;
                    curr2 = curr2.next;
                }
            }
            while (curr1 != null) {
                resTail.next = new ListNode(curr1.val);
                resTail = resTail.next;
                curr1 = curr1.next;
            }
            while (curr2 != null) {
                resTail.next = new ListNode(curr2.val);
                resTail = resTail.next;
                curr2 = curr2.next;
            }
        }
        return res.next;
    }
}
