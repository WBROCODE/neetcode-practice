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
        map = new HashMap<>();
        int n = preorder.length;

        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return buildUp(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode buildUp(int[] preorder, int pS, int pE, int[] inorder, int iS, int iE){
        if(pS > pE) return null;
        int rootV = preorder[pS];
        TreeNode root = new TreeNode(rootV);
        int leftI = map.get(rootV);
        int leftS = map.get(rootV) - iS;
        TreeNode l = buildUp(preorder, pS + 1, pS + leftS, inorder, iS, leftI - 1);
        TreeNode r = buildUp(preorder, pS + leftS + 1, pE, inorder, leftI + 1, iE);
        root.left = l;
        root.right = r;
        return root;
    }



}
