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
        PriorityQueue<ListNode> p = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        ListNode finalNode = new ListNode(0);
        ListNode finalNodeTail = finalNode;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) p.add(lists[i]);
        }
        while (p.size() > 0) {
            ListNode curr = p.poll();
            finalNodeTail.next = curr;
            finalNodeTail = finalNodeTail.next;
            if (curr.next != null) {
                p.add(curr.next);
            }
        }
        return finalNode.next;
    }
}
