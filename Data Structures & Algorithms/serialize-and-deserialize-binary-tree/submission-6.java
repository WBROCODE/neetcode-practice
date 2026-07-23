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
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("null,");
                continue;
            }
            sb.append(cur.val + ",");
            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;

        String[] strs = data.split(",");
        int rootV = Integer.valueOf(strs[0]);
        TreeNode root = new TreeNode(rootV);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 1;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            String left = strs[index++];
            if(left.equals("null")){
                cur.left = null;
            }else{
                TreeNode l = new TreeNode(Integer.valueOf(left));
                cur.left = l;
                q.offer(l);
            }
            String right = strs[index++];
            if(right.equals("null")){
                cur.right = null;
            }else{
                TreeNode r = new TreeNode(Integer.valueOf(right));
                cur.right = r;
                q.offer(r);
            }
        }
        return root;

    }
}
