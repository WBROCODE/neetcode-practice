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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        dfs(root, root.val);
        return ans;
    }

    public void dfs(TreeNode root, int pathMax){
        if(root == null) return;
        pathMax = Math.max(root.val, pathMax);
        if(root.val >= pathMax){
            ans++;
        }
        
        dfs(root.left, pathMax);
        dfs(root.right, pathMax);


    }
}
