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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // recursion
        if(root == null) return null;

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return dfs(root, min, max);
    }

    public TreeNode dfs(TreeNode root, int min, int max){
        if(root == null) return null;

        if(root.val < min) return dfs(root.right, min, max);
        if(root.val > max) return dfs(root.left, min, max);

        return root;
    }
}
