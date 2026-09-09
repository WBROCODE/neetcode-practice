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
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
        }

       
        ListNode second = reverse(s.next);
        s.next = null;    


        ListNode first = head;
        ListNode p = new ListNode(-1);
        while(first != null && second != null){
            p.next = first;
            ListNode firstN = first.next;
            first.next = second;
            ListNode secondN = second.next;
            second.next = firstN;
            first = firstN;
            second = secondN;
        }

    }

    public ListNode reverse(ListNode head){
        if(head == null) return head;
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
