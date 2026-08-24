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
        
                        2
                    1 2 3 4 
        
                    m: 4 
        */
        if(head == null) return null;
        int total = 0;

        ListNode cur = head;
        while(cur != null){
            total++;
            cur = cur.next;
        }

        int toN = total - n;
        if(toN == 0) return head.next;
        toN--;

        ListNode prev = head;
        for(int i = 0; i < toN; i++){
            prev = prev.next;
        }
        ListNode next = prev.next.next;
        prev.next = next;


        return head;
    }
}
