class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
        if((root.val < q.val && root.val > p.val) || (root.val > q.val && root.val < p.val)) return root;
        if(root.val > p.val && root.val > q.val) return dfs(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return dfs(root.right, p, q);
        return root;
    }
}