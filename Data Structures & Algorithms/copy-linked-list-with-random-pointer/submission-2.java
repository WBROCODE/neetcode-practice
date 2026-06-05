/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>(); 
    public Node copyRandomList(Node head) {
        return dfs(head);
    }

    public Node dfs(Node head){
        if(head == null) return head;
        if(map.containsKey(head)) return map.get(head);
        Node copy = new Node(head.val);
        map.put(head, copy);
        copy.next = dfs(head.next);
        copy.random = dfs(head.random); 
        
        return copy;
    }
}
