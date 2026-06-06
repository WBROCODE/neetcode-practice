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
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                sb.append("null,");
            }else{
                int val = cur.val;
                sb.append(val).append(",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }    
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strs = data.split(",");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int rootVal = Integer.parseInt(strs[index]);
        TreeNode root = new TreeNode(rootVal);
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            // left
            index++;
            if(strs[index].equals("null")){
                cur.left = null;
            }else{
                int leftV = Integer.parseInt(strs[index]);
                TreeNode left = new TreeNode(leftV);
                cur.left = left;
                queue.offer(left);
            }
            index++;
            if(strs[index].equals("null")){
                cur.right = null;
            }else{
                int rightV = Integer.parseInt(strs[index]);
                TreeNode right = new TreeNode(rightV);
                cur.right = right;
                queue.offer(right);
            }

        }
        

        return root;


    }
}
