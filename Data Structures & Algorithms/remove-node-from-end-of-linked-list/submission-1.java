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
        /**

        1,2,3,4
        i 
        j
        */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        for(int i = 0; i <= n; i++){
            if(fast == null) return head;
            fast = fast.next;
        }

        ListNode p = dummy;

        while(fast != null){
            p = p.next;
            fast = fast.next;
        }
        if(p.next != null) p.next = p.next.next;

        return dummy.next;
    }
}
