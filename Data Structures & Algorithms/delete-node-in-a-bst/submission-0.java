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
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val < val){
            root.right = deleteNode(root.right, val);
        }else if(root.val > val){
            root.left = deleteNode(root.left, val);
        }else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }

        return root;

    }


    public TreeNode findMin(TreeNode root){
        while(root.left != null) root = root.left;
        return root;
    }
}