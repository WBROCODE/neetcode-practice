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
    List<Integer> order;
    public int kthSmallest(TreeNode root, int k) {
        if(root ==null) return -1;
        order = new ArrayList<>();
        dfs(root);
        return order.get(k - 1);
    }

    public void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        order.add(root.val);
        dfs(root.right);

    }
}
