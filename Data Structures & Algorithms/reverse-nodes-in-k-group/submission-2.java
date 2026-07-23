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
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            if(cur == null) return head;
            cur = cur.next; 
        }

        ListNode start = reverseByStop(head, cur);
        ListNode next = reverseKGroup(cur, k);
        head.next = next;
        return start;
    }

    public ListNode reverseByStop(ListNode cur, ListNode stop){
        if(cur == null) return null;
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
