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
        ListNode first = head;

        for(int i = 0; i < k - 1; i++){
            if(first == null) return head;
            first = first.next;
        }
        if(first == null) return head;

        ListNode second = first.next;
        ListNode firstP = reverseByStop(head, second);
        ListNode secondP = reverseKGroup(second, k);
        head.next = secondP;
        return firstP;
    }

    public ListNode reverseByStop(ListNode head, ListNode stop) {
        if(head == null) return null;

        ListNode prev = null;
        ListNode cur = head;
        while(cur != stop){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
