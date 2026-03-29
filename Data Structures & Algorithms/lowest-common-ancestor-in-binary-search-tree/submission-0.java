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
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        return findAncestor(root, min, max);
    }

    public TreeNode findAncestor(TreeNode root, int val1, int val2){
        if(root == null) return null;

        if(root.val > val1 && root.val < val2) return root;
        if(root.val > val2) return findAncestor(root.left, val1, val2);
        if(root.val < val1) return findAncestor(root.right, val1, val2);
        return root;

    }
}
