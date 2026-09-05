/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        sb = new StringBuilder();
        dfs(root);
        return sb.toString();
    }

    public void dfs(TreeNode root){
        if(root == null){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val + "");
        sb.append(",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] str = data.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : str){
            nodes.addLast(s);
        }
        return dfs(nodes);
    }

    public TreeNode dfs(LinkedList<String> nodes){
        String rootV = nodes.removeFirst();
        if(rootV.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(rootV));

        root.left = dfs(nodes);
        root.right = dfs(nodes);

        return root;
    }

}
