/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode rev = reverse(slow);
        merge(head, rev);
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
    public void merge(ListNode l1, ListNode l2) {
        while(l2!=null){
            ListNode cur = l2;
            l2 = l2.next;
            cur.next = l1.next;
            l1.next = cur;
            l1 = l1.next.next;
        }
    }
}