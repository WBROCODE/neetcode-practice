/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        dfs(root.left, root.right);
        return root;
    }



    public void dfs(Node rootL, Node rootR){
        if(rootL == null || rootR == null) return;

        rootL.next = rootR;
        dfs(rootL.left, rootL.right);
        dfs(rootL.right, rootR.left);
        dfs(rootR.left, rootR.right);


    }
}