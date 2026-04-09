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
        /**
        String str = 1,2,3,NULL,NULL,4,5
           1
        l 2 3 
        null null 4 5
        */
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null) {
                sb.append("NULL,");
                continue;
            }
            sb.append(cur.val).append(",");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strs = data.split(",");
        int rootV = Integer.parseInt(strs[0]);
        TreeNode root = new TreeNode(rootV);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 1;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            String left = strs[index++];
            if(left.equals("NULL")){
                cur.left = null;
            }else{
                int leftV = Integer.parseInt(left);
                cur.left = new TreeNode(leftV);
                q.offer(cur.left);
            }
            String right = strs[index++];
            if(right.equals("NULL")){
                cur.right = null;
            }else{
                int rightV = Integer.parseInt(right);
                cur.right = new TreeNode(rightV);
                q.offer(cur.right);
            }
        }
        return root;
    }
}
