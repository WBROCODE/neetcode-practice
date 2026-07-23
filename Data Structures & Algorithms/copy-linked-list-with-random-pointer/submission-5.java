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
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        map = new HashMap<>();
        return dfs(head);

    }

    public Node dfs(Node cur){
        if(cur == null) return cur;
        if(map.containsKey(cur)) return map.get(cur);
        Node newNode = new Node(cur.val);
        map.put(cur, newNode);
        newNode.next = dfs(cur.next);
        newNode.random = dfs(cur.random);
        
        return newNode;
    }
}
