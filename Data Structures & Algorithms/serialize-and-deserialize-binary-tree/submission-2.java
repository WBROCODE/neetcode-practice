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
    String SEP = "#";
    String NULL = "NULL";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {  
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append(NULL);
                sb.append(SEP);
                continue;
            }
            int val = cur.val;
            sb.append(val + "");
            sb.append(SEP);
            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;

        String[] nodes = data.split(SEP);
        String strRoot = nodes[0];
        int rootVal = Integer.parseInt(strRoot); 
        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 1;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            String left = nodes[index++]; 
            if(!left.equals(NULL)){
                int leftVal = Integer.parseInt(left); 
                TreeNode leftN = new TreeNode(leftVal);
                cur.left = leftN;
                q.offer(leftN);
            }
            String right = nodes[index++];
            if(!right.equals(NULL)){
                int rightVal = Integer.parseInt(right); 
                TreeNode rightN = new TreeNode(rightVal);
                cur.right = rightN;
                q.offer(rightN);
            }    
        }

        return root;
    }
}
