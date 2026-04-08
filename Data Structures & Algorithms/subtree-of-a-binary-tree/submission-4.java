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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // dfs 
        if(root == null) return false;
        if(dfs(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean dfs(TreeNode startR, TreeNode subRoot){
        if(startR == null && subRoot == null) return true;
        if(startR == null || subRoot == null) return false;

        if(startR.val != subRoot.val) return false;

        return dfs(startR.left, subRoot.left) && dfs(startR.right, subRoot.right);
    }
}
