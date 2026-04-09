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

class Solution {
    public boolean isValidBST(TreeNode root) {
        // bfs
        if(root == null) return true;

        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});


        while(!q.isEmpty()){
            Object[] cur = q.poll();
            TreeNode curN = (TreeNode)cur[0];
            int min = (int) cur[1];
            int max = (int) cur[2];

            if(curN.val <= min || curN.val >= max) return false;

            if(curN.left != null){
                q.offer(new Object[]{curN.left, min, (int)curN.val});
            }

            if(curN.right != null){
                q.offer(new Object[]{curN.right, (int)curN.val, max});
            }
        }

        return true;
    }
}
