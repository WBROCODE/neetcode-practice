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
        if(head == null) return null;
        map = new HashMap<>();
        return dfs(head);
    }

    public Node dfs(Node node){
        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);
        Node copy = new Node(node.val);
        map.put(node, copy);

        copy.next = dfs(node.next);
        copy.random = dfs(node.random);

        return copy;
    }
}
