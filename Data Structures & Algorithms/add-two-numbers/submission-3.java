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
        
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;

            carry = sum / 10;
            int val = sum % 10;

            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            while(l1 != null && carry != 0){
                int sum = l1.val + carry;
                carry = sum / 10;
                int val = sum % 10;
                p.next = new ListNode(val);
                p = p.next;
                l1 = l1.next;
            }
            p.next = l1;
        }
        else if(l2 != null){
            while(l2 != null && carry != 0){
                int sum = l2.val + carry;
                carry = sum / 10;
                int val = sum % 10;
                p.next = new ListNode(val);
                p = p.next;
                l2 = l2.next;
            }
            p.next = l2;
        }
        
        if(carry != 0){
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
