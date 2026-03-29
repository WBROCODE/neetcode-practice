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
        return dfs(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    public boolean dfs(long min, long max, TreeNode root){
        if(root == null) return true;

        if(min >= root.val || root.val >= max) return false;

        return dfs(min, root.val, root.left) && dfs(root.val, max, root.right);

    }
}
