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
            TC: N * log Total
            SC: Total
        */
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b)->a.val - b.val
        );
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for(ListNode list : lists){
            if(list == null) continue;
            pq.offer(list);
        }

        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            if(cur.next != null){
                pq.offer(cur.next);
            }
            p.next = cur;
            p = p.next;
        }

        return dummy.next;
    }
}
