/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        k = k % len;
        
        ListNode cur = head;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        
        ListNode tail = head;
        while (cur.next != null) {
            cur = cur.next;
            tail = tail.next;
        }
        ListNode newHead = tail.next；
        cur.next = head;
        tail.next = null;
        
        return newHead;
    }
}