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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
            pre: 1
            in: 
        */
        int n = preorder.length;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode build(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE){
        if(preS > preE) return null;
        TreeNode root = new TreeNode(preorder[preS]);
        int inR = map.get(root.val);
        int leftS = inR - inS;
        TreeNode left = build(preorder, preS + 1, preS + leftS, inorder, inS, inR - 1);
        TreeNode right = build(preorder, preS + leftS + 1, preE, inorder, inR + 1, inE);
        root.left = left;
        root.right = right;

        return root;
    }
}
