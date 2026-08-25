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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur == null){
                    sb.append("NULL,");
                }else{
                    sb.append(cur.val + ",");
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        int index = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                String left = nodes[++index];
                if(left.equals("NULL")){
                    cur.left = null;
                }else{
                    cur.left = new TreeNode(Integer.parseInt(left));
                    q.offer(cur.left);
                }
                String right = nodes[++index];
                if(right.equals("NULL")){
                    cur.right = null;
                }else{
                    cur.right = new TreeNode(Integer.parseInt(right));
                    q.offer(cur.right);
                }
            }
        }
        return root;
    }
}
