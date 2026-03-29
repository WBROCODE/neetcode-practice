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
        if(lists == null) return null;
        return divide(lists, 0, lists.length - 1);

    }

    public ListNode divide(ListNode[] list, int l, int r){
        if(l == r) return list[l];
        if(l > r) return null;
        
            int mid = l + (r - l) / 2;
            ListNode left = divide(list, l, mid);
            ListNode right = divide(list, mid + 1, r);
        
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(left != null && right != null){

            if(left.val <= right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;                
            }
            cur = cur.next;
        }

        if(left != null) cur.next = left;
        if(right != null) cur.next = right;

        return dummy.next;
    }
}
