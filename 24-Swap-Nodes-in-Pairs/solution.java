/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (head != null && head.next != null) {
            ListNode temp = head.next.next;
            
            pre.next = head.next;
            pre = pre.next;
            pre.next = head;
            pre = head;
            
            head = temp;
        }
        if (head != null) {
            pre.next = head;
        } else {
            pre.next = null;
        }
        return dummy.next;
    }
}