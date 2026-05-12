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
        /**
        1 - 2
          |
           -3
        
        */
        if(node == null) return null;
        map = new HashMap<>();
        

        return dfs(node);

    }


    public Node dfs(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node child : node.neighbors){
            newNode.neighbors.add(dfs(child));            
        }

        return newNode;
    }
}