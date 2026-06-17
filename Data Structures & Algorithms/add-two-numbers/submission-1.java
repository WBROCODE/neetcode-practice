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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(p1 != null || p2 != null || carry != 0){
            int val = carry;
            if(p1 != null){
                val += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                val += p2.val;
                p2 = p2.next;
            }
            carry = (val / 10);
            val %= 10;

            ListNode newP = new ListNode(val);
            p.next = newP;
            p = p.next;
        }
        
        if(p1 == null){
            p.next = p2;
        }

        if(p2 == null){
            p.next = p1;
        }

        return dummy.next;
    }
}
