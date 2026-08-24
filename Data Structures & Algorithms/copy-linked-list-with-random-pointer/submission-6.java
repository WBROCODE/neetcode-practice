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
        dfs(head);
        return map.get(head);
    }

    public Node dfs(Node head){
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);

        Node newN = new Node(head.val);
        map.put(head, newN);

        Node next = head.next;
        Node random = head.random;

        newN.next = dfs(next);
        newN.random = dfs(random);

        return newN;
    }
}
