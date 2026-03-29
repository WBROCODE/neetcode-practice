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
        String SEP = ",";
        String NULL = "NULL";
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append(NULL);
                sb.append(SEP);
            }else{
                sb.append(cur.val + "");
                sb.append(SEP);
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strs = data.split(",");
        int rootVal = Integer.parseInt(strs[0]);
        TreeNode root = new TreeNode(rootVal);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int start = 1;

        while(!q.isEmpty()){          
            TreeNode cur = q.poll();
            if(!strs[start].equals("NULL")){
                int nodeVal = Integer.parseInt(strs[start]);
                cur.left = new TreeNode(nodeVal);
                q.offer(cur.left);
            }
            start++;
            if(!strs[start].equals("NULL")){
                int nodeVal = Integer.parseInt(strs[start]);
                cur.right = new TreeNode(nodeVal);
                q.offer(cur.right);
            }
            start++;      
        }
        return root;        
    }
}
