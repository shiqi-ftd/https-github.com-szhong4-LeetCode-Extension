/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        
        ListNode cur = head;
        ListNode newHead = new ListNode(0);
        ListNode newCur = newHead;
        while (cur != null) {
            ListNode temp = cur.next;
            newCur = newHead;
            while (newCur.next != null && newCur.next.val > cur.val) {
                newCur = newCur.next;
            }
            cur.next = newCur.next;
            newCur.next = cur;
            cur = temp;
        }
        return newHead.next;
    }
}