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
    public ListNode mergeKLists(ListNode[] lists) {
        /**
        TC: n * k 
        SC: 1
        */  
        if(lists == null || lists.length == 0) return null;
        ListNode start = lists[0];
        for(int i = 1; i < lists.length; i++){
            ListNode next = lists[i];
            start = merge(start, next);
        }
        return start;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p = new ListNode(-1);
        ListNode dummy = p;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;                
            }
            p = p.next;
        }
        if(l1 == null) p.next = l2;
        if(l2 == null) p.next = l1;
        return dummy.next;
    }
}
