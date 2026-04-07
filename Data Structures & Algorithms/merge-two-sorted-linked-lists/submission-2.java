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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode p = new ListNode(-1);
        ListNode dummy = p;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null){
            p.next = p1;
        }

        if(p2 != null){
            p.next = p2;
        }

        return dummy.next;
    }
}