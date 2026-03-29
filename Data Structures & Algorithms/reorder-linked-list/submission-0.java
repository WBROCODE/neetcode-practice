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
    public void reorderList(ListNode head) {
        /**
             10 5
        8 4  8  4
        6 3  6  3
        4 2  4  2
        2 1  2  1
        
        0     1  
        2->8->
        */
        if(head == null || head.next == null) return;
        int c = 0;
        Stack<ListNode> st = new Stack();
        ListNode p = head;

        while(p != null){
            st.push(p);
            p = p.next;
            c++;
        }

        int steps = (c - 1) / 2;
        p = head;

        for (int i = 0; i < steps; i++) {
            ListNode last = st.pop();
            ListNode next = p.next;
            p.next = last;
            last.next = next;
            p = next;
        }
        st.pop().next = null;
    }
}
