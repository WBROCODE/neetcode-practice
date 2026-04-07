/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {
 }
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack();
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            st.push(cur);
            len++;
            cur = cur.next;
        }

        int step = (len - 1) / 2;
        cur = head;
        for(int i = 0; i < step; i++){
            ListNode last = st.pop();
            ListNode next = cur.next;
            cur.next = last;
            last.next = next;
            cur = next;
        }
        if(!st.isEmpty()){
            st.pop().next = null;
        }
    }
}