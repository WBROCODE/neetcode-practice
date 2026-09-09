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
            TC: N *K SC: 1
        */
        if(lists == null || lists.length == 0) return null;
        ListNode p = lists[0];
        for(int i = 1; i < lists.length; i++){
            ListNode list = lists[i];
            if(list == null) continue;
            p = merge(p, list);
        }

        return p;

    }

    public ListNode merge(ListNode a, ListNode b){

        if(a == null) return b;
        if(b == null) return a;

        ListNode p = new ListNode(-1); 
        ListNode dummy = p;
        while(a != null && b != null){
            if(a.val < b.val){
                p.next = a;
                a = a.next;
            }else{
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        if(a == null) p.next = b;
        if(b == null) p.next = a;
        return dummy.next;
    }

    
}
