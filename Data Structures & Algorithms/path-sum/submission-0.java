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
    int sum = 0;
    boolean isTrue = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return isTrue;
    }

    public void dfs(TreeNode root, int targetSum){
        if(root == null) return;

        sum+=root.val;
        dfs(root.left, targetSum);
        if(root.left == null && root.right == null && targetSum == sum){
            isTrue = true;
            return;
        }
        dfs(root.right, targetSum);
        sum-=root.val;
    }
}