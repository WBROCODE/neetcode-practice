/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    StringBuilder sb;
    public String serialize(Node root) {
        if(root == null) return "";
        sb = new StringBuilder();
        dfs(root);
        return sb.toString();
    }
    
    public void dfs(Node root){
        if(root == null){
            sb.append("#").append(",");
            return;
        }

        sb.append(root.val);
        sb.append(",");
        List<Node> child = root.children;
        int size = child.size();
        sb.append(size);
        sb.append(",");
        for(Node c : child){
            dfs(c);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strs  = data.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : strs){
            nodes.add(s);
        }
        return dfs(nodes);
    }

    public Node dfs(LinkedList<String> nodes){
        String strR = nodes.removeFirst();
        if(strR.equals("#")) return null;
        Node root = new Node(Integer.valueOf(strR), new ArrayList<>());
        String strSize = nodes.removeFirst();
        int size = Integer.valueOf(strSize);
        List<Node> child = root.children;
        for(int i = 0; i < size; i++){
            child.add(dfs(nodes));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
