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
    public void reorderList(ListNode head) {
        
        if(head == null) return;

        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode end = reverseList(slow.next);

        slow.next = null;
        
        ListNode p = new ListNode(-1);
        ListNode p1 = p;
        p.next = head;

        ListNode first = head;
        
        while(first != null && end != null){
            p1.next = first;
            first = first.next;
            p1 = p1.next;
            p1.next = end;
            end = end.next;
            p1 = p1.next;
        }

        if(first != null){
            p1.next = first;
        }

        if(end != null){
            p1.next = end;
        }

    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
