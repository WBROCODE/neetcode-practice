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

        ListNode s = head, f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
  
        ListNode cur = head;
        ListNode rev = reverse(s);
        
        while(rev.next != null){
            ListNode next = cur.next;
            ListNode lastN = rev.next;

            cur.next = rev;
            rev.next = next;
            cur = next;
            rev = lastN;
        }

    }

    public ListNode reverse(ListNode cur){
        if(cur == null || cur.next == null) return cur;

        ListNode next = reverse(cur.next);
        cur.next.next = cur;
        cur.next = null;

        return next;
    }
}
