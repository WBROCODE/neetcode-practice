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
        if(lists == null || lists.length == 0) return null;
        ListNode start = lists[0];
        int n = lists.length;
        for(int i = 1; i < n; i++){
            ListNode next = lists[i];
            if(next == null) continue;
            start = mergeTwoLists(start, next);
        }
        return start;
    }

     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;        

        ListNode p1 = new ListNode(-1);
        p1.next = list1;
        ListNode p = p1;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;                
            }
            p = p.next;
        }

        if(list2 != null){
            p.next = list2;
        }
        if(list1 != null){
            p.next = list1;
        }

        return p1.next;
    }
}
