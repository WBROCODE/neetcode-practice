/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null) return null;
        return dfs(node);
    }

    public Node dfs(Node node){
        if(node == null) return node;
        if(map.containsKey(node)) return map.get(node);

        Node newN = new Node(node.val);
        List<Node> children = newN.neighbors;
        map.put(node, newN);
        for(Node child : node.neighbors){
            children.add(dfs(child));
        }
        return newN;
    }
}