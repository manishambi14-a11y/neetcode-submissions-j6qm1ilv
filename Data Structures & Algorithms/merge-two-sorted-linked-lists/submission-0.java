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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode tail = res;
        while (list1 != null && list2 != null) {
            ListNode temp;
            if (list1.val > list2.val) {
                temp = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                temp = new ListNode(list1.val);
                list1 = list1.next;
            }
            tail.next = temp;
            tail = tail.next;
        }
        while (list1 != null) {
            tail.next = new ListNode(list1.val);
            tail = tail.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            tail.next = new ListNode(list2.val);
            tail = tail.next;
            list2 = list2.next;
        }
        return res.next;
    }
}