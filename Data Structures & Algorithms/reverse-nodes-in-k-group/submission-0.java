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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode a = head;
        ListNode b = head;
        
        for(int i = 0; i < k; i++){
            if(b == null) return head;
            b = b.next;
        }

        ListNode newH = reverse(a, b);
        ListNode nextS = reverseKGroup(b,k);
        a.next = nextS;
        return newH;
    }

    public ListNode reverse(ListNode head, ListNode stop){
        if(head == null) return null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur != stop){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
