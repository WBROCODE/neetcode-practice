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

        ListNode p = list1;
        ListNode q = list2;     
        ListNode j = new ListNode(-1);
        ListNode head = new ListNode(-1);
        head = j;

        while(p != null && q != null){      
            if(p.val < q.val){
                j.next = p;
                p = p.next;
            }else{
                j.next = q;
                q = q.next;                
            }
            j = j.next;
        }
        if(p == null) j.next = q;
        if(q == null) j.next = p;

        return head.next;

    }
}