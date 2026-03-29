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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;
        ListNode rev = reverseNode(head);
        
        if(n == 1){
            rev = rev.next;
        }else{
            ListNode prev = rev;
            for(int i = 1; i < n - 1; i++){
                prev = prev.next;
            }
            if(prev.next != null) prev.next = prev.next.next;
        }

        return reverseNode(rev);
    }

    public ListNode reverseNode(ListNode head){
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
